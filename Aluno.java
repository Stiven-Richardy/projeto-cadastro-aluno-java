/*
IFSP - CAMPUS CUBATÃO
TURMA: ADS 471 - LINGUAGEM DE PROGRAMAÇÃO II
INTEGRANTES:
-> Stiven Richardy Silva Rodrigues
-> Guilherme Mendes de Sousa
*/

import java.util.UUID;

public class Aluno {
    private UUID uuid;
    private String nome;
    private int idade;
    private String endereco;

    public UUID getUuid() {
        return this.uuid;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public UUID setUuid(UUID uuid) {
        return this.uuid = uuid;
    }

    public String setNome(String nome) {
        return this.nome = nome;
    }

    public int setIdade(int idade) {
        return this.idade = idade;
    }

    public String setEndereco(String endereco) {
        return this.endereco = endereco;
    }

    public Aluno(String nome, int idade, String endereco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome vazio");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Erro: Idade menor que 0");
        }
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Endereco vazio");
        }
        setUuid(UUID.randomUUID());
        setNome(nome);
        setIdade(idade);
        setEndereco(endereco);
    }
}