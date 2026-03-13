import java.util.LinkedList;
import java.util.Queue;



class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addBookingRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Booking request received from " + reservation.getGuestName());
    }

    public void displayQueue() {
        System.out.println("\nCurrent Booking Requests (FIFO Order):");

        for (Reservation r : requestQueue) {
            r.display();
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("       Book My Stay App          ");
        System.out.println("        Version 5.0              ");
        System.out.println("=================================");

        BookingRequestQueue queue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Rohan", "Single Room");
        Reservation r2 = new Reservation("Sampath", "Double Room");
        Reservation r3 = new Reservation("Rahul", "Suite Room");

        queue.addBookingRequest(r1);
        queue.addBookingRequest(r2);
        queue.addBookingRequest(r3);

        queue.displayQueue();

        System.out.println("\nAll requests stored in arrival order.");
        System.out.println("Room allocation will happen in the next stage.");
    }
}