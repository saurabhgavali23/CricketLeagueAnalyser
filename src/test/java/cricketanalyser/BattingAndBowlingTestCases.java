package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BattingAndBowlingTestCases {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnBestBattingAndBowlingDataPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BATTING);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN,IPL2019_FACT_SHEET_MOST_WKTS);
            List<BatsmanDAO> bestBattingAndBowlingAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.BestBallingAndBattingAvg);
            Assert.assertEquals(83.2, bestBattingAndBowlingAvg.get(0).avg, 0);
            Assert.assertEquals(0.0, bestBattingAndBowlingAvg.get(99).avg, 0);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
