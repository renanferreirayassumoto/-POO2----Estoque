package poo2.estoque.repository;

import java.time.LocalDate;
import poo2.estoque.domain.Fornecedor;
import poo2.estoque.fakedb.FornecedorFakeDB;

public class FornecedorRepositorio extends BaseRepositorio<Fornecedor> {

    public FornecedorRepositorio() {
        FornecedorFakeDB db = new FornecedorFakeDB();
        this.storage = db.getLista();
    }

    @Override
    public Fornecedor Create(Fornecedor instancia) {
        Fornecedor f = this.storage.getLast();
        Long novoCodigo = f.getCodigo() + 1;
        instancia.setCodigo(novoCodigo);
        this.storage.add(instancia);
        return instancia;
    }

    @Override
    public Fornecedor Read(Long codigo) {
        for (Fornecedor f : this.storage) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Fornecedor Update(Fornecedor instancia) {
        Fornecedor f = this.Read(instancia.getCodigo());
        if (f != null) {
            f.setCnpj(instancia.getCnpj());
            f.setDataDeAlteracao(LocalDate.now());
            f.setCep(instancia.getCep());
            f.setCidade(instancia.getCidade());
            f.setEmail(instancia.getEmail());
            f.setEndereco(instancia.getEndereco());
            f.setEstado(instancia.getEstado());
            f.setTelefone(instancia.getTelefone());
            return f;
        }
        return null;
    }

    @Override
    public Fornecedor Delete(Long codigo) {
        Fornecedor f = this.Read(codigo);
        if (f != null) {
            this.storage.remove(f);
            return f;
        } else {
            return null;
        }
    }
}
