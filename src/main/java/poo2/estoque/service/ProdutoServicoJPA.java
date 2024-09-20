package poo2.estoque.service;

import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Produto;
import poo2.estoque.repository.IProdutoRepositorio;

@Service
public class ProdutoServicoJPA implements IBaseServicoJPA<Produto> {

    private IProdutoRepositorio repositorio;

    public ProdutoServicoJPA(IProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<Produto> Browse() {
        return new ArrayList<Produto>(this.repositorio.findAll());
    }

    @Override
    public Optional<Produto> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Produto Edit(Produto obj) {
        Optional<Produto> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            Produto p = old.get();
            p.setCodigoSubclasse(obj.getCodigoSubclasse());
            p.setDataDeAlteracao(LocalDate.now());
            p.setDescricao(obj.getDescricao());
            p.setValor(obj.getValor());
            this.repositorio.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Produto Add(Produto obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Produto Delete(Long chave) {
        Optional<Produto> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }
}
