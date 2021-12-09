package Model;

import Enums.Direction;
import Services.RoverMovementService;

public class Rover extends RoverMovementService {

	private String id;
	private Position position;
	private Direction direction;
	
	//Set rover details
	public Rover(String id, Position position, String direction) throws Exception {
		this.id = id;
		this.position = position;
		setDirection(direction);
	}
	
	//Set rover override details
	public Rover(String id, Position position, Direction direction) throws Exception {
		this.id = id;
		this.position = position;
		this.direction = direction;
	}

	//Get rover name
	public String getId() {
		return id;
	}
	
	//Set rover name
	public void setId(String id) {
		this.id = id;
	}

	//Get rover position
	public Position getPosition() {
		return position;
	}

	//Set rover position
	public void setPosition(Position position) {
		this.position = position;
	}

	//Get rover direction
	public Direction getDirection() {
		return direction;
	}
	
	//Set rover direction
	public void setDirection(Direction direction) {
		
		this.direction = direction;
	}

	//Set rover direction
	public void setDirection(String direction) throws Exception {
		
		this.direction = Direction.fromString(direction);
	}
	
	//Set rovers new position
	public void setMovement(Position grid, String movement) throws Exception {
		Rover rover = super.CalculateRoverMovement(grid, this.position, this.direction, movement, this.id);
		this.position = rover.position;
		this.direction = rover.direction;
	}
}
