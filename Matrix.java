public class Matrix{

    private int rows=0;
    private int columns=0;
    int userMatrix[][];
    int transMatrix[][]; //trans steht hier natuerlich fuer transponiert ;)

    public static void main(String args[]){
        Matrix matrix=new Matrix();
        handleUserInput(matrix);
        System.out.println("Rows: "+matrix.rows+" Columns: "+matrix.columns);
        matrix.initMatrices(matrix);
        matrix.setMatrixValues(matrix);
        matrix.matrixTransponierer(matrix);
        matrix.outputMatrix(matrix.userMatrix);
        matrix.outputMatrix(matrix.transMatrix);
    }

    public void initMatrices(Matrix matrix){
        userMatrix=new int[matrix.rows][matrix.columns];
        transMatrix=new int[matrix.columns][matrix.rows];
    }

    public void matrixTransponierer(Matrix matrix){
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                matrix.transMatrix[j][i]=matrix.userMatrix[i][j];
            }
        }
    }

    public static void handleUserInput(Matrix tmp){
        tmp.setRows(getRows());
        tmp.setColumns(getColumns());
    }

    public static int getRows(){
        int rows=0;
        while(rows<1){
            rows=SimpleIO.getInt("Wie viele Zeilen hat die Matrix?(>=1");
        }
        return rows;
    }

    public static int getColumns(){
        int colums=0;
        while(true){
            colums=SimpleIO.getInt("Wie viele Spalten hat die Matrix?(>=1");
         if(colums>=1){
               return colums;
            }
        }
    }

    public void setRows(int rows){
        this.rows=rows;
    }

    public void setColumns(int colums){
        this.columns=colums;
    }

    public void setMatrixValues(Matrix matrix){
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                matrix.userMatrix[i][j]=SimpleIO.getInt("Wie lautet die Zahl fuer Position"+" ("+i+", "+j);
            }
        }
    }

    public void outputMatrix(int[][] array){
        System.out.println("Matrix: ");
        for(int[] a:array){
            for(int b:a){
                System.out.print(" "+b);
            }
            System.out.println();
        }
    }
}