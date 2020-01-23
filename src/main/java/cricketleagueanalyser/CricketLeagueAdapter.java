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

public abstract class CricketLeagueAdapter {

    public abstract <E> Map<String, CricketLeagueDAO> loadCricketCSVData(String... csvFilePath) throws CricketLeagueException;

    public <E> Map<String, CricketLeagueDAO> loadCricketCSVData(Class className, String CsvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> SORTEDLIST = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> CSVList = csvBuilder.getListCsvFile(reader, className);

            if (className.getName().equals("cricketleagueanalyser.BatsmanDAO")) {
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BatsmanDAO.class::cast)
                        .forEach(cricketData -> SORTEDLIST.put(cricketData.player, new CricketLeagueDAO(cricketData)));
            } else if (className.getName().equals("cricketleagueanalyser.BowlerDAO")) {
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BowlerDAO.class::cast)
                        .forEach(cricketData -> SORTEDLIST.put(cricketData.player, new CricketLeagueDAO(cricketData)));
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
