package cricketanalyser;

import cricketleagueanalyser.CricketLeagueAnalyser;
import cricketleagueanalyser.CricketLeagueDAO;
import cricketleagueanalyser.CricketLeagueException;
import cricketleagueanalyser.CricketLeagueFactory;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;


public class BattingMockTest {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";

    @Mock
    CricketLeagueFactory cricketLeagueFactoryMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Test
    public void givenCricketSheetMostRuns_ShouldReturnNumberOfRecords() {
        try {
            Map<String, CricketLeagueDAO> map = new HashMap<>();
            map.put("aldj", new CricketLeagueDAO());
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(cricketLeagueFactoryMock,CricketLeagueAnalyser.BatOrBall.BATTING);
            when(cricketLeagueFactoryMock.getCricketData(CricketLeagueAnalyser.BatOrBall.BATTING, IPL2019_FACT_SHEET_MOST_RUN))
                    .thenReturn(map);
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            Assert.assertEquals(1, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
