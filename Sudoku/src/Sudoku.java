
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Sudoku extends JFrame {

	private int[][] board;
	private boolean[][] hide;
	private JTextField[][] cells;

	public Sudoku() {
		board = new int[9][9];
		fillBoard();

		hide = new boolean[9][9];
		for (int i = 0; i < hide.length; i++) {
			for (int j = 0; j < hide[0].length; j++) {
				double ran = Math.random();
				if (ran >= 0.60) {
					hide[i][j] = false;
				} else {
					hide[i][j] = true;
				}
			}
		}

		Container cp = getContentPane();
		cp.setLayout(new GridLayout(9, 9));

		InputListener il = new InputListener();

		cells = new JTextField[9][9];

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				cells[i][j] = new JTextField();
				cp.add(cells[i][j]);
				if (hide[i][j]) {
					cells[i][j].setText("");
					cells[i][j].setEditable(true);
					cells[i][j].setBackground(Color.WHITE);
					cells[i][j].addActionListener(il);
				} else {
					cells[i][j].setText(board[i][j] + "");
					cells[i][j].setEditable(false);
					cells[i][j].setBackground(new Color(236, 236, 236));
					cells[i][j].setForeground(Color.BLACK);
				}
				cells[i][j].setHorizontalAlignment(JTextField.CENTER);
				cells[i][j].setFont(new Font("Arial", Font.BOLD, 20));
			}
		}

		cp.setPreferredSize(new Dimension(540, 540));
		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sudoku");
		setVisible(true);
	}

	/**
	 * Generates the sudoku board.
	 */
	public void fillBoard() {
		for (int i = 0; i < 9; i = i + 3) {
			fillBox(i, i);
		}
		fill(0, 3);
	}

	/**
	 * Fills a box on the sudoku board.
	 * 
	 * @param row	row of the box
	 * @param col	column of the box
	 */
	public void fillBox(int row, int col) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int num = (int) Math.floor((Math.random() * 9 + 1));
				while (!canUse(row, col, num)) {
					num = (int) Math.floor((Math.random() * 9 + 1));
				}
				board[row + i][col + j] = num;
			}
		}
	}

	/**
	 * Checks if there are duplicates of a number in a cell
	 * 
	 * @param row	starting row of cell
	 * @param col	starting col of cell
	 * @param n		number to be checked
	 * @return		true:	no duplicates
	 * 				false:	duplicates
	 */
	private boolean canUse(int row, int col, int n) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row + i][col + j] == n) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the number can be put in the select row and column.
	 * 
	 * @param row	row
	 * @param col	column
	 * @param num	number
	 * @return		true: number is valid
	 * 				false: number doesn't work
	 */
	public boolean check(int row, int col, int num) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (board[i][col] == num) {
				return false;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[row - row % 3 + i][col - col % 3 + j] == num) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Fill the remainder of the cells.
	 * 
	 * @param i		column
	 * @param j		row
	 * @return		true: if successful
	 */
	public boolean fill(int i, int j) {
		if (j >= 9 && i < 9 - 1) {
			i = i + 1;
			j = 0;
		}
		if (i >= 9 && j >= 9) {
			return true;
		}

		if (i < 3) {
			if (j < 3) {
				j = 3;
			}
		} else if (i < 9 - 3) {
			if (j == (int) (i / 3) * 3) {
				j = j + 3;
			}
		} else {
			if (j == 9 - 3) {
				i = i + 1;
				j = 0;
				if (i >= 9) {
					return true;
				}
			}
		}

		for (int num = 1; num <= 9; num++) {
			if (check(i, j, num)) {
				board[i][j] = num;
				if (fill(i, j + 1))
					return true;

				board[i][j] = 0;
			}
		}
		return false;
	}

	/**
	 * Takes in input for the cells
	 */
	private class InputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = -1;
			int col = -1;

			JTextField source = (JTextField) e.getSource();

			boolean found = false;
			for (int i = 0; i < 9 && !found; ++i) {
				for (int j = 0; j < 9 && !found; ++j) {
					if (cells[i][j] == source) {
						row = i;
						col = j;
						found = true;
					}
				}
			}

			int in = Integer.parseInt(cells[row][col].getText());
			if (in == board[row][col]) {
				cells[row][col].setBackground(new Color(119, 221, 119));
				hide[row][col] = false;
			} else {
				cells[row][col].setBackground(new Color(255, 105, 97));
			}

			isFinished();
		}

		/**
		 * Checks if the board is completed.
		 */
		public boolean isFinished() {
			for (int i = 0; i < hide.length; i++) {
				for (int j = 0; j < hide[0].length; j++) {
					if (hide[i][j]) {
						return false;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Congratulations! You did it!");
			return true;
		}
	}

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
	}
}
