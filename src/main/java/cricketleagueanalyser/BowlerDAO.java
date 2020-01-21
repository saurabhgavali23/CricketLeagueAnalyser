package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class BowlerDAO {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Mat", required = true)
    public int Mat;

    @CsvBindByName(column = "Inns", required = true)
    public int Inns;

    @CsvBindByName(column = "Ov", required = true)
    public double over;

    @CsvBindByName(column = "Runs", required = true)
    public int Runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "Econ", required = true)
    public double eCon;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicket;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWicket;


    @Override
    public String toString() {
        return "BowlerDAO{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", Mat=" + Mat +
                ", Inns=" + Inns +
                ", over=" + over +
                ", Runs=" + Runs +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", avg=" + avg +
                ", eCon=" + eCon +
                ", strikeRate=" + strikeRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }
}

