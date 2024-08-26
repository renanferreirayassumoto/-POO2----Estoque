package poo2.estoque.repository;

import java.time.LocalDate;

import poo2.estoque.domain.Produto;
import poo2.estoque.fakedb.ProdutoFakeDB;

public class ProdutoRepositorio extends BaseRepositorio<Produto> {

    public ProdutoRepositorio() {
        ProdutoFakeDB db = new ProdutoFakeDB();
        this.storage = db.getLista();
    }

    @Override
    public Produto Create(Produto instancia) {
        Produto p = this.storage.getLast();
        Long novoCodigo = p.getCodigo() + 1;
        instancia.setCodigo(novoCodigo);
        this.storage.add(instancia);
        return instancia;
    }

    @Override
    public Produto Read(Long codigo) {
        for (Produto p : this.storage) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Produto Update(Produto instancia) {
        Produto p = this.Read(instancia.getCodigo());
        if (p != null) {
            p.setDescricao(instancia.getDescricao());
            p.setDataDeAlteracao(LocalDate.now());
            p.setCodigoSubclasse(instancia.getCodigoSubclasse());
            p.setValor(instancia.getValor());
            return p;
        } else {
            return null;
        }
    }

    @Override
    public Produto Delete(Long codigo) {
        Produto p = this.Read(codigo);
        if (p != null){
            this.storage.remove(p);
            return p;
        }
        else {
            return null;
        }
    }

}
