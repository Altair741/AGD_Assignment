package com.mygdx.game;
import static com.mygdx.game.Enemy.STATE.MOVING_DOWN;
import static com.mygdx.game.Enemy.STATE.MOVING_UP;
import static com.mygdx.game.Spaceship.STATE.MOVING_DOWN;
import static com.mygdx.game.Spaceship.STATE.MOVING_UP;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Role{
    private final Texture texture;
    private final float x;
    private final float y;
    private int currentState;

    public Player(String texturePath) {
        this.texture = new Texture(texturePath);

        // Place it in the middle of the screen
        this.x =  (Gdx.graphics.getWidth()  - this.texture.getWidth())  / 2.0f;
        this.y =  (Gdx.graphics.getHeight() - this.texture.getHeight()) / 2.0f;
    }

    public void update() {
        // Grab deltatime to calculate movement over time
        float dt = Gdx.graphics.getDeltaTime();

        switch(this.currentState) {
            case MOVING_UP:
                break;
            case MOVING_DOWN:
                break;
            default:
                // code block
        }
    }

    public void dispose() {
        super(dispose());
    }
}
