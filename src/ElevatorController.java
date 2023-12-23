import first.AllOccupiedException;
import first.Callable;
import first.Elevator;

public class ElevatorController implements Callable, FindFree {
    public Elevator last;
    @Override
    public Elevator free(){
        if (last == null) return null;
        Elevator start = last;
        while ( (last.status != Status.FREE) && (last.next != start)) {
            last = last.next;
        }
        if (last.status != Status.FREE) return null;
        return last;
    }
    
    @Override
    public Elevator call(Situation situation) {
        try {
            find(situation);
            last.status = Status.TAKEN;
            System.out.println("Успех");
            System.out.println(situation + " " + last);
            return last;
        } catch (AllOccupiedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void add (Elevator elevator) {
        if (last == null) {
            last = elevator;
            last.next = elevator;
            return;
        }
        Elevator start = last;
        while (last.next != start) last = last.next;
        last.next = elevator;
        elevator.next = start;
    }
    private void find(Situation situation) throws AllOccupiedException {
        last = free();
        if (last == null) throw new AllOccupiedException("Все лифты заняты");
        switch (situation) {
            case ODD: if (last.getClass() == OddElevator.class) return;
            case EVEN: if (last.getClass() == EvenElevator.class) return;
            case WORKER: if (last.getClass() == WorkerElevator.class) return;
        }
        Elevator start = last;
        do {
            last = last.next;
            last = free();
            switch (situation) {
                case ODD: if (last.getClass() == OddElevator.class) return;
                case EVEN: if (last.getClass() == EvenElevator.class) return;
                case WORKER: if (last.getClass() == WorkerElevator.class) return;
            }
        } while (start != last);
        throw new AllOccupiedException("Все лифты заняты");
    }
}
