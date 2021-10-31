package com.doceria.renata.service;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.request.ProdutoRequest;
import com.doceria.renata.model.response.ProdutoResponse;
import com.doceria.renata.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponse insertProduto(ProdutoRequest produtoRequest){
        Produto produto = produtoRequest.toModel();
        produtoRepository.save(produto);
        return ProdutoResponse.toResponse(produto);
    }

    public ProdutoResponse updateProduto(ProdutoRequest produtoRequest, Long id) {

        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            produtoOptional.get().setNome(produtoRequest.getNome());
            produtoOptional.get().setValor(produtoRequest.getValor());
            produtoOptional.get().setImagem(produtoRequest.getImagem());
            produtoRepository.save(produtoOptional.get());
            return ProdutoResponse.toResponse(produtoOptional.get());
        }
        throw new ErrorApiException(HttpStatus.NOT_FOUND, "Produto não encontrado");
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
