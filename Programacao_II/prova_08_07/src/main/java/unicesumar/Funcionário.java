package unicesumar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Funcionario {
    protected String nome;
    protected String cpf;
    protected Integer quantidadeDedHorasTrabalhadas;
    protected double valorPorHoraTrabalhada;
    protected double salario;
    protected static double bonificacaoHoraExtra = 1.2;

    public Funcionario(){}

    public Funcionario(String nome, String cpf, Integer quantidadeDedHorasTrabalhadas, double valorPorHoraTrabalhada) {
        this.nome = nome;
        this.cpf = cpf;
        this.quantidadeDedHorasTrabalhadas = quantidadeDedHorasTrabalhadas;
        this.valorPorHoraTrabalhada = valorPorHoraTrabalhada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Integer getQuantidadeDedHorasTrabalhadas() {
        return quantidadeDedHorasTrabalhadas;
    }

    public void setQuantidadeDedHorasTrabalhadas(Integer quantidadeDedHorasTrabalhadas) {
        this.quantidadeDedHorasTrabalhadas = quantidadeDedHorasTrabalhadas;
    }

    public double getValorPorHoraTrabalhada() {
        return valorPorHoraTrabalhada;
    }

    public double getBonificacaoHoraExtra() {
        return bonificacaoHoraExtra;
    }

    public void setBonificacaoHoraExtra(double bonificacaoHoraExtra) {
        this.bonificacaoHoraExtra = bonificacaoHoraExtra;
    }

    public void setValorPorHoraTrabalhada(double valorPorHoraTrabalhada) {
        this.valorPorHoraTrabalhada = valorPorHoraTrabalhada;
    }

    public double calculaSalario(double quantidadeDedHorasTrabalhadas, double valorPorHoraTrabalhada ){
        if(valorPorHoraTrabalhada > 0){
            salario = quantidadeDedHorasTrabalhadas * valorPorHoraTrabalhada;
            setSalario(salario);
            return (salario);
        }throw new RuntimeException("Valor deve ser positvo.");
    }

    public double atribuiBonificacao(){
        return salario * bonificacaoHoraExtra;
    }

    class TesteDeFuncionario {

        @Test
        void exercicioA() {
            Funcionario funcionario = new Funcionario();
            funcionario.calculaSalario(40.00, 70.00);
            assertEquals(2800.00, getSalario());
        }

        @Test
        void exercicioB() {
            Funcionario funcionario = new Funcionario();
            funcionario.calculaSalario(40.00, 70.00);
            funcionario.atribuiBonificacao();
            assertEquals(3360, funcionario.atribuiBonificacao());
        }

        @Test
        void exercicioC() {
            Funcionario funcionario = new Funcionario();
            funcionario.calculaSalario(40.00, -70.00);
            RuntimeException exceptionTrowed = assertThrows(RuntimeException.class, () ->  funcionario.calculaSalario(40, -70.00));
            assertEquals("Valor deve ser positvo.", exceptionTrowed.getMessage());
        }

        @Test
        void exercicioD() {
            Funcionario funcionario = new Funcionario("Joao Pedro","18064608902",40,70);
            assertEquals(40, funcionario.getQuantidadeDedHorasTrabalhadas());
            assertEquals("Joao Pedro", funcionario.getNome());
        }

        @Test
        void exercicioE() {
            Funcionario funcionario = new Funcionario();
            funcionario.calculaSalario(40.00, 70.00);
            assertEquals(2800.00, calculaSalario(40.00,70.00));
        }
    }
}
