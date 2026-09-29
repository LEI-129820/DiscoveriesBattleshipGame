package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define as regras e o estado do Discoveries Battleship Game.
 * Fornece métodos para interagir com o jogo em grelhas de 10x10 quadrados, 
 * incluindo disparos sobre os navios da época dos descobrimentos, estatísticas e impressão do estado.
 */
public interface IGame {
    
    /**
     * Efetua um disparo na grelha do adversário numa determinada posição.
     * 
     * @param pos A posição (IPosition) alvo do disparo na grelha 10x10.
     * @return O navio (IShip) atingido pelo disparo, ou null se for um "tiro na água".
     */
    IShip fire(IPosition pos);

    /**
     * Obtém a lista de todas as posições onde foram efetuados disparos válidos.
     * 
     * @return Uma lista (List) de objetos IPosition representando as posições dos disparos.
     */
    List<IPosition> getShots();

    /**
     * Obtém o número total de disparos repetidos efetuados pelo jogador.
     * 
     * @return O número de disparos repetidos.
     */
    int getRepeatedShots();

    /**
     * Obtém o número total de disparos inválidos efetuados.
     * 
     * @return O número de disparos inválidos.
     */
    int getInvalidShots();

    /**
     * Obtém o número de disparos que acertaram com sucesso em navios da frota adversária.
     * 
     * @return O número total de acertos (hits).
     */
    int getHits();

    /**
     * Obtém o número de navios que já foram totalmente afundados na grelha do oponente.
     * 
     * @return O número de navios afundados.
     */
    int getSunkShips();

    /**
     * Obtém o número de navios da frota que ainda não foram totalmente afundados. O primeiro a atingir todos os navios adversários ganha.
     * 
     * @return O número de navios restantes no jogo.
     */
    int getRemainingShips();

    /**
     * Imprime na consola o registo de todos os disparos válidos efetuados.
     */
    void printValidShots();

    /**
     * Imprime na consola o estado atual de todos os navios que compõem a frota do jogo.
     */
    void printFleet();
}
