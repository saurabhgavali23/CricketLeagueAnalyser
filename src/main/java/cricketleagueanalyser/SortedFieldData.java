package cricketleagueanalyser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.Comparator.comparing;

public class SortedFieldData {

    Map<Fields, Comparator<CricketLeagueDAO>> sortedField = null;

    public enum Fields {
        Runs, Avg, BallAvg, StrikeRate, FourAndSixAvg, GreatAvgWithBestStrikeRate, MaxRunsWithBestAvg, BestEconomy,
        BestStrikeWith5wAnd4w, FiveWicketAndFourWicket, Wickets, MaxWktsWithBestBallingAvg;
    }

    public SortedFieldData() {
        sortedField = new HashMap<>();
        this.sortedField.put(Fields.Avg, comparing(player -> player.avg));
        this.sortedField.put(Fields.BallAvg, comparing(player -> player.ballAvg));
        this.sortedField.put(Fields.Runs, comparing(player -> player.runs));
        this.sortedField.put(Fields.BestEconomy, comparing(player -> player.eCon));
        this.sortedField.put(Fields.Wickets, comparing(player -> player.wickets));
        this.sortedField.put(Fields.StrikeRate, comparing(iplCsvData -> iplCsvData.strikeRate));
        this.sortedField.put(Fields.FourAndSixAvg, comparing(player -> (player.four * 4 + player.six * 6)));
        this.sortedField.put(Fields.MaxWktsWithBestBallingAvg, this.sortedField.get(Fields.Wickets).thenComparing(player -> player.ballAvg));
        this.sortedField.put(Fields.FiveWicketAndFourWicket, comparing(player -> player.fiveWicket * 5 + player.fourWicket * 4));
        this.sortedField.put(Fields.GreatAvgWithBestStrikeRate, this.sortedField.get(Fields.Avg).thenComparing(player -> player.strikeRate));
        this.sortedField.put(Fields.MaxRunsWithBestAvg, this.sortedField.get(Fields.Runs).thenComparing(player -> player.avg));
        this.sortedField.put(Fields.BestStrikeWith5wAnd4w, this.sortedField.get(Fields.FiveWicketAndFourWicket).thenComparing(player -> player.strikeRate));
    }

    public Comparator<CricketLeagueDAO> getSortedFields(Fields fields) {
        return sortedField.get(fields);
    }
}
