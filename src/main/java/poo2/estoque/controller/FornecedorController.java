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
    public ResponseEntity<List<Fornecedor>> getAll() {
        List<Fornecedor> f = this.servico.Browse();
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long codigo) {
        Optional<Fornecedor> opt = this.servico.Read(codigo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Fornecedor> post(@RequestBody Fornecedor f) {
        Fornecedor fnew = this.servico.Add(f);
        return new ResponseEntity<>(fnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Fornecedor> put(@RequestBody Fornecedor f) {
        Fornecedor falt = this.servico.Edit(f);
        if (falt != null) {
            return new ResponseEntity<>(falt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Fornecedor> delete(@PathVariable Long codigo) {
        Fornecedor fdel = this.servico.Delete(codigo);
        if (fdel != null) {
            return new ResponseEntity<>(fdel, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
