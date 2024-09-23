package br.ryan;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    List<Funcionarios> listFuncionarios;

    public FuncionarioController() {
        listFuncionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionarios funcionarios) {
        try {
            listFuncionarios.add(funcionarios);
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }

    }

    public void listFuncionarios() {
        if (listFuncionarios.size() == 0) {
            System.out.println("Não ha funcionarios cadastrados");
        } else {
            for (Funcionarios funcionarios : listFuncionarios) {
                System.out.println(funcionarios.toString());
            }
        }
    }

    public void removerFuncionarios(String nome) throws Exception {
        try {
            boolean encontrado = false;
            for (Funcionarios funcionarios : listFuncionarios) {
                if (funcionarios.getNome().equals(nome)) {
                    encontrado = true;
                    listFuncionarios.remove(funcionarios);
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario não encontrado!");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

    }

    public double calcularMediaSalarial() {
        if (listFuncionarios.size() == 0) {
            return 0.0;
        } else {
            double media = 0;
            for (Funcionarios funcionarios : listFuncionarios) {
                media += funcionarios.getSalario();
            }
            return media / listFuncionarios.size();
        }
    }
}
