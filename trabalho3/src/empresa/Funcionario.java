package empresa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Funcionario {
    private String cpf;
    private String nome;
    private char sexo;
    private double salarioBruto;
    private GregorianCalendar dataNascimento;
    private GregorianCalendar dataAdmissao;

    public Funcionario() {
        this.dataAdmissao = new GregorianCalendar();
    }

    public Funcionario(String cpf, String nome, GregorianCalendar dataAdmissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario(String cpf, String nome, char sexo, double salarioBruto, GregorianCalendar dataNascimento, GregorianCalendar dataAdmissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.salarioBruto = salarioBruto;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}") || cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
                cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }

        int soma1 = 0;
        int soma2 = 0;

        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            soma1 += digito * (10 - i);
            soma2 += digito * (11 - i);
        }

        int digito1 = 11 - (soma1 % 11);
        if (digito1 == 10 || digito1 == 11) {
            digito1 = 0;
        }

        soma2 += digito1 * 2;
        int digito2 = 11 - (soma2 % 11);
        if (digito2 == 10 || digito2 == 11) {
            digito2 = 0;
        }

        return cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2;
    }

    public boolean validarDataNascimento() {
        int anoNascimento = dataNascimento.get(Calendar.YEAR);
        return anoNascimento >= 1920;
    }

    public boolean validarDataAdmissao() {
        int anoAdmissao = dataAdmissao.get(Calendar.YEAR);
        return anoAdmissao >= 1995;
    }

    public int calcularIdade() {
        GregorianCalendar hoje = new GregorianCalendar();
        int anoNascimento = dataNascimento.get(Calendar.YEAR);
        int anoAtual = hoje.get(Calendar.YEAR);
        return anoAtual - anoNascimento;
    }

    public double calcularSalarioLiquido() {
        if (salarioBruto <= 3000.00) {
            return salarioBruto * 0.83;
        } else {
            return salarioBruto * 0.73;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "CPF: " + cpf +
                "\nNome: " + nome +
                "\nSexo: " + sexo +
                "\nSalário Bruto: " + salarioBruto +
                "\nData de Nascimento: " + dateFormat.format(dataNascimento.getTime()) +
                "\nData de Admissão: " + dateFormat.format(dataAdmissao.getTime());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Funcionario other = (Funcionario) obj;
        return cpf.equals(other.cpf) && nome.equals(other.nome) && sexo == other.sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public GregorianCalendar getDataAdmissao() {
        return dataAdmissao;
    }
}
