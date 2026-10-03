package iscteiul.ista.battleship;

/**
 * Representa uma fragata (dimensão 4), um dos navios da frota na versão dos
 * Descobrimentos do jogo da Batalha Naval.
 * <p>
 * Com orientação norte ou sul, ocupa 4 posições em linhas consecutivas da
 * mesma coluna; com orientação este ou oeste, ocupa 4 posições em colunas
 * consecutivas da mesma linha, sempre a partir da posição de referência.
 *
 * @author LEI-129820
 * @see Ship
 */
public class Frigate extends Ship {
    /** Dimensão da fragata, isto é, o número de posições que ocupa. */
    private static final Integer SIZE = 4;

    /** Nome (categoria) deste tipo de navio. */
    private static final String NAME = "Fragata";

    /**
     * Cria uma fragata na posição e orientação indicadas.
     *
     * @param bearing orientação do navio (norte, sul, este ou oeste)
     * @param pos     posição de referência do navio (extremo superior
     *                esquerdo)
     * @throws IllegalArgumentException se a orientação não for norte, sul,
     *                                  este ou oeste
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Devolve a dimensão da fragata.
     *
     * @return {@code 4}
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}