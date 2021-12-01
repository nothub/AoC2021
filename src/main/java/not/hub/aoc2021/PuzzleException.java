package not.hub.aoc2021;

public class PuzzleException extends IllegalStateException {

    public PuzzleException(String s) {
        super(s);
    }

    public PuzzleException(String message, Throwable cause) {
        super(message, cause);
    }

}
