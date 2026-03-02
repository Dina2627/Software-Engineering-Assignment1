import java.util.ArrayList;
import java.util.Scanner;

class Artwork {
    private  String artist_name;
    private String artwork_name;
    private double purchase_price;
    private double sell_price;


    // constractor
    Artwork (String ar , String ark , double pp) {
        artist_name = ar;
        artwork_name = ark;
        purchase_price = pp;
        sell_price = purchase_price * 1.2;
    }

    double getProfit() {
        return sell_price - purchase_price;
    }

    String getArtistname() {
        return artist_name;
    }

    String getArtwork_name (){
        return artwork_name;
    }

    public double getSellPrice() {
        return sell_price;
    }
}
//-------------------------------------------------------------
class Stock {
    public ArrayList<Artwork> artworks ;

    Stock() {
        artworks = new ArrayList<>();
    }

    void Add_artwork (Artwork a) {
        artworks.add(a);
    }

    void remove_artwork(String artist, String artworkName) {
        for (int i = 0; i < artworks.size(); i++) {
            if (artworks.get(i).getArtistname().equals(artist) &&
                    artworks.get(i).getArtwork_name().equals(artworkName)) {

                artworks.remove(i);
                return;
            }
        }
    }  //removed the old one w the remove only bc it searches for a refrence then deletes but u search for items w their names so it won't work :0

    boolean find_artwork (Artwork a){
         for (int i = 0; i< artworks.size() ;i++) {
             if (a.getArtwork_name().equals(artworks.get(i).getArtwork_name()) && a.getArtistname().equals(artworks.get(i).getArtistname())) {
                return true;
             }
         }
         return false;
    }

    void displayArtwork (){
        for (Artwork a :artworks) {
            System.out.println(a.getArtwork_name() + " - " + a.getArtistname() );
        }
        System.out.println("================================"); //tried to use this method in my buyartwork case but couldn't XC
    }

}

//-------------------------------------------------------------

class MarketPlace extends Stock {
    private double totalProfit;

    void sellArtwork(Stock s, Artwork a) {
        if (s.find_artwork(a)) {
            s.remove_artwork(a.getArtistname(), a.getArtwork_name());
            totalProfit += a.getProfit();
            System.out.println(" u have Bought: " + a.getArtwork_name());
        }
        else {
            System.out.println("Artwork not found in stock.");
        }
    }

    void buyArtwork (Stock s, Artwork a) {
        s.Add_artwork(a);
        System.out.println("u have sold " + a.getArtwork_name());
    }
    double getMarketProfit() {
        return totalProfit;
    }
}

//-------------------------------------------------------------
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //to input


        Stock stock = new Stock();
        MarketPlace market = new MarketPlace();

        stock.Add_artwork(new Artwork("Van Gogh", "Starry Night", 1000));
        stock.Add_artwork(new Artwork("Da Vinci", "Mona Lisa", 2000));
        stock.Add_artwork(new Artwork("Picasso", "Guernica", 1500));


        System.out.println("===================================================================\n welcome to Artworks market place! \n it is nice to meet u again traveller :D \n===================================================================");

        char x = 'y';

        while (x =='y') {


            System.out.println("what r u intrested in?\n" +
                    "[1]display artworks stock\n" +
                    "[2]sell an artwork\n" +
                    "[3]buy an artwork\n" +
                    "[4]show market profit\n" +
                    "[5]exit\n" +
                    "pls choose a num :D");
            int num = sc.nextInt();
            sc.nextLine();

            if (num == 1) {
                stock.displayArtwork();
            }


            if (num == 2) {
                System.out.print("Enter artist name: ");
                String artist = sc.nextLine();

                System.out.print("Enter artwork name: ");
                String artworkName = sc.nextLine();

                for (int i = 0; i < 3; i++){
                    System.out.print("Enter purchase price: ");
                double price = sc.nextDouble();
                if (price > 2000) {
                    System.out.print("this is too expenseve :b \n");
                    if (i == 2) { System.out.println(" sorry purchase failed XC !!");}
                }
                else {
                    Artwork a1 = new Artwork(artist, artworkName, price);
                    market.buyArtwork(stock, a1);
                    break;
                }
            }
            }


            if (num == 3) {
                for (int i = 0; i < stock.artworks.size(); i++) {
                    Artwork a = stock.artworks.get(i);
                    System.out.println((i + 1) + ") " + a.getArtwork_name() + " - " + a.getArtistname() + " - " + a.getSellPrice() );
                }
                    System.out.print("Enter the number: ");
                    int choice = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    Artwork selected = stock.artworks.get(choice - 1);

                    market.sellArtwork(stock, selected);
            }


            if (num == 4) {
                System.out.println("earned profit from sold artworks = " + market.getMarketProfit());
            }

            if (num == 5) {
                System.out.println("have a nice day 3>");
                x = 'n';
            }


        }

    }
}