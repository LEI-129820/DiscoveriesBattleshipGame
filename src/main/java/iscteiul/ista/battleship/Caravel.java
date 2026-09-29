/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Representa uma Caravela, um tipo específico de navio na Batalha Naval dos Descobrimentos.
 * Este navio ocupa 2 posições no tabuleiro e é posicionado em linha reta (vertical ou horizontal)
 * consoante a sua orientação.
 */
public class Caravel extends Ship {
    
    /** O tamanho ocupado pela Caravela (número de posições no tabuleiro). */
    private static final Integer SIZE = 2;
    
    /** O nome da categoria deste navio. */
    private static final String NAME = "Caravela";

    /**
     * Construtor da classe Caravel.
     * Cria uma nova Caravela orientada e posicionada a partir de um ponto inicial no tabuleiro.
     *
     * @param bearing the bearing where the Caravel heads to
     * @param pos     initial point for positioning the Caravel
     * @throws NullPointerException     Se a orientação fornecida (bearing) for nula.
     * @throws IllegalArgumentException Se a orientação fornecida for inválida.
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
