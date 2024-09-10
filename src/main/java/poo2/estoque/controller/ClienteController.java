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

import poo2.estoque.domain.Cliente;
import poo2.estoque.service.ClienteServicoJPA;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    private ClienteServicoJPA servico;

    public ClienteController(ClienteServicoJPA s) {
        this.servico = s;
    }

    @GetMapping
    public List<Cliente> getAll() {
        List<Cliente> cp = this.servico.Browse();
        return cp;
    }

    @GetMapping("/{codigo}")
    public Cliente getById(@PathVariable Long codigo) {
        Cliente cp = this.servico.Read(codigo);
        return cp;
    }

    @PostMapping
    public Cliente post(@RequestBody Cliente c) {
        Cliente cnew = this.servico.Add(c);
        return cnew;
    }

    @PutMapping
    public Cliente put(@RequestBody Cliente c) {
        Cliente calt = this.servico.Edit(c);
        return calt;
    }

    @DeleteMapping("/{codigo}")
    public Cliente delete(@PathVariable Long codigo) {
        Cliente cdel = this.servico.Delete(codigo);
        return cdel;
    }
}
