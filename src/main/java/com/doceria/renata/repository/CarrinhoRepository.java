package com.doceria.renata.repository;

import com.doceria.renata.model.Carrinho;
import com.doceria.renata.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    public List<Carrinho> findByUsuario(Usuario usuario);
}
