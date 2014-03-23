package net.mostlyoriginal.ns2d.component;

import com.artemis.Component;

/**
 * @author Daan van Yperen
 */
public class Weapon extends Component {

    public float cooldown = 0;

    public float bulletLifetime = 10;
    public float bulletSpeed = 500;
    public int minBullets = 1;
    public int maxBullets = 1;
    public float fireCooldown = 1f/15f; // cooldown per bullet.
    public float spread = 10f; // spread in degrees
    public boolean firing = false;

    public String bulletGroup = "bullet";
    public String bulletAnimId = "bullet";
}
