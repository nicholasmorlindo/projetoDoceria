package com.doceria.renata.controller;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.request.ProdutoRequest;
import com.doceria.renata.model.response.ProdutoResponse;
import com.doceria.renata.repository.ProdutoRepository;
import com.doceria.renata.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponse consultar(@PathVariable Long id) {

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            return ProdutoResponse.toResponse(produtoOptional.get());
        }

        throw new ErrorApiException(HttpStatus.NOT_FOUND, "Produto não encontrado");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponse> consultarProdutos() {

        Iterable<Produto> listProdutos = produtoRepository.findAll();

        List<ProdutoResponse> listResponse = new ArrayList<ProdutoResponse>();
        listProdutos.forEach(x -> {
            listResponse.add(ProdutoResponse.toResponse(x));
        });

        return listResponse;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse insert(@RequestBody @Valid ProdutoRequest produtoRequest){
        return produtoService.insertProduto(produtoRequest);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ProdutoResponse update(@RequestBody ProdutoRequest produtoRequest, @PathVariable Long id){
        return produtoService.updateProduto(produtoRequest, id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){

        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()){
            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        produtoService.deleteProduto(id);
    }
}
