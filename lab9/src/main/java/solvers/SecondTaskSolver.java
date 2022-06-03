package solvers;

import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SecondTaskSolver implements Solver {
    @Override
    public int solve(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
        List<PhysicalMachine> physicalMachines2 = new ArrayList<>();
        for (PhysicalMachine pm : physicalMachines) {
            physicalMachines2.add(new PhysicalMachine(pm.getResources(), pm.getCost()));
        }
        List<VirtualMachine> virtualMachines2 = new ArrayList<>();
        for (VirtualMachine vm : virtualMachines) {
            virtualMachines2.add(new VirtualMachine(vm.getResources()));
        }
        return Math.min(getResultMinToHigh(physicalMachines, virtualMachines2),
                getResultHighToMin(physicalMachines2, virtualMachines));
    }


    private int getResultMinToHigh(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
        int result = 0;
        List<PhysicalMachine> physicalMachineList = new ArrayList<>
                (physicalMachines.stream()
                        .sorted(Comparator.comparing(PhysicalMachine::getResources))
                        .toList());
        List<VirtualMachine> virtualMachineList = new ArrayList<>
                (virtualMachines.stream()
                        .sorted(Comparator.comparing(VirtualMachine::getResources))
                        .toList());
        return forCycle(result, physicalMachineList, virtualMachineList);
    }

    private int getResultHighToMin(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
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
        return forCycle(result, physicalMachineList, virtualMachineList);
    }

    private int forCycle(int result, List<PhysicalMachine> physicalMachineList, List<VirtualMachine> virtualMachineList) {
        for (PhysicalMachine physicalMachine : physicalMachineList) {
            for (VirtualMachine virtualMachine : virtualMachineList) {
                if (physicalMachine.getResources() >= virtualMachine.getResources()
                        && !virtualMachine.isCompleted()) {
                    if (!physicalMachine.isUsed()) result += physicalMachine.getResources();
                    physicalMachine.setResources(physicalMachine.getResources() - virtualMachine.getResources());
                    virtualMachine.setCompleted(true);
                    physicalMachine.setUsed(true);
                }
            }
        }
        return result;
    }
}
