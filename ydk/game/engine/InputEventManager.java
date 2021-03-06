package ydk.game.engine;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputEventManager
    implements KeyListener, MouseListener, MouseMotionListener
{
    private Component component;
    private volatile int mouseX, mouseY;
    private final boolean[] keyState    = new boolean[525];
    private final boolean[] mouseState  = new boolean[4];
    
    public InputEventManager(Component component)
    {
        this.component = component;
        this.component.addKeyListener(this);
        this.component.addMouseListener(this);
        this.component.addMouseMotionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keyState[e.getKeyCode()] = true;
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keyState[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e)
    {
        mouseState[e.getButton()] = true;
        System.out.println(e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        mouseState[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }
}
