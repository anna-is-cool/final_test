public abstract class Elevator {
    Status status;
    Elevator next;
    public Elevator(){
        status = Status.FREE;
    }
}
