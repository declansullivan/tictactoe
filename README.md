#tictactoe

<h2>Description</h2>

This Tic-Tac-Toe game was created as an extra credit assignment for my Intro to Java course, CSE 11.  Below is the write up that I included for the program.  It is a simple, GUI oriented version of Tic-Tac-Toe that works using JFrame.

<hr>

<h2>Write-Up</h2>

Hello, welcome to my extra credit for CSE 11, Tic-Tac-Toe.  This program has three methods: main, checkWin(), and actionPerformed(ActionEvent e), and one constructor: TicTacToe.


main():

The main method is only one line, and is used to call on the constructor that creates the window to play Tic-Tac-Toe in, allowing for the rest of the game to happen.  Nothing else is required in the main method as everything else is controlled by Buttons.


TicTacToe():

The TicTacToe constructor creates the game board, as well as assigns previously initialized variables to values.  The first main block sets the title of the newly made frame, and then sets a grid layout of a 3x3.  The size is then set to 500x500.  After this, an exit on close operation is set, and then setLocationRelativeTo(null) is used to center the window in the middle of the screen.

After this a 2D array is assigned to be of size 3x3, like the grid layout is.  A nested for loop then runs in order to populate the array full of JButtons.  Each JButton is given a value defined by a counter increasing by one each time: 1, 2, 3, etc.  This is so that the logic for checking a win is not interfered with later.  These values are set to a font size of 0 so that they cannot be seen by the user, but can still be used by the program to determine winning moves.  When a button is assigned, it is also given a default ActionListener, then added to the grid layout of the frame.

Once the JButton array is populated, the window is set to visible, and the game is ready to be played.


actionPerformed(ActionEvent e):

The actionPerformed method is written for two reasons: firstly, so each button knows how to react when it is pushed, and secondly, we are required to because the class implements ActionListener.  When a button is pushed, the first thing that is checked is the current move value.  Initially, this value is set to 0, and is incremented by 1 every time a button is pushed.  This is so that we can take the remainder of this value when dividing by 2 so that we have either a 1 or a 0 value, so that we can alternate what kind of label the button gets, either an “X” or an “O”.  These values replace the integer to string values that the buttons were previously assigned with, so that comparisons to determine a winner can begin to properly be made.

It is important to make sure that the buttons start off all with different values, as the way that I wrote my program, the game checks for a winner every single round.

After the button is given an “X” or an “O” value, it is set to be disabled, so that it cannot be clicked again.  Its font is also changed to be much larger so that the new value is visible to the user.  After these steps are taken, the method to checkWin is called, in order to see whether or not a set of three matching values has been played.  I will describe checkWin in a moment, but for now I will finish detailing what happens in actionPerformed.

checkWin will return either “X”, “O”, or just a space “ “.  actionPerformed will check to make sure that the value is not “ “, which means there is no winner yet.  If there is a winner, then every single button will be disabled so that no more moves can be played, and the middle button will have its text changed to show off the winner, as well as changing the font size so that the text is properly displayed.


checkWin():

The checkWin method is where most of the logic is for the game.  There are only 8 possible ways that you can win in a game of Tic-Tac-Toe, so it was relatively easy to explicitly check each combination.  The first thing that happens in the method is a for loop is entered, which runs a value from 0 to 2.  Each loop, two if statements are checked.  These are for checking an entire row or column in one go.  The button texts are compared in a straight line in one direction.  Portions of the JButton array which are referenced with [idx][0] are checking columns, as the row value changes, and references of [0][idx] are checking rows, as the column value changes.

This for loop allows for all 3 horizontal rows and all 3 vertical columns to be checked for any complete matches.  If none are found, two external if statements are checked.  These are used to check diagonal matches.  There are only two possibilities of these, and as such, there are only two if statements.  These just use simple indexes to check the array in a diagonal line to compare texts.

These comparisons are why the JButton texts had to be initialized with different variables each, otherwise after the first button push a win would be declared.  When three matching values in a row are found, the resulting value is returned to the actionPerformed method to declare a winner.  If no winner is found in checkWin, then a single space is returned so that the actionPerformed method knows to allow the game to continue running.
