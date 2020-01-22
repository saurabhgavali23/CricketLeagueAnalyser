package cricketleagueanalyser;

import com.opencsv.bean.CsvBindByName;

public class BatsmanDAO {

    @CsvBindByName(column = "POS", required = true)
    public int pos;

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "mat", required = true)
    public int mat;

    @CsvBindByName(column = "inns", required = true)
    public int inns;

    @CsvBindByName(column = "NO", required = true)
    public int notOut;

    @CsvBindByName(column = "runs", required = true)
    public int runs;

    @CsvBindByName(column = "HS", required = true)
    public String highScore;

    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @CsvBindByName(column = "BF", required = true)
    public int ballsFaced;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "100", required = true)
    public int century;

    @CsvBindByName(column = "50", required = true)
    public int halfCentury;

    @CsvBindByName(column = "4s", required = true)
    public int four;

    @CsvBindByName(column = "6s", required = true)
    public int six;

    @Override
    public String toString() {
        return "BatsmanDAO{" +
                "pos='" + pos + '\'' +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", avg=" + avg +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four=" + four +
                ", six=" + six +
                '}';
    }

    public BatsmanDAO() {
    }

    public BatsmanDAO(int pos, String player, int mat, int inns, int notOut, int runs, String highScore, double avg, int ballsFaced, double strikeRate, int century, int halfCentury, int four, int six) {
        this.pos = pos;
        this.player = player;
        this.mat = mat;
        this.inns = inns;
        this.notOut = notOut;
        this.runs = runs;
        this.highScore = highScore;
        this.avg = avg;
        this.ballsFaced = ballsFaced;
        this.strikeRate = strikeRate;
        this.century = century;
        this.halfCentury = halfCentury;
        this.four = four;
        this.six = six;
    }
}
