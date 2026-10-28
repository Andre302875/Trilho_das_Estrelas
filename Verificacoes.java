/* Module and purpose: Verificacoes - verificações automáticas repetíveis com dados predefinidos (estado inicial, entrada, resultado esperado).
 * Student name/number and implemented contributions: André (30014704), Tomás (30017467), Isaias (30017477) - desenvolvimento conjunto.
 * Collaborator/reviewer and contribution: revisão mútua entre os três elementos do grupo.
 * AI assistance: ChatGPT (versão inicial) e Claude (refatoração e novas verificações); ver AI_USE.md.
 */
package trilho;

import java.util.Arrays;
import java.util.List;

public class Verificacoes {
    private static int certas = 0;
    private static int total = 0;

    private static void verificar(boolean condicao, String descricao) {
        total++;
        if (condicao) {
            certas++;
            System.out.println("OK: " + descricao);
        } else {
            System.out.println("FALHOU: " + descricao);
        }
    }

    private static void jogarSequencia(Jogo jogo, int... dados) {
        for (int dado : dados) {
            jogo.jogarTurno(dado);
        }
    }

    private static boolean construcaoRejeitada(List<String> nomes) {
        try {
            new Jogo(nomes);
            return false;
        } catch (IllegalArgumentException erro) {
            return true;
        }
    }

