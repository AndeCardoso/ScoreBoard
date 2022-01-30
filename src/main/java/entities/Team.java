package entities;

public class Team {

    private String name;
    private Game games;
    private int victory;
    private int ties;
    private int defeat;

    public Team(String name, Game games) {
        this.name = name;
        this.games = games;
    }
}
