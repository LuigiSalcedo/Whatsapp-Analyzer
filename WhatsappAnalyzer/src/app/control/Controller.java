package app.control;

import app.elements.ChatDay;
import app.windows.FileSelection;
import app.windows.LoadingData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luigi Salcedo
 */
public class Controller 
{
    /*
     *  Método "readFile()":
     *
     *  Inicia el procesamiento del archivo.
     */
    public static void readFile(LoadingData ld)
    {
        try
        {
            // Lector del archivo
            BufferedReader br = new BufferedReader(new FileReader(FileSelection.getFile()));
            
            // Almacenador de la linea leida
            String chatLine;
            
            // División de la linea leida
            String [] chatLineInfo;
            
            // Almacenar el día actual
            ChatDay currentDay = null;
            
            // Almacenar la fecha
            String date = null;
            
            while((chatLine = br.readLine()) != null)
            {
                
            }
            
            ld.getLoadingChatDataText().setText("Cargando información del chat . . . (Listo)");
        }
        catch(IOException e)
        {
            System.out.println("Ha ocurrido un error.");
        }
        
    }
}
