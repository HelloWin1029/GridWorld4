import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * 	BlusterCritter class that extends Critter class. A BlusterCritter looks at all
 * 	of the neighbors within two steps of its current location. (For a BlusterCritter
 * 	not near an edge, this includes 24 locations). It counts the number of critters
 * 	in those locations. If there are fewer than c critters, the BlusterCritter's 
 * 	color gets brighter (color values increase). If there are c or more critters,
 * 	the BlusterCritter's color darkens (color values decrease). Here, c is a value
 * 	that indicates the courage of the critter. It should be set in the constructor.
 * 
 * 	@author	Win Chang
 * 	@since	March 21, 2025
 */

public class BlusterCritter extends Critter
{
	private static final double DARKENING_FACTOR = 0.05;
	private int courage;
	
	public BlusterCritter(int courage){ this.courage = courage; }
	
	public ArrayList<Actor> getActors()
    {
		ArrayList<Actor> actors = new ArrayList<Actor>();
        for (int i = -2; i <= 2; i++){
			for (int j = -2; j <= 2; j++){
				int r = getLocation().getRow() + i;
				int c = getLocation().getCol() + j;
				if (i >= 0 && i < getGrid().getNumRows() && j >= 0 && j < getGrid().getNumCols()){
					Location neighbor = new Location(r, c);
					if (getGrid().isValid(neighbor) && (getGrid().get(neighbor)) != null) actors.add(getGrid().get(neighbor));
				}
			}
		}
		return actors;
    }
    
	public void processActors(ArrayList<Actor> actors)
    {
		int count = 0;
		for (Actor a : actors)
			if (a instanceof Critter) count++;
        
		int red, green, blue;
		Color c = getColor();
		if (count >= courage){
			red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
		}
		else{
			red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
			green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
			blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
			red = Math.min(red, 255);
			blue = Math.min(blue, 255);
			green = Math.min(green, 255);
		}
		setColor(new Color(red, green, blue));
    }
}
