import java.util.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Fletcher Meyer
 * @date 1/30/2025
 */
public class CardReader {
    Vector<BingoCard> Cards;

    public Vector<BingoCard> getCards() {
        return Cards;
    }

    public void setCards(Vector<BingoCard> cards) {
        Cards = cards;
    }

    CardReader() {
        Vector<BingoCard> BingoCards = new Vector<>();

        try {
            File cardsTxtFile = new File("./BingoCards.txt");
            Scanner fileReader = new Scanner(cardsTxtFile);

            Vector<Vector<Integer>> cardData = new Vector<>();

            while (fileReader.hasNextLine()) {

                String data = fileReader.nextLine();

                char[] lineAsChars = data.toCharArray();
                /* Finds a new Bingo card in the file. */
                if (lineAsChars[0] == 'C') {
                    BingoCard newCard = new BingoCard(cardData);
                    BingoCards.add(newCard);
                    // System.out.println("NEW CARD");
                    // newCard.printCard();

                    // System.out.println(data);
                    cardData.clear();
                } else {
                    Vector<Integer> column = stringToInts(data);
                    cardData.add(column);
                    // System.out.print(data);
                }
            }

            fileReader.close();
        } catch (FileNotFoundException error) {
            System.out.println("Error finding Bingo card data...");
        }
        this.Cards = BingoCards;
    }

    private static Vector<Integer> stringToInts(String input) {
        /*
         * Expecting input like:
         * "4, 20, 30, 50, 60"
         */

        char[] asArray = input.toCharArray();

        Vector<Integer> intVector = new Vector<>();

        String currentInt = "";

        for (char c : asArray) {
            if (c == ',') {
                intVector.add(Integer.parseInt(currentInt));
                currentInt = "";
            } else if (c == ' ') {
            } else {
                currentInt = currentInt + c;
            }
        }
        intVector.add(Integer.parseInt(currentInt));
        return intVector;
    }
}
