package poo2.estoque.repository;

import java.time.LocalDate;

import poo2.estoque.domain.Cliente;
import poo2.estoque.fakedb.ClienteFakeDB;

public class ClienteRepositorio extends BaseRepositorio<Cliente> {

    public ClienteRepositorio() {
        ClienteFakeDB db = new ClienteFakeDB();
        this.storage = db.getLista();
    }

    @Override
    public Cliente Create(Cliente instancia) {
        Cliente c = this.storage.getLast();
        Long novoCodigo = c.getCodigo() + 1;
        instancia.setCodigo(novoCodigo);
        this.storage.add(instancia);
        return instancia;
    }

    @Override
    public Cliente Read(Long codigo) {
        for (Cliente c : this.storage) {
            if (c.getCodigo() == codigo) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Cliente Update(Cliente instancia) {
        Cliente c = this.Read(instancia.getCodigo());
        if (c != null) {
            c.setCpf(instancia.getCpf());
            c.setCep(instancia.getCep());
            c.setCidade(instancia.getCidade());
            c.setDataDeAlteracao(LocalDate.now());
            c.setEmail(instancia.getEmail());
            c.setEndereco(instancia.getEndereco());
            c.setEstado(instancia.getEstado());
            c.setTelefone(instancia.getTelefone());
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Cliente Delete(Long codigo) {
        Cliente c = this.Read(codigo);
        if (c != null) {
            this.storage.remove(c);
            return c;
        } else {
            return null;
        }
    }
}
