package poo2.estoque.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.estoque.model.SubclasseProduto;
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
    public ResponseEntity<List<SubclasseProduto>> getAll() {
        List<SubclasseProduto> p = this.servico.Browse();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<SubclasseProduto> getById(@PathVariable Long codigo) {
        Optional<SubclasseProduto> opt = this.servico.Read(codigo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SubclasseProduto> post(@RequestBody SubclasseProduto sp) {
        SubclasseProduto spnew = this.servico.Add(sp);
        return new ResponseEntity<>(spnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<SubclasseProduto> put(@RequestBody SubclasseProduto sp) {
        SubclasseProduto spalt = this.servico.Edit(sp);
        if (spalt != null) {
            return new ResponseEntity<>(spalt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<SubclasseProduto> delete(@PathVariable Long codigo) {
        SubclasseProduto spdel = this.servico.Delete(codigo);
        if (spdel != null) {
            return new ResponseEntity<>(spdel, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
