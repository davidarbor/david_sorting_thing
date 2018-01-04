import java.util.Collections;

public class Runner{
    public static void main(String[] args){
        Deck theDeck=new Deck(true);
        for(int i=0; i<theDeck.getDeck().length; i++) {
            System.out.println(theDeck.getDeck()[i].getName());
        }

        theDeck.shuffleDeck();
        System.out.println("");
        System.out.println("Hand dealt:");
        theDeck.bubbleSort();
        theDeck.dealHand(7);
        for(int j=0; j<theDeck.listHand().length; j++){
            System.out.println(theDeck.listHand()[j].getName());
        }

        Mergesort m=new Mergesort();
        int toSort[]={12, 11, 13, 5, 6, 7};
        m.numbers=toSort;
        m.mergesort();

        /*
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