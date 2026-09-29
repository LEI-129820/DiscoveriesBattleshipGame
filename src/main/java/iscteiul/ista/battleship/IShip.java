package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o comportamento de um navio no jogo da Batalha Naval.
 * <p>
 * Um navio tem uma categoria, uma dimensão, uma orientação e ocupa uma ou mais
 * posições da grelha, que podem ser atingidas por tiros.
 *
 * @author LEI-129820
 * @see Ship
 */
public interface IShip {

    /**
     * Devolve a categoria (nome) do navio.
     *
     * @return a categoria do navio
     */
    String getCategory();

    /**
     * Devolve a dimensão do navio, isto é, o número de posições que ocupa.
     *
     * @return a dimensão do navio
     */
    Integer getSize();

    /**
     * Devolve a lista de posições da grelha ocupadas pelo navio.
     *
     * @return a lista de posições ocupadas
     */
    List<IPosition> getPositions();

    /**
     * Devolve a posição de referência do navio.
     *
     * @return a posição de referência
     */
    IPosition getPosition();

    /**
     * Devolve a orientação do navio.
     *
     * @return a orientação do navio
     */
    Compass getBearing();

    /**
     * Indica se o navio ainda está a flutuar, isto é, se pelo menos uma das
     * suas posições ainda não foi atingida.
     *
     * @return {@code true} se o navio ainda flutua, {@code false} se está
     *         afundado
     */
    boolean stillFloating();

    /**
     * Devolve a linha mais alta (menor índice de linha) ocupada pelo navio.
     *
     * @return o menor índice de linha ocupado
     */
    int getTopMostPos();

    /**
     * Devolve a linha mais baixa (maior índice de linha) ocupada pelo navio.
     *
     * @return o maior índice de linha ocupado
     */
    int getBottomMostPos();

    /**
     * Devolve a coluna mais à esquerda (menor índice de coluna) ocupada pelo
     * navio.
     *
     * @return o menor índice de coluna ocupado
     */
    int getLeftMostPos();

    /**
     * Devolve a coluna mais à direita (maior índice de coluna) ocupada pelo
     * navio.
     *
     * @return o maior índice de coluna ocupado
     */
    int getRightMostPos();

    /**
     * Indica se o navio ocupa a posição dada.
     *
     * @param pos posição a verificar
     * @return {@code true} se o navio ocupa a posição, {@code false} caso
     *         contrário
     */
    boolean occupies(IPosition pos);

    /**
     * Indica se este navio está demasiado perto de outro navio.
     *
     * @param other o outro navio
     * @return {@code true} se os navios estão demasiado próximos,
     *         {@code false} caso contrário
     */
    boolean tooCloseTo(IShip other);

    /**
     * Indica se este navio está demasiado perto de uma posição.
     *
     * @param pos a posição a verificar
     * @return {@code true} se o navio está demasiado perto da posição,
     *         {@code false} caso contrário
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Regista um tiro na posição dada. Se o navio ocupar essa posição, esta
     * fica marcada como atingida.
     *
     * @param pos posição do tiro
     */
    void shoot(IPosition pos);
}
