package cricketleagueanalyser;

public class CricketLeagueException extends Exception {

    ExceptionType type;

    enum ExceptionType {

        FILE_PROBLEM, UNABLE_TO_PARSE, INCORRECT_FILE_DATA;
    }

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
