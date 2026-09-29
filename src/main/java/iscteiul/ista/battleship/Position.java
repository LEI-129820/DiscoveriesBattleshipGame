package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma coordenada ou posição no tabuleiro da Batalha Naval.
 * Mantém o estado da posição (linha, coluna), verificando se está ocupada 
 * por um navio e se já foi atingida por um tiro.
 */
public class Position implements IPosition {
    
    /** Linha do tabuleiro. */
    private int row;
    
    /** Coluna do tabuleiro. */
    private int column;
    
    /** Indica se a posição está ocupada por um navio. */
    private boolean isOccupied;
    
    /** Indica se a posição já foi alvo de um tiro. */
    private boolean isHit;

    /**
     * Construtor da classe Position.
     * Inicializa a posição com uma linha e coluna específicas.
     * Por omissão, a posição começa sem estar ocupada nem atingida.
     *
     * @param row    A linha correspondente à posição.
     * @param column A coluna correspondente à posição.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Obtém a linha correspondente a esta posição.
     * 
     * @return O valor numérico da linha.
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Obtém a coluna correspondente a esta posição.
     * 
     * @return O valor numérico da coluna.
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Retorna o código hash para esta posição, com base na linha, coluna e estados de impacto e ocupação.
     *
     * @return O valor do código hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outro objeto para verificar se representam as mesmas coordenadas exatas.
     * 
     * @param otherPosition O objeto a comparar com esta posição.
     * @return {@code true} se representarem as mesmas coordenadas, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é imediatamente adjacente a uma outra posição (incluindo nas diagonais).
     * 
     * @param other A outra posição ({@link IPosition}) a verificar.
     * @return {@code true} se as posições forem adjacentes, {@code false} caso contrário.
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marca esta posição como estando ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Regista um tiro nesta posição, marcando-a como atingida.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Verifica se esta posição está atualmente ocupada por um navio.
     * 
     * @return {@code true} se estiver ocupada, {@code false} caso contrário.
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se esta posição já foi alvo de um tiro.
     * 
     * @return {@code true} se já foi atingida, {@code false} caso contrário.
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Retorna uma representação textual da posição.
     *
     * @return Uma string no formato "Linha = X Coluna = Y".
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
