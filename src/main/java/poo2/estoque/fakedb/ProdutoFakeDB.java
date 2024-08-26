package poo2.estoque.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import poo2.estoque.domain.Produto;

public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    public ProdutoFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        this.lista.add(new Produto(1L, LocalDate.now(), null, "Cerveja", 1L, 33.90));
        this.lista.add(new Produto(2L, LocalDate.now(), null, "Refrigerante", 2L, 50.90));
        this.lista.add(new Produto(3L, LocalDate.now(), null, "Arroz", 3L, 3.90));
        this.lista.add(new Produto(4L, LocalDate.now(), null, "Batata", 4L, 31.90));
        this.lista.add(new Produto(5L, LocalDate.now(), null, "Carne", 5L, 13.90));
    }
}