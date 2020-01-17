package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import org.junit.Test;

public class CricketAnalyserTest {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnAveragesOfCricketersWhoPlayedIPL2019() {

        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
    }
}
