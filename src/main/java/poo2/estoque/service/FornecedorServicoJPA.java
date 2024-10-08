package poo2.estoque.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import poo2.estoque.model.Fornecedor;
import poo2.estoque.repository.IFornecedorRepositorio;

@Service
public class FornecedorServicoJPA implements IBaseServicoJPA<Fornecedor> {

    private IFornecedorRepositorio repositorio;

    public FornecedorServicoJPA(IFornecedorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Fornecedor> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Fornecedor> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Fornecedor Edit(Fornecedor obj) {
        Optional<Fornecedor> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            Fornecedor f = old.get();
            f.setCep(obj.getCep());
            f.setCidade(obj.getCidade());
            f.setCnpj(obj.getCnpj());
            f.setEmail(obj.getEmail());
            f.setEndereco(obj.getEndereco());
            f.setEstado(obj.getEstado());
            f.setTelefone(obj.getTelefone());
            f.setDataDeAlteracao(LocalDate.now());
            this.repositorio.save(f);
            return f;
        }
        return null;
    }

    @Override
    public Fornecedor Add(Fornecedor obj) {
        return this.repositorio.save(obj);

    }

    @Override
    public Fornecedor Delete(Long chave) {
        Optional<Fornecedor> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }

}
