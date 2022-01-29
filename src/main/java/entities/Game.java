package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Game {
    private Team homeTeam;
    private int homeTeamGoals;
    private Team awayTeam;
    private int awayTeamGoals;
    private LocalDateTime dateTime;

    public Game(Team homeTeam, int homeTeamGoals, Team awayTeam, int awayTeamGoals, LocalDateTime dateTime) {
        this.homeTeam = homeTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeam = awayTeam;
        this.awayTeamGoals = awayTeamGoals;
        this.dateTime = dateTime;
    }

}
