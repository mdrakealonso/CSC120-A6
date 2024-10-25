import java.util.Hashtable;

/**
 * Represents the Library class
 */
public class Library extends Building {

  // Attributes
  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for a Library class
   * @param name a Library's name
   * @param address a Library's address
   * @param nFloors the number of stories inside a Library
   * @param collection a Library's collection in which
   *                   each item has a name and whether it is available for check out
   */
  public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Returns a boolean based on whether an item is in a Library's collection
   * @param title the desired item's title
   * @return true if the item is in the collection
   */
  public boolean containsTitle(String title) {
    return (collection.containsKey(title));
  }
  /**
   * Returns a boolean based on whether an item in a Library's collection is available for check out
   * @param title the desired item's title
   * @return true if the item is in the collection and available
   */
  public boolean isAvailable(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " isn't in the library's collection.");
    }
    return (collection.get(title)).equals(true);
  }

  /**
   * Adds a title to a Library's collection, provided it is not already there
   * @param title the title to be added
   */
  public void addTitle(String title) {
    if (containsTitle(title)) {
      System.out.println(title + " is already in the library's collection.");
    } else {
      collection.put(title, true);
    }
  }

  /**
   * Removes a title from a Library's collection, provided it is currently there
   * @param title the title to be removed
   * @return the title that was removed
   */
  public String removeTitle(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " isn't in the library's collection.");
    }
    collection.remove(title);
    return (title);
  }

  /**
   * Checks out an item, provided it is there and available, 
   * by changing its availablity status to false
   * @param title the item to be checked out
   */
  public void checkOut(String title) {
    if (!isAvailable(title)) {
      System.out.println(title + " isn't available.");
    } else {
      collection.replace(title, true, false);
    }
  }

  /**
   * Returns an item, provided it has not already been returned,
   * by changing its availability status to true
   * @param title the item to be returned
   */
  public void returnBook(String title) {
    if (isAvailable(title)) {
      System.out.println(title + " has already been returned.");
    } else {
      collection.replace(title, false, true);
    }
  }

  /**
   * Prints an organized record of a Library's collection,
   * with each item's title and availability status
   */
  public void printCollection() {
    for (String key : collection.keySet()) {
      System.out.println("Title: " + key + ". Available for checkout: " + collection.get(key));
    }
  }
  
  /**
     * A main function for creating an example Library
     * @param args an empty Array of Strings for storing command line arguments
     */
  public static void main(String[] args) {
    Library forbesLib = new Library("Forbes Library", "20 West St", 3, new Hashtable<>());
    forbesLib.addTitle("David Copperfield");
    forbesLib.addTitle("Animal Farm");
    forbesLib.printCollection();
    forbesLib.checkOut("David Copperfield");
    forbesLib.printCollection();
    forbesLib.returnBook("David Copperfield");
    forbesLib.printCollection();
    //forbesLib.returnBook("DC");
    forbesLib.removeTitle("Animal Farm");
    forbesLib.printCollection();
  }
}