package br.ryan;

import javax.swing.JOptionPane;

public class AgendaTelefonica {
    // Atributos
    private Contato[] agendaTelefonica;
    private int contador;

    public AgendaTelefonica(int maxContatos) {
        agendaTelefonica = new Contato[maxContatos];
        contador = 0;
    }

    // Métodos
    // Add
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contador >= agendaTelefonica.length) {
            throw new AgendaCheiaException("Você ja adicionou o número máximo de contatos");
        }
        try {
            agendaTelefonica[contador] = contato;
            contador++;
            System.out.println("Contato adicionado com sucesso!!");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
        }
    }

    // Listar
    public void listarContatos() {
        if (contador == 0) {
            System.out.println("Agenda vazia!");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(agendaTelefonica[i].toString());
            }
        }
    }

    // BuscaContato
    public Contato buscaContato(String nome) throws ContatoNaoEncontradoException {
        for (int i = 0; i < agendaTelefonica.length; i++) {
            if (nome.trim().equalsIgnoreCase(agendaTelefonica[i].getNome())) {
                return agendaTelefonica[i];
            }
        }
        throw new ContatoNaoEncontradoException("Contato não encontrado!");
    }

    // RemoverContato
    public void removerContato(String nome) throws ContatoNaoEncontradoException {
        boolean contatoEncontrado = false;
        for (int i = 0; i < agendaTelefonica.length; i++) {
            if (nome.trim().equals(agendaTelefonica[i].getNome())) {
                contatoEncontrado = true;
                agendaTelefonica[i] = agendaTelefonica[contador - 1];
                agendaTelefonica[contador - 1] = null;
                contador--;
                System.out.println("Contato removido com sucesso!");
            }
        }
        if (!contatoEncontrado) {
            throw new ContatoNaoEncontradoException("Contato não foi encontrado!");
        }
    }
}
