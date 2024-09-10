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

import poo2.estoque.domain.SubclasseProduto;
import poo2.estoque.service.SubclasseProdutoServicoJPA;

@RestController
@RequestMapping("/api/estoque/subclasseproduto")
public class SubclasseProdutoController {
    @Autowired
    private SubclasseProdutoServicoJPA servico;

    public SubclasseProdutoController(SubclasseProdutoServicoJPA s) {
        this.servico = s;
    }

    @GetMapping
    public List<SubclasseProduto> getAll() {
        List<SubclasseProduto> p = this.servico.Browse();
        return p;
    }

    @GetMapping("/{codigo}")
    public SubclasseProduto getById(@PathVariable Long codigo) {
        SubclasseProduto p = this.servico.Read(codigo);
        return p;
    }

    @PostMapping
    public SubclasseProduto post(@RequestBody SubclasseProduto sp) {
        SubclasseProduto spnew = this.servico.Add(sp);
        return spnew;
    }

    @PutMapping
    public SubclasseProduto put(@RequestBody SubclasseProduto sp) {
        SubclasseProduto spalt = this.servico.Edit(sp);
        return spalt;
    }

    @DeleteMapping("/{codigo}")
    public SubclasseProduto delete(@PathVariable Long codigo) {
        SubclasseProduto spdel = this.servico.Delete(codigo);
        return spdel;
    }
}
