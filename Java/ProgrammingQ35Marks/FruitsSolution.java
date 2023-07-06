/* IPA 21 */

/*

Create a class Fruits with below attributes as private
● int fruitId
● String fruitName
● int price
● int rating

Write getters, setters and parameterized constructor in the abovementioned attribute 
sequence as required.

Create class Solution with main method

Implement One static method-

● findMaximumPriceByRating

findMaximumPriceByRating in the solution class. 
This method will take array of Fruit objects, int paramater and returns the maximum priced fruit 
object from array of Fruit objects whichever has rating greater than the rating 
(rating parameter passed). This method should be called from main method.

Write code to perform following tasks:

1. Take necessary input variable and call findMaximumPriceByRating.

For this method- The main method should print the fruitId from returnedobject. As if the 
returned value is not null, or it should print "No such Fruit".

Note:- Before calling this static method, use Scanner object to read thevalues of four Fruits 
objects. No two Fruits will have same price. All thesearches should be case insensitive.
Consider below sample input and output to test your code.


Input
-------------------
555
Apple
200
5
777
Orange
150
4
333
Banana
100
4
888
Avocado
250
4
3

Output
-----------------
888

*/


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
