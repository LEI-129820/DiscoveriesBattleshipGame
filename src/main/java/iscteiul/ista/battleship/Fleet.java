package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma frota de navios no jogo da Batalha Naval.
 * Implementa a interface {@link IFleet}, gerindo a adição, estado e localização
 * dos navios no tabuleiro.
 */
public class Fleet implements IFleet {
    /**
     * Imprime todos os navios fornecidos na consola.
     *
     * @param ships A lista de navios a imprimir.
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /**
     * Lista interna que armazena os navios que compõem a frota.
     */
    private List<IShip> ships;

    /**
     * Construtor por omissão.
     * Inicializa uma nova frota com uma lista vazia de navios.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Obtém a lista de todos os navios atualmente na frota.
     *
     * @return Uma lista de objetos {@link IShip} pertencentes à frota.
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um novo navio à frota, garantindo que as regras do jogo são respeitadas.
     * O navio só é adicionado se o limite de navios da frota não tiver sido excedido,
     * se estiver totalmente dentro dos limites do tabuleiro e se não houver risco de colisão.
     *
     * @param s O navio ({@link IShip}) a adicionar.
     * @return {@code true} se o navio for adicionado com sucesso, {@code false} caso contrário.
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Obtém todos os navios da frota que pertencem a uma determinada categoria.
     *
     * @param category A categoria do navio (ex: "Galeao", "Fragata").
     * @return Uma lista de navios que correspondem à categoria indicada.
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Obtém a lista de navios da frota que ainda não foram totalmente afundados.
     *
     * @return Uma lista de navios que continuam a flutuar.
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Procura um navio da frota que ocupe a posição especificada no tabuleiro.
     *
     * @param pos A posição ({@link IPosition}) a verificar.
     * @return O navio que ocupa a posição, ou {@code null} se não existir nenhum nessa coordenada.
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um determinado navio está totalmente contido dentro das fronteiras do tabuleiro.
     *
     * @param s O navio a ser verificado.
     * @return {@code true} se o navio estiver dentro do tabuleiro, {@code false} caso contrário.
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se existe risco de colisão (proximidade excessiva) entre um determinado navio
     * e os restantes navios já existentes na frota.
     *
     * @param s O navio a ser testado.
     * @return {@code true} se o navio estiver demasiado perto de um já existente, {@code false} caso contrário.
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Mostra o estado atual da frota, imprimindo todos os navios, os que ainda flutuam e a distribuição por categorias.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios da frota pertencentes a uma determinada categoria.
     *
     * @param category A categoria de navios de interesse.
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Imprime todos os navios da frota que ainda flutuam (que não foram totalmente afundados).
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios da frota.
     */
    void printAllShips() {
        printShips(ships);
    }

}
