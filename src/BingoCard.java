import java.util.Vector;

/**
 * @author Fletcher Meyer
 */
public class BingoCard {
    private Vector<Vector<Integer>> columns = new Vector<>();
    private Vector<Vector<Integer>> marks = new Vector<>();

    BingoCard(Vector<Vector<Integer>> newColumns) {
        this.columns = newColumns;
        for (int i = 0; i < 5; i++){
            Vector<Integer> toAdd = new Vector<>(); 
            for (int ii = 0; ii < 5; ii++){
                toAdd.add(0);
            }   
            marks.add(toAdd);
        }
    }
    BingoCard() {
        for (int i = 0; i < 5; i++){
            Vector<Integer> toAdd = new Vector<>(); 
            for (int ii = 0; ii < 5; ii++){
                toAdd.add(0);
            }   
            marks.add(toAdd);
        }
    }

    public static int convert(String input) {
        char[] asChars = input.toCharArray();
        int firstPos = -1;
        switch (asChars[0]) {
            case 'B':
                firstPos = 0;
                break;
            case 'I':
                firstPos = 1;
                break;
            case 'N':
                firstPos = 2;
                break;
            case 'G':
                firstPos = 3;
                break;
            case 'O':
                firstPos = 4;
                break;
        }
        
        return firstPos;
    }

    public void mark(int loc1, int loc2) {
        marks.get(loc1 - 1).set(loc2 - 1, 1);
    }

    public Vector<Vector<Integer>> getColumns() {
        return columns;
    }

    public void setColumns(Vector<Vector<Integer>> columns) {
        this.columns = columns;
    }

    public void printMarkedCard(){
        System.out.println("     B    I    N    G    O");
        int row = 1;
        for (Vector<Integer> column : this.marks) {
            System.out.print(row + " | ");
            row++;
            for (Integer value : column) {
                if (Integer.toString(value).length() == 1){
                    System.out.print(" ");
                }
                System.out.print(value + " | ");
            }
            System.out.println();
        }

        
    }
    public void printMarkedCard(int q){
        System.out.println("     B    I    N    G    O");
        
        for (int i = 0; i < this.marks.size(); i++){
            System.out.print((i+1) + " | ");
            Vector<Integer> currentCol = this.marks.get(i);
            for (int ii = 0; ii < currentCol.size(); ii++){
                if (currentCol.get(ii) == 0){
                    if (Integer.toString(this.columns.get(i).get(ii)).length() == 1){
                        System.out.print(" ");
                    }
                    System.out.print(this.columns.get(i).get(ii) + " | ");
                } else {
                    System.out.print(" X | ");
                }
            }
            System.out.println();
        }

        
    }

    public void printCardValues() {
        System.out.println("   B    I    N    G    O");
        for (Vector<Integer> column : this.columns) {
            System.out.print("| ");
            for (Integer value : column) {
                if (Integer.toString(value).length() == 1){
                    System.out.print(" ");
                }
                System.out.print(value + " | ");
            }
            System.out.println();
        }

    }
}
