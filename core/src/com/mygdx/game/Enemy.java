package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Role{
    public enum STATE {
        MOVING_UP,
        MOVING_DOWN,
        PATROLLING,
        BOOSTING,
        CHASING,
        FLEEING,
        DODGING}

    STATE currentState;

    Texture texture;

    float x;
    float y;

    public Vector2 getPosition() {
        float currentX = this.x + (this.texture.getWidth()  / 2.0f);
        float currentY = this.y + (this.texture.getHeight() / 2.0f);
        return new Vector2(currentX, currentY);
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.texture, this.x, this.y);
    }

    public void dispose() {
        this.texture.dispose();
    }
}
