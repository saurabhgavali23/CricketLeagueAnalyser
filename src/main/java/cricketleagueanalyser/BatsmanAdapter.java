package cricketleagueanalyser;

import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatsmanAdapter extends CricketLeagueAdapter {
    @Override
    public <E> Map<String, CricketLeagueDAO> loadCricketCSVData(String... csvFilePath) throws CricketLeagueException {
        Map<String, CricketLeagueDAO> cricketLeagueDAOMap = super.loadCricketCSVData(BatsmanDAO.class, csvFilePath[0]);
        if (csvFilePath.length == 2) {
            this.loadBowlerCSVData(cricketLeagueDAOMap, csvFilePath[1]);
        }
        return cricketLeagueDAOMap;
    }

    public <E> int loadBowlerCSVData(Map<String, CricketLeagueDAO> cricketLeagueDAOMap, String CsvFilePath) throws CricketLeagueException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilePath));) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<BowlerDAO> CSVList = csvBuilder.getListCsvFile(reader, BowlerDAO.class);

            StreamSupport.stream(CSVList.spliterator(), false)
                    .filter(cricketData -> cricketLeagueDAOMap.get(cricketData.player) != null)
                    .forEach(cricketData -> {
                        cricketLeagueDAOMap.get(cricketData.player).ballAvg = cricketData.ballAvg;
                        cricketLeagueDAOMap.get(cricketData.player).wickets = cricketData.wickets;});
            return cricketLeagueDAOMap.size();

        } catch (IOException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new CricketLeagueException(e.getMessage(),
                    CricketLeagueException.ExceptionType.INCORRECT_FILE_DATA);
        } catch (CSVBuilderException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
