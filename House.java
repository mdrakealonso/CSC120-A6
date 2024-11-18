import java.util.ArrayList;

/**
 * Represents the House class
 */
public class House extends Building {

  // Attributes
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * Constructor for the House class
   * @param name a House's name
   * @param address a House's address
   * @param nFloors the number of stories inside a House
   * @param residents residents living in a House
   * @param hasDiningRoom whether or not a House has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom){
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Returns a boolean based on whether a house has a dining room
   * @return true if a House has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents currently living in a House
   * @return a House's number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Returns a boolean based on whether a given person is a resident of a House
   * @param name a person's name
   * @return true if a person is a resident
   */
  public boolean isResident(String name) {
    return (residents.contains(name));
  }

  /**
   * Moves a new resident into a house, provided they are not already living there
   * @param name the name of the person to move in
   */
  public void moveIn(String name) {
    if (isResident(name)) {
      throw new RuntimeException(name + " is already living at this address.");
    }
    residents.add(name);
  }

  /**
   * Moves a new resident out of a house, provided they are currently living there
   * @param name the name of the person to move out
   */
  public String moveOut(String name) {
    if (!isResident(name)) {
      throw new RuntimeException(name + " is not living at this address.");
    }
    residents.remove(name);
    return(name);
  }

  /**
     * Returns a String representing a House with building and resident details.
     * @return a String representing a House
     */
  public String toString() {
    String diningRoom = "";
    if(hasDiningRoom) {
      diningRoom = "a dining room";
    } else {
      diningRoom = "no dining room";
    }
    return super.toString() + " with " + diningRoom + " and " + nResidents() + " resident(s)";
  }

  /**
     * A main function for creating an example House
     * @param args an empty Array of Strings for storing command line arguments
     */
  public static void main(String[] args) {
    House someHouse = new House("Harry's House", "12 Grimmauld Place", 3, true);
    System.out.println(someHouse);
    someHouse.moveIn("Mavis");
    System.out.println(someHouse);
    someHouse.moveOut("Harry");
    someHouse.moveIn("Mavis");
    System.out.println(someHouse);
  }

}