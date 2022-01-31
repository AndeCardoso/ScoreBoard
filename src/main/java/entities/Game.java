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

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
