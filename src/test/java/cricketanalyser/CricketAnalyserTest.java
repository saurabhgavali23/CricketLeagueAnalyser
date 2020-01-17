package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueException;
import cricketleagueanalyser.IPLCSVData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketAnalyserTest {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactsheetMostWkts.csv";

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnNumberOfRecords() {

        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            Assert.assertEquals(100, noOfRecords);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnAveragesOfCricketersWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<IPLCSVData> topBattingAvg = cricketLeagueAnalyser.getTopBattingAvgList();
            Assert.assertEquals(83.2, topBattingAvg.get(0).avg, 0);
            Assert.assertEquals(0.0, topBattingAvg.get(99).avg, 0);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnStrikeRatesOfCricketersWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<IPLCSVData> topStrikeRateList = cricketLeagueAnalyser.getTopStrikeRateList();
            Assert.assertEquals(333.33, topStrikeRateList.get(0).strikeRate, 0);
            Assert.assertEquals(63.15, topStrikeRateList.get(99).strikeRate, 0);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnMaximum4sAnd6sOfBatsmanWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<IPLCSVData> max4sAnd6s = cricketLeagueAnalyser.getMax4sAnd6s();
            Assert.assertEquals("Andre Russell", max4sAnd6s.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", max4sAnd6s.get(99).player);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
