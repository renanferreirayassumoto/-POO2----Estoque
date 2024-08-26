package poo2.estoque.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import poo2.estoque.domain.ClasseProduto;

public class ClasseProdutoFakeDB extends BaseFakeDB<ClasseProduto> {

    public ClasseProdutoFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        this.lista.add(new ClasseProduto(1L, LocalDate.now(), null, "Carnes"));
        this.lista.add(new ClasseProduto(2L, LocalDate.now(), null, "Bebidas"));
        this.lista.add(new ClasseProduto(3L, LocalDate.now(), null, "Laticínios"));
        this.lista.add(new ClasseProduto(4L, LocalDate.now(), null, "Biscoitos"));
        this.lista.add(new ClasseProduto(5L, LocalDate.now(), null, "Limpeza"));
    }
}