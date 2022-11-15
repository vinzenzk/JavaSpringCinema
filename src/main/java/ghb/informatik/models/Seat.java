package ghb.informatik.models;

public class Seat {
    
    String name;
    boolean status;
    
    public Seat(boolean status){
        setStatus(status);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return this.status;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
