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
    public List<Funcionario> getAll() {
        List<Funcionario> f = this.servico.Browse();
        return f;
    }

    @GetMapping("/{codigo}")
    public Funcionario getById(@PathVariable Long codigo) {
        Funcionario f = this.servico.Read(codigo);
        return f;
    }

    @PostMapping
    public Funcionario post(@RequestBody Funcionario f) {
        Funcionario fnew = this.servico.Add(f);
        return fnew;
    }

    @PutMapping
    public Funcionario put(@RequestBody Funcionario f) {
        Funcionario falt = this.servico.Edit(f);
        return falt;
    }

    @DeleteMapping("/{codigo}")
    public Funcionario delete(@PathVariable Long codigo) {
        Funcionario fdel = this.servico.Delete(codigo);
        return fdel;
    }
}
