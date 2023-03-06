package com.ada.webfilmes.dao;

import com.ada.webfilmes.model.Filme;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class FilmeDAO {
    private static List<Filme> filmes = new ArrayList<>();
   private static int proximoId = 1;
    public void adicionar(Filme filme) {
        filme.setId(proximoId++);
        filmes.add(filme);
    }

    public void atualizar(Filme Filme) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme p = filmes.get(i);
            if (p.getId() == Filme.getId()) {
                filmes.set(i, Filme);
                break;
            }
        }
    }

    public void remover(int id) {
        filmes.removeIf(p -> p.getId() == id);
    }

    public Filme buscarPorId(int id) {
        return filmes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Filme> buscarTodos() {
        return filmes;
    }
    }

