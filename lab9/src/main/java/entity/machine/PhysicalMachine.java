package entity.machine;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class PhysicalMachine extends Machine{
    protected int cost;
    protected boolean isUsed;

    public PhysicalMachine(int resources, int cost) {
        super(resources);
        this.cost = cost;
        this.isUsed = false;
    }
}
