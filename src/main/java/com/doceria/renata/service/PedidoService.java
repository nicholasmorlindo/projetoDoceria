package com.doceria.renata.service;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Pedido;
import com.doceria.renata.model.Pedido_Produto;
import com.doceria.renata.model.Usuario;
import com.doceria.renata.model.request.PedidoRequest;
import com.doceria.renata.model.response.CarrinhoResponse;
import com.doceria.renata.model.response.PedidoResponse;
import com.doceria.renata.repository.CarrinhoRepository;
import com.doceria.renata.repository.PedidoRepository;
import com.doceria.renata.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public PedidoResponse insert(PedidoRequest pedidoRequest) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(pedidoRequest.getUsuario());
        List<Carrinho> carrinhoOptional = carrinhoRepository.findByUsuario(usuarioOptional.get());

        if (usuarioOptional.isEmpty()) {
            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Usuario nao encontrado");
        }

        if (carrinhoOptional.isEmpty()){
            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Carrinho vazio");
        }

        if (!UsuarioService.validarToken(usuarioOptional.get())) {
            throw new ErrorApiException(HttpStatus.UNAUTHORIZED, "Login Expirou");
        }

        Pedido pedido = pedidoRequest.toModel(usuarioOptional.get());

        carrinhoOptional.forEach(x -> {
            pedido.addProduto(new Pedido_Produto(x.getProduto(),x.getQuantidade(),x.getValor()));
        });

        pedido.calcularValorTotal();

        pedidoRepository.save(pedido);

        carrinhoOptional.forEach(x -> {
            carrinhoRepository.delete(x);
        });

        return PedidoResponse.toResponse(pedido);
    }
}
