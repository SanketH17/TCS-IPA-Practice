/* IPA 11 */

/*

Create a class Player with below attributes: 

playerId - int 
skill - String 
level - String 
points - int

Write getters, setters and parameterized constructor in the above mentioned attribute 
sequence as required.

Create class Solution with the main method.

Implement two static methods - findPointsForGivenSkill and getPlayerBasedOnLevel in Solution class.

findPointsForGivenSkill method: 
------------------------------------
This method will take two input parameters - array of Player objects 
and string parameter skill. The method will return the sum of the points attribute from player objects 
for the skill passed as parameter. If no player with the given skill is present in the array of player 
objects, then the method should return 0.

getPlayerBasedOnLevel method: 
-------------------------------------
This method will take two String parameters level and skill, along with the array of Player objects. 
The method will return the player object, if the input String parameters matches with the level and 
skill attribute of the player object and its point attribute is greater than or equal to 20. If any 
of the conditions are not met, then the method should return null.

Note : No two player object would have the same value for skill and level attribute. All player object 
would have the points greater than 0. All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPointsForGivenSkill method - The main method should print the points as it is if the returned 
price is greater than 0, or it should print "The given Skill is not available".

For getPlayerBasedOnLevel method - The main method should print the playerId of the returned player object.
If the returned value is null then it should print "No player is available with specified level, skill 
and eligibility points".

Before calling these static methods in main, use Scanner object to read the values of four Player objects 
referring attributes in the above mentioned attribute sequence. Next, read the value for skill and level.
Please consider the skill value read above as skill parameter for both the static methods.

Input:
-----------
101
Cricket
Basic
20
102
Cricket
Intermediate
25
111
Football
Intermediate
50
113
BaseBall
Advanced
100
Cricket
Intermediate

Output:
--------------
45
102

*/

import java.util.Scanner;

public class PlayerSolution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Player2[] players = new Player2[4];

		for (int i = 0; i < players.length; i++) {
			int playerId = sc.nextInt();
			String skill = sc.next();
			String level = sc.next();
			int points = sc.nextInt();

			players[i] = new Player2(playerId, skill, level, points);
		}

		String targetSkill = sc.next();
		String targetLevel = sc.next();

		sc.close();

		int pointsSum = findPointsForGivenSkill(players, targetSkill);

		if (pointsSum != 0) {
			System.out.println(pointsSum);
		} else {
			System.out.println("The given Skill is not available");
		}

		Player2 playerBasedOnLevel = getPlayerBasedOnLevel(players, targetLevel, targetSkill);

		if (playerBasedOnLevel != null) {
			System.out.println(playerBasedOnLevel.getPlayerId());
		} else {
			System.out.println("No player is available with specified level, skill \r\n" + "and eligibility points");
		}

	}

	public static int findPointsForGivenSkill(Player2[] players, String targetSkill) {
		int sum = 0;

		for (int i = 0; i < players.length; i++) {
			if (players[i].getSkill().equalsIgnoreCase(targetSkill)) {
				sum = sum + players[i].getPoints();
			}
		}
		return sum;
	}

	public static Player2 getPlayerBasedOnLevel(Player2[] players, String targetLevel, String targetSkill) {
		Player2 playerBasedOnLevelAndString = null;

		for (Player2 player : players) {
			if (player.getLevel().equalsIgnoreCase(targetLevel) && player.getSkill().equalsIgnoreCase(targetSkill)
					&& player.getPoints() >= 20) {
				playerBasedOnLevelAndString = player;
				break; // Exit the loop after finding a player that satisfies the conditions
			}
		}
		return playerBasedOnLevelAndString;
	}

}

class Player2 {
	private int playerId;
	private String skill;
	private String level;
	private int points;

	// Constructors
	public Player2(int playerId, String skill, String level, int points) {
		super();
		this.playerId = playerId;
		this.skill = skill;
		this.level = level;
		this.points = points;
	}

	// Getters ans setters
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}