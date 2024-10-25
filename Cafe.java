/**
 * Represents the Cafe class
 */
public class Cafe extends Building{

    // Attributes
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for Cafe class
     * @param name a Cafe's name
     * @param address a Cafe's address
     * @param nFloors the number of stories inside a Cafe
     * @param nCoffeeOunces number of ounces of coffee remaining in a Cafe's inventory
     * @param nSugarPackets number of sugar packets remaining in a Cafe's inventory
     * @param nCreams number of pumps of cream remaining in a Cafe's inventory
     * @param nCups number of cups remaining in a Cafe's inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Restocks the coffee, sugar packets, cream, and cups in a Cafe's inventory 
     * @param nCoffeeOunces ounces of coffee to be in the inventory after restock
     * @param nSugarPackets number of sugar packets to be in the inventory after restock
     * @param nCreams pumps of cream to be in the inventory after restock
     * @param nCups number of cups to be in the inventory after restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Decreases a Cafe's inventory by selling a drink 
     * containing a given amount of coffee, sugar packets, and cream.
     * If inventory stock is too low, restocks before selling.
     * @param size the desired amount of coffee in ounces
     * @param nSugarPackets the desired number of sugar packets
     * @param nCreams the desired pumps of cream
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Inventory low. Restocking...");
            restock((size + 10), (nSugarPackets + 10), (nCreams + 10), 10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * Returns a String representing a Cafe with building and inventory details.
     */
    public String toString() {
        return super.toString() + ". " + "\n" + "The current cafe inventory is " + nCoffeeOunces + " ounces of coffee, " + nCreams + " pumps of cream, " + nSugarPackets + " sugar packets, and " + nCups + " cups.";
    }
 
    /**
     * A main function for creating an example Cafe
     * @param args an empty Array of Strings for storing command line arguments
     */
    public static void main(String[] args) {
        Cafe funCafe = new Cafe("Sunbucks", "1 Chapin Way", 10, 15, 10, 15, 5);
        //funCafe.restock(10, 100, 100, 100);
        System.out.println(funCafe);
        funCafe.sellCoffee(100, 100, 100);
        System.out.println(funCafe);
    }
    
}
