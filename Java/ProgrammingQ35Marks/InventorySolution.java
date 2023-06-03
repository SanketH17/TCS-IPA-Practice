import java.util.Scanner;

public class InventorySolution {
    public static void main(String[] args) {
        Inventory[] inventory = new Inventory[4];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < inventory.length; i++) {
            int inventoryId = sc.nextInt();
            sc.nextLine();
            int maximumQuantity = sc.nextInt();
            int currentQuantity = sc.nextInt();
            int threshold = sc.nextInt();
            sc.nextLine();

            inventory[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        int limit = sc.nextInt();
        sc.close();

        // this method will return an array of inventory where the threshold attribute
        // is less than or equal to the int parameter passed

        // this method should be called from main method and display the id of returned
        // objects along with filling status

        Inventory[] newInventory = replenish(inventory, limit);

        for (int i = 0; i < newInventory.length; i++) {
            if (newInventory[i].getThreshold() >= 75) {
                System.out.println(newInventory[i].getInventoryID() + " Critical Filling");
            } else if (newInventory[i].getThreshold() <= 74 && newInventory[i].getThreshold() >= 50) {
                System.out.println(newInventory[i].getInventoryID() + " Moderate Filling");
            } else {
                System.out.println(newInventory[i].getInventoryID() + " Non-Critical Filling");
            }
        }
    }

    public static Inventory[] replenish(Inventory[] inventory, int limit) {
        int count = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getThreshold() <= limit) {
                count++;
            }
        }
        int index = 0;
        Inventory[] newInventory = new Inventory[count];
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getThreshold() <= limit) {
                newInventory[index] = inventory[i];
                index++;
            }
        }
        return newInventory;
    }

}

class Inventory {
    private int inventoryID;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    // inventoryID
    public int getInventoryID() {
        return this.inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    // maximumQuantity
    public int getMaximumQuantity() {
        return this.maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    // currentQuantity
    public int getCurrentQuantity() {
        return this.currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    // threshold
    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    // constructor
    public Inventory(int inventoryID, int maximumQuantity, int currentQuantity, int threshold) {
        super();
        this.inventoryID = inventoryID;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
}
