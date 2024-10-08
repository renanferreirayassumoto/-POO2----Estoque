package poo2.estoque.controller;

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
import java.util.List;

import poo2.estoque.model.TipoFuncionario;
import poo2.estoque.service.TipoFuncionarioServicoJPA;

@RestController
@RequestMapping("/api/tipoFuncionario")
public class TipoFuncionarioController {
    @Autowired
    private TipoFuncionarioServicoJPA servico;

    public TipoFuncionarioController(TipoFuncionarioServicoJPA s) {
        this.servico = s;
    }

    @GetMapping
    public ResponseEntity<List<TipoFuncionario>> getAll() {
        List<TipoFuncionario> tf = this.servico.Browse();
        return new ResponseEntity<>(tf, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TipoFuncionario> getById(@PathVariable Long codigo) {
        Optional<TipoFuncionario> opt = this.servico.Read(codigo);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<TipoFuncionario> post(@RequestBody TipoFuncionario tf) {
        TipoFuncionario cnew = this.servico.Add(tf);
        return new ResponseEntity<>(cnew, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TipoFuncionario> put(@RequestBody TipoFuncionario tf) {
        TipoFuncionario tfalt = this.servico.Edit(tf);
        if (tfalt != null) {
            return new ResponseEntity<>(tfalt, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<TipoFuncionario> delete(@PathVariable Long codigo) {
        TipoFuncionario tfdel = this.servico.Delete(codigo);
        if (tfdel != null) {
            return new ResponseEntity<>(tfdel, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
