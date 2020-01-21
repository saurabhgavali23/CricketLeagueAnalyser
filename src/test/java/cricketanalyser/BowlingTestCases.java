package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueDAO;
import cricketleagueanalyser.CricketLeagueException;
import cricketleagueanalyser.SortedFieldData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BowlingTestCases {

    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnNoOfRecordsWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            int noOfRecords = cricketLeagueAnalyser.loadBowlerCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            Assert.assertEquals(99, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnTopBowlingAverageWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBowlerCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> toBowlingAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.Avg);
            Assert.assertEquals(166.0, toBowlingAvg.get(0).avg, 0);
            Assert.assertEquals(0.0, toBowlingAvg.get(98).avg, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
