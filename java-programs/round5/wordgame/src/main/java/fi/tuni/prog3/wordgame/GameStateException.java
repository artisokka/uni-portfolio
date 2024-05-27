package fi.tuni.prog3.wordgame;

/**
 *
 * @author janik
 */
public class GameStateException extends Exception {

    /**
     * Creates a new instance of <code>GameStateException</code> without detail
     * message.
     */
    public GameStateException() {
    }

    /**
     * Constructs an instance of <code>GameStateException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public GameStateException(String msg) {
        super(msg);
    }
}
