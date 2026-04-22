#Tic Tac Toe
Team Names: Sabrina Vu, Claire Ricca

##OOP Design Patterns
###1. Strategy Pattern
This is to determine how a move is chosen. A NPC or bot player could choose either random moves or stragized moves like open corners, 
blocks, or first open squares on the grid
###2. Observer Pattern
This pattern is used to detect changes in the game or board, and determine how other objects need to react.
For example, after each turn the board should update, the move should be logged, a game over message may appear, 
or if consecutive games are executed with the same players, 
a potential scoreboard would update.
###3. State Pattern
This is for tracking the current state or phase of the game.
In Tic Tac Toe we may have a few states: game start, X's turn, O's turn, X won, O won, and draw.
To prevent long blocks of if statements, we can use a State Pattern to make state classes for each phase of the game.
This is a good way to ensure there is a clean switch between game states. 
###4. Factory Pattern
This pattern is used to create different player types. If there were to be a game between 
player and player, npc vs player, or npc vs. npc than this pattern allows for clean construction for these types fo players.