# Command Line Set
### By Team Craze_Hashing

## Description
Command Line Set is the classic game of Set (http://www.setgame.com) designed for Unix-based command line terminals. It is based off the game and has similar gameplay, but with several added features, including:
 - New Game Modes
 - Highscore Saving
 - Automatic Set Detection

## Running The Game
The game can be run by typing the following in command line:
```
$ javac Set.java
$ java Set
```
**_Please note that running the game in Windows or on a non-Unix command line may not display colors._**

## Gameplay
The gameplay of Command Line Set is the same as the game of Set itself. Sets are found by choosing three cards with each attribute (among color, shape, shading and number) being all the same, or all different. Coordinates are inputted to select cards, and are entered in the form ROW COLUMN, such as A0. There may not be more than 21 cards on the baord at any time, and there will always be at least 9 cards on the board if there are cards remaining in the deck. Descriptions of the two game modes are below.

1. **Standard Game Mode**
This is the original game of Set. Gameplay plays like normal set, with the exception that if there are no sets on the board, you will automatically draw. A highscore is generated by taking the average amount of time taken to find a set.

2. **Sprint Game Mode**
Spring mode plays like the original game of Set, except the user has 3 minutes to find as many sets as possible. A highscore is generated by taking the amount of sets found in the three minute limit. 

## Instructions
The objective of the game is to identify Sets of 3 cards from the cards placed on the board. Each card has four features, which can vary as follows:

- Shape: O, S, or X
- Color: RED, GREEN, or BLUE
- Number: 1, 2, or 3
- Shading: {}. (), or []
- Example: {OO} (As color cannot be displayed, we will omit color in the following examples.)

A Set consists of 3 cards in which each of the cards’ features, looked at one by one, are the same on each card or different on each card. All of the features must separately satisfy this rule.

Some examples of Sets:
 1. {0} {OO} {OOO}
 2. [S] {OO} (XXX)
 3. {X} {O} {S}

These are NOT Sets:
 1. {O} (OO) {OOO} // There are two cards with curly braces, and one with parentheses.
 2. [S] {OO} (OOO) // There are two cards with shape O, and one card with shape S.
 3. {X} {O} {SS} // There are two cards with size 1, and one card with size 2.

9 cards are placed on the board. If there are no possible Sets, 3 more cards will be dealt. To select 3 cards that you think make a Set, type in their coordinates in the form “A0”. Neither capitalization nor whitespace matters.

Examples of valid entires:
- A0 B2 C1
- A3 B1 C0
- A0 A1 A3

If your selection is a Set, the cards selected will be removed from the board. There will always be at least 9 cards on the board, unless there are no more cards in the deck. You can manually draw by typing “D” or “d”. You are also able to quit the game at any point by entering “Q” or “q.”

Good luck, and happy Set finding!

## About
Command Line Set was created by Team Craze_Hashing (Sarah Yoon and Zicheng Zhen) for AP Computer Science. The program was created in Java 7. The goal of the project was to incorporate what was learned in class into a project of the students' own design.
