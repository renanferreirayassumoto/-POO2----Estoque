package poo2.estoque.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Funcionario;
import poo2.estoque.repository.IFuncionarioRepositorio;

@Service
public class FuncionarioServicoJPA implements IBaseServicoJPA<Funcionario> {

    private IFuncionarioRepositorio repositorio;

    public FuncionarioServicoJPA(IFuncionarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public ArrayList<Funcionario> Browse() {
        return new ArrayList<Funcionario>(this.repositorio.findAll());
    }

    @Override
    public Funcionario Read(Long chave) {
        return this.repositorio.findById(chave).get();
    }

    @Override
    public Funcionario Edit(Funcionario obj) {
        Optional<Funcionario> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            Funcionario f = old.get();
            f.setCep(obj.getCep());
            f.setCidade(obj.getCidade());
            f.setCodigoTipoFunc(obj.getCodigoTipoFunc());
            f.setDataDeAlteracao(LocalDate.now());
            f.setEmail(obj.getEmail());
            f.setEndereco(obj.getEndereco());
            f.setEstado(obj.getEstado());
            f.setSenha(obj.getSenha());
            f.setTelefone(obj.getTelefone());
            this.repositorio.save(f);
            return f;
        }
        return null;
    }

    @Override
    public Funcionario Add(Funcionario obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Funcionario Delete(Long chave) {
        Optional<Funcionario> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }

}
