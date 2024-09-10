package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.domain.Fornecedor;

public interface IFornecedorRepositorio extends JpaRepository<Fornecedor, Long> {

}
