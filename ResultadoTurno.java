/* Module and purpose: ResultadoTurno - descreve o que aconteceu num turno, para a consola (ou GUI) mostrar sem conter regras.
 * Student name/number and implemented contributions: André (30014704), Tomás (30017467), Isaias (30017477) - desenvolvimento conjunto.
 * Collaborator/reviewer and contribution: revisão mútua entre os três elementos do grupo.
 * AI assistance: Claude (criação da classe na refatoração); ver AI_USE.md.
 */
package trilho;

public class ResultadoTurno {
    private final String nomeJogador;
    private final int dado;
    private final int posicaoAnterior;
    private final int posicaoNova;
    private final boolean venceu;

    public ResultadoTurno(String nomeJogador, int dado, int posicaoAnterior, int posicaoNova, boolean venceu) {
        this.nomeJogador = nomeJogador;
        this.dado = dado;
        this.posicaoAnterior = posicaoAnterior;
        this.posicaoNova = posicaoNova;
        this.venceu = venceu;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public int getDado() {
        return dado;
    }

    public int getPosicaoAnterior() {
        return posicaoAnterior;
    }

    public int getPosicaoNova() {
        return posicaoNova;
    }

    public boolean isMoveu() {
        return posicaoNova != posicaoAnterior;
    }

    public boolean isVenceu() {
        return venceu;
    }
}
