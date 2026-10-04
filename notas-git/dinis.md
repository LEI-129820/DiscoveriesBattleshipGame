# Notas de Git em CLI (dinis)

## Conceitos
- **Working area:** onde edito os ficheiros.
- **Staging area:** o que preparei para o próximo commit (`git add`).
- **Repositório local:** os commits guardados no meu computador (`git commit`).
- **Repositório remoto:** o GitHub (`git push` envia, `git pull` traz).

## Comandos praticados
`init`, `clone`, `add`, `commit`, `push`, `pull`.

## Modelos de branching
- **Git Flow:** `main`, `develop`, `feature/*`, `release/*`, `hotfix/*`. Mais estruturado.
- **GitHub Flow:** `main` e ramos curtos por funcionalidade, integrados por PR. Mais simples.
- **O nosso grupo** usa o GitHub Flow.
- experimentei merge

## Resultados
- **pull:** trouxe o `main` atualizado antes de criar o ramo.
- **merge:** com `--no-ff` ficou um commit de merge visível no grafo.
- **rebase:** reaplicou o commit de um ramo por cima de outro e deixou o histórico linear.
- **conflito:** dois ramos criaram o mesmo ficheiro com conteúdos diferentes; resolvi à mão e fiz commit.
- **stash:** guardou uma alteração temporária e o `pop` recuperou-a.
- **tag:** criei uma tag anotada local e apaguei-a (a release do grupo vem no fim).
