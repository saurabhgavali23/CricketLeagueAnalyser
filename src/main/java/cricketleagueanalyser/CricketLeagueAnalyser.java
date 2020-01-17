package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

public class CricketLeagueAnalyser {

    List<IPLCSVData> IPLCSVList = null;

    public int loadCricketCSVData(String CsvFilePath) throws CricketLeagueException {

        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            IPLCSVList = csvBuilder.getListCsvFile(reader, IPLCSVData.class);
            return IPLCSVList.size();

        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.CSV_FILE_PROBLEM);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List getTopBattingAvgList() {

        List<IPLCSVData> sortedAvgList = IPLCSVList.stream()
                .sorted((bat1,bat2)-> (int) (bat2.avg - bat1.avg))
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
}
