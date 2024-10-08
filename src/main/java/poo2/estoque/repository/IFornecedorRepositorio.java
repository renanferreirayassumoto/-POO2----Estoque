package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.model.Fornecedor;

public interface IFornecedorRepositorio extends JpaRepository<Fornecedor, Long> {

}
