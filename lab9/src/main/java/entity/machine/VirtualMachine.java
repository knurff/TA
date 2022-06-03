package entity.machine;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class VirtualMachine extends Machine{
    protected boolean isCompleted;
    public VirtualMachine(int resources) {
        super(resources);
        this.isCompleted = false;
    }
}
