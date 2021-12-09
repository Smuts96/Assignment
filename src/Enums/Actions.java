package Enums;

public enum Actions {
	RotateLeft, 
	RotateRight,
	MoveForward;

	public static Actions fromString(String action) throws Exception{
		switch(action) {
		case "L":
			return Actions.RotateLeft;
		case "R":
			return Actions.RotateRight;
		case "M":
			return Actions.MoveForward;
		default:
			throw new Exception("Invalid action: " + action);
		}
	}	
}
