public class Card{
     private int mSuit=0;
     private int mValue=0;
     private String mName="";

    public Card(int suit, int value){
        this.mSuit=suit;
        this.mValue=value;
    }

    public int getSuit(){
        return mSuit;
    }
    public int getValue(){
        return mValue;
    }
    public String suitName(){
        String nameOfSuit="";
        switch(mSuit){
            case 0:
                nameOfSuit="hearts";
                break;
            case 1:
                nameOfSuit="spades";
                break;
            case 2:
                nameOfSuit="diamonds";
                break;
            case 3:
                nameOfSuit="clubs";
                break;
        }
        return nameOfSuit;
    }

    public String getName(){
        if(mValue==0){
            mName="Ace of "+suitName();
        }
        else if(mValue==10){
            mName="Jack of "+suitName();
        }
        else if(mValue==11){
            mName="Queen of "+suitName();
        }
        else if(mValue==12){
            mName="King of "+suitName();
        }
        else{
            mName=(mValue+1)+" of "+suitName();
        }
        return mName;
    }
}
