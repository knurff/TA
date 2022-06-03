import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;
import solvers.FirstTaskSolver;
import solvers.SecondTaskSolver;
import solvers.Solver;
import solvers.ThirdTaskSolver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solver s1 = new FirstTaskSolver(), s2 = new SecondTaskSolver(), s3 = new ThirdTaskSolver();
        System.out.println(s1.solve(List.of(new PhysicalMachine(30, 4), new PhysicalMachine(15, 4), new PhysicalMachine(5, 4)),
                List.of(new VirtualMachine(20), new VirtualMachine(15), new VirtualMachine(3))));
        System.out.println(s2.solve(List.of(new PhysicalMachine(30, 4), new PhysicalMachine(15, 4), new PhysicalMachine(5, 4)),
                List.of(new VirtualMachine(20), new VirtualMachine(15), new VirtualMachine(3))));
        System.out.println(s3.solve(List.of(new PhysicalMachine(8, 20), new PhysicalMachine(8, 4)),
                List.of(new VirtualMachine(4), new VirtualMachine(4))));
    }
}
