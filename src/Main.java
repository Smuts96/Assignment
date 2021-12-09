import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import Model.Position;
import Model.Rover;

public class Main {
	public static void main(String[] args) {

		int count = 0;
		HashMap<String, Rover> rovers = new HashMap<>();
		
		//Retrieve file from location
		File inputFile = new File("./src/InputFile.txt"); 
		Position plateau = null;

		//Attempt to read file
		try {
			Scanner fileReader = new Scanner(inputFile);
			
			//Extract data and keep in memory due to nature of project.
			while(fileReader.hasNextLine()) {
				String line = fileReader.nextLine().toUpperCase();
				String name = "Rover "+ count; 
				//Grid size always comes first
				if(count == 0) {
					String[] coordinates = line.split("\\s+");
					plateau = new Position(Integer.parseInt(coordinates[0]),Integer.parseInt(coordinates[1]));
					count++;
					continue;
				}
				
				//Check for movement
				if(count != 0 && (line.contains("M") || line.contains("L") || line.contains("R"))) {
					name = "Rover "+ (count - 1);

					if(!rovers.containsKey(name))
						throw new Exception("Rover need to be placed on plateau first before trying to move it.");
					
					Rover rover = rovers.get(name);
					rover.setMovement(plateau, line);
					rovers.put(rover.getId(), rover);
				}
				else if(count != 0) {
					//Add rover to the list
					String[] roverDetails = line.split("\\s+");
					rovers.put(
								name,
								new Rover(
										name, 
										new Position(
												plateau, 
												Integer.parseInt(roverDetails[0]),
												Integer.parseInt(roverDetails[1])
											),
										roverDetails[2]
										)
								);
					//Only increments count if new rover have been added
					count++;
				}
			}
			//Close file reader
			fileReader.close();
			
			for(Rover rover : rovers.values()) {
				System.out.println(rover.getId()+": "+ rover.getPosition().getxCoordinate() + " " + rover.getPosition().getyCoordinate() + " " + rover.getDirection() + "\n\n");
			}
		} catch (Exception e) {
			//Print system exception if program could not find the relevant file.
			System.out.println(e.getMessage());
		}
	}
}
