import java.util.Vector;


/**
 * @author Fletcher Meyer
 */
public class Bingo {
    private Vector<String> balls;
    private BingoCard card;

    public Bingo(){
        CardReader readCards = new CardReader();
        readCards.getCards().get(0);
        this.card = readCards.getCards().get(0);
    }

    public BingoCard getCard() {
        return card;
    }

    public Vector<String> getBalls() {
        return balls;
    }

    public void setBalls(Vector<String> balls) {
        this.balls = balls;
    }

    public void setCard(BingoCard card) {
        this.card = card;
    }

    public String drawABall(){
        if (this.balls.size() == 0) return "";
        int rand = (int)(Math.random() * this.balls.size());
        String toReturn = this.balls.get(rand);
        this.balls.remove(rand);
        return toReturn;
    }

    public void fillBalls(){
        Vector<String> tempBalls = new Vector<>();

        for (int i = 1; i < 16; i++){
            String tmp = "B" + i; 
            tempBalls.add(tmp);
        }
        for (int i = 16; i < 31; i++){
            String tmp = "I" + i; 
            tempBalls.add(tmp);

        }
        for (int i = 31; i < 46; i++){
            String tmp = "N" + i; 
            tempBalls.add(tmp);
        }
        for (int i = 46; i < 61; i++){
            String tmp = "G" + i; 
            tempBalls.add(tmp);
        }
        for (int i = 61; i < 76; i++){
            String tmp = "O" + i; 
            tempBalls.add(tmp);
        }

        this.balls = randomizeVector(tempBalls);
        printVector(tempBalls);
    }

    public <T> Vector<T> randomizeVector(Vector<T> someVector){
        Vector<T> newVector = new Vector<>();

        while (someVector.size() != 0){
            int rand = (int)(Math.random() * someVector.size());
            newVector.add(someVector.get(rand));
            someVector.remove(rand);
        }
        return newVector;
    }

    public static <T> void printVector(Vector<T> someVector){
        for (int i = 0; i < someVector.size(); i++){
            System.out.println(someVector.get(i));
        }
    }
}
