package cricketleagueanalyser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static java.util.Comparator.comparing;

public class SortedFieldData {

    public Map<Fields, Comparator<BatsmanDAO>> sortedField = null;

    public enum Fields {
        POS, PLAYER, Mat, Inns, NotOut, Runs, HighScore, Avg, BallFaced, StrikeRate, Century, HalfCentury,
        FourAndSixAvg, GreatAvgWithBestStrikeRate, MaxRunsWithBestAvg;
    }

    public SortedFieldData() {
        sortedField = new HashMap<>();
        this.sortedField.put(Fields.Avg, comparing(player -> player.avg));
        this.sortedField.put(Fields.Runs, comparing(player -> player.runs));
        this.sortedField.put(Fields.StrikeRate, comparing(iplCsvData -> iplCsvData.strikeRate));
        this.sortedField.put(Fields.FourAndSixAvg, comparing(player -> (player.four * 4 + player.six * 6)));
        this.sortedField.put(Fields.GreatAvgWithBestStrikeRate, this.sortedField.get(Fields.Avg).thenComparing(player -> player.strikeRate));
        this.sortedField.put(Fields.MaxRunsWithBestAvg, this.sortedField.get(Fields.Runs).thenComparing(player -> player.avg));
    }

    public Comparator<BatsmanDAO> getSortedFields(Fields fields) {
        return sortedField.get(fields);
    }
}
