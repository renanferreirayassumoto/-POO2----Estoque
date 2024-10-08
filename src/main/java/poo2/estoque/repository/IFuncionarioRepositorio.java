package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.model.Funcionario;

public interface IFuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
