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

    void displayInventory() {
        System.out.println("\n--- Current Inventory ---");

        for(String room : inventory.keySet()){
            System.out.println(room + " Rooms Available: " + inventory.get(room));
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

        System.out.println("----- Single Room -----");
        single.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Single"));

        System.out.println("\n----- Double Room -----");
        doubleRoom.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Double"));

        System.out.println("\n----- Suite Room -----");
        suite.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Suite"));

        // Display all inventory
        inventory.displayInventory();

        System.out.println("\nApplication Terminated.");
    }
}