package cricketleagueanalyser;

public class CricketLeagueException extends Exception {

    ExceptionType type;
     enum ExceptionType{

        CSV_FILE_PROBLEM, UNABLE_TO_PARSE, INCORRECT_FILE_DATA, NO_CENSUS_DATA;
    }

    public CricketLeagueException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
