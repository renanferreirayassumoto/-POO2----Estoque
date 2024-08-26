package poo2.estoque.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;


import poo2.estoque.domain.SubclasseProduto;

public class SubclasseProdutoFakeDB extends BaseFakeDB<SubclasseProduto> {

    public SubclasseProdutoFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        this.lista.add(new SubclasseProduto(1L, LocalDate.now(), null, "Bovina", 1L));
        this.lista.add(new SubclasseProduto(2L, LocalDate.now(), null, "Suina", 1L));
        this.lista.add(new SubclasseProduto(3L, LocalDate.now(), null, "Peixe", 2L));
        this.lista.add(new SubclasseProduto(4L, LocalDate.now(), null, "Frutas", 3L));
        this.lista.add(new SubclasseProduto(5L, LocalDate.now(), null, "Verduras", 3L));
    }

}
