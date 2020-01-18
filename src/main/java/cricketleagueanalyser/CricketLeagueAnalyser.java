package cricketleagueanalyser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class CricketLeagueAnalyser {

    List<IPLCSVData> IPLCSVList = null;

    public int loadCricketCSVData(String CsvFilePath) throws CricketLeagueException{
        IPLCSVList = new CricketLeagueAdapter().loadCricketCSVData(CsvFilePath);
        return IPLCSVList.size();
    }

    public List getTopBattingAvgList() {

        List<IPLCSVData> sortedAvgList = IPLCSVList.stream()
                .sorted((bat1, bat2) -> (int) (bat2.avg - bat1.avg))
                .collect(Collectors.toList());
        return sortedAvgList;
    }

    public List getTopStrikeRateList() {
        List<IPLCSVData> sortedStrikeRateList = IPLCSVList.stream()
                .sorted(comparing(iplCsvData -> iplCsvData.strikeRate))
                .collect(Collectors.toList());
        Collections.reverse(sortedStrikeRateList);
        return sortedStrikeRateList;
    }

    public List getMax4sAnd6s() {
        List<IPLCSVData> sorted6sAnd4sList = IPLCSVList.stream()
                .sorted(comparing(player -> player.six * 6 + player.four * 4))
                .collect(Collectors.toList());
        Collections.reverse(sorted6sAnd4sList);
        return sorted6sAnd4sList;
    }

    public List getBestStrikeRateWithMax4sAnd6s() {
        Comparator<IPLCSVData> comparator = Comparator.comparing(player -> player.six * 6 + player.four * 4);
        comparator = comparator.thenComparing(player -> player.strikeRate);
        Collections.sort(IPLCSVList, comparator.reversed());
        return IPLCSVList;
    }
}
