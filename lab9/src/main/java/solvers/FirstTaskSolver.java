package solvers;

import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FirstTaskSolver implements Solver {
    @Override
    public int solve(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
        int result = 0;
        List<PhysicalMachine> physicalMachineList = new ArrayList<>
                (physicalMachines.stream()
                        .sorted(Comparator.comparing(PhysicalMachine::getResources)
                                .reversed())
                        .toList());
        List<VirtualMachine> virtualMachineList = new ArrayList<>
                (virtualMachines.stream()
                        .sorted(Comparator.comparing(VirtualMachine::getResources)
                                .reversed())
                        .toList());
        for (PhysicalMachine physicalMachine : physicalMachineList) {
            for (VirtualMachine virtualMachine : virtualMachineList) {
                if (physicalMachine.getResources() >= virtualMachine.getResources()
                        && !virtualMachine.isCompleted()) {
                    physicalMachine.setResources(physicalMachine.getResources() - virtualMachine.getResources());
                    virtualMachine.setCompleted(true);
                    physicalMachine.setUsed(true);
                }
            }
            if (physicalMachine.isUsed()) result++;
        }
        return result;
    }
}

