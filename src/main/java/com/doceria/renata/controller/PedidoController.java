package com.doceria.renata.controller;

import com.doceria.renata.exception.ErrorApiException;
import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Pedido;
import com.doceria.renata.model.Produto;
import com.doceria.renata.model.Usuario;
import com.doceria.renata.model.request.CarrinhoRequest;
import com.doceria.renata.model.request.PedidoRequest;
import com.doceria.renata.model.request.ProdutoRequest;
import com.doceria.renata.model.response.CarrinhoResponse;
import com.doceria.renata.model.response.PedidoResponse;
import com.doceria.renata.model.response.ProdutoResponse;
import com.doceria.renata.repository.CarrinhoRepository;
import com.doceria.renata.repository.PedidoRepository;
import com.doceria.renata.repository.UsuarioRepository;
import com.doceria.renata.service.CarrinhoService;
import com.doceria.renata.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @GetMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<CarrinhoResponse> consultar(@PathVariable Long id) {
//
//        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
//
//        List<Carrinho> carrinhoOptional = carrinhoRepository.findByUsuario(usuarioOptional.get());
//
//        if (usuarioOptional.isEmpty()){
//            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Nao existe este usuario");
//        }
//
//        if (carrinhoOptional.isEmpty()) {
//            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Nao existe produtos no carrinho");
//        }
//
//        List<CarrinhoResponse> listResponse = new ArrayList<CarrinhoResponse>();
//        carrinhoOptional.forEach(items -> {
//            listResponse.add(CarrinhoResponse.toResponse(items));
//        });
//
//        return listResponse;
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoResponse insertPedido(@RequestBody @Valid PedidoRequest pedidoRequest){
        return pedidoService.insert(pedidoRequest);
    }

//    @DeleteMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable Long id){
//
//        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
//
//        if (carrinhoOptional.isEmpty()){
//            throw new ErrorApiException(HttpStatus.NOT_FOUND, "Carrinho vazio");
//        }
//        carrinhoRepository.delete(carrinhoOptional.get());
//    }
}
