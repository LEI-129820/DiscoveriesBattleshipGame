package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da interface {@link IGame} para o Discoveries Battleship Game.
 * Esta classe gere a lógica e o estado de uma partida na época dos Descobrimentos,
 * controlando a frota numa grelha de 10x10 quadrados, os disparos efetuados e 
 * as estatísticas de jogo (navios históricos afundados, disparos inválidos, etc.).
 *
 * @author fba
 */
public class Game implements IGame {
    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    /**
     * Construtor que inicializa uma nova partida com a frota especificada.
     *
     * @param fleet A frota (IFleet) contendo os navios posicionados na grelha.
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Efetua um disparo sobre a frota adversária numa determinada coordenada.
     * Regista se o tiro foi inválido, repetido ou se acertou num navio.
     *
     * @param pos A posição (IPosition) na grelha 10x10 onde o disparo incide.
     * @return O navio (IShip) caso o disparo tenha resultado no seu afundamento total, ou null caso contrário.
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Devolve o histórico de posições onde ocorreram disparos válidos e não repetidos.
     *
     * @return Uma lista (List) com as posições (IPosition) dos disparos aceites.
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Devolve a quantidade de vezes que o jogador tentou disparar numa posição previamente atingida.
     *
     * @return O número total de disparos repetidos.
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Devolve a quantidade de disparos realizados fora dos limites da grelha de 10x10.
     *
     * @return O número de disparos considerados inválidos.
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Devolve o número total de disparos que atingiram com sucesso algum navio da frota.
     *
     * @return O contador de impactos diretos (hits).
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Devolve o número de navios que já não se encontram a flutuar.
     *
     * @return A quantidade de navios totalmente afundados.
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Verifica quantos navios da frota ainda estão a flutuar no jogo.
     *
     * @return O número de navios restantes.
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime na consola a representação visual de um tabuleiro de 10x10,
     * assinalando posições específicas com um marcador.
     *
     * @param positions Lista das posições (IPosition) que deverão conter o marcador.
     * @param marker O carácter (Character) a ser exibido nas coordenadas indicadas.
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }

    /**
     * Imprime a grelha exibindo todos os disparos válidos efetuados, marcados com 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime a grelha revelando a disposição atual da frota no mar, assinalando os navios com '#'.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
