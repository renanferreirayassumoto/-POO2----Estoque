package poo2.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import poo2.estoque.model.TipoFuncionario;
import poo2.estoque.repository.ITipoFuncionarioRepositorio;

@Service
public class TipoFuncionarioServicoJPA implements IBaseServicoJPA<TipoFuncionario> {

    private ITipoFuncionarioRepositorio repositorio;

    public TipoFuncionarioServicoJPA(ITipoFuncionarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<TipoFuncionario> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<TipoFuncionario> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public TipoFuncionario Edit(TipoFuncionario obj) {
        Optional<TipoFuncionario> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            TipoFuncionario tf = old.get();
            tf.setDataDeAlteracao(obj.getDataDeAlteracao());
            tf.setDescricao(obj.getDescricao());
            this.repositorio.save(tf);
            return tf;
        }
        return null;
    }

    @Override
    public TipoFuncionario Add(TipoFuncionario obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public TipoFuncionario Delete(Long chave) {
        Optional<TipoFuncionario> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }

}
