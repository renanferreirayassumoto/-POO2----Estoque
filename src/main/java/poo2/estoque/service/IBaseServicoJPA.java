package poo2.estoque.service;

import java.util.ArrayList;

public interface IBaseServicoJPA<TDominio> {
    ArrayList<TDominio> Browse();

    TDominio Read(Long chave);

    TDominio Edit(TDominio obj);

    TDominio Add(TDominio obj);

    TDominio Delete(Long chave);
}
