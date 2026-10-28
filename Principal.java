/* Module and purpose: Principal - protótipo de consola que corre uma sequência de dados predefinida e mostra o estado.
 * Student name/number and implemented contributions: André (30014704), Tomás (30017467), Isaias (30017477) - desenvolvimento conjunto.
 * Collaborator/reviewer and contribution: revisão mútua entre os três elementos do grupo.
 * AI assistance: ChatGPT (versão inicial) e Claude (refatoração); ver AI_USE.md.
 */
package trilho;

import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        Jogo jogo = new Jogo(Arrays.asList("André", "Tomás", "Isaias"));
        System.out.println("=== TRILHO DAS ESTRELAS - PROTOTIPO DE OUTUBRO ===");
        mostrarEstado(jogo);

        int[] dados = {3, 5, 2, 4, 6, 1};
        for (int dado : dados) {
            System.out.println("\nVez de " + jogo.getJogadorAtual().getNome() + ": dado = " + dado);
            ResultadoTurno r = jogo.jogarTurno(dado);
            mostrarResultado(r);
            mostrarEstado(jogo);
            if (jogo.isTerminado()) {
                break;
            }
        }
        System.out.println("\nFim da demonstracao. Os efeitos especiais serao implementados mais tarde.");
    }

    private static void mostrarResultado(ResultadoTurno r) {
        if (r.isMoveu()) {
            System.out.println(r.getNomeJogador() + " avanca da casa " + r.getPosicaoAnterior()
                    + " para a casa " + r.getPosicaoNova() + ".");
        } else {
            System.out.println(r.getNomeJogador() + " nao avanca (ultrapassaria a casa " + Jogo.ULTIMA_CASA + ").");
        }
        if (r.isVenceu()) {
            System.out.println("Vencedor: " + r.getNomeJogador());
        }
    }

    private static void mostrarEstado(Jogo jogo) {
        for (Jogador j : jogo.getJogadores()) {
            System.out.println(j.getNome() + ": casa " + j.getPosicao());
        }
        if (!jogo.isTerminado()) {
            System.out.println("Proxima vez: " + jogo.getJogadorAtual().getNome());
        }
    }
}
