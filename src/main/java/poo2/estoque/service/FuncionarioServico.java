package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Funcionario;
import poo2.estoque.repository.FuncionarioRepositorio;

@Service
public class FuncionarioServico extends BaseServico<FuncionarioRepositorio, Funcionario> {

    public FuncionarioServico() {
        this.repo = new FuncionarioRepositorio();
    }

    @Override
    public List<Funcionario> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public Funcionario Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public Funcionario Edit(Funcionario obj) {
        return this.repo.Update(obj);
    }

    @Override
    public Funcionario Add(Funcionario obj) {
        return this.repo.Create(obj);
    }

    @Override
    public Funcionario Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }
}
