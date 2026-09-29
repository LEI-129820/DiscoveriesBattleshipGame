package iscteiul.ista.battleship;

/**
 * Enumeração das orientações possíveis de um navio na grelha, cada uma
 * associada a um carácter: {@code 'n'} (norte), {@code 's'} (sul),
 * {@code 'e'} (este), {@code 'o'} (oeste) e {@code 'u'} (desconhecida).
 *
 * @author fba
 */
public enum Compass {
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');

    private final char c;

    /**
     * Cria uma orientação associada ao carácter indicado.
     *
     * @param c carácter que representa a orientação
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Devolve o carácter que representa a orientação.
     *
     * @return o carácter da orientação ({@code 'n'}, {@code 's'},
     *         {@code 'e'}, {@code 'o'} ou {@code 'u'})
     */
    public char getDirection() {
        return c;
    }

    /**
     * Devolve o carácter da orientação sob a forma de texto.
     *
     * @return o carácter da orientação como {@code String}
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um carácter na orientação correspondente.
     *
     * @param ch carácter a converter ({@code 'n'}, {@code 's'}, {@code 'e'}
     *           ou {@code 'o'})
     * @return a orientação correspondente ao carácter, ou {@link #UNKNOWN} se
     *         o carácter não for reconhecido
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
