import java.util.ArrayList;

public class Flight {
    private String flightNum;
    private String model;
    private Passenger[][] seats;
    public static ArrayList<Flight> flights = new ArrayList<>();
    
    public Flight(String flightNum, String model, int rows, int col) {
        this.flightNum = flightNum;
        this.model = model;
        this.seats = new Passenger[rows][col];
        flights.add(this);
    }

    public static void printFlights() {
        System.out.println(flights);
    } 

    public void addPassenger(Passenger passenger, int row, int col) {
        seats[row][col] = passenger;
    }

    public static void addPassenger(Passenger passenger) {
        for (Flight flight : flights) {
            if (flight.flightNum.equalsIgnoreCase(passenger.getFlightNum())) {
                flight.addPassenger(passenger, passenger.getRow(), passenger.getCol());;
                return;
            }
        }
        System.out.println("\nNo Such Flight Exists");
        Passenger.passengers.remove(passenger);
    }

    public void printSeatingPlan() {
        System.out.println();
        for (Passenger[] passengers : seats) {
            for (Passenger passenger : passengers) {
                if (passenger == null) {
                    System.out.print("()");
                } else {
                    System.out.print("(" + passenger.getName() + ")");
                }
            }
            System.out.println();
        }
    }

    public static void printSeatingPlan(String flightNum) {
        for (Flight flight : flights) {
            if (flight.flightNum.equalsIgnoreCase(flightNum)) {
                flight.printSeatingPlan();
                return;
            }
        }
        System.out.println("\nNo Such Flight Exists");
    }

    public String toString() {
        return(flightNum);
    }
}
