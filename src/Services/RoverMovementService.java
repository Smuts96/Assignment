package Services;

import Enums.Actions;
import Enums.Direction;
import Model.Position;
import Model.Rover;

public class RoverMovementService {

	public Rover CalculateRoverMovement(Position grid, Position currentPosition, Direction direction, String movement, String id) throws Exception {
		
		//Check if movement have a value
		if(movement == null || movement == "")
			throw new Exception("Invalid movement");
		
		//make sure all white spaces are removed
		movement = movement.replaceAll("\\s","");
		
		//handle movement
		for(char move : movement.toCharArray()) {
			Actions action = Actions.fromString(String.valueOf(move));
			if(action == Actions.MoveForward)
				currentPosition = calculatePosition(grid, currentPosition, direction);
			else
				direction = calculateDirection(direction, Actions.fromString(String.valueOf(move)));
		}
		
		//Return new rover details
		return new Rover(id, currentPosition, direction);
	}
	
	private Position calculatePosition(Position grid, Position currentPosition, Direction direction) throws Exception {
		switch(direction) {
			case North:{
			currentPosition.setyCoordinate(grid, currentPosition.getyCoordinate() + 1);
			 return currentPosition;
			}	
			case East:{
				currentPosition.setxCoordinate(grid, currentPosition.getxCoordinate() + 1);
				 return currentPosition;
			}	
			case South:{
				currentPosition.setyCoordinate(grid, currentPosition.getyCoordinate() - 1);
				 return currentPosition;
			}	
			case West:{
				currentPosition.setxCoordinate(grid, currentPosition.getxCoordinate() - 1);
				 return currentPosition;
			}	
			default:
				return currentPosition;
		}
	}
	
	private Direction calculateDirection(Direction direction, Actions action) {
		//Rotate direction
		switch(action) {
		 case RotateLeft:
			 if(direction == Direction.North)
				 return Direction.West;
			 else if(direction == Direction.West)
				 return Direction.South;
			 else if(direction == Direction.South)
				 return Direction.East;
			 else
				 return Direction.North;
			 
		 case RotateRight:
			 if(direction == Direction.North)
				 return Direction.East;
			 else if(direction == Direction.East)
				 return Direction.South;
			 else if(direction == Direction.South)
				 return Direction.West;
			 else
				 return Direction.North;
		 default: 
		 return direction;
		}
	}
}
