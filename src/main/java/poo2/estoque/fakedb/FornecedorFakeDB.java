package poo2.estoque.fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import poo2.estoque.domain.Fornecedor;

public class FornecedorFakeDB extends BaseFakeDB<Fornecedor> {

    public FornecedorFakeDB() {
        super();
    }

    @Override
    protected void preencherLista() {
        if (this.lista == null){
            this.lista = new ArrayList<>();
        }
        this.lista.add(new Fornecedor(1L, LocalDate.now(), null, "Rua dos Anjos", "São Paulo", "São Paulo", "79000100", "1199969595", "email@email.com.br", "0001230110011"));
        this.lista.add(new Fornecedor(2L, LocalDate.now(), null, "Rua dos Pinheiros", "São Paulo", "São Paulo", "79000200", "1199969596", "carlos@email.com.br", "0001230110023"));
        this.lista.add(new Fornecedor(3L, LocalDate.now(), null, "Rua dos Vascaínos", "São Paulo", "São Paulo", "79000300", "1199969597", "copasul@email.com.br", "0001230110024"));
        this.lista.add(new Fornecedor(4L, LocalDate.now(), null, "Rua dos Ricos", "São Paulo", "São Paulo", "79000400", "1199969598", "bevara@email.com.br", "0001230110025"));
        this.lista.add(new Fornecedor(5L, LocalDate.now(), null, "Rua dos Empresarios", "São Paulo", "São Paulo", "79000500", "1199969599", "aver@email.com.br", "0001230110027"));
        
    }

}
