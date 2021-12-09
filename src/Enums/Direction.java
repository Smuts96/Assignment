package Enums;

public enum Direction {
	North, 
	East, 
	South, 
	West; 
	
	public static Direction fromString(String direction) throws Exception{
		switch(direction) {
		case "E":
			return Direction.East;
		case "N":
			return Direction.North;
		case "W":
			return Direction.West;
		case "S":
			return Direction.South;
		default:
			throw new Exception("Invalid direction: " + direction);
		}
	}				
}
