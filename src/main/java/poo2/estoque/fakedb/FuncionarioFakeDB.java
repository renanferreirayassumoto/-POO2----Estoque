package poo2.estoque.fakedb;

import java.util.ArrayList;
import java.time.LocalDate;

import poo2.estoque.domain.Funcionario;

public class FuncionarioFakeDB extends BaseFakeDB<Funcionario> {

    public FuncionarioFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        this.lista.add(new Funcionario(1L, LocalDate.now(), null, "Rua 14 de Julho", "Campo Grande",
                "Mato Grosso do Sul", "79080110", "67999999999", "jorge@gmail.com", 1L, "jorge123"));
        this.lista.add(new Funcionario(2L, LocalDate.now(), null, "Rua 15 de Julho", "Campo Grande",
                "Mato Grosso do Sul", "79080220", "67999888888", "pedro@gmail.com", 2L, "pedro456"));
        this.lista.add(new Funcionario(3L, LocalDate.now(), null, "Rua 16 de Julho", "Campo Grande",
                "Mato Grosso do Sul", "79080330", "67999777777", "ana@gmail.com", 3L, "ana789"));
        this.lista.add(new Funcionario(4L, LocalDate.now(), null, "Rua 17 de Julho", "Campo Grande",
                "Mato Grosso do Sul", "79080440", "67999666666", "lucas@gmail.com", 4L, "lucas101"));
        this.lista.add(new Funcionario(5L, LocalDate.now(), null, "Rua 18 de Julho", "Campo Grande",
                "Mato Grosso do Sul", "79080550", "67999555555", "mariana@gmail.com", 5L, "mariana202"));

    }
}
