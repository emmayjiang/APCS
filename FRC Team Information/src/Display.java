
import java.io.IOException;

public class Display extends Search {

	// stores the input made by the user
	static String input;

	public Display() {

	}

	public static void main(String[] args) throws IOException {
		System.out.println("This is a database that can a. Search for which teams were at a particular regional or b. Show you details of a team.");
		System.out.println("Type 'regional' to search for regionals, 'team' to search for teams");
		input = removeCaps(input());
		if (input.equals("regional")) { // runs the program that will check for teams at regionals
			Regionals.run();
		} else if (input.equals("team")) { // runs the program that will check for team details
			Teams.run();
		} else {
			System.out.println("Please check your spelling and try again."); // error message if input didn't match
			main(args);
		}
	}
}
