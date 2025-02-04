
/*
Object-oriented design
Consistent good programming style
Documentation (in the code and any other documentation you may have created)
Source and any documentation must be saved in a Repository on GitHub in our class organization
Command Line Interface - use system prompts and user inputs; no GUI is allowed
Write as best you can for extensibility as a peer will be adding features and automated tests to this program
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Bingo game = new Bingo();

        game.getCard().printMarkedCard(1);
        game.fillBalls();

        String ball = game.drawABall();

        while (ball != ""){
            System.out.println(ball + ", ");
            int c2 = (sc.nextInt());
            int c1 = (sc.nextInt());

            game.getCard().mark(c1, c2);
            game.getCard().printMarkedCard(1);
            // System.out.print(BingoCard.convert(ball));
            // System.out.println();

            ball = game.drawABall();
        }

    }
}