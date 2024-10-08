package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.model.Cliente;

public interface IClienteRepositorio extends JpaRepository<Cliente, Long> {

}
