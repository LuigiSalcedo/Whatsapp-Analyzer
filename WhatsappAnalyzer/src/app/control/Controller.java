package app.control;

import app.elements.ChatDay;
import app.elements.Emoji;
import app.elements.Word;
import app.windows.FileSelection;
import app.windows.LoadingData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
            // Reiniciamos la información del chat
            ChatData.restartData();
            
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
            
            // Almacenar información del mensaje
            String [] messageInfo = null;
            
            // Almacenar la fecha del conversor
            String dateAux = null;
            
            while((chatLine = br.readLine()) != null)
            {
                // Escribiendo de forma factible la información del chat.
                chatLine = chatLine.replace(" am - ", "a. m. - ");
                chatLine = chatLine.replace(" pm - ", "p. m. - ");
                chatLine = chatLine.replace(". - ", ".<<<>>><<<>>>");
                
                chatLineInfo = chatLine.split("<<<>>><<<>>>");
                
                if(chatLineInfo.length > 0)
                {
                    messageInfo = chatLineInfo[0].split(" ");
                    if(messageInfo.length == 0) continue;
                    
                    if(messageInfo[0].split("/").length == 3)
                    {
                        try
                        {
                            for(String i : messageInfo[0].replace(",", "").split("/"))
                            {
                                Integer.parseInt(i);
                            }
                            date = messageInfo[0].replace(",", "");
                        }
                        catch(NumberFormatException e)
                        {
                            
                        }
                    }
                }
                
                dateAux = ChatDay.convertStringToDate(date).trim();
                
                if(ChatData.chatDays.isEmpty())
                {
                    ChatData.chatDaysHash.put(dateAux, new ChatDay(dateAux));
                    ChatData.chatDays.add(ChatData.chatDaysHash.get(dateAux));
                    currentDay = ChatData.chatDays.get(0);
                    continue;
                }
                
                if(!currentDay.getDate().equals(dateAux))
                {
                    ChatData.chatDaysHash.put(dateAux, new ChatDay(dateAux));
                    ChatData.chatDays.add(ChatData.chatDaysHash.get(dateAux));
                    currentDay = ChatData.chatDaysHash.get(dateAux);
                }
                
                if(currentDay == null)
                {
                    System.out.println("Ocurrió un error. Se ha encontrado un día nulo.");
                }
                
                if(chatLineInfo.length > 1)
                {
                    currentDay.getMessages().add(chatLineInfo[1].trim());
                }
                else
                {
                    currentDay.getMessages().add(chatLineInfo[0].trim());
                }
            }
            
            ld.getLoadingChatDataText().setText("Cargando información del chat . . . (Listo)");
        }
        catch(IOException e)
        {
            System.out.println("Ha ocurrido un error.");
        }
    }
    
    /*
     *  Métodos "setStats()":
     *  
     *  Interpretar información y hallar estádisticas.
     */
    public static void setStats(LoadingData ld)
    {
        countMessages(); // Contar mensajes
        detectNames(); // Detectar nombre
        detectWords(); // Contar palabras
        sortWords(); // Ordenar palabras por uso
        calcAverage(); // Calcular promedio de mensajes
        sortDays(); // Ordenar días por número de mensajes
        countParticipations(); // Contar los mensajes por persona
        ld.getLoadingChatDataText().setText("Organizando información del chat . . . (Listo)");
        
        loadEmojiData(); // Cargar la información de los emojis
        countEmojis(); // Conteo de emojis
        ChatData.emojis = sortEmojis(ChatData.emojis); // Organizar emojis en base a los más usados
        ld.getLoadingEmojiDataText().setText("Cargando emojis disponibles . . . (Listo)");
    }
    
    /*
     *  Método "countMessage()":
     *
     *  Contar el número de mensajes detectados.
     */
    private static void countMessages()
    {
        ChatData.totalMessages = 0;
        for(ChatDay day : ChatData.chatDays) 
        {
            ChatData.totalMessages += day.getMessages().size();
        }
    }
    
    /*
     *  Método "detectNames()"
     *
     *  Detectar los nombres de los particiantes del chat.
     */
    private static void detectNames()
    {
        StringBuilder sb = new StringBuilder(); // Contenedor temporalde nombres
        
        boolean userReady = false;
        boolean otherReady = false;
        
        char a;
        for(ChatDay day : ChatData.chatDays)
        {
            for(String message : day.getMessages())
            {
                // Si no se detecta que puede contener un nombre continuar.
                if(!message.contains(":")) continue;
                
                // Recorrer letra por letra
                for(int i = 0; i < message.length(); i++)
                {
                    a = message.charAt(i);
                    
                    // Nombre encontrado
                    if(a == ':')
                    {
                        // Si el primer nombre no ha sido detectado
                        if(userReady == false)
                        {
                            userReady = true;
                            ChatData.userName = sb.toString();
                        }
                        else
                        {
                            if(!ChatData.userName.equals(sb.toString()))
                            {
                                otherReady = true;
                                ChatData.otherName = sb.toString();
                                break;
                            }
                        }
                        sb = new StringBuilder();
                        break;
                    }
                    else
                    {
                        sb.append(a);
                    }
                }
                if(userReady && otherReady) break;
            }
            if(userReady && otherReady) break;
        }
    }
    
    /*
     *  Método "countWords()"
     *
     *  Inicia el conteo de palabras.
     */
    private static void detectWords()
    {
        String line;
        
        String userName = ChatData.userName + ":";
        String otherName = ChatData.otherName + ":";
        
        for(ChatDay day : ChatData.chatDays)
        {
            for(String message : day.getMessages())
            {
                line = message.replaceFirst(userName, "").trim();
                line = line.replaceFirst(otherName, "").trim();
                
                if(line.equals("<Multimedia omitido>"))
                {
                    ChatData.nMultimedia += 1;
                    continue;
                }
                
                line = line.toLowerCase();
                
                for(String word : line.split(" "))
                {
                    if(!ChatData.usedWords.containsKey(word))
                    {
                        ChatData.usedWords.put(word, new Word(word));
                        ChatData.sortedWords.add(ChatData.usedWords.get(word));
                    }
                    else
                    {
                        ChatData.usedWords.get(word).incrementAppearances();
                    }
                }
            }
        }
    }
    
    /*
     *  Método: sortWords()
     *
     *  Ordenar las palabras por apariciones.
     */
    private static void sortWords()
    {
        ChatData.sortedWords = sortWordsByAppearances(ChatData.sortedWords);
    }
    
    /*
     *  Método: sortWordsByAppearances()
     *
     *  Ordenar las palabras encontradas en base al algoritmo MergeSort
     */
    private static ArrayList<Word> sortWordsByAppearances(ArrayList<Word> array)
    {
        if(array.size() <= 1) return array;
        
        ArrayList<Word> left = new ArrayList<>(
                // Agregar a la izquierda la mitad izquierda del array
                array.subList(0, array.size()/2)
        );
        ArrayList<Word> rigth = new ArrayList<>(
                // Agregar a la derecha la mitad derecha del array
                array.subList(array.size()/2, array.size())
        );
        
        left = sortWordsByAppearances(left);
        rigth = sortWordsByAppearances(rigth);
        
        return merge(left, rigth);
    }
    
    /*
     *  Método: merge(ArrayList<Word>, ArrayList<Word>)
     *
     *  Mezclar dos ArrayList ordenados de palabras
     */
    private static ArrayList<Word> merge(ArrayList<Word> left, ArrayList<Word> rigth)
    {
        ArrayList<Word> merged = new ArrayList<>(left.size() + rigth.size());
        
        int p_left = 0;
        int p_rigth = 0;
        
        while(p_left < left.size() && p_rigth < rigth.size())
        {
            if(left.get(p_left).getAppearances() > rigth.get(p_rigth).getAppearances())
            {
                merged.add(left.get(p_left));
                p_left++;
            }
            else
            {
                merged.add(rigth.get(p_rigth));
                p_rigth++;
            }
        }
        
        merged.addAll(left.subList(p_left, left.size()));
        merged.addAll(rigth.subList(p_rigth, rigth.size()));
    
        return merged;
    }
    
    /*
     *  Método: calcAverage()
     *
     *  Calcular el promedio de mensajes por día.
     */
    private static void calcAverage()
    {
        ChatData.average = ChatData.totalMessages / ChatData.nDays();
    }
    
    /*
     * Método: sortDays()
     *
     *  Ordenar los mensajes en base al número de mensajes 
     */
    private static void sortDays()
    {
        ChatData.sortedDays = sortDaysByMessages(ChatData.chatDays);
    }
    
    /*
     *  Método: "sortDaysByMessages(ArrayList<ChatDay>)"
     *
     *  Aplicación del algoritmo "MergeSort" para ordenar los días. 
     */
    private static ArrayList<ChatDay> sortDaysByMessages(ArrayList<ChatDay> array)
    {
        if(array.size() <= 1) return array;
        
        ArrayList<ChatDay> left = new ArrayList<ChatDay>(array.subList(0, array.size()/2));
        ArrayList<ChatDay> rigth = new ArrayList<ChatDay>(array.subList(array.size()/2, array.size()));
        
        left = sortDaysByMessages(left);
        rigth = sortDaysByMessages(rigth);
        
        return mergeMessages(left, rigth);
    }
    
    /*
     *  Método: "megeMessages(ArrayList<ChatDay>, ArrayList<ChatDay>)"
     *  
     *  Mezcla ordenada de dos ArrayList de ChatDay en base a su número de mensajes.
     */
    
    private static ArrayList<ChatDay> mergeMessages(ArrayList<ChatDay> left, ArrayList<ChatDay> rigth)
    {
        ArrayList<ChatDay> merged = new ArrayList<ChatDay>(left.size() + rigth.size());
        
        int p_left = 0;
        int p_rigth = 0;
        
        while(p_left < left.size() && p_rigth < rigth.size())
        {
            if(left.get(p_left).getMessages().size() > rigth.get(p_rigth).getMessages().size())
            {
                merged.add(left.get(p_left));
                p_left++;
            }
            else
            {
                merged.add(rigth.get(p_rigth));
                p_rigth++;
            }
        }
        
        return merged;
    }
    
    /*
     *  countParticipations()
     *
     *  Contar las participaciones por persona.
     */
    private static void countParticipations()
    {
        String userName = ChatData.userName + ":";
        String otherName = ChatData.otherName + ":";
        
        ChatData.userTotalMessages = 0;
        ChatData.otherTotalMessages = 0;
        
        for(ChatDay day : ChatData.chatDays)
        {
            for(String message : day.getMessages())
            {
                if(message.contains(userName))
                {
                    ChatData.userTotalMessages += 1;
                }
                else if(message.contains(otherName))
                {
                    ChatData.otherTotalMessages += 1;
                }
            }
        }
    }
    
    /*
     *  Método: "loadEmojiData()"
     *  
     *  Cargar desde el archivo los emojis disponibles.
     */
    private static void loadEmojiData()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("src\\emoji_data\\emojis.txt")));
            String emojiLine;
            
            while((emojiLine = br.readLine()) != null)
            {
                ChatData.emojis.add(new Emoji(emojiLine));
            }
        }
        catch(IOException e)
        {
            if(e instanceof java.io.FileNotFoundException)
            {
                javax.swing.JOptionPane.showMessageDialog(null, 
                        "Ha ocurrido un error al cargar el archivo de emojis.");
                return;
            }
            
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /*
     *  Método: "countEmojis()"
     * 
     *  Iniciará el conteo de los emojis encontrado dentro del chat.
     */
    private static void countEmojis()
    {
        String aux;
        
        for(ChatDay day : ChatData.chatDays)
        {
            for(String message : day.getMessages())
            {
                aux = new String(message);
                for(Emoji emoji : ChatData.emojis)
                {
                    while(aux.contains(emoji.getValue()))
                    {
                        emoji.incrementAppearances();
                        aux = aux.replaceFirst(emoji.getValue(), "");
                    }
                }
            }
        }
    }
    
    /*
     *  Método: "sortEmojis(ArrayList<Emoji>)"
     *
     *  Organizar los emojis de más a meno usados.
     *
     *  Se usará el algoritmo "QuickSort"
     */
    private static ArrayList<Emoji> sortEmojis(ArrayList<Emoji> array)
    {
        if(array.size() <= 0) return array;
        
        ArrayList<Emoji> left = new ArrayList<>();
        ArrayList<Emoji> rigth = new ArrayList<>();
        
        Emoji piv = array.get(0);
        
        for(int i = 1; i < array.size(); i++)
        {
            if(array.get(i).getAppaerances() < piv.getAppaerances())
            {
                left.add(array.get(i));
            }
            else
            {
                rigth.add(array.get(i));
            }
        }
        
        rigth = sortEmojis(rigth);
        left = sortEmojis(left);
        
        left.add(piv);
        left.addAll(rigth);
        
        return left;
    }
}
