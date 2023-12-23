import first.ElevatorController;
import first.EvenElevator;

public class Main {
    public static void main(String[] args) {
        EvenElevator evenElevator1 = new EvenElevator();
        EvenElevator evenElevator2 = new EvenElevator();
        EvenElevator evenElevator3 = new EvenElevator();
        OddElevator oddElevator1 = new OddElevator();
        OddElevator oddElevator2 = new OddElevator();
        OddElevator oddElevator3 = new OddElevator();
        WorkerElevator workerElevator1 = new WorkerElevator();

        ElevatorController elevatorController = new ElevatorController();

        elevatorController.add(evenElevator1);
        elevatorController.add(evenElevator2);
        elevatorController.add(evenElevator3);
        elevatorController.add(oddElevator1);
        elevatorController.add(oddElevator2);
        elevatorController.add(oddElevator3);
        elevatorController.add(workerElevator1);

        for (int i = 0; i < 20; i++) {
            System.out.println(elevatorController.last);
            elevatorController.last = elevatorController.last.next;

        }

        for (int i = 0; i < 20; i++) {
            int random = (int) (Math.random() * 3);
            switch (random){
                case 0: elevatorController.call(Situation.EVEN);
                case 1: elevatorController.call(Situation.ODD);
                case 2: elevatorController.call(Situation.WORKER);
            }
        }

    }
}
