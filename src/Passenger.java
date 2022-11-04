import java.util.ArrayList;

public class Passenger {
    private String flightNum;
    private String name;
    private int row;
    private int col;
    public static ArrayList<Passenger> passengers = new ArrayList<>();

    public Passenger(String flightNum, String name, int row, int col) {
        this.flightNum = flightNum;
        this.name = name;
        this.row = row;
        this.col = col;
        passengers.add(this);
        Flight.addPassenger(this);
    }

    public static void printPassengers() {
        System.out.println(passengers);
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String toString() {
        return(name + " on " + flightNum + " at " + row + " " + col);
    }
}
