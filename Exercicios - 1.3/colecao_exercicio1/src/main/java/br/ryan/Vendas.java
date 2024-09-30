package br.ryan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Vendas {
    // Atributos
    private Map<String, List<Produto>> vendasCpf;

    // Construtor
    public Vendas() {
        vendasCpf = new HashMap<>();
    }

    // Métodos
    // Cadastrar a venda
    public void cadastroVenda(String cpf, Produto p) {
        for (String cpfCliente : vendasCpf.keySet()) {
            if (cpfCliente.equals(cpf)) {
                List<Produto> produtosCPF = vendasCpf.get(cpf);
                produtosCPF.add(p);
                vendasCpf.put(cpf, produtosCPF);
                return;
            }
        }
        List<Produto> produtosCpf = new ArrayList<>();
        produtosCpf.add(p);
        vendasCpf.put(cpf, produtosCpf);
    }

    // Listar produtos de um CPF
    public List<Produto> listaProdutos(String cpf) {
        List<Produto> listaCpf = vendasCpf.getOrDefault(cpf, Collections.emptyList());
        return listaCpf;
    }

    public List<Produto> listaProdutosFiltro(String cpf, double valorMinimo) throws Exception {
        List<Produto> listaCpfFiltro = vendasCpf.getOrDefault(cpf, Collections.emptyList());
        if (listaCpfFiltro.isEmpty()) {
            throw new Exception("CPF não encontrado!");
        } else {
            List<Produto> resultado = listaCpfFiltro.stream().filter(p -> p.getPreco() >= valorMinimo)
                    .collect(Collectors.toList());
            return resultado;
        }

    }
}
