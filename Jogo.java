/* Module and purpose: Jogo - regras do Trilho das Estrelas: 2 a 4 jogadores, turnos, movimento e fim do jogo (sem escrita na consola).
 * Student name/number and implemented contributions: André (30014704), Tomás (30017467), Isaias (30017477) - desenvolvimento conjunto.
 * Collaborator/reviewer and contribution: revisão mútua entre os três elementos do grupo.
 * AI assistance: ChatGPT (versão inicial) e Claude (refatoração); ver AI_USE.md.
 */
package trilho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {
    public static final int ULTIMA_CASA = 30;
    public static final int DADO_MIN = 1;
    public static final int DADO_MAX = 6;
    public static final int MIN_JOGADORES = 2;
    public static final int MAX_JOGADORES = 4;

    private final List<Jogador> jogadores = new ArrayList<>();
    private int turno;
    private boolean terminado;
    private Jogador vencedor;

    public Jogo(List<String> nomes) {
        if (nomes == null || nomes.size() < MIN_JOGADORES || nomes.size() > MAX_JOGADORES) {
            throw new IllegalArgumentException("O jogo precisa de " + MIN_JOGADORES + " a " + MAX_JOGADORES + " jogadores.");
        }
        for (String nome : nomes) {
            Jogador novo = new Jogador(nome);
            for (Jogador existente : jogadores) {
                if (existente.getNome().equalsIgnoreCase(novo.getNome())) {
                    throw new IllegalArgumentException("Os nomes dos jogadores devem ser diferentes.");
                }
            }
            jogadores.add(novo);
        }
        turno = 0;
        terminado = false;
        vencedor = null;
    }

    public List<Jogador> getJogadores() {
        return Collections.unmodifiableList(jogadores);
    }

    public Jogador getJogadorAtual() {
        return jogadores.get(turno);
    }

    public boolean isTerminado() {
        return terminado;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    /**
     * Joga um turno com o valor do dado indicado. Se o dado for inválido, lança exceção
     * e o estado do jogo não é alterado.
     */
    public ResultadoTurno jogarTurno(int dado) {
        if (terminado) {
            throw new IllegalStateException("O jogo ja terminou.");
        }
        if (dado < DADO_MIN || dado > DADO_MAX) {
            throw new IllegalArgumentException("O dado deve estar entre " + DADO_MIN + " e " + DADO_MAX + ".");
        }
        Jogador atual = getJogadorAtual();
        int antes = atual.getPosicao();
        atual.avancar(dado, ULTIMA_CASA);
        ResultadoTurno resultado = new ResultadoTurno(
                atual.getNome(), dado, antes, atual.getPosicao(), atual.getPosicao() == ULTIMA_CASA);
        if (resultado.isVenceu()) {
            terminado = true;
            vencedor = atual;
        } else {
            turno = (turno + 1) % jogadores.size();
        }
        return resultado;
    }
}
