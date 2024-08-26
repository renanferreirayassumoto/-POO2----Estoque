package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Produto;
import poo2.estoque.repository.ProdutoRepositorio;

@Service
public class ProdutoServico extends BaseServico<ProdutoRepositorio, Produto> {

    public ProdutoServico() {
        this.repo = new ProdutoRepositorio();
    }

    @Override
    public List<Produto> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public Produto Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public Produto Edit(Produto obj) {
        return this.repo.Update(obj);
    }

    @Override
    public Produto Add(Produto obj) {
        return this.repo.Create(obj);
    }

    @Override
    public Produto Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }

}
