package ghb.informatik.models;

public class CinemaHall {
    
    int rows, cols;
    int number;

    public CinemaHall(int rows, int cols, int number){
        setCols(cols);
        setNumber(number);
        setRows(rows);
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getCols() {
        return cols;
    }
    public int getNumber() {
        return number;
    }
    public int getRows() {
        return rows;
    }
}
