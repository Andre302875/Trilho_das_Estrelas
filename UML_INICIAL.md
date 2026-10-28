# UML inicial — outubro

O diagrama representa o **protótipo atual**, não a versão final com Swing.

```text
+------------------------------+
| Principal                    |
+------------------------------+
| + main(args: String[]): void |
| - mostrarEstado(jogo): void  |
| - mostrarResultado(r): void  |
+------------------------------+
        | utiliza
        v
+------------------------------------------------------+
| Jogo                                                 |
+------------------------------------------------------+
| + ULTIMA_CASA: int = 30 {static, final}              |
| + DADO_MIN: int = 1, DADO_MAX: int = 6               |
| + MIN_JOGADORES: int = 2, MAX_JOGADORES: int = 4     |
| - jogadores: List<Jogador>                           |
| - turno: int                                         |
| - terminado: boolean                                 |
| - vencedor: Jogador                                  |
+------------------------------------------------------+
| + Jogo(nomes: List<String>)                          |
| + getJogadores(): List<Jogador>                      |
| + getJogadorAtual(): Jogador                         |
| + getVencedor(): Jogador                             |
| + isTerminado(): boolean                             |
| + jogarTurno(dado: int): ResultadoTurno              |
+------------------------------------------------------+
     | possui 2..4 (composição)        | devolve
     v                                 v
+-----------------------------------+  +--------------------------------------+
| Jogador                           |  | ResultadoTurno                       |
+-----------------------------------+  +--------------------------------------+
| - nome: String                    |  | - nomeJogador: String                |
| - posicao: int                    |  | - dado: int                          |
+-----------------------------------+  | - posicaoAnterior: int               |
| + Jogador(nome: String)           |  | - posicaoNova: int                   |
| + getNome(): String               |  | - venceu: boolean                    |
| + getPosicao(): int               |  +--------------------------------------+
| + avancar(casas: int,             |  | + getNomeJogador(): String           |
|           ultimaCasa: int): boolean|  | + getDado(): int                     |
+-----------------------------------+  | + getPosicaoAnterior(): int          |
                                       | + getPosicaoNova(): int              |
                                       | + isMoveu(): boolean                 |
                                       | + isVenceu(): boolean                |
                                       +--------------------------------------+
```

`-` indica atributo privado e `+` método público.

- `Jogo` contém as regras e **não escreve na consola**. Quem mostra o estado é `Principal` (e, mais tarde, a interface Swing), a partir de `getJogadores()` e do `ResultadoTurno`.
- `Verificacoes` usa `Jogo`, `Jogador` e `ResultadoTurno`, mas não está representada para simplificar.
- Em novembro vão acrescentar-se as casas especiais (avanço e recuo), o modo de dado (manual ou aleatório) e a interface.
