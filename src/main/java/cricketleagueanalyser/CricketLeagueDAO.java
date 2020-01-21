package cricketleagueanalyser;

public class CricketLeagueDAO {

    public int pos;
    public String player;
    public int mat;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public double avg;
    public int ballsFaced;
    public double strikeRate;
    public int century;
    public int halfCentury;
    public int four;
    public int six;

    //public int pos;
    // public String player;
    // public int mat;
    // public int Inns;
    public double over;
    // public int runs;
    public int wickets;
    public int bbi;
    // public double avg;
    public double eCon;
    public double ballStrikeRate;
    public int fourWicket;
    public int fiveWicket;

    public CricketLeagueDAO() {
    }

    public CricketLeagueDAO(BatsmanDAO batsmanDAO) {

        pos = batsmanDAO.pos;
        player = batsmanDAO.player;
        mat = batsmanDAO.mat;
        inns = batsmanDAO.Inns;
        notOut = batsmanDAO.notOut;
        runs = batsmanDAO.runs;
        highScore = batsmanDAO.highScore;
        avg = batsmanDAO.avg;
        ballsFaced = batsmanDAO.ballsFaced;
        strikeRate = batsmanDAO.strikeRate;
        century = batsmanDAO.century;
        halfCentury = batsmanDAO.halfCentury;
        four = batsmanDAO.four;
        six = batsmanDAO.six;
    }

    public CricketLeagueDAO(BowlerDAO bowlerDAO) {
        pos = bowlerDAO.pos;
        player = bowlerDAO.player;
        avg = bowlerDAO.avg;
        mat = bowlerDAO.Mat;
        inns = bowlerDAO.Inns;
        over = bowlerDAO.over;
        runs = bowlerDAO.Runs;
        wickets = bowlerDAO.wickets;
        bbi = bowlerDAO.bbi;
        eCon = bowlerDAO.eCon;
        ballStrikeRate = bowlerDAO.ballStrikeRate;
        fourWicket = bowlerDAO.fourWicket;
        fiveWicket = bowlerDAO.fiveWicket;
    }

    @Override
    public String toString() {
        return "CricketLeagueDAO{" +
                "pos=" + pos +
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
                ", over=" + over +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", eCon=" + eCon +
                ", ballStrikeRate=" + ballStrikeRate +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }
}
