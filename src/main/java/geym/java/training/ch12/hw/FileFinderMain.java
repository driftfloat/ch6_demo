package geym.java.training.ch12.hw;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import geym.java.training.ch12.hw.ui.MainFrame;

public class FileFinderMain {
    public static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("spring.xml");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    private static void createAndShowGUI() {
        JFrame f = new MainFrame("File Searcher Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setSize(500,500);
        f.setSize(getScreenSize().width/2, getScreenSize().height/2);
        //居中
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
  //获取屏幕大小，去除标题栏和状态栏
    public static Dimension getScreenSize() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//        int w = screensize.width;
//        int h = screensize.height;

//        Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(
//                window.getGraphicsConfiguration());
//
//
//        w = w - (screenInsets.left + screenInsets.right);
//        h = h - (screenInsets.top + screenInsets.bottom);

//        return new Dimension(w, h);
        return screensize;
    } 
}
