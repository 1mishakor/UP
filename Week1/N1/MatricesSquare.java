package Misha.Week1.N1;

public class MatricesSquare {
    private int [][] ms;
    private int [][] ms2;
    public MatricesSquare(int [][] ms){
        this.ms = ms;
    }
    public int [][] transpose(){
        ms2 = new int[getMs().length][getMs().length];
        for (int i = 0; i < getMs().length; i++){
            for (int j = 0; j < getMs().length; j++){
                ms2[j][i] = ms[i][j];
            }
        }
        return ms2;
    }
    public int[][] getMs() {
        return ms;
    }

    public void setMs(int[][] ms) {
        this.ms = ms;
    }
    public int[][] getMs2() {
        return ms2;
    }

    public void setMs2(int[][] ms2) {
        this.ms2 = ms2;
    }
}
