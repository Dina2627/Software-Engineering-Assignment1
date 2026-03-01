import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // global variables needed for the seats data
    static int registered = 0;
    static String[] routes = { "Cairo to Aswan", "Aswan to Cairo", "Alex to Aswan", "Aswan to Alex" };
    static int[][] seats = { { 20, 20, 20, 20 }, { 80, 80, 80, 80 } };

    // container for all tickets registered
    static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public static void main(String[] args) {

        System.out.print("================================================\n");
        System.out.print("=========  Train Registeration System  =========\n");
        System.out.print("================================================\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice;
            showMenu();
            choice = scanner.nextInt();
            System.out.print("================================================\n");

            switch (choice) {
                case 1:
                    availableSeats();
                    break;
                case 2:
                    bookTicket(scanner);
                    break;
                case 3:
                    if(tickets.isEmpty()){
                        System.out.println("No tickets registered to cancel\n");
                        break;
                    }
                    else{
                        cancelTicket(scanner);
                        break;

                    }
                case 4:
                    if(tickets.isEmpty()){
                        System.out.println("No tickets registered\n");
                        break;
                    }
                    else{
                        ticketInfo();
                        break;
                    }
                case 5:
                    System.out.println("Thanks for using our registeration system <3");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.print("1. Show available seats\n");
        System.out.print("2. Book a ticket\n");
        System.out.print("3. Cancel a ticket\n");
        System.out.print("4. My registered tickets\n");
        System.out.print("5. Exit program\n");
        System.out.print("================================================\n");
        System.out.print("Select your choice: ");
    }

    public static void availableSeats() {
        System.out.println("1. Cairo to Aswan route:\n");
        System.out.println("    Vip class ---------> (" + seats[0][0] + ") seats remaining\n");
        System.out.println("    Passenger class ---> (" + seats[1][0] + ") seats remaining\n");
        System.out.print("================================================\n");
        System.out.println("2. Aswan to Cairo route:\n");
        System.out.println("    Vip class ---------> (" + seats[0][1] + ") seats remaining\n");
        System.out.println("    Passenger class ---> (" + seats[1][1] + ") seats remaining\n");
        System.out.print("================================================\n");
        System.out.println("3. Alex to Aswan route:\n");
        System.out.println("    Vip class ---------> (" + seats[0][2] + ") seats remaining\n");
        System.out.println("    Passenger class ---> (" + seats[1][2] + ") seats remaining\n");
        System.out.print("================================================\n");
        System.out.println("4. Aswan to Alex route:\n");
        System.out.println("    Vip class ---------> (" + seats[0][3] + ") seats remaining\n");
        System.out.println("    Passenger class ---> (" + seats[1][3] + ") seats remaining\n");
        System.out.print("================================================\n\n");
    }

    public static void bookTicket(Scanner s) {
        // create a new ticket object and its attributes is based on user input
        Ticket ticket = new Ticket();
        registered++;

        // id
        ticket.id = registered;

        // route
        int choice;
        System.out.print("Choose the train route\n");
        System.out.print("1. Cairo to Aswan\n");
        System.out.print("2. Aswan to Cairo\n");
        System.out.print("3. Alex to Aswan\n");
        System.out.print("4. Aswan to Alex\n");
        System.out.print("Enter a number: ");
        while(true){
            choice = s.nextInt();
            if (choice == 1){
                ticket.route = routes[0];
                break;
            }
            else if (choice == 2){
                ticket.route = routes[1];
                break;
            }
            else if (choice == 3){
                ticket.route = routes[2];
                break;
            }
            else if (choice == 4){
                ticket.route = routes[3];
                break;
            }
            System.out.println("Enter a valid number of the trip route: ");
        }
        
        // day
        System.out.print("\nChoose the trip date in (dd/mm/yyyy) format:\n");
        ticket.date = s.next();
        
        // time
        int n;
        System.out.print("\nChoose the trip time:\n");
        System.out.print("1. 08:00 AM\n");
        System.out.print("2. 10:00 AM\n");
        System.out.print("3. 12:00 PM\n");
        System.out.print("4. 02:00 PM\n");
        System.out.print("5. 04:00 PM\n");
        System.out.print("6. 06:00 PM\n");
        System.out.print("Enter a number: ");
        while(true){
            n = s.nextInt();
            if (n == 1){
                ticket.time = "08:00 AM";
                break;
            }
            else if (n == 2){
                ticket.time = "10:00 AM";
                break;
            }
            else if (n == 3){
                ticket.time = "12:00 PM";
                break;
            }
            else if (n == 4){
                ticket.time = "02:00 PM";
                break;
            }
            else if (n == 5){
                ticket.time = "04:00 PM";
                break;
            }
            else if (n == 6){
                ticket.time = "10:00 PM";
                break;
            }
            System.out.println("Enter a valid number of the trip timing: ");
        }


        // class
        int x;
        System.out.print("\nChoose seats class type : \n");
        System.out.print("1. Vip\n");
        System.out.print("2. Passenger\n");
        System.out.print("Enter a number: ");
        while(true){
            x = s.nextInt();
            if (x == 1){
                ticket.seatClass = "VIP";
                break;
            }
            else if (x == 2){
                ticket.seatClass = "Passenger";
                break;
            }
            System.out.println("Enter a valid number of the trip seat class:");
        }

        // seats number
        System.out.print("\nEnter how many seats would you register: \n");
        ticket.seats = s.nextInt();

        // seat calculation
        while (true) {
            int t = ticket.seats;
            boolean booked = false;

            while (ticket.seats < 0) {
                System.out.print("\nEnter a valid number of seats to register: \n");
                ticket.seats = s.nextInt();
            }
            for (int i = 0; i < 4; ++i) {
                if (ticket.seatClass.equals("VIP") && ticket.route.equals(routes[i]) && seats[0][i] >= t) {
                    seats[0][i] -= t;
                    booked = true;
                } else if (ticket.seatClass.equals("Passenger") && ticket.route.equals(routes[i]) && seats[1][i] >= t) {
                    seats[1][i] -= t;
                    booked = true;
                }
            }
            if (booked)
                break;
            System.out.println("Remainig seats are not enogh!\n");
            System.out.print("\nEnter a valid number of seats to register: \n");
            ticket.seats = s.nextInt();
        }
        System.out.println("================================================\n");
        
        // add new ticket to the arraylist
        tickets.add(ticket);
    }

    public static void ticketInfo() {
        // print info for every ticket in the tickets arraylist
        for (Ticket t : tickets) {
            System.out.println("Ticket ID:" + t.id);
            System.out.println("Route: " + t.route);
            System.out.println("Date:" + t.date);
            System.out.println("Time: " + t.time);
            System.out.println("Number of seats: " + t.seats);
            System.out.println("Seat class: " + t.seatClass);
            System.out.println("================================================\n");
        }
        System.out.println("Number of registed tickets: " + tickets.size());
        System.out.println("================================================\n");
    }
    
    public static void cancelTicket(Scanner s) {
        int x;
        System.out.print("All registered tickets:\n");
        System.out.println("================================================\n");
        ticketInfo();
        System.out.print("Enter ticket id of the ticket you want to cancel: ");
        x = s.nextInt();
        while (x > registered || x < 0) {
            System.out.println("Wrong ticket ID!!");
            x = s.nextInt();
        }

        // remove ticket by id (index+1)
        for (Ticket t : tickets) {
            if (x == t.id)
                tickets.remove((t.id - 1));
        }
    }
}