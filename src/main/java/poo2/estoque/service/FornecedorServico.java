package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Fornecedor;
import poo2.estoque.repository.FornecedorRepositorio;

@Service
public class FornecedorServico extends BaseServico<FornecedorRepositorio, Fornecedor> {

    public FornecedorServico() {
        this.repo = new FornecedorRepositorio();
    }

    @Override
    public List<Fornecedor> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public Fornecedor Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public Fornecedor Edit(Fornecedor obj) {
        return this.repo.Update(obj);
    }

    @Override
    public Fornecedor Add(Fornecedor obj) {
        return this.repo.Create(obj);
    }

    @Override
    public Fornecedor Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }
}
