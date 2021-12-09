package Model;

public class Position {
	//variables
	private int xCoordinate;
	private int yCoordinate;
	
	//For plateau only
	public Position(int x, int y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public Position(Position grid, int x, int y) throws Exception {
		//Validate x coordinate
		validateXCoordinate(grid, x);
		this.xCoordinate = x;
		
		//Validate y coordinate
		validateYCoordinate(grid, y);
		this.yCoordinate = y;
	}
	
	//Get x Coordinate of rover position
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	//Set x Coordinate of rover position
	public void setxCoordinate(Position grid, int xCoordinate) throws Exception {
		//Validate x coordinate
		validateXCoordinate(grid, xCoordinate);
		this.xCoordinate = xCoordinate;
	}
	
	//Get y Coordinate of rover position
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	//Set y Coordinate of rover position
	public void setyCoordinate(Position grid,int yCoordinate) throws Exception {
		//Validate y coordinate
		validateYCoordinate(grid, yCoordinate);
		this.yCoordinate = yCoordinate;
	}
	
	public void validateXCoordinate(Position grid, int x) throws Exception {
		//Check if x coordinate was in range
		if(grid == null || x < 0 || x > grid.xCoordinate)
			throw new Exception("Invalid X - Coordinate: "+ x +". The grid is only " + grid.getxCoordinate() + " units long horizontal.");
	}
	
	public void validateYCoordinate(Position grid, int y) throws Exception {
		//Check if y coordinate was in range

		if(grid == null || y < 0 || y > grid.yCoordinate)
			throw new Exception("Invalid Y - Coordinate: "+ y +". The grid is only " + grid.getyCoordinate() + " units long vertical.");
	}
}
