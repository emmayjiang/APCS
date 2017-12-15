
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Regionals extends Search {

	// stores the input made by the user
	static String inputYear;
	static String inputName;

	public Regionals() {

	}

	/**
	 * Finds the list of teams that went to a particular regional
	 * 
	 * @param year
	 *            Year of regional
	 * @param comp
	 *            Abbreviated name of regional
	 */
	public static void findTeamsAtComp(String year, String comp) throws IOException {
		String line = "";

		// forms the URL to the database
		String teamList = "https://raw.githubusercontent.com/the-blue-alliance/the-blue-alliance-data/master/events/"
				+ year + "/" + year + comp + "/" + year + comp + "_teams.csv";

		URL url = new URL(teamList);

		// checks the existence of the regional in the database
		try {
			InputStream is = url.openStream();
		} catch (FileNotFoundException e) {
			System.out.println("That regional doesn't exist. Please try again.");
			restart();
		}

		// reads the database for the list of teams
		InputStream is = url.openStream();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			System.out.println("Teams:");
			line = br.readLine();
			while (line.indexOf(",") != -1) { // prints out the teams
				System.out.println(line.substring(3, line.indexOf(",")));
				line = line.substring(line.indexOf(",") + 1);
			}
			System.out.println(line.substring(3));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException("URL is malformed!!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	/**
	 * Restarts the method.
	 */
	public static void restart() throws IOException {
		run();
	}

	public static void run() throws IOException {
		System.out.println("Type the year of the regional you are looking for.");
		inputYear = input();

		// checks to confirm that the year is an integer
		if (isNumeric(inputYear)) {
			if (!(Integer.parseInt(inputYear) >= 1992 && Integer.parseInt(inputYear) <= 2017)) {
				System.out.println("Error: Unable to find Regionals. Please try another year.");
				restart();
			}
		} else {
			System.out.println("Make sure you are typing the year and only the year.");
			restart();
		}

		System.out.println("Please type the abbreviated name of the competition");
		inputName = removeCaps(input());

		findTeamsAtComp(inputYear, inputName);
	}
}
