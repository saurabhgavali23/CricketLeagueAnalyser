package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<CricketLeagueDAO> SORTEDLIST = null;

    public int loadBatsmanCSVData(String CsvFilePath) throws CricketLeagueException {
        SORTEDLIST = new CricketLeagueAdapter().loadCricketCSVData(CsvFilePath, BatsmanDAO.class);
        return SORTEDLIST.size();
    }

    public int loadBowlerCSVData(String CsvFilePath) throws CricketLeagueException {
        SORTEDLIST = new CricketLeagueAdapter().loadCricketCSVData(CsvFilePath, BowlerDAO.class);
        return SORTEDLIST.size();
    }

    public List getSortedData(SortedFieldData.Fields fieldName) {
        List sortedList = SORTEDLIST.stream()
                .sorted(new SortedFieldData().getSortedFields(fieldName))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);
        return sortedList;
    }
}
