Introduction:
Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9×9 grid with digits so that each column, each row, and each of the nine 3×3 subgrids that compose the grid contains all of the digits from 1 to 9. The puzzle setter provides a partially completed grid, which for a well-posed puzzle has a single solution. This project is simple: a JFrame that implements the commonly played game, Sudoku. It has methods to generate a board that allows users to fill in, and gives a prompt when the game is complete.

How this fulfills / does not fulfill the specification:
The task for this assignment was to create an independent project. I knew I needed to work more on JFrames because my understanding of it was lacking and I wanted to improve. I settled on coding Sudoku, because it is not too simple and allows me to learn in the process.

Current Errors:
Right now, there are no errors that hinders my program from running, but there are plenty of places where code could be simplified so that the program runs more smoothly and more quickly. I could also make the display look a little more appealing than it does right now.

Code Overview:
The constructor takes care of creating the JFrame and the display. There is a method named FillBoard() that calls helper methods in order to fill the entire board with an automatically generated solution. Of course, many of the answers are masked, which is stored in the private array shown[][]. The user input for each cell is compared to the actual answer, stored inside board[][], and if it is correct, the cell turns green. If it is incorrect, the cell turns red.

Major Challenges:
It was extremely difficult for me to figure out an algorithm that could help my sudoku work as I wanted, since I didn’t understand the basics of creating a sudoku board. Once I did some more research, however, it was smooth sailing.

Acknowledgements:
https://en.wikipedia.org/wiki/Sudoku
http://www.baeldung.com/java-sudoku
