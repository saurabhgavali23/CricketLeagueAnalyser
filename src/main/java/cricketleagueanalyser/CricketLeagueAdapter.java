package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class CricketLeagueAdapter {

    List<CricketLeagueDAO> BATSMANLIST = new ArrayList<>();

    public <E> List<CricketLeagueDAO> loadCricketCSVData(String CsvFilePath, Class className) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> BATSMANLIST1 = csvBuilder.getListCsvFile(reader, className);

            StreamSupport.stream(BATSMANLIST1.spliterator(), false)
                    .map(BatsmanDAO.class::cast)
                    .forEach(censusData -> BATSMANLIST.add(new CricketLeagueDAO(censusData)));

            return BATSMANLIST;

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
