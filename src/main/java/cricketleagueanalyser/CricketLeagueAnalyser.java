package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    public enum BatOrBall { BATTING, BALLING}
    List<CricketLeagueDAO> SORTEDLIST = null;

    private BatOrBall batAndBall;

    public CricketLeagueAnalyser(BatOrBall batAndBall) {
        this.batAndBall = batAndBall;
    }

    public int loadCricketCSVData(String CsvFilePath) throws CricketLeagueException{
        SORTEDLIST = CricketLeagueFactory.getCricketData(batAndBall,CsvFilePath);
        return SORTEDLIST.size();
    }

    public List getSortedData(SortedFieldData.Fields fieldName) {
        List sortedList = SORTEDLIST.stream()
                .sorted(new SortedFieldData().getSortedFields(fieldName))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);
        sortedList.stream().forEach(System.out::println);
        return sortedList;
    }
}
