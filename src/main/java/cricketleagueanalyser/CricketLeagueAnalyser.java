package cricketleagueanalyser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

    List<BatsmanDAO> BATSMANLIST = null;

    public int loadBatsmanCSVData(String CsvFilePath) throws CricketLeagueException {
        BATSMANLIST = new CricketLeagueAdapter().loadCricketCSVData(CsvFilePath, BatsmanDAO.class);
        return BATSMANLIST.size();
    }

    public int loadBowlerCSVData(String CsvFilePath) throws CricketLeagueException {
        BATSMANLIST = new CricketLeagueAdapter().loadCricketCSVData(CsvFilePath, BowlerDAO.class);
        return BATSMANLIST.size();
    }

    public List getSortedData(SortedFieldData.Fields fieldName) {
        List<BatsmanDAO> sortedList = BATSMANLIST.stream()
                .sorted(new SortedFieldData().getSortedFields(fieldName))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);
        return sortedList;
    }
}
