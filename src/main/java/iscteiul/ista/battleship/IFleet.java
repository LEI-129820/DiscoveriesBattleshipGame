package iscteiul.ista.battleship;

import java.util.List;

/**
 * Define o contrato para uma frota de navios no jogo da Batalha Naval.
 */
public interface IFleet {
    
    /**
     * Tamanho da grelha do tabuleiro da Batalha Naval (10x10).
     */
    Integer BOARD_SIZE = 10;
    
    /**
     * Número máximo de navios permitidos numa frota.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Obtém a lista de todos os navios pertencentes à frota.
     * 
     * @return Uma lista de objetos {@link IShip}.
     */
    List<IShip> getShips();

    /**
     * Adiciona um navio à frota, desde que cumpra as regras de limite, fronteiras e colisão.
     * 
     * @param s O navio ({@link IShip}) a adicionar.
     * @return {@code true} se o navio for adicionado com sucesso, {@code false} caso contrário.
     */
    boolean addShip(IShip s);

    /**
     * Obtém os navios da frota que correspondem a uma determinada categoria.
     * 
     * @param category A categoria do navio (ex: "Galeao", "Fragata").
     * @return Uma lista de navios ({@link IShip}) pertencentes à categoria indicada.
     */
    List<IShip> getShipsLike(String category);

    /**
     * Obtém a lista de navios que ainda não foram totalmente afundados.
     * 
     * @return Uma lista de navios que continuam a flutuar.
     */
    List<IShip> getFloatingShips();

    /**
     * Procura um navio da frota que ocupe a posição especificada no tabuleiro.
     * 
     * @param pos A posição ({@link IPosition}) a verificar.
     * @return O navio que ocupa a posição, ou {@code null} se não existir nenhum nessa coordenada.
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime na consola o estado atual da frota, incluindo a lista de todos os navios,
     * os navios a flutuar e a organização por categorias.
     */
    void printStatus();
}
