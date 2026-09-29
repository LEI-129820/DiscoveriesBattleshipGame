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

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#getRow()
     */
    @Override
    public int getRow() {
        return row;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#getColumn()
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

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#equals(java.lang.Object)
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

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isAdjacentTo(battleship.IPosition)
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#occupy()
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#shoot()
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isOccupied()
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isHit()
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
