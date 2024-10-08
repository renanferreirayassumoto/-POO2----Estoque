package poo2.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.estoque.model.SubclasseProduto;

public interface ISubclasseProdutoRepositorio extends JpaRepository<SubclasseProduto, Long> {
    
}
