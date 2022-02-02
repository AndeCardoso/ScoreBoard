package entities;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Game {
    private String homeTeam;
    private int homeTeamGoals;
    private String awayTeam;
    private int awayTeamGoals;
    private Date date;

}
