package entity.machine;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
public abstract class Machine {
    protected int resources;

    public Machine(int resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "resources=" + resources +
                '}';
    }
}
