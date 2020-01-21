package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BattingTestCases {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnNumberOfRecords() {

        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        try {
            int noOfRecords = cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            Assert.assertEquals(100, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnAveragesOfCricketersWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<CricketLeagueDAO> topBattingAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.Avg);
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
            cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<CricketLeagueDAO> topStrikeRateList = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.StrikeRate);
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
            cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<CricketLeagueDAO> max4sAnd6s = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.FourAndSixAvg);
            Assert.assertEquals("Andre Russell", max4sAnd6s.get(0).player);
            Assert.assertEquals("Shakib Al Hasan", max4sAnd6s.get(99).player);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnGreatAverageWithBestStrikeRateWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<CricketLeagueDAO> greatAvgWithBestStrikeRate = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.GreatAvgWithBestStrikeRate);
            Assert.assertEquals("MS Dhoni", greatAvgWithBestStrikeRate.get(0).player);
            Assert.assertEquals("Tim Southee", greatAvgWithBestStrikeRate.get(99).player);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnMaxRunsWithBestAverageWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
            cricketLeagueAnalyser.loadBatsmanCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<CricketLeagueDAO> maxRunsWithBestAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.MaxRunsWithBestAvg);
            Assert.assertEquals("David Warner", maxRunsWithBestAvg.get(0).player);
            Assert.assertEquals("Tim Southee", maxRunsWithBestAvg.get(99).player);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
