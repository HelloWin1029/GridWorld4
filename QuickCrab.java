import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * 	QuickCrab class that extends CrabCritter class. A QuickCrab processes
 * 	actors the same way a CrabCritter does. A QuickCrab moves to one of
 * 	the two locations, randomly selected, that are two spaces to its right
 * 	or left, if that location and the intervening location are both empty.
 * 	Otherwise, a QuickCrab moves like a CrabCritter.
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */
 
public class QuickCrab extends CrabCritter
{
	/**
     * @return list of empty locations two spaces to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        int dir = (getDirection() + Location.LEFT + Location.FULL_CIRCLE) % Location.FULL_CIRCLE;
        Location left1 = getLocation().getAdjacentLocation(dir);
        Grid<Actor> gr = getGrid();
        if (gr.isValid(left1) && gr.get(left1) == null){
            Location left2 = left1.getAdjacentLocation(dir);
            if (gr.isValid(left2) && gr.get(left2) == null) locs.add(left2);
        }
        
        dir = (getDirection() + Location.RIGHT + Location.FULL_CIRCLE) % Location.FULL_CIRCLE;
        Location right1 = getLocation().getAdjacentLocation(dir);
        if (gr.isValid(right1) && gr.get(right1) == null){
            Location right2 = right1.getAdjacentLocation(dir);
            if (gr.isValid(right2) && gr.get(right2) == null) locs.add(right2);
        }

        if (locs.size() == 0){
			locs = super.getMoveLocations();
        return locs;
    }
}