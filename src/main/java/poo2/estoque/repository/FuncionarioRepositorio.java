package poo2.estoque.repository;

import poo2.estoque.domain.Funcionario;
import poo2.estoque.fakedb.FuncionarioFakeDB;
import java.time.LocalDate;

public class FuncionarioRepositorio extends BaseRepositorio<Funcionario> {

    public FuncionarioRepositorio() {
        FuncionarioFakeDB db = new FuncionarioFakeDB();
        this.storage = db.getLista();
    }

    @Override
    public Funcionario Create(Funcionario instancia) {
        Funcionario f = this.storage.getLast();
        Long novoCodigo = f.getCodigo() + 1;
        instancia.setCodigo(novoCodigo);
        this.storage.add(instancia);
        return instancia;
    }

    @Override
    public Funcionario Read(Long codigo) {
        for (Funcionario f : this.storage) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Funcionario Update(Funcionario instancia) {
        Funcionario f = this.Read(instancia.getCodigo());
        if (f != null) {
            f.setSenha(instancia.getSenha());
            f.setDataDeAlteracao(LocalDate.now());
            f.setCep(instancia.getCep());            
            f.setCidade(instancia.getCidade());
            f.setCodigoTipoFunc(instancia.getCodigoTipoFunc());
            f.setEmail(instancia.getEmail());
            f.setEndereco(instancia.getEndereco());
            f.setEstado(instancia.getEstado());
            f.setTelefone(instancia.getTelefone());
            return f;
        }
        return null;
    }

    @Override
    public Funcionario Delete(Long codigo) {
        Funcionario f = this.Read(codigo);
        if (f!= null){
            this.storage.remove(f);
            return f;
        } else {
            return null;
        }
    }
}
