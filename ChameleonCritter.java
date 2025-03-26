import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * 	ChameleonCritter class that extends Critter class. The only difference
 * 	from Critter class is that in processActors methods, if the list of actors
 * 	to process is empty, the color of this ChameleonCritter will darken (like a flower)
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */

public class ChameleonCritter extends Critter
{
	private static final double DARKENING_FACTOR = 0.05; // lose 5% of color value in each step

    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, the color will darken (like a flower).
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0){
			Color c = getColor();
			int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

			setColor(new Color(red, green, blue));
            return;
        }
        int i = (int)(Math.random() * n);
        setColor(actors.get(i).getColor());
    }
}
