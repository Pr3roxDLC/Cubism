package me.pr3;

import com.google.common.eventbus.EventBus;
import com.sun.javafx.geom.Vec3f;
import javafx.geometry.Point3D;
import me.pr3.events.Render3DEvent;
import me.pr3.managers.InputManager;
import me.pr3.primitives.Cube;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


//Tim & Leo

public class Main extends JFrame implements Runnable {

    Image dbImage = null;
    Graphics dbg = null;
    private JPanel contentPane;


    public static EventBus EVENT_BUS = new EventBus();
    public static Camera CAMERA = new Camera(new Point3D(0, 0, 0), new Vec3f(0, 0, 0));
    public static int WIDTH = 1920;
    public static int HEIGHT = 1080;


    public Cube cube = new Cube(10, 10, 10, 20, 20, 20);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Thread f = new Thread(new Main());

        f.start();

    }


    public void run() {
        //PreInit
        while (true) {
            //GameCycle
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {

        dbImage = createImage(this.getSize().width, this.getSize().height);
        dbg = dbImage.getGraphics();
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) dbg).setRenderingHints(hints);


        Main.EVENT_BUS.post(new Render3DEvent(dbg));


        g.drawImage(dbImage, 8, 32, null);
    }


    /**
     * Create the frame.
     */
    public Main() {
        setBackground(Color.GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1920, 1080);
        addKeyListener(new InputManager());


        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        setVisible(true);
    }

}