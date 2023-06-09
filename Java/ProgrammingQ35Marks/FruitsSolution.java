/* IPA 21 */

import java.util.Scanner;

public class FruitsSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Fruits[] fruits = new Fruits[4];

		for (int i = 0; i < fruits.length; i++) {
			int fruitId = sc.nextInt();
			sc.nextLine();
			String fruitName = sc.nextLine();
			int price = sc.nextInt();
			int rating = sc.nextInt();

			fruits[i] = new Fruits(fruitId, fruitName, price, rating);
		}
		int targetRating = sc.nextInt();

		sc.close();

		Fruits maxPricedFruit = findMaximumPriceByRating(fruits, targetRating);

		if (maxPricedFruit != null) {
			System.out.println(maxPricedFruit.getFruitId());
		} else {
			System.out.println("No such fruit");
		}

	}

	public static Fruits findMaximumPriceByRating(Fruits[] fruits, int rating) {
		Fruits ansFruit = null;
		int max = Integer.MIN_VALUE;

		for (Fruits f : fruits) {
			if (f.getRating() > rating && f.getPrice() > max) {
				max = f.getPrice();
				ansFruit = f;
			}
		}
		return ansFruit;
	}
}

class Fruits {
	private int fruitId;
	private String fruitName;
	private int price;
	private int rating;

	public Fruits(int fruitId, String fruitName, int price, int rating) {
		this.fruitId = fruitId;
		this.fruitName = fruitName;
		this.price = price;
		this.rating = rating;
	}

	public int getFruitId() {
		return fruitId;
	}

	public void setFruitId(int fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
