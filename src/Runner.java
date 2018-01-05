import java.util.Collections;

public class Runner{
    public static void main(String[] args){
        Deck theDeck=new Deck(true);
        for(int i=0; i<theDeck.getDeck().length; i++) {
            System.out.println(theDeck.getDeck()[i].getName());
        }

        theDeck.mergeSort(theDeck.allCards);
        System.out.println("");
        System.out.println("Merge-sorted deck:");
        for(int k=0; k<theDeck.getDeck().length; k++){
            System.out.println(theDeck.getDeck()[k].getName());
        }

        theDeck.shuffleDeck();
        System.out.println("");
        System.out.println("Hand dealt:");
        theDeck.dealHand(7);
        theDeck.mergeSortHand();
        for(int j=0; j<theDeck.listHand().length; j++){
            System.out.println(theDeck.listHand()[j].getName());
        }

        /*
        theDeck.mergeSortHand();
        System.out.println("");
        System.out.println("Merge-sorted hand:");
        for(int k=0; k<theDeck.listHand().length; k++){
            System.out.println(theDeck.listHand()[k].getName());
        }

        System.out.println("");
        System.out.println("Bubble-sorted hand:");
        for(int k=0; k<theDeck.bubbleSortHand().length; k++){
            System.out.println(theDeck.bubbleSortHand()[k].getName());
        }

        System.out.println("");
        System.out.println("Bubble-sorted deck:");
        for(int j=0; j<theDeck.bubbleSort().length; j++){
            System.out.println(theDeck.bubbleSort()[j].getName());
        }
        */
    }
}