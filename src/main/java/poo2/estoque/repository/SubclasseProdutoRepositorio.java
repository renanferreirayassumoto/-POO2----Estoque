package poo2.estoque.repository;

import java.time.LocalDate;

import poo2.estoque.domain.SubclasseProduto;
import poo2.estoque.fakedb.SubclasseProdutoFakeDB;

public class SubclasseProdutoRepositorio extends BaseRepositorio<SubclasseProduto> {

    public SubclasseProdutoRepositorio() {
        SubclasseProdutoFakeDB db = new SubclasseProdutoFakeDB();
        this.storage = db.getLista();
    }

    @Override
    public SubclasseProduto Create(SubclasseProduto instancia) {
        SubclasseProduto p = this.storage.getLast();
        Long novoCodigo = p.getCodigo() + 1;
        instancia.setCodigo(novoCodigo);
        this.storage.add(instancia);
        return instancia;
    }

    @Override
    public SubclasseProduto Read(Long codigo) {
        for (SubclasseProduto p : this.storage) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public SubclasseProduto Update(SubclasseProduto instancia) {
        SubclasseProduto p = this.Read(instancia.getCodigo());
        if (p != null) {
            p.setDescricao(instancia.getDescricao());
            p.setDataDeAlteracao(LocalDate.now());
            p.setCodigoClasse(instancia.getCodigoClasse());
            return p;
        } else {
            return null;
        }
    }

    @Override
    public SubclasseProduto Delete(Long codigo) {
        SubclasseProduto p = this.Read(codigo);
        if (p != null) {
            this.storage.remove(p);
            return p;
        } else {
            return null;
        }
    }

}
