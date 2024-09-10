package poo2.estoque.service;

import java.util.ArrayList;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.SubclasseProduto;
import poo2.estoque.repository.ISubclasseProdutoRepositorio;

@Service
public class SubclasseProdutoServicoJPA implements IBaseServicoJPA<SubclasseProduto> {

    private ISubclasseProdutoRepositorio repositorio;

    SubclasseProdutoServicoJPA(ISubclasseProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<SubclasseProduto> Browse() {
        return new ArrayList<SubclasseProduto>(this.repositorio.findAll());
    }

    @Override
    public SubclasseProduto Read(Long chave) {
        return this.repositorio.findById(chave).get();
    }

    @Override
    public SubclasseProduto Edit(SubclasseProduto obj) {
        Optional<SubclasseProduto> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            SubclasseProduto sp = old.get();
            sp.setCodigoClasse(obj.getCodigoClasse());
            sp.setDataDeAlteracao(LocalDate.now());
            sp.setDescricao(obj.getDescricao());
            this.repositorio.save(sp);
            return sp;
        }
        return null;
    }

    @Override
    public SubclasseProduto Add(SubclasseProduto obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public SubclasseProduto Delete(Long chave) {
        Optional<SubclasseProduto> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }
}
