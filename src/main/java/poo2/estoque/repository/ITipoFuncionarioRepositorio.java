package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.model.TipoFuncionario;

public interface ITipoFuncionarioRepositorio extends JpaRepository<TipoFuncionario, Long> {
    
}
