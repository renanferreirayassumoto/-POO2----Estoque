package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.ClasseProduto;
import poo2.estoque.repository.ClasseProdutoRepositorio;

@Service
public class ClasseProdutoServico extends 
    BaseServico<ClasseProdutoRepositorio, ClasseProduto>{

    public ClasseProdutoServico(){
        this.repo = new ClasseProdutoRepositorio();
    }

    @Override
    public List<ClasseProduto> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public ClasseProduto Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public ClasseProduto Edit(ClasseProduto obj) {
        return this.repo.Update(obj);
    }

    @Override
    public ClasseProduto Add(ClasseProduto obj) {
        return this.repo.Create(obj);
    }

    @Override
    public ClasseProduto Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }
}
