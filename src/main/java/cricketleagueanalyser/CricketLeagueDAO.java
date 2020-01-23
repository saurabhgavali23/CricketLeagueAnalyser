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

    public double over;
    public double ballAvg;
    public int wickets;
    public int bbi;
    public double eCon;
    public int fourWicket;
    public int fiveWicket;

    public CricketLeagueDAO(BatsmanDAO batsmanDAO) {

        pos = batsmanDAO.pos;
        player = batsmanDAO.player;
        mat = batsmanDAO.mat;
        inns = batsmanDAO.inns;
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
        ballAvg = bowlerDAO.ballAvg;
        mat = bowlerDAO.mat;
        inns = bowlerDAO.inns;
        over = bowlerDAO.over;
        runs = bowlerDAO.runs;
        wickets = bowlerDAO.wickets;
        bbi = bowlerDAO.bbi;
        eCon = bowlerDAO.eCon;
        strikeRate = bowlerDAO.strikeRate;
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
                ", ballAvg=" + avg +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four=" + four +
                ", six=" + six +
                ", over=" + over +
                ", ballAvg=" + ballAvg +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", eCon=" + eCon +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }

    public Object getCricketDTO(CricketLeagueAnalyser.BatOrBall batAndBall) {
        if (batAndBall.equals(CricketLeagueAnalyser.BatOrBall.BATTING))
            return new BatsmanDAO(pos, player, mat, inns, notOut, runs, highScore, avg, ballsFaced, strikeRate, century, halfCentury, four, six);
        return new BowlerDAO(pos, player, mat, inns, over, runs, wickets, bbi, ballAvg, eCon, strikeRate, fourWicket, fiveWicket);
    }
}
