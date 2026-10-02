/**
 * Classes principais do jogo da Batalha Naval, na versão dos Descobrimentos
 * (<em>Discoveries Battleship Game</em>).
 * <p>
 * O pacote contém:
 * <ul>
 *   <li>os navios da frota: {@link iscteiul.ista.battleship.Ship} (classe base)
 *       e as suas subclasses {@link iscteiul.ista.battleship.Galleon},
 *       {@link iscteiul.ista.battleship.Frigate},
 *       {@link iscteiul.ista.battleship.Carrack},
 *       {@link iscteiul.ista.battleship.Caravel} e
 *       {@link iscteiul.ista.battleship.Barge};</li>
 *   <li>a grelha e a frota: {@link iscteiul.ista.battleship.Position} e
 *       {@link iscteiul.ista.battleship.Fleet};</li>
 *   <li>a lógica do jogo: {@link iscteiul.ista.battleship.Game} e
 *       {@link iscteiul.ista.battleship.Tasks};</li>
 *   <li>as orientações possíveis: {@link iscteiul.ista.battleship.Compass}.</li>
 * </ul>
 * O jogo decorre numa grelha 10x10, com uma frota de 11 navios (1 galeão,
 * 1 fragata, 2 naus, 3 caravelas e 4 barcas), em rajadas de 3 tiros por turno.
 *
 * @author LEI-129820
 */
package iscteiul.ista.battleship;