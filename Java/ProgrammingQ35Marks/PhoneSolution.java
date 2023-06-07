/* IPA 15 */
/*

Create a class Phone with below attributes: 

phoneId - int 
os - String 
brand - String 
price - int

Write getters, setters and parameterized constructor in the above mentioned attribute sequence as required.

Create class Solution with main method.

Implement two static methods - findPriceForGivenBrand and getPhoneIdBasedOnOs in Solution class.

findPriceForGivenBrand method: 
----------------------------------
This method will take two input parameters - array of Phone objects and string 
parameter brand. The method will return the sum of the price attribute from phone objects for the brand passed as parameter. If no phones with the given brand is present in the array of phone objects, then the method should 
return 0.

getPhoneIdBasedOnOs method: 
----------------------------------
This method will take a String parameter os, along with the array of Phone objects. 
The method will return the phone object, if the input String parameter matches with the os attribute of the phone object and its price attribute is greater than or equal to 50000. If any of the conditions are not met, then the method should return null.

Note : No phone object would have the same value for os attribute. All phone object would have the price greater than 0. 
All the searches should be case insensitive.

These above mentioned static methods should be called from the main method.

For findPriceForGivenBrand method - The main method should print the price as it is if the returned price is greater 
than 0, or it should print "The given Brand is not available".

For getPhoneIdBasedOnOs method - The main method should print the phoneId of the returned phone object. If the returned value is null then it should print "No phones are available with specified os and price range".

Before calling these static methods in main, use Scanner object to read the values of four Phone objects referring 
attributes in the above mentioned attribute sequence. Next, read the value for brand and os.

Input
--------------
111
iOS
Apple
30000
222
android
Samsung
50000
333
Symbian
HTC
12000
444
Paranoid
HTC
89000
Blackberry
aNdRoid

Output
------------------
The given Brand is not available
222

*/

import java.util.Scanner;

public class PhoneSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Phone[] phones = new Phone[4];

		for (int i = 0; i < phones.length; i++) {
			int phoneId = sc.nextInt();
			String os = sc.next();
			String brand = sc.next();
			int price = sc.nextInt();

			phones[i] = new Phone(phoneId, os, brand, price);

		}

		String targetBrand = sc.next();
		String targetOs = sc.next();

		sc.close();

		int totatBrandSum = findPriceForGivenBrand(phones, targetBrand);

		if (totatBrandSum > 0) {
			System.out.println(totatBrandSum);
		} else {
			System.out.println("The given brand is not available");
		}

		Phone phone = getPhoneIdBasedOnOs(phones, targetOs);

		if (phone != null) {
			System.out.println(phone.getPhoneId());
		} else {
			System.out.println("No phones are available with specified os and price range");
		}

	}

	// findPriceForGivenBrand

	public static int findPriceForGivenBrand(Phone[] phones, String targetBrand) {
		int totalBrandSum = 0;
		for (Phone phone : phones) {
			if (phone.getBrand().equalsIgnoreCase(targetBrand)) {
				totalBrandSum += phone.getPrice();
			}
		}
		return totalBrandSum;
	}

	// getPhoneIdBasedOnOs

	public static Phone getPhoneIdBasedOnOs(Phone[] phones, String targetOs) {
		Phone targetPhone = null;

		for (Phone phone : phones) {
			if (phone.getOs().equalsIgnoreCase(targetOs) && phone.getPrice() >= 50000) {
				targetPhone = phone;
				break;
			}
		}
		return targetPhone;

	}

}

class Phone {
	private int phoneId;
	private String os;
	private String brand;
	private int price;

	public Phone(int phoneId, String os, String brand, int price) {
		super();
		this.phoneId = phoneId;
		this.os = os;
		this.brand = brand;
		this.price = price;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}