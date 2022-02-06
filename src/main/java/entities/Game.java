package entities;

import lombok.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Game {
    private String homeTeam;
    private int homeTeamGoals;
    private String visitorTeam;
    private int visitorTeamGoals;
    private Date date;

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return  format.format(date) + ": " +
                homeTeam +  " " +
                homeTeamGoals + " " +
                "x " +
                visitorTeamGoals + " " +
                visitorTeam + "\n"
                ;
    }
}
