import java.util.Scanner;
import java.util.*;

// IPA 12

public class MedicineSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Medicine[] medicines = new Medicine[4];

		for (int i = 0; i < medicines.length; i++) {
			String medicineName = sc.next();
			String batch = sc.next();
			String disease = sc.next();
			int price = sc.nextInt();

			medicines[i] = new Medicine(medicineName, batch, disease, price);
		}
		String targetDisease = sc.next();
		sc.close();

		List<Integer> ansPrice = getPriceByDisease(medicines, targetDisease);

		if (!ansPrice.isEmpty()) {
			for (int price : ansPrice) {
				System.out.println(price);
			}
		} else {
			System.out.println("No medicine is available for the specified disease.");
		}

	}

	public static List<Integer> getPriceByDisease(Medicine[] medicines, String targetDisease) {

		List<Integer> prices = new ArrayList<>();

		for (Medicine medicine : medicines) {
			if (medicine.getDisease().equalsIgnoreCase(targetDisease)) {
				prices.add(medicine.getPrice());
			}
		}
		prices.sort(null);
		return prices;

	}

}


class Medicine {
	private String medicineName;
	private String batch;
	private String disease;
	private int price;

	public Medicine(String medicineName, String batch, String disease, int price) {
		super();
		this.medicineName = medicineName;
		this.batch = batch;
		this.disease = disease;
		this.price = price;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}