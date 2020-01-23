package cricketleagueanalyser;

import java.util.Map;

public class BowlerAdapter extends CricketLeagueAdapter{
    @Override
    public <E> Map<String, CricketLeagueDAO> loadCricketCSVData(String... csvFilePath) throws CricketLeagueException {
        return super.loadCricketCSVData(BowlerDAO.class,csvFilePath[0]);
    }
}