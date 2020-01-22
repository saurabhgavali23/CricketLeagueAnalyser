package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CricketLeagueAdapter {

    Map<String, CricketLeagueDAO> SORTEDLIST = new HashMap<>();

    public <E> Map<String, CricketLeagueDAO> loadCricketCSVData(String CsvFilePath, Class className) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> CSVList = csvBuilder.getListCsvFile(reader, className);

            if (className.getName().equals("cricketleagueanalyser.BatsmanDAO")) {
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BatsmanDAO.class::cast)
                        .forEach(censusData -> SORTEDLIST.put(censusData.player, new CricketLeagueDAO(censusData)));
            } else if (className.getName().equals("cricketleagueanalyser.BowlerDAO")) {
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BowlerDAO.class::cast)
                        .forEach(censusData -> SORTEDLIST.put(censusData.player, new CricketLeagueDAO(censusData)));
            }

            return SORTEDLIST;

        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return null;
    }
}
