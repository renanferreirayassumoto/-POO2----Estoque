package poo2.estoque.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import poo2.estoque.model.Cliente;
import poo2.estoque.repository.IClienteRepositorio;

@Service
public class ClienteServicoJPA implements IBaseServicoJPA<Cliente> {

    private IClienteRepositorio repositorio;

    public ClienteServicoJPA(IClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Cliente> Browse() {
        return this.repositorio.findAll();
    }

    @Override
    public Optional<Cliente> Read(Long chave) {
        return this.repositorio.findById(chave);
    }

    @Override
    public Cliente Edit(Cliente obj) {
        Optional<Cliente> old = this.repositorio.findById(obj.getCodigo());
        if (old.isPresent()) {
            Cliente c = old.get();
            c.setCep(obj.getCep());
            c.setCidade(obj.getCidade());
            c.setCpf(obj.getCpf());
            c.setDataDeAlteracao(LocalDate.now());
            c.setEmail(obj.getEmail());
            c.setEndereco(obj.getEndereco());
            c.setEstado(obj.getEstado());
            c.setTelefone(obj.getTelefone());
            this.repositorio.save(c);
            return c;
        }
        return null;
    }

    @Override
    public Cliente Add(Cliente obj) {
        return this.repositorio.save(obj);
    }

    @Override
    public Cliente Delete(Long chave) {
        Optional<Cliente> old = this.repositorio.findById(chave);
        if (old.isPresent()) {
            this.repositorio.delete(old.get());
            return old.get();
        }
        return null;
    }
}