    public static void main(String[] args) {
        // Estado inicial: 3 jogadores. Entrada: nome com espacos. Esperado: nome limpo, casa 0, vez do primeiro.
        Jogo jogo = new Jogo(Arrays.asList(" André ", "Tomás", "Isaias"));
        verificar(jogo.getJogadorAtual().getNome().equals("André"), "3 jogadores: nome limpo e vez do primeiro");
        verificar(jogo.getJogadorAtual().getPosicao() == 0, "3 jogadores: posicao inicial 0");

        // Entrada: dados 3, 5, 2. Esperado: vez passa por cada jogador e volta ao primeiro.
        jogo.jogarTurno(3);
        verificar(jogo.getJogadorAtual().getNome().equals("Tomás"), "3 jogadores: vez passa ao segundo");
        jogo.jogarTurno(5);
        verificar(jogo.getJogadorAtual().getNome().equals("Isaias"), "3 jogadores: vez passa ao terceiro");
        jogo.jogarTurno(2);
        verificar(jogo.getJogadorAtual().getNome().equals("André"), "3 jogadores: vez volta ao primeiro");
        verificar(jogo.getJogadores().get(0).getPosicao() == 3 && jogo.getJogadores().get(1).getPosicao() == 5
                && jogo.getJogadores().get(2).getPosicao() == 2, "3 jogadores: posicoes (3, 5, 2) apos dados 3, 5, 2");

        // Estado inicial: 2 jogadores. Entrada: dados 1, 2, 3. Esperado: alterna entre os dois.
        Jogo dois = new Jogo(Arrays.asList("A", "B"));
        jogarSequencia(dois, 1, 2);
        verificar(dois.getJogadorAtual().getNome().equals("A"), "2 jogadores: vez volta ao primeiro apos 2 turnos");
        verificar(dois.getJogadores().get(0).getPosicao() == 1 && dois.getJogadores().get(1).getPosicao() == 2,
                "2 jogadores: posicoes (1, 2)");

        // Estado inicial: 4 jogadores. Entrada: 4 dados. Esperado: volta ao primeiro.
        Jogo quatro = new Jogo(Arrays.asList("A", "B", "C", "D"));
        jogarSequencia(quatro, 1, 1, 1, 1);
        verificar(quatro.getJogadorAtual().getNome().equals("A"), "4 jogadores: vez volta ao primeiro apos 4 turnos");

        // Entrada: numero de jogadores/nomes invalidos. Esperado: construcao rejeitada.
        verificar(construcaoRejeitada(Arrays.asList("A")), "1 jogador rejeitado");
        verificar(construcaoRejeitada(Arrays.asList("A", "B", "C", "D", "E")), "5 jogadores rejeitados");
        verificar(construcaoRejeitada(Arrays.asList("A", "a")), "nomes repetidos rejeitados");
        verificar(construcaoRejeitada(Arrays.asList("A", "  ")), "nome vazio rejeitado");

        // Estado inicial: (0, 0), vez de A. Entrada: dados 0 e 7. Esperado: excecao e estado igual.
        Jogo inv = new Jogo(Arrays.asList("A", "B"));
        int[] invalidos = {0, 7, -1};
        boolean todosRejeitados = true;
        for (int d : invalidos) {
            try {
                inv.jogarTurno(d);
                todosRejeitados = false;
            } catch (IllegalArgumentException erro) {
                // esperado
            }
        }
        verificar(todosRejeitados, "dados 0, 7 e -1 rejeitados");
        verificar(inv.getJogadorAtual().getNome().equals("A") && inv.getJogadores().get(0).getPosicao() == 0
                && inv.getJogadores().get(1).getPosicao() == 0, "dado invalido nao altera posicoes nem vez");

        // Estado inicial: (0, 0). Entrada: A tira 3, B tira 3. Esperado: casa partilhada (3, 3).
        Jogo partilha = new Jogo(Arrays.asList("A", "B"));
        jogarSequencia(partilha, 3, 3);
        verificar(partilha.getJogadores().get(0).getPosicao() == 3 && partilha.getJogadores().get(1).getPosicao() == 3,
                "dois jogadores na mesma casa (3, 3)");

        // Estado inicial: (0, 0). Entrada: A faz 6,6,6,6,4 (B faz 1). Esperado: A na casa 28, B na casa 4.
        Jogo fim = new Jogo(Arrays.asList("A", "B"));
        jogarSequencia(fim, 6, 1, 6, 1, 6, 1, 6, 1, 4);
        verificar(fim.getJogadores().get(0).getPosicao() == 28 && fim.getJogadores().get(1).getPosicao() == 4,
                "posicoes (28, 4) antes do fim");

        // Entrada: B tira 1, A tira 3 (ultrapassa 30). Esperado: A fica em 28 e a vez passa a B.
        jogarSequencia(fim, 1);
        ResultadoTurno excesso = fim.jogarTurno(3);
        verificar(!excesso.isMoveu() && fim.getJogadores().get(0).getPosicao() == 28,
                "ultrapassar a casa 30: jogador nao avanca");
        verificar(fim.getJogadorAtual().getNome().equals("B") && !fim.isTerminado(),
                "ultrapassar a casa 30: a vez passa ao seguinte");

        // Entrada: B tira 1, A tira 2 (chega a 30). Esperado: A vence e o jogo termina.
        jogarSequencia(fim, 1);
        ResultadoTurno ultimo = fim.jogarTurno(2);
        verificar(ultimo.isVenceu() && fim.isTerminado() && fim.getVencedor().getNome().equals("A"),
                "chegada exata a casa 30: A vence e o jogo termina");

        // Entrada: novo dado depois do fim. Esperado: excecao e posicao inalterada.
        boolean recusado = false;
        try {
            fim.jogarTurno(1);
        } catch (IllegalStateException erro) {
            recusado = true;
        }
        verificar(recusado && fim.getJogadores().get(0).getPosicao() == 30, "jogada apos o fim rejeitada");

        // Jogador isolado: avanco normal e limite.
        Jogador teste = new Jogador("Teste");
        verificar(teste.avancar(6, 30) && teste.getPosicao() == 6, "Jogador: avanco normal");
        for (int i = 0; i < 4; i++) {
            teste.avancar(6, 30);
        }
        verificar(teste.getPosicao() == 30, "Jogador: chegada a casa final");
        verificar(!teste.avancar(2, 30) && teste.getPosicao() == 30, "Jogador: nao ultrapassa a ultima casa");

        System.out.println("Resultado: " + certas + "/" + total);
        if (certas != total) {
            System.exit(1);
        }
    }
}
