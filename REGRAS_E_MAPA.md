# Regras e mapa — Trilho das Estrelas

**Nome:** Trilho das Estrelas. **Tema:** corrida espacial por um percurso de estrelas.

## Regras
1. Jogam de 2 a 4 jogadores. O protótipo de outubro corre com os valores 2, 3 e 4 nas verificações.
2. Cada jogador começa na casa 0.
3. Jogam à vez, pela ordem em que foram registados, e avançam o número de casas indicado por um dado de 1 a 6.
4. Podem existir vários jogadores na mesma casa (casas partilhadas).
5. O objetivo é chegar **exatamente à casa 30**. Se o dado ultrapassar a casa 30, o jogador não avança e a vez passa ao seguinte.
6. Ganha o primeiro jogador a chegar à casa 30 e o jogo termina.
7. Um dado inválido (fora de 1 a 6) é rejeitado e não altera o estado do jogo.

**Por decidir (novembro):** como garantir que o jogo não é infinito (por exemplo, um limite de rondas). Com chegada exata, o jogo termina quase sempre, mas não há um limite.

## Mapa (0 a 30)
```text
INÍCIO [00]--[01]--[02]--[03]--[04]--[05*]--[06]--[07]--[08]--[09]--[10]
       [11*]--[12]--[13]--[14*]--[15]--[16]--[17]--[18]--[19*]--[20]
       [21]--[22*]--[23]--[24]--[25]--[26]--[27*]--[28]--[29]--[30] FIM
```
O mapa é uma representação linear em três linhas, não uma ligação em serpentina. As casas com `*` são especiais.

## Casas especiais previstas (não implementadas em outubro)
- 5 → 9: avanço
- 11 → 7: recuo
- 14 → 18: avanço
- 19 → 15: recuo
- 22 → 26: avanço
- 27 → 23: recuo

Nenhum destino (9, 7, 18, 15, 26, 23) é uma casa especial, por isso não há efeitos encadeados.
