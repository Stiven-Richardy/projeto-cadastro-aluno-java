/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FormAluno extends JFrame {
    private static List<Aluno> listaAlunos = new ArrayList<>();

    private static JTextField txtNome = new JTextField(20);
    private static JTextField txtIdade = new JTextField(20);
    private static JTextField txtEndereco = new JTextField(20);

    private static JButton btnOk = new JButton("Ok");
    private static JButton btnLimpar = new JButton("Limpar");
    private static JButton btnMostrar = new JButton("Mostrar");
    private static JButton btnSair = new JButton("Sair");

    public FormAluno() {
        setTitle("TP02 - LPR2");
        setSize(400,180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));
        setVisible(true);

        JPanel painelSuperior = new JPanel();
        JPanel painelInferior = new JPanel();

        painelSuperior.setLayout(new GridLayout(3, 2, 10, 10));
        painelInferior.setLayout(new GridLayout(1, 4, 10, 10));

        painelSuperior.add(new JLabel("Nome:"));
        painelSuperior.add(txtNome);

        painelSuperior.add(new JLabel("Idade:"));
        painelSuperior.add(txtIdade);

        painelSuperior.add(new JLabel("Endereco:"));
        painelSuperior.add(txtEndereco);

        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        btnOk.addActionListener(e -> cadastraAluno());

        btnLimpar.addActionListener(e -> limpaTexto());

        btnMostrar.addActionListener(e -> mostraAlunos());

        btnSair.addActionListener(e -> System.exit(0));

        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
    }

    private void cadastraAluno() {
            try {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                String endereco = txtEndereco.getText();
                Aluno novoAluno = new Aluno(nome, idade, endereco);
                listaAlunos.add(novoAluno);
                JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Erro: Insira um numero inteiro", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
    }

    private void limpaTexto() {
        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
    }

    private void mostraAlunos() {
        if (listaAlunos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado ainda.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            StringBuilder mensagem = new StringBuilder();
            for (Aluno aluno : listaAlunos) {
                mensagem.append("Id: " + aluno.getUuid().toString() + " | Nome: " + aluno.getNome().toString() + "\n");
            }
            JOptionPane.showMessageDialog(this, mensagem.toString(), "Alunos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormAluno().setVisible(true));
    }
}