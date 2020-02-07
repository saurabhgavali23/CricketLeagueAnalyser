package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CricketLeagueFactory.class)
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
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BATTING, new TestStaticMethodOfCricketFactory());

            mockStatic(CricketLeagueFactory.class);
            PowerMockito.when(cricketLeagueFactoryMock.getCricketData(CricketLeagueAnalyser.BatOrBall.BATTING, IPL2019_FACT_SHEET_MOST_RUN))
                    .thenReturn(map);
            int noOfRecords = cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            Assert.assertEquals(1, noOfRecords);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
