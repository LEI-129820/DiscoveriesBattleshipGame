# Battleship

Basic academic version of Battleship game to build upon.


# 🚢 DiscoveriesBattleshipGame

## Grupo: [Fuzzys]

### Curso
[LEI]

### Membros do Grupo

| Nº de Aluno | Nome                   |
|-------------|------------------------|
| [129820]    | [Dinis Sousa]          |
| [129851]    | [Duarte Oliveira]      |
| [129853]    | [Daniel Masqueiro]     |

---

## Sobre o Projeto

Este é um projeto desenvolvido no âmbito da unidade curricular de Engenharia de Software (ISCTE, 2026/2027), que consiste na implementação do jogo Batalha Naval, numa versão temática inspirada na época dos Descobrimentos — Discoveries Battleship Game. O backlog do projeto foi gerido em Issues do GitHub, com user stories e etiquetas de prioridade. A documentação foi feita com Javadoc e as páginas HTML geradas no IntelliJ ficam na pasta docs. O repositório usa GitHub Actions para sincronizar etiquetas e notificar os revisores dos Pull Requests.

## 🛳️ Frota

| Batalha Naval            | Descobrimentos   | English  | Dimensão | Nº de Navios |
|--------------------------|------------------|----------|----------|--------------|
| Porta-aviões             | Galeão           | Galleon  | 5        | 1            |
| Navio de 4 canhões       | Fragata          | Frigate  | 4        | 1            |
| Navio de 3 canhões       | Nau              | Carrack  | 3        | 2            |
| Navio de 2 canhões       | Caravela         | Caravel  | 2        | 3            |
| Submarino                | Barca            | Barge    | 1        | 4            |

## 🎮 Regras do Jogo

1. Cada jogador constrói duas grelhas 10x10: uma para a sua frota ("o seu mar") e outra para registar os tiros ao adversário ("o mar do adversário").
2. Os navios são posicionados na horizontal ou vertical, sem se tocarem entre si (podem estar encostados à borda da grelha).
3. Cada jogador, à vez, dispara **três tiros**, indicando as coordenadas (linha, coluna).
4. O adversário informa o resultado dos três tiros: acerto (e em que navio), afundamento, ou tiro na água.
5. Cada jogador regista na sua grelha do adversário os resultados conhecidos até então.
6. Vence quem afundar primeiro toda a frota adversária.

## 📚 Curiosidades Históricas (Navios dos Descobrimentos)

Podes explorar mais sobre as embarcações utilizadas na época dos Descobrimentos nos seguintes links:
- [Galeão](https://pt.wikipedia.org/wiki/Gale%C3%A3o) - O equivalente ao Porta-aviões.
- [Fragata](https://pt.wikipedia.org/wiki/Fragata) - O equivalente ao Navio de 4 canhões.
- [Nau](https://pt.wikipedia.org/wiki/Nau) - O equivalente ao Navio de 3 canhões.
- [Caravela](https://pt.wikipedia.org/wiki/Caravela) - O equivalente ao Navio de 2 canhões.

## 🔧 Tecnologias

- Java
- Git / GitHub
- IntelliJ IDEA Ultimate

## 🔀 Reflexão: trabalhar via web vs via IDE

Ao longo das duas partes do guião usámos o Git de duas formas: pela plataforma web do GitHub e pelo IntelliJ IDEA (com o terminal integrado). As duas chegam ao mesmo repositório, mas servem para coisas diferentes.

### Via plataforma web (GitHub)

Usámo-la sobretudo para **gerir e colaborar**: criar o *product backlog* em Issues com etiquetas, abrir e rever Pull Requests, aprovar e fazer merge, correr o GitHub Actions (Sync Labels e a notificação de revisores) e consultar o grafo em Insights → Network.

- **Vantagens:** não exige instalação, mostra de forma visual o que mudou em cada PR e é o sítio natural para a revisão e para a gestão do backlog. Também permitiu resolver um conflito simples (no `pom.xml`) com o editor de conflitos.
- **Limitações:** é pouco prática para alterar vários ficheiros de uma vez, não compila nem corre testes, e o editor web não ajuda a perceber o impacto de uma alteração no resto do código.

### Via IDE (IntelliJ IDEA) e linha de comandos

Usámo-la para **desenvolver e documentar**: clonar o repositório, criar ramos, escrever o Javadoc, gerar as páginas HTML em `docs/`, fazer commits de vários ficheiros e dar push.

- **Vantagens:** tem compilação, navegação no código, geração de Javadoc e uma ferramenta visual de resolução de conflitos. A linha de comandos dá controlo total sobre operações como `stash`, `rebase` e `tag`, e deixa um histórico de commits mais cuidado.
- **Limitações:** exige configuração (JDK, Maven, autenticação) e uma curva de aprendizagem maior. Não substitui a web para a gestão do backlog e a revisão de PRs.

### Quando preferir cada abordagem

| Situação | Abordagem preferível |
|---|---|
| Criar e priorizar user stories, etiquetas e Issues | Web |
| Rever um Pull Request e aprovar o merge | Web |
| Correções pequenas (uma frase no README, um typo) | Web |
| Escrever código, Javadoc ou testes | IDE |
| Alterações em vários ficheiros, com commits organizados | IDE |
| Conflitos complexos, `rebase`, `stash`, tags | IDE / linha de comandos |

### Conclusão

Não se trata de escolher uma só: o fluxo mais eficaz combina as duas. A **web** serve para planear, rever e decidir (Issues, PRs, Actions), e o **IDE** serve para construir e testar (código, Javadoc, conflitos). Foi assim que trabalhámos: cada tarefa nasceu num Issue, foi feita num ramo no IDE e voltou ao `main` por Pull Request revisto por um colega.

## 📖 Documentação (Javadoc)

O código está documentado com Javadoc. As páginas HTML geradas estão na pasta [`docs/`](docs/); para as ver, abra `docs/index.html` no browser.

### Como gerar a documentação no IntelliJ IDEA

1. Vá a **Tools** → **Generate JavaDoc...**
2. Defina as seguintes configurações:
    * **Scope:** `Whole project`
    * **Output directory:** `<pasta do projeto>/docs`
    * **Other command line arguments:** `-encoding UTF-8 -charset UTF-8 -docencoding UTF-8`
3. Clique em **Generate** e abra `docs/index.html`.

### Como documentar uma classe ou método

Escreva `/**` por cima da declaração e carregue em **Enter**: o IntelliJ gera automaticamente o esqueleto com `@param`, `@return` e `@throws`.


