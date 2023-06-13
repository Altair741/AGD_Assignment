package com.mygdx.game;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlatformerGame extends SurfaceView implements SurfaceHolder.Callback {
    private static final int PLAYER_WIDTH = 100;
    private static final int PLAYER_HEIGHT = 100;
    private static final int GROUND_HEIGHT = 200;
    private static final int GRAVITY = 10;

    private int playerX;
    private int playerY;
    private int playerSpeedY;
    private boolean isJumping;

    public PlatformerGame(Context context) {
        super(context);
        getHolder().addCallback(this);
        setFocusable(true);
        initializeGame();
    }

    private void initializeGame() {
        playerX = 100;
        playerY = getHeight() - GROUND_HEIGHT - PLAYER_HEIGHT;
        playerSpeedY = 0;
        isJumping = false;
    }

    private void update() {
        playerY += playerSpeedY;
        playerSpeedY += GRAVITY;

        if (playerY > getHeight() - GROUND_HEIGHT - PLAYER_HEIGHT) {
            playerY = getHeight() - GROUND_HEIGHT - PLAYER_HEIGHT;
            playerSpeedY = 0;
            isJumping = false;
        }
    }

    private void jump() {
        if (!isJumping) {
            playerSpeedY = -150;
            isJumping = true;
        }
    }

    private void checkCollisions() {
        // Example collision detection logic
        // You can add more complex collision detection based on your game requirements
        if (playerY >= getHeight() - GROUND_HEIGHT - PLAYER_HEIGHT) {
            playerY = getHeight() - GROUND_HEIGHT - PLAYER_HEIGHT;
            playerSpeedY = 0;
            isJumping = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Start the game loop when the surface is created
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    update();
                    checkCollisions();
                    drawGame();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // Not used in this example
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Not used in this example
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            jump();
        }
        return true;
    }

    private void drawGame() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawColor(Color.WHITE);

            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawRect(playerX, playerY, playerX + PLAYER_WIDTH, playerY + PLAYER_HEIGHT, paint);

            paint.setColor(Color.GREEN);
            canvas.drawRect(0, getHeight() - GROUND_HEIGHT, getWidth(), getHeight(), paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }
}
