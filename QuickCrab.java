import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

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
        Location loc = getAdjacentLocation(getDirection() + Location.LEFT);
        Location loc2 = loc.getAdjacentLocation(loc.getDirection());
        if (getGrid().isValid(loc2)) locs.add(loc2);
        
        loc3 = getAdjacentLocation(getDirection() + Location.RIGHT);
        loc4 = loc.getAdjacentLocation(loc.getDirection());
        if (getGrid().isValid(loc2)) locs.add(loc2);
        
        if (locs.size() == 0){
			locs = super.getMoveLocations();
        return locs;
    }
}
