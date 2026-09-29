package iscteiul.ista.battleship;

/**
 * Representa um Galeão, um tipo específico de navio na Batalha Naval dos Descobrimentos.
 * Este navio tem a forma de um "T" e ocupa 5 posições no tabuleiro, variando a sua 
 * disposição geométrica consoante a orientação (Norte, Sul, Este, Oeste).
 */
public class Galleon extends Ship {
    
    /** O tamanho ocupado pelo Galeão (número de posições no tabuleiro). */
    private static final Integer SIZE = 5;
    
    /** O nome da categoria deste navio. */
    private static final String NAME = "Galeao";

    /**
     * Construtor da classe Galleon.
     * Cria um novo Galeão com uma orientação e posição de referência específicas.
     *
     * @param bearing A orientação do navio (Norte, Sul, Este, Oeste).
     * @param pos     A posição de referência a partir da qual o navio é construído no tabuleiro.
     *                Nota: Consoante a orientação (Sul ou Este), as posições ocupadas podem
     *                estender-se para colunas à esquerda deste ponto.
     * @throws IllegalArgumentException Se a orientação fornecida for inválida.
     * @throws NullPointerException     Se a orientação fornecida (bearing) for nula.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Obtém o tamanho deste navio em número de posições ocupadas no tabuleiro.
     * 
     * @return O tamanho do Galeão (5 posições).
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando está orientado para Norte.
     *
     * @param pos A posição de referência inicial.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando está orientado para Sul.
     * Nota: Utiliza colunas à esquerda da posição de referência para completar a forma em "T".
     *
     * @param pos A posição de referência inicial.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando está orientado para Este.
     * Nota: Utiliza colunas à esquerda da posição de referência para completar a forma em "T".
     *
     * @param pos A posição de referência inicial.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as posições ocupadas pelo Galeão quando está orientado para Oeste.
     *
     * @param pos A posição de referência inicial.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
