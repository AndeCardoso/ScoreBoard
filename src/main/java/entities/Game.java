package entities;

import java.util.Date;

public class Game {
    private String homeTeam;
    private int homeTeamGoals;
    private String awayTeam;
    private int awayTeamGoals;
    private Date dateTime;

    public Game(String homeTeam, int homeTeamGoals, String awayTeam, int awayTeamGoals, Date dateTime) {
        this.homeTeam = homeTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeam = awayTeam;
        this.awayTeamGoals = awayTeamGoals;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return
                 dateTime + " " +
                 homeTeam + " " +
                 homeTeamGoals +
                 " X " +
                 awayTeamGoals + " " +
                 awayTeam
                 ;
    }


}
