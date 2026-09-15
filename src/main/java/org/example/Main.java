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
        String continuar;
        int pedidos = 0;
        double total = 0;
        double maior = 0;
        double menor = 0;
        int comprasAltas = 0;


        do {
            System.out.println("Indique o nome do cliente:");
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
            }

            if (menor == 0) {
                menor = compra;
            } else if (compra < menor) {
                menor = compra;
            }

            if (compra > 50) {
                comprasAltas++;
            }

            System.out.println("Pedido cadastrado!");
            pedidos++;

            System.out.println("Você deseja cadastrar um novo pedido?");
            System.out.println("Responda apenas com 'SIM' ou 'NÃO':");
            entrada.nextLine();
            continuar = entrada.nextLine();

        } while (continuar.equalsIgnoreCase ("SIM"));

        double ticket = total / pedidos;

        System.out.println("==================== RELATÓRIO FINAL ====================");
        System.out.println("Quantidade total de pedidos cadastrados: " + pedidos + ".");
        System.out.println("Valor total das vendas: R$ " + total + ".");
        System.out.println("Ticket médio das vendas: R$ " + ticket + ".");
        System.out.println("Maior valor de compra registrado: R$ " + maior + ".");
        System.out.println("Menor valor de compra registrado: R$ " + menor + ".");
        System.out.println("Quantidade de compras com valor superior a R$ 50,00: " + comprasAltas + ".");
        System.out.println("=========================================================");

    }
}
