package com.doceria.renata.service;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.Usuario;
import com.doceria.renata.model.request.CarrinhoRequest;
import com.doceria.renata.model.response.CarrinhoResponse;
import com.doceria.renata.repository.CarrinhoRepository;
import com.doceria.renata.repository.ProdutoRepository;
import com.doceria.renata.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CarrinhoResponse insert(CarrinhoRequest carrinhoRequest){

        Optional<Produto> produtoOptional = produtoRepository.findById(carrinhoRequest.getProduto());
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(carrinhoRequest.getUsuario());

        if (produtoOptional.isEmpty() || usuarioOptional.isEmpty()) {
            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Produto nao encontrado ou usuario nao encontrados");
        }

        Carrinho carrinho = carrinhoRequest.toModel(produtoOptional.get(), usuarioOptional.get());
        carrinho.setValor(produtoOptional.get().getValor());
        carrinhoRepository.save(carrinho);
        return CarrinhoResponse.toResponse(carrinho);
    }
}
