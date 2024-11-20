
public class PlayerX {

    public void printSympol(char[][] mainArray,char[][] xArray,int x,int y){


        for (int i=0 ; i<5 ;i++){
            for (int j=0 ; j<7 ;j++) {

                mainArray[i+x][j+y]=xArray[i][j];
            }
            System.out.println();
        }

        for (char[] row : mainArray) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();






    }


}

