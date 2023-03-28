import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Flight {
    private String flightNum;
    private String model;
    private Passenger[][] seats;
    private int rows;
    private int col;
    public static ArrayList<Flight> flights = new ArrayList<>();
    
    public Flight(String flightNum, String model, int rows, int col) {
        this.flightNum = flightNum;
        this.model = model;
        this.rows = rows;
        this.col = col;
        this.seats = new Passenger[rows][col];
        flights.add(this);
    }

    public static void readFlights() throws IOException {
        File flightsFile = new File("Flights.txt");

        Scanner scanS = new Scanner(flightsFile);

        while(scanS.hasNextLine()) {
            String[] flightInfo = scanS.nextLine().split(";");

            new Flight(flightInfo[0], flightInfo[1], Integer.parseInt(flightInfo[2]), Integer.parseInt(flightInfo[3]));
        }
 
    }

    public static void writeFlights() throws IOException {
        FileWriter writeFlights = new FileWriter("Flights.txt");

        for (Flight flight : flights) {
            writeFlights.write(flight.getFlightNum() + ";" + flight.getModel() + ";" + flight.getRows() + ";" + flight.getCol() + "\n");
        }

        writeFlights.close();
    }    

    public static void printFlights() {
        System.out.println(flights);
    } 

    public String getFlightNum() {
        return flightNum;
    }

    public String getModel() {
        return model;
    }

    public int getRows() {
        return rows;
    }

    public int getCol() {
        return col;
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
