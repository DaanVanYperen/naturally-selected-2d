package net.mostlyoriginal.ns2d.component;

import com.artemis.Component;

/**
 * @author Daan van Yperen
 */
public class Buildable extends Component {
    public boolean built;
    public String builtAnimId;
    public String unbuiltAnimId;
    public final int resourceCost;

    public Buildable(String builtAnimId, String unbuiltAnimId, int resourceCost) {
        this.builtAnimId = builtAnimId;
        this.unbuiltAnimId = unbuiltAnimId;
        this.resourceCost = resourceCost;
    }
}
