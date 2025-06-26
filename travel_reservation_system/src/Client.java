import java.util.ArrayList;

public class Client {

    private String name;
    private ArrayList<Reservation> reservations;

    public Client (String name) {
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public String getName () {
        return name;
    }

    public void addReservation (String nameTrip) {
        reservations.add(new Reservation(nameTrip));
    }

    public boolean hasAlreadyBooked (String nameTrip) {
        for (Reservation reservation : reservations) {
            if (nameTrip.equalsIgnoreCase(reservation.getNameTrip())) {
                return true;
            }
        }
        return false;
    }

    public void showReservation () {
        if (reservations.isEmpty()) System.out.println("    ❌ No reservations found.");
        else {
            for (Reservation reservation : reservations) {
                System.out.println("    - " + reservation.getNameTrip());
            }
        }

    }

    public Reservation findReservation (String nameTrip) {
        for (Reservation reservation : reservations) {
            if (reservation.getNameTrip().equalsIgnoreCase(nameTrip)) return reservation;
        }
        return null;
    }

    public boolean cancelReservation (String nameTrip) {
        Reservation foundReservation = findReservation(nameTrip);
        if (foundReservation == null) {
            System.out.println("❌ No reservations found.");
            return false;
        } else {
            System.out.println("✅ Bookings to " + foundReservation.getNameTrip() + " canceled for " + name + ".");
            reservations.remove(foundReservation);
            return true;
        }
    }

}
