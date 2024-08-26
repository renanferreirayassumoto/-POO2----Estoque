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

import poo2.estoque.domain.ClasseProduto;
import poo2.estoque.service.ClasseProdutoServico;

@RestController
@RequestMapping("/api/estoque/classeproduto")
public class ClasseProdutoController {
    
    @Autowired
    private ClasseProdutoServico servico;

    public ClasseProdutoController(ClasseProdutoServico s){
        this.servico = s;
    }    

    @GetMapping
    public List<ClasseProduto> getAll(){
        List<ClasseProduto> cp = this.servico.Browse();
        return cp;
    }

    @GetMapping("/{codigo}")
    public ClasseProduto getById(@PathVariable Long codigo){        
        ClasseProduto cp = this.servico.Read(codigo);
        return cp;
    } 

    @PostMapping
    public ClasseProduto post(@RequestBody ClasseProduto cp) {
        ClasseProduto cpnew = this.servico.Add(cp);
        return cpnew;
    }

    @PutMapping
    public ClasseProduto put(@RequestBody ClasseProduto cp){
        ClasseProduto cpalt = this.servico.Edit(cp);
        return cpalt;
    }

    @DeleteMapping("/{codigo}")
    public ClasseProduto delete(@PathVariable Long codigo){
        ClasseProduto cpdel = this.servico.Delete(codigo);
        return cpdel;
    }
}
