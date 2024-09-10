package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.domain.Produto;

public interface IProdutoRepositorio extends JpaRepository<Produto, Long> {

}
