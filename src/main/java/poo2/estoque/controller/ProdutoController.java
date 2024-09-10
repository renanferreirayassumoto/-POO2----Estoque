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

import poo2.estoque.domain.Produto;
import poo2.estoque.service.ProdutoServicoJPA;

@RestController
@RequestMapping("/api/estoque/produto")
public class ProdutoController {
    @Autowired
    private ProdutoServicoJPA servico;

    public ProdutoController(ProdutoServicoJPA s) {
        this.servico = s;
    }

    @GetMapping
    public List<Produto> getAll() {
        List<Produto> p = this.servico.Browse();
        return p;
    }

    @GetMapping("/{codigo}")
    public Produto getById(@PathVariable Long codigo) {
        Produto p = this.servico.Read(codigo);
        return p;
    }

    @PostMapping
    public Produto post(@RequestBody Produto p) {
        Produto pnew = this.servico.Add(p);
        return pnew;
    }

    @PutMapping
    public Produto put(@RequestBody Produto p) {
        Produto palt = this.servico.Edit(p);
        return palt;
    }

    @DeleteMapping("/{codigo}")
    public Produto delete(@PathVariable Long codigo) {
        Produto pdel = this.servico.Delete(codigo);
        return pdel;
    }
}
