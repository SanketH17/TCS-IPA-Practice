
import java.util.Scanner;

public class PlayerSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player[] players = new Player[4];

        for (int i = 0; i < players.length; i++) {
            int playerId = sc.nextInt();
            sc.nextLine();
            String playerName = sc.nextLine();
            int iccRank = sc.nextInt();
            int noOfMatchesPlayed = sc.nextInt();
            int noOfRunsScored = sc.nextInt();
            sc.nextLine();

            players[i] = new Player(playerId, playerName, iccRank, noOfMatchesPlayed, noOfRunsScored);
        }
        int target = sc.nextInt();
        sc.close();

        double[] avgRunRate = findAverageScoreOfPlayers(players, target);

        for (int i = 0; i < avgRunRate.length; i++) {
            if (avgRunRate[i] >= 80.0) {
                System.out.println("Grade A Player");
            } else if (avgRunRate[i] <= 79.0 && avgRunRate[i] >= 50.0) {
                System.out.println("Grade B Player");
            } else {
                System.out.println("Grade C Player");
            }
        }
    }

    public static double[] findAverageScoreOfPlayers(Player[] players, int target) {
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i].getNoOfMatchesPlayed() >= target) {
                count++;
            }
        }

        int index = 0;
        double avgRunRate = 0.0;
        double[] avgRunRateArray = new double[count];

        for (int i = 0; i < players.length; i++) {
            if (players[i].getNoOfMatchesPlayed() >= target) {
                avgRunRate = Double.valueOf(players[i].getTotalRunsScored() / players[i].getNoOfMatchesPlayed());

                avgRunRateArray[index] = avgRunRate;
                index++;
            }
        }
        return avgRunRateArray;
    }

}

class Player {
    private int playerId;
    private String playerName;
    private int iccRank;
    private int noOfMatchesPlayed;
    private int totalRunsScored;

    // getters and setters

    // playerId
    public int getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    // playerName
    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // iccRank
    public int getIccRank() {
        return this.iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    // noOfMatchesPlayed
    public int getNoOfMatchesPlayed() {
        return this.noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    // totalRunsScored
    public int getTotalRunsScored() {
        return this.totalRunsScored;
    }

    public void setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    // Constructor
    public Player(int playerId, String playerName, int iccRank, int noOfMatchesPlayed, int totalRunsScored) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.iccRank = iccRank;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.totalRunsScored = totalRunsScored;
    }
}