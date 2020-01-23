package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class BowlerDAO {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "mat", required = true)
    public int mat;

    @CsvBindByName(column = "inns", required = true)
    public int inns;

    @CsvBindByName(column = "Ov", required = true)
    public double over;

    @CsvBindByName(column = "runs", required = true)
    public int runs;

    @CsvBindByName(column = "Wkts", required = true)
    public int wickets;

    @CsvBindByName(column = "BBI", required = true)
    public int bbi;

    @CsvBindByName(column = "Avg", required = true)
    public double ballAvg;

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
                ", mat=" + mat +
                ", inns=" + inns +
                ", over=" + over +
                ", runs=" + runs +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", ballAvg=" + ballAvg +
                ", eCon=" + eCon +
                ", strikeRate=" + strikeRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }

    public BowlerDAO() {
    }

    public BowlerDAO(int pos, String player, int mat, int inns, double over, int runs, int wickets, int bbi, double avg, double eCon, double strikeRate, int fourWicket, int fiveWicket) {
        this.pos = pos;
        this.player = player;
        this.mat = mat;
        this.inns = inns;
        this.over = over;
        this.runs = runs;
        this.wickets = wickets;
        this.bbi = bbi;
        this.ballAvg = avg;
        this.eCon = eCon;
        this.strikeRate = strikeRate;
        this.fourWicket = fourWicket;
        this.fiveWicket = fiveWicket;
    }
}

