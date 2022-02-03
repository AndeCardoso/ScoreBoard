package entities;
import lombok.*;
import services.FileManager;
import java.util.ArrayList;

@Getter
@Setter
@RequiredArgsConstructor
public class Team {

    private final String name;
    private ArrayList<Game> teamGames;
    private int victory;
    private int ties;
    private int defeat;
    private int goalsScore;
    private int points;

    @Override
    public String toString() {
        return  name + "\n" +
                "- games played: " + teamGames.size() + "\n" +
                "- victory: " + victory + "\n" +
                "- ties: " + ties + "\n" +
                "- defeat: " + defeat + "\n" +
                "- goals score: " + goalsScore + "\n" +
                "- points: " + points + "\n"
                ;
    }

    public void getData() {
        this.teamGames = FileManager.getByTeamName(this.name);
        for (Game game : teamGames) {
            hasTie(game);
        }
        this.calculatePoints();
        System.out.println(this);
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
