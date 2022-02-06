package entities;

import lombok.*;
import services.FileManager;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Team {

    private final String name;
    private List<Game> teamGames = new ArrayList<Game>();
    private int victory;
    private int ties;
    private int defeat;
    private int goalsScore;
    private int points;

    public static void printInfos(String teamName) {
        if(FileManager.createTeams().get(teamName) != null) {
            Team team = FileManager.createTeams().get(teamName);
            System.out.print(team.name + " -" +
                    "\n Games played: " + team.teamGames.size() +
                    "\n Victory: " + team.victory +
                    "\n Ties: " + team.ties +
                    "\n Losses: " + team.defeat +
                    "\n Goals score: " + team.goalsScore +
                    "\n Points: " + team.points + "\n\n");
        } else {
            System.out.println("Team name invalid!");
        }
    }

    public void getData() {
        for (Game game : teamGames) {
            hasTie(game);
        }
        this.calculatePoints();
    }

    private void hasTie(Game game) {
        if(game.getHomeTeamGoals() == game.getVisitorTeamGoals()) {
            this.goalsScore += game.getVisitorTeamGoals();
            this.ties += 1;
        } else {
            getAwayTeam(game);
            getHomeTeam(game);
        }
    }

    private void getHomeTeam(Game game) {
        if(game.getHomeTeam().equalsIgnoreCase(this.name)) {
            this.goalsScore += game.getHomeTeamGoals();
            if(game.getHomeTeamGoals() > game.getVisitorTeamGoals()) {
                this.victory += 1;
            } else {
                this.defeat += 1;
            }
        }
    }

    private void getAwayTeam(Game game) {
        if(game.getVisitorTeam().equalsIgnoreCase(this.name)) {
            this.goalsScore += game.getVisitorTeamGoals();
            if(game.getHomeTeamGoals() < game.getVisitorTeamGoals()) {
                this.victory += 1;
            } else {
                this.defeat += 1;
            }
        }
    }

    private void calculatePoints(){
        this.points = (this.getVictory()*3 + this.getTies());
    }
}
