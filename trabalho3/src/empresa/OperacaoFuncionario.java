package empresa;

public class OperacaoFuncionario {
    public static void verificarDadosValidos(Funcionario[] funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.validarDataNascimento() && funcionario.validarDataAdmissao()) {
                System.out.println("Dados válidos para o funcionário: " + funcionario.getNome());
            } else {
                System.out.println("Dados inválidos para o funcionário: " + funcionario.getNome());
            }
        }
    }

    public static void contarFuncionariosPorSexo(Funcionario[] funcionarios) {
        int masculino = 0;
        int feminino = 0;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSexo() == 'M') {
                masculino++;
            } else if (funcionario.getSexo() == 'F') {
                feminino++;
            }
        }

        System.out.println("Número de funcionários do sexo masculino: " + masculino);
        System.out.println("Número de funcionários do sexo feminino: " + feminino);
    }

    public static void imprimirMaiorEMenorSalario(Funcionario[] funcionarios) {
        Funcionario maiorSalario = funcionarios[0];
        Funcionario menorSalario = funcionarios[0];

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.calcularSalarioLiquido() > maiorSalario.calcularSalarioLiquido()) {
                maiorSalario = funcionario;
            }
            if (funcionario.calcularSalarioLiquido() < menorSalario.calcularSalarioLiquido()) {
                menorSalario = funcionario;
            }
        }

        System.out.println("Funcionário com o maior salário : " + maiorSalario.getNome());
        System.out.println("Funcionário com o menor salário : " + menorSalario.getNome());
    }

    public static void imprimirFuncionarioMaisVelhoENovo(Funcionario[] funcionarios) {
        Funcionario maisVelho = funcionarios[0];
        Funcionario maisNovo = funcionarios[0];

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.calcularIdade() > maisVelho.calcularIdade()) {
                maisVelho = funcionario;
            }
            if (funcionario.calcularIdade() < maisNovo.calcularIdade()) {
                maisNovo = funcionario;
            }
        }

        System.out.println("Funcionário mais velho: " + maisVelho.getNome() + ", idade: " + maisVelho.calcularIdade() + " anos");
        System.out.println("Funcionário mais novo: " + maisNovo.getNome() + ", idade: " + maisNovo.calcularIdade() + " anos");
    }
}
