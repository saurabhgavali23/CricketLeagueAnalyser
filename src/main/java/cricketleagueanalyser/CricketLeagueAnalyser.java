package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                .sorted(Comparator.comparing(iplCsvData -> iplCsvData.avg))
                .collect(Collectors.toList());
        Collections.reverse(sortedAvgList);
        return sortedAvgList;
    }
}
