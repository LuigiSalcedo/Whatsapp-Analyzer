package app.control;

import app.elements.ChatDay;
import app.elements.Emoji;
import app.elements.Word;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Luigi Salcedo
 */
public class ChatData 
{
    public static ArrayList<Emoji> emojis = new ArrayList<>();
    public static ArrayList<ChatDay> chatDays = new ArrayList<>();
    public static ArrayList<ChatDay> sortedDays = new ArrayList<>();
    public static ArrayList<Word> sortedWords = new ArrayList<>();
    public static HashMap<String, Word> usedWords = new HashMap<>();
    public static String userName;
    public static String otherName;
    public static int totalMessages;
    public static int average;
    public static int userTotalMessages;
    public static int otherTotalMessages;
    public static int nMultimedia = 0;
    
    public static int nDays()
    {
        return chatDays.size();
    }
}
