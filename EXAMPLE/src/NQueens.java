public class NQueens {
    final int N = 10;


    //Pomocna funkcija za ispisivanje resenja
    void printSoultion(int board[][]) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");

            }
            System.out.println();
        }


    }

    //Pomocna funkcija koja provjerava da li kraljica moze biti postavljena na polje (board[row][col])
    //Ova funkcija je pozvata kada su "col" dame vec posatvljene u kolonama od 0 do -1, dakle moramo samo da provjerimo lijevu stranu za napadajucu kraljicu
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        //Provjeravamo ovaj red sa lijeve strane
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }

        }
        //Porvjeravamo gornju dijanogalu na lijevoj strani
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;

            }
        }
        //Provjeravamo donju dijagonalu na lijevoj strani
        for (i = row, j = col; j >= 0 && i < N; j--, i++) {
            if (board[i][j] == 1) {
                return false;
            }

        }
        return true;

    }

    //Rekurzivna funkcija za rijesavenje problema N dama
    boolean solveNQUtil(int board[][], int col) {
        //Najbolji slucaj: ako su sve dame postavljene vrati TRUE
        if (col >= N) {
            return true;
        }
        //Razmotri ovu kolonu i probaj da stavis ovu damu u svaki red jednom po jednom
        for (int i = 0; i < N; i++) {
            //Provjerimo da li dama moze biti postavljena na board[i][col]
            if (isSafe(board, i, col)) {
                //Stavi ovu damu u board[i][col]
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1) == true) {
                    return true;

                    // Ako stavljanje dame na board[i][col] nije dovelo do rijesenja onda tu damu makni sa te pozicije

                }
                board[i][col] = 0;
            }

        }
        //Ako dama ne moze biti postravljena u bilo koji red u ovoj koloni onda vrati FALSE
        return false;


    }

    //Ova funkcija rijesava problem N dama koristeci BACKTRACKING. Najvise koristi solveNQUtil() da rijesi problem. Ako vrati FALSE to znaci da se dame ne mogu postaviti u suprotnom,
    // ako vrati TRUE i izstampa pozicije dami u formi od 1s.
    boolean solveNQ() {
        int board[][] = new int[N][N];
        if (solveNQUtil(board, 0) == false) {
            System.out.print("Rijesenje nepostoji");
            return false;
        }
        printSoultion(board);
        return true;
    }

    public static void main(String[] args) {
        NQueens q = new NQueens();
        q.solveNQ();
    }

}
