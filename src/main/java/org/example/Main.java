package org.example;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Locale;


public class Main {
    static void main() {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner entrada = new Scanner (System.in);
        entrada.useLocale(Locale.US);

        String nome;
        double compra;
        int pedidos = 0;
        double total = 0;
        double maior = 0;
        double menor = 0;
        int comprasAltas = 0;
        String maiorCliente = "";
        int compraTrinta = 0;
        double totalTrinta = 0;
        double ticket;
        double mediaTrinta;
        int menu = 0;


        do {

            System.out.println("=== MENU INICIAL ===");
            System.out.println("1 - Cadastrar Pedido");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Encerrar Sistema");
            System.out.println("====================");
            menu = entrada.nextInt();

            while (menu > 3) {

                System.out.println("Insira uma opção válida, por favor!");
                menu = entrada.nextInt();

            }

            if (menu == 1) {

                System.out.println("Indique o nome do cliente:");
                entrada.nextLine();
                nome = entrada.nextLine();

                System.out.println("Agora indique o valor da compra, do mesmo cliente:");
                compra = entrada.nextDouble();

                while (compra <= 0) {
                    System.out.println("Insira um valor valido, por favor!");
                    compra = entrada.nextDouble();
                }

                total = total + compra;

                if (compra > maior) {
                    maior = compra;
                    maiorCliente = nome;
                }

                if (menor == 0) {
                    menor = compra;
                } else if (compra < menor) {
                    menor = compra;
                }

                if (compra > 50) {
                    comprasAltas++;
                }

                if (compra > 30) {
                    compraTrinta++;
                    totalTrinta = totalTrinta + compra;
                }

                System.out.println("Pedido cadastrado!");
                pedidos++;

                System.out.println("Pressione enter para voltar ao menu inicial...");
                entrada.nextLine();
                entrada.nextLine();

            } else if (menu == 2) {

                ticket = total / pedidos;
                mediaTrinta = totalTrinta / compraTrinta;

                System.out.println("==================== RELATÓRIO FINAL ====================");
                System.out.println("Quantidade total de pedidos cadastrados: " + pedidos + ".");
                System.out.println("Valor total das vendas: R$ " + total + ".");
                System.out.println("Ticket médio das vendas: R$ " + ticket + ".");
                System.out.println("Maior valor de compra registrado: R$ " + maior + ".");
                System.out.println("Menor valor de compra registrado: R$ " + menor + ".");
                System.out.println("Quantidade de compras com valor superior a R$ 50,00: " + comprasAltas + ".");
                System.out.println("Cliente que realizou maior compra: " + maiorCliente + ".");
                System.out.println("Média de compras acima de R$ 30,00: R$ " + mediaTrinta + ".");
                System.out.println("=========================================================");

                System.out.println("Pressione enter para voltar ao menu inicial...");
                entrada.nextLine();
                entrada.nextLine();

            }

        } while (menu == 1 || menu == 2);

        if (menu == 3) {

            System.out.println("Obrigado por usar nosso sistema.");
            System.out.println("Até Logo!");

        }

    }
}
