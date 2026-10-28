# Registo de utilização de IA

Cada entrada indica ferramenta, finalidade, prompt (ou resumo), o que foi mantido, o que foi alterado e como foi verificado.

## 1. ChatGPT — versão inicial do protótipo
- **Ferramenta:** ChatGPT.
- **Finalidade:** estruturar uma proposta de protótipo de outubro, redigir a documentação inicial e preparar código Java de demonstração, com base nos conteúdos Lab01–Lab04.
- **Prompt / resumo:** [COMPLETAR: colar o prompt principal ou resumi-lo em 2–3 linhas.]
- **Mantido:** a ideia do jogo, o mapa 0–30, as casas especiais previstas e as classes `Jogador`, `Jogo`, `Principal` e `Verificacoes` na primeira versão.
- **Alterado:** [COMPLETAR: o que o grupo mudou por sua iniciativa.]
- **Verificação:** o grupo compilou e executou o protótipo e as verificações. [COMPLETAR se for diferente.]

## 2. Claude — revisão e refatoração do protótipo
- **Ferramenta:** Claude (Anthropic).
- **Finalidade:** rever o protótipo face ao enunciado e corrigir os pontos em falta para o checkpoint de outubro.
- **Resumo do pedido:** comparar o zip com o enunciado; separar a consola das regras; suportar 2 a 4 jogadores; acrescentar o cabeçalho obrigatório em todos os ficheiros Java; atualizar a documentação.
- **Mantido:** as regras, o mapa e a estrutura de classes; a lógica de movimento e de ultrapassagem da casa 30.
- **Alterado pelo Claude:**
  - `Jogo` passou a usar `List<Jogador>` (2 a 4) e deixou de escrever na consola.
  - Foi criada a classe `ResultadoTurno`.
  - `Jogo.jogarTurno` passou a devolver o resultado e a lançar `IllegalStateException` depois do fim.
  - `Jogador.avancar` devolve `boolean` e deixou de validar o intervalo do dado, que passou para `Jogo`.
  - `Verificacoes` passou de 9 para 24 verificações, com 2, 3 e 4 jogadores e com estado inalterado após entrada inválida.
  - Atualização do README, do UML, das regras e da divisão de tarefas.
- **Verificação:** compilação com `javac -Xlint:all` sem avisos e execução de `Verificacoes` com 24/24 corretas. [COMPLETAR: o grupo deve ler o código e correr `Verificacoes` e `Principal` na sua máquina.]

## Código e materiais externos
Nenhum código externo. Os conteúdos Lab01–Lab04 da unidade curricular serviram de referência.
