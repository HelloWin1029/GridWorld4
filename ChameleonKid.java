import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * 	ChameleonKid class that extends ChameleonCritter class. A ChameleonKid
 * 	changes its color to the color of one of the actors immediately in front
 * 	or behind. If there is no actor in either of these locations, then the
 * 	ChameleonKid darkens like ChameleonCritter.
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */

public class ChameleonKid extends ChameleonCritter
{	
	public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        
        Location loc = getLocation();
        Location front = loc.getAdjacentLocation(getDirection());
        Grid<Actor> gr = getGrid();
        if (gr.isValid(front) && gr.get(front) != null)
            actors.add(gr.get(front));
            
        Location back = loc.getAdjacentLocation((getDirection() + Location.HALF_CIRCLE) % Location.FULL_CIRCLE);
        if (gr.isValid(back) && gr.get(back) != null)
            actors.add(gr.get(back));
            
        return actors;
    }
}
