package net.mostlyoriginal.ns2d.system.active;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import net.mostlyoriginal.ns2d.component.MouseCursor;
import net.mostlyoriginal.ns2d.component.Pos;
import net.mostlyoriginal.ns2d.system.passive.CameraSystem;

/**
 * @author Daan van Yperen
 */
@Wire
public class MouseCursorSystem extends EntityProcessingSystem {

    private ComponentMapper<Pos> pm;
    private ComponentMapper<MouseCursor> am;

    private CameraSystem cameraSystem;

    public MouseCursorSystem() {
        super(Aspect.getAspectForAll(Pos.class, MouseCursor.class));
    }

    Vector3 aimAtTmp = new Vector3();

    @Override
    protected void process(Entity e) {

        final Pos pos = pm.get(e);

        aimAtTmp.set(Gdx.input.getX(), Gdx.input.getY(), 0);

        final Vector3 unproject = cameraSystem.camera.unproject(aimAtTmp);

        pos.x = unproject.x;
        pos.y = unproject.y;
    }
}
