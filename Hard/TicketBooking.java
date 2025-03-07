import java.util.*;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private static boolean[] seats = new boolean[TOTAL_SEATS];

    public synchronized boolean bookSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= TOTAL_SEATS || seats[seatNumber]) {
            return false; // Seat is already booked or invalid
        }
        seats[seatNumber] = true;
        return true;
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private int seatNumber;

    public BookingThread(TicketBookingSystem system, int seatNumber, String name, int priority) {
        super(name);
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    @Override
    public void run() {
        if (system.bookSeat(seatNumber)) {
            System.out.println(getName() + " successfully booked seat " + seatNumber);
        } else {
            System.out.println(getName() + " failed to book seat " + seatNumber + " (Already booked or invalid)");
        }
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();

        List<Thread> threads = new ArrayList<>();
        threads.add(new BookingThread(system, 2, "VIP-1", Thread.MAX_PRIORITY));
        threads.add(new BookingThread(system, 2, "Regular-1", Thread.NORM_PRIORITY));
        threads.add(new BookingThread(system, 5, "VIP-2", Thread.MAX_PRIORITY));
        threads.add(new BookingThread(system, 5, "Regular-2", Thread.NORM_PRIORITY));
        threads.add(new BookingThread(system, 7, "VIP-3", Thread.MAX_PRIORITY));
        threads.add(new BookingThread(system, 7, "Regular-3", Thread.NORM_PRIORITY));

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

