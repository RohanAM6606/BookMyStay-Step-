import java.util.HashMap;

abstract class Room {

    int beds;
    int size;
    int price;

    Room(int beds, int size, int price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq.ft");
        System.out.println("Price: $" + price);
    }
}

class SingleRoom extends Room {

    SingleRoom() {
        super(1, 200, 100);
    }
}

class DoubleRoom extends Room {

    DoubleRoom() {
        super(2, 350, 180);
    }
}

class SuiteRoom extends Room {

    SuiteRoom() {
        super(3, 600, 350);
    }
}

/* Centralized Inventory Class */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    int getAvailability(String roomType) {
        return inventory.get(roomType);
    }

    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }
}

/* Search Service (Read Only) */
class SearchService {

    void searchAvailableRooms(RoomInventory inventory,
                              Room single,
                              Room doubleRoom,
                              Room suite) {

        System.out.println("\n--- Available Rooms ---");

        if (inventory.getAvailability("Single") > 0) {
            System.out.println("\nSingle Room");
            single.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Single"));
        }

        if (inventory.getAvailability("Double") > 0) {
            System.out.println("\nDouble Room");
            doubleRoom.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Double"));
        }

        if (inventory.getAvailability("Suite") > 0) {
            System.out.println("\nSuite Room");
            suite.displayDetails();
            System.out.println("Available: " + inventory.getAvailability("Suite"));
        }
    }
}

public class BookMyStay {

    public static void main(String[] args){

        System.out.println("Welcome to BookMyStay");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.\n");

        // Creating room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Creating centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Search service
        SearchService searchService = new SearchService();

        // Guest searches rooms
        searchService.searchAvailableRooms(inventory, single, doubleRoom, suite);

        System.out.println("\nSearch completed. Inventory remains unchanged.");
    }
}