package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import sun.jvm.hotspot.gc.shared.Space;

public class Enemy extends Spaceship {
    private float speed = 50f;
    this.x -= this.speed * dt;

    public Enemy(String texturePath) {
        this.texture = new Texture(texturePath);

        // Place it in the middle of the screen
        this.x = Gdx.graphics.getWidth() + 100;
        this.y = (Gdx.graphics.getHeight() - this.texture.getHeight()) / 2.0f;

        this.currentState = Spaceship.STATE.PATROLLING;
    }

    public void update(Player player) {
        // Grab deltatime to calculate movement over time
        float dt = Gdx.graphics.getDeltaTime();

        switch(this.currentState) {
            case MOVING_UP:
                break;
            case MOVING_DOWN:
                break;
            case PATROLLING:
                break;
            case BOOSTING:
                break;
            case CHASING:
                break;
            case DODGING:
                break;
            case FLEEING:
                break;
            default:
                // code block
        }
    }public float getAngle(Vector2 target) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - this.getPosition().y, target.x - this.getPosition().x));

        if(angle < 0){
            angle += 360;
        }

        return angle;
    }
    public boolean canSeePlayer(Player player) {
        float angle = this.getAngle(player.getPosition());
        if (player.getPosition().x < this.x) {
            if (angle > 170 && angle < 190) {
                return true;
            }
        }
        return false;
    }
}
