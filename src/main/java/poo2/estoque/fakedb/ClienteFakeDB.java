package poo2.estoque.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import poo2.estoque.domain.Cliente;

public class ClienteFakeDB extends BaseFakeDB<Cliente> {

    public ClienteFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        this.lista.add(new Cliente(1L, LocalDate.now(), null, "Rua dos Anjos", "Campo Grande", "Mato Grosso do Sul",
                "79020100", "67998662470", "renan@gmail.com", "12345678911"));
        this.lista.add(new Cliente(2L, LocalDate.now(), null, "Rua dos Pinheiros", "Campo Grande", "Mato Grosso do Sul",
                "79005000", "67998778890", "pedro@gmail.com", "98765432100"));
        this.lista.add(new Cliente(3L, LocalDate.now(), null, "Rua das Laranjeiras", "Campo Grande",
                "Mato Grosso do Sul", "79010000", "67998555555", "joao@gmail.com", "01234567890"));
        this.lista.add(new Cliente(4L, LocalDate.now(), null, "Rua das Aves", "Campo Grande",
                "Mato Grosso do Sul", "790100333", "67998444444", "jorge@gmail.com", "01234123419"));
        this.lista.add(new Cliente(5L, LocalDate.now(), null, "Rua das Abóboras", "Campo Grande",
                "Mato Grosso do Sul", "79010120", "67998555544", "henrique@gmail.com", "00111329"));

    }

}
