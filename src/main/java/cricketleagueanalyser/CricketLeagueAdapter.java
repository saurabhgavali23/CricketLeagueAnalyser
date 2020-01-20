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

public class CricketLeagueAdapter {

    List<BatsmanDAO> BATSMANLIST = new ArrayList<>();

    public List<BatsmanDAO> loadCricketCSVData(String CsvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            BATSMANLIST = csvBuilder.getListCsvFile(reader, BatsmanDAO.class);
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
