package iscteiul.ista.battleship;

/**
 * Representa uma barca, o menor navio da frota (dimensão 1), na versão dos
 * Descobrimentos do jogo da Batalha Naval.
 * <p>
 * Ocupa uma única posição, pelo que a orientação não altera as posições
 * ocupadas.
 *
 * @author LEI-129820
 * @see Ship
 */
public class Barge extends Ship {
    /** Dimensão da barca, isto é, o número de posições que ocupa. */
    private static final Integer SIZE = 1;

    /** Nome (categoria) deste tipo de navio. */
    private static final String NAME = "Barca";

    /**
     * Cria uma barca na posição indicada.
     *
     * @param bearing orientação da barca
     * @param pos     posição ocupada pela barca
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Devolve a dimensão da barca.
     *
     * @return {@code 1}
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}