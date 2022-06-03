package solvers;

import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;

import java.util.List;

public interface Solver {
    int solve(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines);
}
