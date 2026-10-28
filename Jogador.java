/* Module and purpose: Jogador - guarda o nome e a posição de um jogador e aplica o avanço no tabuleiro.
 * Student name/number and implemented contributions: André (30014704), Tomás (30017467), Isaias (30017477) - desenvolvimento conjunto.
 * Collaborator/reviewer and contribution: revisão mútua entre os três elementos do grupo.
 * AI assistance: ChatGPT (versão inicial) e Claude (refatoração); ver AI_USE.md.
 */
package trilho;

public class Jogador {
    private final String nome;
    private int posicao;

    public Jogador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome nao pode estar vazio.");
        }
        this.nome = nome.trim();
        this.posicao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }

    /**
     * Avança o número de casas indicado, desde que não ultrapasse a última casa.
     *
     * @return true se o jogador se moveu, false se o movimento ultrapassava a última casa
     */
    public boolean avancar(int casas, int ultimaCasa) {
        if (casas < 1) {
            throw new IllegalArgumentException("O numero de casas deve ser positivo.");
        }
        if (posicao + casas <= ultimaCasa) {
            posicao = posicao + casas;
            return true;
        }
        return false;
    }
}
