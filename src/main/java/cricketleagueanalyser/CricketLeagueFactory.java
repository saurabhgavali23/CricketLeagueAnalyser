package cricketleagueanalyser;

import java.util.List;

public class CricketLeagueFactory {

    public static <E> List<CricketLeagueDAO> getCricketData(CricketLeagueAnalyser.BatOrBall batOrBall, String csvFilePath) throws CricketLeagueException {
        if (batOrBall.equals(CricketLeagueAnalyser.BatOrBall.BATTING))
            return new CricketLeagueAdapter().loadCricketCSVData(csvFilePath, BatsmanDAO.class);
        else if (batOrBall.equals(CricketLeagueAnalyser.BatOrBall.BALLING))
            return new CricketLeagueAdapter().loadCricketCSVData(csvFilePath, BowlerDAO.class);

        throw new CricketLeagueException("Unkown Field", CricketLeagueException.ExceptionType.UNKNOWN_FIELD);
    }
}
