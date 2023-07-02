package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_Z -> {
                upPressed = true;
                downPressed = false;
                rightPressed = false;
                leftPressed = false;
            }
            case KeyEvent.VK_S -> {
                upPressed = false;
                downPressed = true;
                rightPressed = false;
                leftPressed = false;
            }
            case KeyEvent.VK_Q -> {
                upPressed = false;
                downPressed = false;
                rightPressed = false;
                leftPressed = true;
            }
            case KeyEvent.VK_D -> {
                upPressed = false;
                downPressed = false;
                rightPressed = true;
                leftPressed = false;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
