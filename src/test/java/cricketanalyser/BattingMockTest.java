package cricketanalyser;

import cricketleagueanalyser.*;
import org.junit.Assert;
import org.junit.Before;
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
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CricketLeagueFactory.class)
public class BattingMockTest {

    private static final String IPL2019_FACT_SHEET_MOST_RUN = "./src/test/resources/IPL2019FactSheetMostRuns.csv";

    Map<String,CricketLeagueDAO> leagueDAOMap = new HashMap<>();

    @Mock
    TestStaticMethodOfCricketFactory testStaticMethodOfCricketFactory; // WithOut Static Method Test
    CricketLeagueFactory cricketLeagueFactoryMock; //With Static Method Test Using PowerMock

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        BatsmanDAO batsmanDAO = new BatsmanDAO(13,"MS Dhoni",15,12,7,416,"84*",83.2,309,134.62,0,3,22,23);
        BatsmanDAO batsmanDAO1 = new BatsmanDAO(15,"Rohit Sharma",15,15,1,405,"67",28.92,315,128.57,0,2,52,10);
        leagueDAOMap.put("MS Dhoni",new CricketLeagueDAO(batsmanDAO));
        leagueDAOMap.put("Rohit Sharma",new CricketLeagueDAO(batsmanDAO1));
        /*try{
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BATTING)).thenReturn(map);
        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnNumberOfRecords() {
        try {
            Map<String, CricketLeagueDAO> map = new HashMap<>();
            map.put("key1", new CricketLeagueDAO());

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

    @Test
    public void givenCricketSheetMostRuns_ShouldReturnAveragesOfCricketersWhoPlayedIPL2019() {

        try {
            CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser(CricketLeagueAnalyser.BatOrBall.BATTING,testStaticMethodOfCricketFactory);
            when(testStaticMethodOfCricketFactory.loadCricketCSVData(CricketLeagueAnalyser.BatOrBall.BATTING,IPL2019_FACT_SHEET_MOST_RUN)).thenReturn(leagueDAOMap);
            cricketLeagueAnalyser.loadCricketCSVData(IPL2019_FACT_SHEET_MOST_RUN);
            List<BatsmanDAO> topBattingAvg = cricketLeagueAnalyser.getSortedData(SortedFieldData.Fields.Avg);
            Assert.assertEquals(83.2, topBattingAvg.get(0).avg, 0);
            Assert.assertEquals(28.92, topBattingAvg.get(1).avg, 0);

        } catch (CricketLeagueException e) {
            e.printStackTrace();
        }
    }
}
