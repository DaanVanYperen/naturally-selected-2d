package net.mostlyoriginal.ns2d.system.passive;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import net.mostlyoriginal.ns2d.api.PassiveSystem;

import java.util.HashMap;

/**
 * @author Daan van Yperen
 */
public class AssetSystem extends PassiveSystem {

    public static final int TILE_SIZE = 32;
    public final BitmapFont font;

    public Texture tileset;
    public HashMap<String, Animation> sprites = new HashMap<String, Animation>();
    public HashMap<String, Sound> sounds = new HashMap<String, Sound>();

    public Animation get(final String identifier) {
        return sprites.get(identifier);
    }

    public Sound getSfx(final String identifier) {
        return sounds.get(identifier);
    }

    public Animation add(final String identifier, int x1, int y1, int w, int h, int repeatX) {
        return add(identifier, x1, y1, w, h, repeatX, 1, tileset);
    }

    public Animation add(final String identifier, int x1, int y1, int w, int h, int repeatX, int repeatY) {
        return add(identifier, x1, y1, w, h, repeatX, repeatY, tileset);
    }

    public Animation add(final String identifier, int x1, int y1, int w, int h, int repeatX, int repeatY, Texture texture) {

        TextureRegion[] regions = new TextureRegion[repeatX*repeatY];

        int count = 0;
        for (int y = 0; y < repeatY; y++) {
            for (int x = 0; x < repeatX; x++) {
                regions[count++] = new TextureRegion(texture, x1 + w * x, y1 + h * y, w, h);
            }
        }

        return sprites.put(identifier, new Animation(0.5f, regions));
    }

    public AssetSystem() {

        font = new BitmapFont(Gdx.files.internal("font/tahoma-10.fnt"), false);
        font.setColor(0, 0, 0, 0.9f);

        tileset = new Texture("ns2d_tileset.png");

        add("player", 0, 0, TILE_SIZE, TILE_SIZE, 2);
        add("player-jetpack", 192, 0, TILE_SIZE, TILE_SIZE, 1);
        add("player-respawning", 224, 0, TILE_SIZE, TILE_SIZE, 1);


        add("spawner", 0, 464, 16,16, 1);
        add("resourcetower", 0, 336, 16*3, 16*3, 1);
        add("armory", 96, 336, 16*3, 16*3, 1);

        add("spawner-unbuilt", 16, 464, 16,16, 1);
        add("resourcetower-unbuilt", 16*3, 336, 16*3, 16*3, 1);
        add("armory-unbuilt", 96+16*3, 336, 16*3, 16*3, 1);

        add("techpoint", 0, 384, TILE_SIZE*2, TILE_SIZE*2, 1);

        add("duct", 32, 224, TILE_SIZE, TILE_SIZE, 1);
        add("skulk", 0, 592, TILE_SIZE, 16, 3);
        add("skulk-head", 105, 590, 15, 10, 1);
        add("debug-marker", 44, 51, 3, 3, 1);

        add("bullet", 43, 45, 9, 6, 1);
        add("slug", 44, 76, 8, 8, 1);
        add("grenade", 42, 108, 12, 8, 1);
        add("flames", 32, 128, 16, 16, 6,2);

        add("health-tick", 14, 526, 4, 5, 1);

        add("rifle", 0, 32, TILE_SIZE, TILE_SIZE, 1);
        add("shotgun", 0, 64, TILE_SIZE, TILE_SIZE, 1);
        add("grenadelauncher", 0, 96, TILE_SIZE, TILE_SIZE, 1);
        add("flamethrower", 0, 128, TILE_SIZE, TILE_SIZE, 1);
    }


    private void loadSounds(String[] soundnames) {
        for (String identifier : soundnames) {
            sounds.put(identifier, Gdx.audio.newSound(Gdx.files.internal("sfx/" + identifier + ".mp3")));
        }
    }

    public void dispose() {
        sprites.clear();
        tileset.dispose();
        tileset = null;
    }

}
