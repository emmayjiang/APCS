
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Teams extends Search {

	// stores the input made by the user
	static String input;

	public Teams() {

	}

	/**
	 * Find the team based on team number, and returns a String that contains the
	 * team's information.
	 * 
	 * @param number
	 *            inputted team number
	 */
	public static String findNumber(int number) throws IOException {
		String line = "";

		String teamList = "https://raw.githubusercontent.com/the-blue-alliance/the-blue-alliance-data/master/teams/teams.csv";

		// forms the URL to the database
		URL url = new URL(teamList);
		InputStream is = url.openStream();

		// reads the database for the team number and returns the line that contains it
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			for (int i = 1; i < 9999; i++) {
				line = br.readLine();
				if ((line != null) && (line.indexOf(",") != -1)) {
					if ((line.substring(3, line.indexOf(","))).equals(Integer.toString(number))) {
						break;
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException("URL is malformed!!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

		return line;
	}

	/**
	 * Find the team based on team name, and returns a String that contains the
	 * team's information.
	 * 
	 * @param name
	 *            inputted team name
	 */
	public static String findName(String name) throws IOException {
		String line = "";

		String teamList = "https://raw.githubusercontent.com/the-blue-alliance/the-blue-alliance-data/master/teams/teams.csv";

		// forms the URL to the database
		URL url = new URL(teamList);
		InputStream is = url.openStream();

		// reads the database for the team name and returns the line that contains it
		try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			for (int i = 1; i < 9999; i++) {
				line = br.readLine();
				if ((line != null) && (line.indexOf(",") != -1)) {
					if ((line.substring(line.indexOf(",") + 1, line.indexOf(",", line.indexOf(",") + 1)).toLowerCase())
							.equals(name)) {
						break;
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException("URL is malformed!!");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}

		return line;
	}

	/**
	 * Formats the display of team information so that it's easier to read.
	 * 
	 * @param str
	 *            the String containing the information of the team
	 */
	public static void format(String str) {
		System.out.println("Team Number: " + str.substring(3, str.indexOf(",")));
		str = str.substring(str.indexOf(",") + 1);
		System.out.println("Team Name: " + str.substring(0, str.indexOf(",")));
		str = str.substring(str.indexOf(",") + 1);

		// checks for the special case (described in method below)
		if (str.substring(0, 1).equals("\"")) {
			specialCase(str);
		} else {
			System.out.println("Sponsors: " + str.substring(0, str.indexOf(",")));
			str = str.substring(str.indexOf(",") + 1);
			System.out.print("Location: " + str.substring(0, str.indexOf(",")) + ", ");
			str = str.substring(str.indexOf(",") + 1);
			System.out.print(str.substring(0, str.indexOf(",")) + ", ");
			str = str.substring(str.indexOf(",") + 1);
			System.out.println(str.substring(0, str.indexOf(",")));
			str = str.substring(str.indexOf(",") + 1);
			System.out.println("Website: " + str.substring(0, str.indexOf(",")));
		}
	}

	/**
	 * Some teams in the database had sponsors with a comma in their names. In order
	 * to fix that, the database surrounded the sponsors with quotes. This deals
	 * with that case.
	 */
	public static void specialCase(String str) {
		str = str.substring(1);
		System.out.println("Sponsors: " + str.substring(0, str.indexOf("\"")));
		str = str.substring(str.indexOf("\"") + 2);
		System.out.print("Location: " + str.substring(0, str.indexOf(",")) + ", ");
		str = str.substring(str.indexOf(",") + 1);
		System.out.print(str.substring(0, str.indexOf(",")) + ", ");
		str = str.substring(str.indexOf(",") + 1);
		System.out.println(str.substring(0, str.indexOf(",")));
		str = str.substring(str.indexOf(",") + 1);
		System.out.println("Website: " + str.substring(0, str.indexOf(",")));
	}

	/**
	 * Restarts the method.
	 */
	public static void restart() throws IOException {
		run();
	}

	public static void run() throws IOException {
		System.out.println("Type in a FRC team number or team name.");

		input = removeCaps(input());

		String str = "";

		// checks if input is a number or a name
		if (isNumeric(input)) {
			str = findNumber(Integer.parseInt(input));
		} else {
			str = findName(input);
		}

		// prints and formats if the team exist and therefore the string isn't empty
		if (!(str == null)) {
			format(str);
		} else {
			System.out.println("Team doesn't exist. Please try again.");
			restart();
		}
	}
}
