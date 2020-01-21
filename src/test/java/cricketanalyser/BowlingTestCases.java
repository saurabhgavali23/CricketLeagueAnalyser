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
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING);
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            Assert.assertEquals(99, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnTopBowlingAverageWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> topAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.Avg);
            Assert.assertEquals(166.0, topAvg.get(0).avg, 0);
            Assert.assertEquals(0.0, topAvg.get(98).avg, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnTopBowlingStrikeRateWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> toStrikeRate = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.StrikeRate);
            Assert.assertEquals(120.0, toStrikeRate.get(0).strikeRate, 0);
            Assert.assertEquals(0.0, toStrikeRate.get(98).strikeRate, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnTopBestEconomyWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> bestEconomy = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.BestEconomy);
            Assert.assertEquals(13.5, bestEconomy.get(0).eCon, 0);
            Assert.assertEquals(4.8, bestEconomy.get(98).eCon, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnBestStrikeRateWith5wAnd4wWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<CricketLeagueDAO> bestStrikeRateWith5wAnd4w = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.BestStrikeWith5wAnd4w);
            Assert.assertEquals("Lasith Malinga", bestStrikeRateWith5wAnd4w.get(0).player);
            Assert.assertEquals("Shivam Dube", bestStrikeRateWith5wAnd4w.get(98).player);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
