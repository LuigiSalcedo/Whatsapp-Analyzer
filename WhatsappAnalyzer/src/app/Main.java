package app;

import app.windows.FileSelection;

/**
 *
 * @author Luigi Salcedo
 */
public class Main 
{
    public static void main(String[] args) 
    {
        FileSelection selectionWindow = new FileSelection();
        
        selectionWindow.setVisible(true);
    }    
}
