import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * 	KingCrab class that extends CrabCritter class. A KingCrab gets the actors
 * 	to be processed in the same way a CrabCritter does. A KingCrab causes each
 * 	actor that it processes to move one location further away from the KingCrab.
 * 	If the actor cannot move way, the KingCrab removes it from the grid. When
 * 	the KingCrab has completed processing the actors, it moves like a
 * 	CrabCritter.
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */
 
public class KingCrab extends CrabCritter
{
	/**
     * To process each actor, the KingCrab causes it to move one location 
     * further away from the KingCrab. If the actor cannot move way, the
     * KingCrab removes it from the grid.
     * 
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            Location loc = a.getLocation().getAdjacentLocation(a.getDirection());
            if (getGrid().isValid(loc))
				a.moveTo(loc);
			else
				a.removeSelfFromGrid();
        }
    }
}