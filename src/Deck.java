import java.util.Arrays;
import java.util.Collections;

public class Deck{
    private Card[] allCards;
    private Card[] hand=new Card[7];

    public Deck(boolean x){
        int count=0;
        if(x){
            allCards=new Card[52];
            for(int i=0; i<=3; i++){
                for(int j=0; j<=12; j++){
                    allCards[count]=new Card(i, j);
                    count++;
                }
            }
        }
        else{
            allCards=new Card[13];
            for(int k=0; k<=12; k++){
                allCards[count]=new Card(0, k);
                count++;
            }
        }
    }

    public Card[] getDeck(){
        return allCards;
    }
    public void swap(int first, int second){
        Card temp=allCards[first];
        allCards[first]=allCards[second];
        allCards[second]=temp;
    }
    public void dealHand(int numCards){
        for(int i=0; i<numCards; i++){
            hand[i]=allCards[i];
        }
    }
    public Card[] listHand(){
        return hand;
    }
    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(allCards));
    }
    public Card[] bubbleSort(){
        int y=allCards.length;
        for(int j=0; j<y; j++){
            for(int i=0; i<y-1; i++){
                if(allCards[i].getValue()>allCards[i+1].getValue()){
                    swap(i, i+1);
                }
            }
        }
        return allCards;
    }
    public Card[] selectionSortHand(){
        int firstValue=hand[0].getValue();
        for(int i=0; i<hand.length; i++){
            if(firstValue>hand[i].getValue()){
                swap(0, i);
            }
        }
        return hand;
    }
    public void mergeSort(){

    }
    public void binarySearch(int suit, int face){

    }
}