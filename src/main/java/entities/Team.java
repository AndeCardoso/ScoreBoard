package entities;
import lombok.*;
import services.FileManager;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Team {

    private final String name;
    private ArrayList<Game> teamGames;
    private int victory;
    private int ties;
    private int defeat;
    private int goalsScore;
    private int points;

    private void printInfos() {
        System.out.print(name + "\n" +
                "- Games played: " + teamGames.size() + "\n" +
                "- Victory: " + victory + "\n" +
                "- Ties: " + ties + "\n" +
                "- Defeat: " + defeat + "\n" +
                "- Goals score: " + goalsScore + "\n" +
                "- Points: " + points + "\n");
    }

    public void getData() {
        this.teamGames = FileManager.getByTeamName(this.name);
        for (Game game : teamGames) {
            hasTie(game);
        }
        this.calculatePoints();
        printInfos();
    }

    private void hasTie(Game game) {
        if(game.getHomeTeamGoals() == game.getAwayTeamGoals()) {
            this.goalsScore += game.getAwayTeamGoals();
            this.ties += 1;
        } else {
            getAwayTeam(game);
            getHomeTeam(game);
        }
    }

    private void getHomeTeam(Game game) {
        if(game.getHomeTeam().equalsIgnoreCase(this.name)) {
            this.goalsScore += game.getHomeTeamGoals();
            if(game.getHomeTeamGoals() > game.getAwayTeamGoals()) {
                this.victory += 1;
            } else {
                this.defeat += 1;
            }
        }
    }

    private void getAwayTeam(Game game) {
        if(game.getAwayTeam().equalsIgnoreCase(this.name)) {
            this.goalsScore += game.getAwayTeamGoals();
            if(game.getHomeTeamGoals() < game.getAwayTeamGoals()) {
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
