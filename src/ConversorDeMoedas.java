import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoedas {

    private static final String API_KEY = "SUA CHAVE AQUI";
    private final ApiHttpClient apiHttpClient;
    private final ServicoConversorDeMoedas servicoConversorDeMoedas;

    public ConversorDeMoedas() {
        this.apiHttpClient = new ApiHttpClient(API_KEY);
        this.servicoConversorDeMoedas = new ServicoConversorDeMoedas(apiHttpClient);
    }

    public static void main(String[] args) {
        ConversorDeMoedas conversor = new ConversorDeMoedas();
        try {
            conversor.executar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executar() throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String moedaBase = null;
        String moedaDestino = null;

        while (true) {
            System.out.println("==================================");
            System.out.println("         CONVERSOR DE MOEDAS      ");
            System.out.println("==================================");
            System.out.println("1. Definir moeda base");
            System.out.println("2. Definir moeda de destino");
            System.out.println("3. Converter valor");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite a moeda base (USD, BRL, ARS, BOB, CLP, COP): ");
                    moedaBase = scanner.nextLine().toUpperCase();
                    break;

                case 2:
                    System.out.print("Digite a moeda de destino (USD, BRL, ARS, BOB, CLP, COP): ");
                    moedaDestino = scanner.nextLine().toUpperCase();
                    break;

                case 3:
                    if (moedaBase == null || moedaDestino == null) {
                        System.out.println("Erro: Defina as duas moedas antes de converter.");
                    } else {
                        System.out.print("Digite o valor que deseja converter: ");
                        double valor = scanner.nextDouble();

                        RespostaTaxaDeCambio resposta = servicoConversorDeMoedas.obterTaxasDeCambio(moedaBase);

                        if (resposta != null) {
                            double valorConvertido = servicoConversorDeMoedas.converterMoeda(resposta, moedaBase, moedaDestino, valor);
                            if (valorConvertido != -1) {
                                System.out.printf("O valor convertido de %.2f %s para %s é: %.2f%n", valor, moedaBase, moedaDestino, valorConvertido);
                            } else {
                                System.out.println("Erro: Conversão falhou. Verifique as moedas.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo.");
                    return;

                default:
                    System.out.println("Opção inválida! Escolha uma opção válida.");
            }
        }
    }
}
