package poo2.estoque.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poo2.estoque.domain.Cliente;
import poo2.estoque.repository.ClienteRepositorio;

@Service
public class ClienteServico extends BaseServico<ClienteRepositorio, Cliente> {
    
    public ClienteServico() {
        this.repo = new ClienteRepositorio();
    }

    @Override
    public List<Cliente> Browse() {
        return this.repo.ReadAll();
    }

    @Override
    public Cliente Read(Long codigo) {
        return this.repo.Read(codigo);
    }

    @Override
    public Cliente Edit(Cliente obj) {
        return this.repo.Update(obj);
    }

    @Override
    public Cliente Add(Cliente obj) {
        return this.repo.Create(obj);
    }

    @Override
    public Cliente Delete(Long codigo) {
        return this.repo.Delete(codigo);
    }
}
