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

import poo2.estoque.model.Produto;
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
    public ResponseEntity<List<Produto>> getAll() {
        List<Produto> p = this.servico.Browse();
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> getById(@PathVariable Long codigo) {
        Optional<Produto> opt = this.servico.Read(codigo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto p) {
        Produto pnew = this.servico.Add(p);
        return new ResponseEntity<>(pnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto p) {
        Produto palt = this.servico.Edit(p);
        if (palt != null) {
            return new ResponseEntity<>(palt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> delete(@PathVariable Long codigo) {
        Produto pdel = this.servico.Delete(codigo);
        if (pdel != null) {
            return new ResponseEntity<>(pdel, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
