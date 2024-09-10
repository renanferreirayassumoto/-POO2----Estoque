package poo2.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.estoque.domain.Fornecedor;
import poo2.estoque.service.FornecedorServicoJPA;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorServicoJPA servico;

    public FornecedorController(FornecedorServicoJPA s) {
        this.servico = s;
    }

    @GetMapping
    public List<Fornecedor> getAll() {
        List<Fornecedor> f = this.servico.Browse();
        return f;
    }

    @GetMapping("/{codigo}")
    public Fornecedor getById(@PathVariable Long codigo) {
        Fornecedor f = this.servico.Read(codigo);
        return f;
    }

    @PostMapping
    public Fornecedor post(@RequestBody Fornecedor f) {
        Fornecedor fnew = this.servico.Add(f);
        return fnew;
    }

    @PutMapping
    public Fornecedor put(@RequestBody Fornecedor f) {
        Fornecedor falt = this.servico.Edit(f);
        return falt;
    }

    @DeleteMapping("/{codigo}")
    public Fornecedor delete(@PathVariable Long codigo) {
        Fornecedor fdel = this.servico.Delete(codigo);
        return fdel;
    }
}
