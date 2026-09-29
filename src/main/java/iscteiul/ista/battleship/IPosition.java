package iscteiul.ista.battleship;

/**
 * Define o contrato para uma posição (coordenada) no tabuleiro da Batalha Naval.
 * 
 * @author fba
 */
public interface IPosition {
    
    /**
     * Obtém a linha correspondente a esta posição.
     * 
     * @return O valor numérico da linha.
     */
    int getRow();

    /**
     * Obtém a coluna correspondente a esta posição.
     * 
     * @return O valor numérico da coluna.
     */
    int getColumn();

    /**
     * Compara esta posição com outro objeto para verificar se são iguais.
     * 
     * @param other O objeto a comparar com esta posição.
     * @return {@code true} se as posições representarem as mesmas coordenadas exatas, {@code false} caso contrário.
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é imediatamente adjacente a uma outra posição (incluindo diagonais).
     * 
     * @param other A outra posição ({@link IPosition}) a verificar.
     * @return {@code true} se as posições forem adjacentes, {@code false} caso contrário.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como estando ocupada por um navio.
     */
    void occupy();

    /**
     * Regista um tiro nesta posição, marcando-a como atingida.
     */
    void shoot();

    /**
     * Verifica se esta posição está atualmente ocupada por um navio.
     * 
     * @return {@code true} se estiver ocupada, {@code false} caso contrário.
     */
    boolean isOccupied();

    /**
     * Verifica se esta posição já foi alvo de um tiro.
     * 
     * @return {@code true} se já foi atingida pelo adversário, {@code false} caso contrário.
     */
    boolean isHit();
}
