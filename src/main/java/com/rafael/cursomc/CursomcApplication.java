package com.rafael.cursomc;

import com.rafael.cursomc.domain.Categoria;
import com.rafael.cursomc.domain.Cidade;
import com.rafael.cursomc.domain.Estado;
import com.rafael.cursomc.domain.Produto;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.repositories.CidadeRepository;
import com.rafael.cursomc.repositories.EstadoRepository;
import com.rafael.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "informática");
        Categoria cat2 = new Categoria(null, "escritório");

        Produto p1 = new Produto(null, "computador", 2000.00);
        Produto p2 = new Produto(null, "impressora", 800.00);
        Produto p3 = new Produto(null, "mouse", 80.00);

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, est1, "Uberlandia");
        Cidade cid2 = new Cidade(null, est2, "São Paulo");
        Cidade cid3 = new Cidade(null, est2, "Campinas");

        est1.getCidades().addAll(Arrays.asList(cid1, cid2));
        est2.getCidades().addAll(Arrays.asList(cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
    }
}

