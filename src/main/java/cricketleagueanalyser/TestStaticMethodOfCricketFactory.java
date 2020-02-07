package cricketleagueanalyser;

import java.util.Map;

public class TestStaticMethodOfCricketFactory {

    public Map<String, CricketLeagueDAO> loadCricketCSVData(CricketLeagueAnalyser.BatOrBall batAndBall, String... CsvFilePath) throws CricketLeagueException {
        return CricketLeagueFactory.getCricketData(batAndBall, CsvFilePath);

    }
}
