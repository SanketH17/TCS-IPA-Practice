
/* IPA 11 */

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