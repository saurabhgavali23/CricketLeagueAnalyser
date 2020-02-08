package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;


public class BowlingMockTest {

    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    Map<String,CricketLeagueDAO> leagueDAOMap = new HashMap<>();

    @Mock
    TestStaticMethodOfCricketFactory testStaticMethodOfCricketFactory;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        BowlerDAO bowlerDAO = new BowlerDAO(3,"Ravichandran Ashwin",14,14,55,400,15,0,26.66,7.27,22,0,0);
        BowlerDAO bowlerDAO1 = new BowlerDAO(14,"Hardik Pandya",16,16,42.3,390,14,0,27.85,9.17,18.21,0,0);
        leagueDAOMap.put("Ravichandran Ashwin",new CricketLeagueDAO(bowlerDAO));
        leagueDAOMap.put("Hardik Pandya",new CricketLeagueDAO(bowlerDAO1));
        /*try{
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BATTING)).thenReturn(map);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnNoOfRecordsWhoPlayedIPL2019() {

        try {
            Map<String, CricketLeagueDAO> map = new HashMap<>();
            map.put("key1", new CricketLeagueDAO());
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING, testStaticMethodOfCricketFactory);
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BALLING, IPL2019_FACT_SHEET_MOST_WKTS))
                    .thenReturn(map);
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            Assert.assertEquals(1, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnTopBowlingAverageWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING,testStaticMethodOfCricketFactory);
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BALLING,IPL2019_FACT_SHEET_MOST_WKTS)).thenReturn(leagueDAOMap);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            List<BowlerDAO> topAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.BallAvg);
            Assert.assertEquals(27.85, topAvg.get(0).ballAvg, 0);
            Assert.assertEquals(26.66, topAvg.get(1).ballAvg, 0);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
