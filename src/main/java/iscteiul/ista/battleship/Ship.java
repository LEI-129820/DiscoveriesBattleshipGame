package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe abstrata que representa um navio da frota no jogo da Batalha Naval
 * (versão dos Descobrimentos).
 * <p>
 * Um navio tem uma categoria (por exemplo, "galeao" ou "barca"), uma
 * orientação ({@link Compass}), uma posição de referência e a lista de
 * posições da grelha que ocupa. Cada subclasse concreta ({@link Galleon},
 * {@link Frigate}, {@link Carrack}, {@link Caravel} e {@link Barge}) define a
 * sua dimensão através de {@link #getSize()} e preenche a lista de posições.
 *
 * @author LEI-129820
 * @see IShip
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Cria um navio do tipo indicado (método fábrica).
     *
     * @param shipKind tipo de navio: "galeao", "fragata", "nau", "caravela"
     *                 ou "barca"
     * @param bearing  orientação do navio
     * @param pos      posição de referência do navio (extremo superior
     *                 esquerdo)
     * @return o navio criado, ou {@code null} se o tipo não for reconhecido
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Cria um navio com a categoria, orientação e posição indicadas. A lista
     * de posições ocupadas começa vazia e deve ser preenchida pelas subclasses.
     *
     * @param category categoria (nome) do navio
     * @param bearing  orientação do navio; não pode ser {@code null}
     * @param pos      posição de referência do navio; não pode ser
     *                 {@code null}
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Devolve a categoria (nome) do navio.
     *
     * @return a categoria do navio
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Devolve a lista de posições da grelha ocupadas pelo navio.
     *
     * @return a lista de posições ocupadas
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Devolve a posição de referência do navio.
     *
     * @return a posição de referência
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Devolve a orientação do navio.
     *
     * @return a orientação do navio
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Indica se o navio ainda está a flutuar, isto é, se pelo menos uma das
     * suas posições ainda não foi atingida.
     *
     * @return {@code true} se alguma posição do navio não foi atingida,
     *         {@code false} se o navio está afundado
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Devolve a linha mais alta (menor índice de linha) ocupada pelo navio.
     *
     * @return o menor índice de linha entre as posições do navio
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Devolve a linha mais baixa (maior índice de linha) ocupada pelo navio.
     *
     * @return o maior índice de linha entre as posições do navio
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Devolve a coluna mais à esquerda (menor índice de coluna) ocupada pelo
     * navio.
     *
     * @return o menor índice de coluna entre as posições do navio
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Devolve a coluna mais à direita (maior índice de coluna) ocupada pelo
     * navio.
     *
     * @return o maior índice de coluna entre as posições do navio
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Indica se o navio ocupa a posição dada.
     *
     * @param pos posição a verificar; não pode ser {@code null}
     * @return {@code true} se o navio ocupa a posição, {@code false} caso
     *         contrário
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Indica se este navio está demasiado perto de outro navio, isto é, se
     * alguma posição do outro navio é adjacente a uma posição deste.
     *
     * @param other o outro navio; não pode ser {@code null}
     * @return {@code true} se os navios estão demasiado próximos,
     *         {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Indica se este navio está demasiado perto de uma posição, isto é, se
     * alguma das suas posições é adjacente à posição dada.
     *
     * @param pos posição a verificar
     * @return {@code true} se alguma posição do navio é adjacente à posição
     *         dada, {@code false} caso contrário
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /**
     * Regista um tiro na posição dada. Se o navio ocupar essa posição, a
     * posição fica marcada como atingida; caso contrário, nada acontece.
     *
     * @param pos posição do tiro; não pode ser {@code null}
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }


    /**
     * Devolve uma representação textual do navio, no formato
     * {@code [categoria orientação posição]}.
     *
     * @return a representação textual do navio
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}
