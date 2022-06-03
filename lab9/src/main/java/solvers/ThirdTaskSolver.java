package solvers;

import entity.machine.Machine;
import entity.machine.PhysicalMachine;
import entity.machine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class ThirdTaskSolver implements Solver {
    @Override
    public int solve(List<PhysicalMachine> physicalMachines, List<VirtualMachine> virtualMachines) {
        int[] costs = physicalMachines.stream()
                .mapToInt(PhysicalMachine::getCost)
                .toArray();
        int[] resources = physicalMachines.stream()
                .mapToInt(PhysicalMachine::getResources)
                .toArray();

        int count = costs.length;
        int neededResources = this.getNeededRes(virtualMachines);

        int[][] A;
        A = new int[count + 1][];
        for (int i = 0; i < count + 1; i++) {
            A[i] = new int[neededResources + 1];
        }

        for (int i = 0; i <= count; i++) {
            for (int j
                 = 0; j <= neededResources; j++) {
                if (i == 0 || j == 0) {
                    A[i][j] = 0;
                } else {
                    if (j >= costs[i - 1]) {
                        A[i][j] = Math.max(A[i - 1][j], A[i - 1][j - costs[i - 1]] + resources[i - 1]);
                    } else {
                        A[i][j] = A[i - 1][j];
                    }
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(A, costs, count, neededResources, result);
        int finalCost = 0;
        for (Integer i:result) {
            finalCost += physicalMachines.get(i- 1).getCost();
        }
        return finalCost;
    }

    private static void traceResult(int[][] A, int[] weight, int k, int s, ArrayList<Integer> result) {
        if (A[k][s] == 0) {
            return;
        }
        if (A[k -1][s] == A[k][s]) {
            traceResult(A, weight, k - 1, s, result);
        } else {
            traceResult(A, weight, k - 1, s - weight[k - 1], result);
            result.add(0, k);
        }
    }

    private int getNeededRes(List<VirtualMachine> virtualMachines){
        return virtualMachines.stream()
                .mapToInt(Machine::getResources)
                .sum();
    }
}
