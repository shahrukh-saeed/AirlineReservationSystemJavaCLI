import java.util.Scanner;

public class Portal {

    public static void main(String[] args) throws Exception {
        Scanner scanS = new Scanner(System.in);
        Scanner scanN = new Scanner(System.in);

        System.out.println("AIRLINE RESERVATION SYSTEM");

        while (true) {

            System.out.println("\n1. New Flight\n2. New Passenger\n3. Display Flight Seating Plan\n4. Display All Flights\n5. Display All Passengers\nq. Quit");
            System.out.print("> ");
            String input = scanS.nextLine();
            System.out.println();

            switch (input) {
                case "1": {
                    System.out.println("Flight Number > Model > Rows > Cols");
                    new Flight(scanS.nextLine(), scanS.nextLine(), scanN.nextInt(), scanN.nextInt());
                    break;
                }
                case "2": {
                    System.out.println("Flight Number > Name > Row > Col");
                    new Passenger(scanS.nextLine(), scanS.nextLine(), scanN.nextInt(), scanN.nextInt());
                    break;
                }
                case "3": {
                    System.out.println("Flight Number");

                    Flight.printSeatingPlan(scanS.nextLine());
                    break;
                }
                case "4": {
                    Flight.printFlights();
                    break;
                }
                case "5": {
                    Passenger.printPassengers();
                    break;
                }
                case "q": {
                    System.exit(0);
                    break;
                }
            }
        } 
    }
}
