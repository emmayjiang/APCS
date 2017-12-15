a. Introduction
	The concept of my code is simple: I wanted to create a program that allowed me to access a given database from the internet for FRC, in this case from the blue alliance, and allow me to a. input a team name or number and get the details of the team, or b. allow me to enter the name and year of a regional and see which teams attended. As a clarification: this project was not intended to be used for Team 8 purposes, neither is it affiliated in any way, it was just for my own amusement, and so I could practice pulling information off websites as well as working with Strings.

b. How this fulfills / does not fulfill the specifications
	There was no specific assignment for this project - it was just to create an independent project. Since I was interested in trying something along these lines and couldn't think of anything better, I decided to just go with it. As expected, when the user inputs "team" or "regional" in order to signify which one they want to check, a different method helps them find team information or regional information.

c. Explaination of current errors
	This program works as expected. There are several instances of exception handling code that helps to reduce errors, but the program is always suspectible to bugs - I did not get the chance to try every single data point in the database to confirm that there wouldn't be anything to prevent it from working. However, there are several things I wish I could fix. First of all, this program doesn't allow typos, or else you will have to resubmit all the information you have entered. Also, there was no way for me to map the name of each regional onto the abbreviated versions, and therefore the user would only be able to enter the abbreviation of the regional they are looking for to find the data. They would be unable to get data if they used the actual name of the competition.

d. Overview of code
	The Search class has several methods that appear in all three of its subclasses. One is for Scanner input, one is to check if a String is numeric, and the last method removes all capitalization from an input.
	The class Display has the main method. It has a Scanner input which allows the user to input either "team" or "regional", which will then run the method in either the Teams or Regionals class. Or, if the wrong word is entered, it will prompt the user to resubmit their word.
	The Teams class first allows for input of either a team name or a team number, and uses the isNumeric method described in Search to decide whether the input is a team name or number. Then it uses BufferedReader to read from the URL taken from the blue alliance's database, gets the line that corresponds to the team number or name, and prints it in a nicely formatted manner.
	The Regionals class uses an inputted year and competition name to go to a website, part of the blue alliance's database, and prints all the teams that were at the competition. The process is similar to that in the Teams class.

e. Major challenges
	For this project, I had originally intended to use the blue alliance site by itself, because I thought it would be easier, but unfortunately I realized too late that it wouldn't be possible. Therefore, I had to think of a workaround, which i found using the database. Also, I ran into a lot of errors with the url, including some unhandled exceptions, as well as a lot of String mistakes.

f. Acknowledgements
	Database: https://github.com/the-blue-alliance