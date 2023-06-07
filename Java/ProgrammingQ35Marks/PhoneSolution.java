
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