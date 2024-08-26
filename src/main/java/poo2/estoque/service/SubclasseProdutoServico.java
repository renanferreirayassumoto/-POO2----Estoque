package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.SubclasseProduto;
import poo2.estoque.repository.SubclasseProdutoRepositorio;

@Service
public class SubclasseProdutoServico extends BaseServico<SubclasseProdutoRepositorio, SubclasseProduto> {
    public SubclasseProdutoServico() {
        this.repo = new SubclasseProdutoRepositorio();
    }

    @Override
    public List<SubclasseProduto> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public SubclasseProduto Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public SubclasseProduto Edit(SubclasseProduto obj) {
        return this.repo.Update(obj);
    }

    @Override
    public SubclasseProduto Add(SubclasseProduto obj) {
        return this.repo.Create(obj);
    }

    @Override
    public SubclasseProduto Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }
}
