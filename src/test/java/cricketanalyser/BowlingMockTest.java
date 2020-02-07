package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


public class BowlingMockTest {

    private static final String IPL2019_FACT_SHEET_MOST_WKTS = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Mock
    TestStaticMethodOfCricketFactory testStaticMethodOfCricketFactory;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void givenCricketSheetMostWkts_ShouldReturnNoOfRecordsWhoPlayedIPL2019() {

        try {
            Map<String, CricketLeagueDAO> map = new HashMap<>();
            map.put("aldj", new CricketLeagueDAO());
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BALLING, testStaticMethodOfCricketFactory);
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BALLING, IPL2019_FACT_SHEET_MOST_WKTS))
                    .thenReturn(map);
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_WKTS);
            Assert.assertEquals(1, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
