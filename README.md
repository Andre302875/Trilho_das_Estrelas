# Trilho das Estrelas — Outubro 2026

Projeto de Programação Orientada a Objetos (UAL, 2026–2027) — protótipo inicial.
Grupo: André (30014704), Tomás (30017467) e Isaias (30017477).

## Requisitos
- Java (JDK) 11 ou superior. Sem Gradle, Maven nem bibliotecas externas.
- Ficheiros em UTF-8 (é o predefinido no IntelliJ IDEA).

## Compilar, correr e verificar (linha de comandos)
Na pasta do projeto:

```bash
javac -encoding UTF-8 -d out src/trilho/*.java
java -cp out trilho.Principal        # protótipo de consola com dados predefinidos
java -cp out trilho.Verificacoes     # verificações automáticas (termina com código 1 se alguma falhar)
```

## Abrir no IntelliJ IDEA
1. Descompactar o ZIP (não abrir o ZIP diretamente).
2. **Open** e escolher a pasta `Trilho_Das_Estrelas_Outubro_3_Jogadores`.
3. Em **File > Project Structure > Project**, selecionar um JDK 11 ou superior.
4. Clicar com o botão direito na pasta `src` > **Mark Directory as > Sources Root** (se ainda não estiver azul).
5. Abrir `src/trilho/Principal.java` e executar `main`. Para as verificações, executar `Verificacoes.java`.

## Estrutura
| Ficheiro | Papel |
|---|---|
| `Jogador.java` | Nome e posição de um jogador; avança sem ultrapassar a última casa. |
| `Jogo.java` | Regras: 2 a 4 jogadores, turnos, validação do dado, fim do jogo. Não escreve na consola. |
| `ResultadoTurno.java` | Descreve o que aconteceu num turno, para a interface o mostrar. |
| `Principal.java` | Protótipo de consola (toda a escrita no ecrã fica aqui). |
| `Verificacoes.java` | Verificações automáticas com dados predefinidos. |

Documentação em `docs/`: regras e mapa, UML inicial e divisão de tarefas. Uso de IA em `AI_USE.md`.

## Âmbito de outubro
- Regras, mapa e diagrama UML inicial.
- Classes com atributos privados, construtores e validação.
- Protótipo de consola com dados predefinidos: avanço, troca de vez e fim de jogo, para 2 a 4 jogadores.
- Verificações automáticas do movimento.
- Preparação do repositório GitHub e divisão de tarefas.

## O que ainda não está implementado
Interface Swing, escolha do modo de dado (manual ou aleatório), efeitos das casas especiais, reinício e saída do jogo. Ficam para a fase seguinte.

## Entrega
Relatório de outubro no Moodle até 29/10/2026, com o URL do repositório e a tag ou commit.
