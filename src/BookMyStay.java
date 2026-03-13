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

public class BookMyStay {

    public static void main(String[] args){

        System.out.println("Welcome to BookMyStay");
        System.out.println("Version: 1.0");
        System.out.println("System initialized successfully.\n");


        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Availability using int variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("----- Single Room -----");
        single.displayDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\n----- Double Room -----");
        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\n----- Suite Room -----");
        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable);

        System.out.println("\nApplication Terminated.");
    }
}