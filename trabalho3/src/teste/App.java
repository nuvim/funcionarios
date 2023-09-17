package teste;

import empresa.Funcionario;
import empresa.OperacaoFuncionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos funcionários você deseja cadastrar?");
        int numFuncionarios = scanner.nextInt();

        Funcionario[] funcionarios = new Funcionario[numFuncionarios];

        for (int i = 0; i < numFuncionarios; i++) {
            System.out.println("\nDados do Funcionário " + (i + 1));
            scanner.nextLine();

            String cpf = null;
            boolean cpfValido = false;

            while (!cpfValido) {
                System.out.print("CPF: ");
                cpf = scanner.nextLine();
                if (Funcionario.validarCPF(cpf)) {
                    cpfValido = true;
                } else {
                    System.out.println("CPF inválido. Digite novamente.");
                }
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            char sexo = ' ';
            boolean sexoValido = false;

            while (!sexoValido) {
                System.out.print("Sexo (M/F): ");
                sexo = scanner.nextLine().charAt(0);

                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Entrada inválida. Digite 'M' para masculino ou 'F' para feminino.");
                } else {
                    sexoValido = true;
                }
            }

            double salarioBruto = 0.0;
            boolean salarioValido = false;

            while (!salarioValido) {
                System.out.print("Salário: ");

                if (scanner.hasNextDouble()) {
                    salarioBruto = scanner.nextDouble();
                    salarioValido = true;
                } else {
                    System.out.println("Salário inválido. Digite novamente.");
                    scanner.next();
                }
            }

            GregorianCalendar dataNascimento = obterDataValida("Data de Nascimento (Ex: 08/05/1990): ", scanner);
            GregorianCalendar dataAdmissao = obterDataValida("Data de Admissão (Ex: 10/09/2022): ", scanner);

            Funcionario funcionario = new Funcionario(cpf, nome, sexo, salarioBruto, dataNascimento, dataAdmissao);
            funcionarios[i] = funcionario;
        }

        scanner.close();

        OperacaoFuncionario.verificarDadosValidos(funcionarios);
        OperacaoFuncionario.contarFuncionariosPorSexo(funcionarios);
        OperacaoFuncionario.imprimirMaiorEMenorSalario(funcionarios);
        OperacaoFuncionario.imprimirFuncionarioMaisVelhoENovo(funcionarios);
    }

    private static GregorianCalendar obterDataValida(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            String dataStr = scanner.next();
            GregorianCalendar data = parseData(dataStr);

            if (data != null) {
                return data;
            } else {
                System.out.println("Data inválida. Digite novamente no formato dd/MM/yyyy: ");
            }
        }
    }


    private static GregorianCalendar parseData(String dataStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(dataStr));
            return new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
