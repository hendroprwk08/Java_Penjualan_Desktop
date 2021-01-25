package java_penjualan_desktop;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Java_Penjualan_Desktop {

    public static void main(String[] args) {
        try {
            //tema
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog( null, ex);
        }
        
        FMenu f = new FMenu();
        f.setExtendedState(FMenu.MAXIMIZED_BOTH);
        f.setVisible( true );  
    }
}
