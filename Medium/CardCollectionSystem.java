import java.util.*;

class CardCollection {
    private HashMap<String, List<String>> cards;

    public CardCollection() {
        cards = new HashMap<>();
    }

    public void addCard(String symbol, String cardName) {
        cards.putIfAbsent(symbol, new ArrayList<>());
        cards.get(symbol).add(cardName);
        System.out.println("Card added successfully!");
    }

    public void findCardsBySymbol(String symbol) {
        if (cards.containsKey(symbol)) {
            System.out.println("Cards with symbol " + symbol + ": " + cards.get(symbol));
        } else {
            System.out.println("No cards found for this symbol!");
        }
    }

    public void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards in the collection!");
        } else {
            for (Map.Entry<String, List<String>> entry : cards.entrySet()) {
                System.out.println("Symbol: " + entry.getKey() + " -> Cards: " + entry.getValue());
            }
        }
    }
}

public class CardCollectionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        
        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Add Card");
            System.out.println("2. Find Cards by Symbol");
            System.out.println("3. Display All Cards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Card Symbol (e.g., Hearts, Spades): ");
                    String symbol = scanner.nextLine();
                    System.out.print("Enter Card Name (e.g., Ace, King): ");
                    String cardName = scanner.nextLine();
                    collection.addCard(symbol, cardName);
                    break;
                case 2:
                    System.out.print("Enter Card Symbol to search: ");
                    symbol = scanner.nextLine();
                    collection.findCardsBySymbol(symbol);
                    break;
                case 3:
                    collection.displayAllCards();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
