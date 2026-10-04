# Notas de Git em CLI (Daniel)

## Conceitos
- **Working area:** onde edito os ficheiros.
- **Staging area:** o que preparei para o próximo commit (`git add`).
- **Repositório local:** os commits guardados no meu computador (`git commit`).
- **Repositório remoto:** o GitHub (`git push` envia, `git pull` traz).

## Comandos praticados
`init`, `clone`, `add`, `commit`, `push`, `pull`, `branch`, `switch`, `merge`, `rebase`, `stash`, `tag`.

## Resultados
- **Merge:** com `--no-ff` fica um commit de merge visível no grafo.
- **Rebase:** reaplica os commits por cima de outro ramo e deixa o histórico linear.
- **Conflito:** aconteceu quando dois ramos alteraram o mesmo ficheiro; resolvi à mão e fiz commit.
- **Stash:** guarda alterações temporárias e o `pop` recupera-as.

## Modelos de branching
- **Git Flow:** `main`, `develop`, `feature/*`, `release/*`, `hotfix/*`. Mais estruturado.
- **GitHub Flow:** `main` e ramos curtos por funcionalidade, integrados por PR. Mais simples.
- **O nosso grupo** usa o GitHub Flow.