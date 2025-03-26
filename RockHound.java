import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

/**
 * 	RockHound class that extends Critter class. A RockHound gets the actors
 * 	to be processed in the same way as a Critter. It removes any rocks in
 * 	that list from the grid. A RockHound moves like a Critter.
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */

public class RockHound extends Critter
{
	public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Rock)
                a.removeSelfFromGrid();
        }
    }
}
