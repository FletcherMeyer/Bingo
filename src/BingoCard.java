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

    public void mark(int[] location) {
        marks.get(location[0]).set(location[1], 1);
    }

    public Vector<Vector<Integer>> getColumns() {
        return columns;
    }

    public void setColumns(Vector<Vector<Integer>> columns) {
        this.columns = columns;
    }

    public void printCard() {
        for (Vector<Integer> column : this.columns) {
            for (Integer value : column) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }

    }
}
