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

import poo2.estoque.domain.Funcionario;
import poo2.estoque.service.FuncionarioServicoJPA;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioServicoJPA servico;

    public FuncionarioController(FuncionarioServicoJPA f) {
        this.servico = f;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll() {
        List<Funcionario> f = this.servico.Browse();
        return new ResponseEntity<>(f, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long codigo) {
        Optional<Funcionario> opt = this.servico.Read(codigo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> post(@RequestBody Funcionario f) {
        Funcionario fnew = this.servico.Add(f);
        return new ResponseEntity<>(fnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Funcionario> put(@RequestBody Funcionario f) {
        Funcionario falt = this.servico.Edit(f);
        if (falt != null) {
            return new ResponseEntity<>(falt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Funcionario> delete(@PathVariable Long codigo) {
        Funcionario fdel = this.servico.Delete(codigo);
        if (fdel != null) {
            return new ResponseEntity<>(fdel, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
