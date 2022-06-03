/*
package solvers;

import entity.machine.Machine;
import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GASolver implements Solver {

    @Override
    public int minCosts(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
        int result = 0;
        int neededResources = neededResources(virtualMachines);
        physicalMachines = physicalMachines.stream()
                .sorted(Comparator.comparing(PhysicalMachine::getResourceCost)
                        .reversed())
                .toList();
        ArrayList<PhysicalMachine> physicalMachineList = new ArrayList<>(physicalMachines);
        for (int i = 0; i < physicalMachineList.size() && neededResources > 0; i++) {
            PhysicalMachine phm = physicalMachineList.get(i);
            neededResources -= phm.getResources();
            result += phm.getResourceCost();
            physicalMachineList.remove(phm);
        }
        return result;
    }

    private int neededResources(List<VirtualMachine> virtualMachines) {
        return virtualMachines.stream()
                .mapToInt(Machine::getResources)
                .sum();
    }
}
*/
