package cricketleagueanalyser;

import java.util.Map;

public class CricketLeagueFactory {

    public static Map<String, CricketLeagueDAO> getCricketData(CricketLeagueAnalyser.BatOrBall batOrBall, String... csvFilePath) throws CricketLeagueException {
        if (batOrBall.equals(CricketLeagueAnalyser.BatOrBall.BATTING))
            return new BatsmanAdapter().loadCricketCSVData(csvFilePath);
        else if (batOrBall.equals(CricketLeagueAnalyser.BatOrBall.BALLING))
            return new BowlerAdapter().loadCricketCSVData(csvFilePath);

        throw new CricketLeagueException("Unkown Field", CricketLeagueException.ExceptionType.UNKNOWN_FIELD);
    }
}