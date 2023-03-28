import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public static void readPassengers() throws IOException {
        File passFile = new File("Passengers.txt");

        Scanner scanS = new Scanner(passFile);

        while(scanS.hasNextLine()) {
            String[] passInfo = scanS.nextLine().split(";");

            new Passenger(passInfo[0], passInfo[1], Integer.parseInt(passInfo[2]), Integer.parseInt(passInfo[3]));
        }
 
    }

    public static void writePassenegers() throws IOException {
        FileWriter writePass = new FileWriter("Passengers.txt");

        for (Passenger pass : passengers) {
            writePass.write(pass.getFlightNum() + ";" + pass.getName() + ";" + pass.getRow() + ";" + pass.getCol());
        }

        writePass.close();
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
