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
    public static ArrayList<Emoji> emojis;
    public static ArrayList<ChatDay> chatDays;
    public static HashMap<String, ChatDay> chatDaysHash;
    public static ArrayList<ChatDay> sortedDays;
    public static ArrayList<Word> sortedWords;
    public static HashMap<String, Word> usedWords;
    public static String userName;
    public static String otherName;
    public static int totalMessages;
    public static int average;
    public static int userTotalMessages;
    public static int otherTotalMessages;
    public static int userMultimedia;
    public static int otherMultimedia;
    
    public static int nDays()
    {
        return chatDays.size();
    }
    
    public static void restartData()
    {
        emojis = new ArrayList<>();
        chatDays = new ArrayList<>();
        chatDaysHash = new HashMap<>();
        sortedDays = new ArrayList<>();
        sortedWords = new ArrayList<>();
        usedWords = new HashMap<>();
        totalMessages = 0;
        average = 0;
        userTotalMessages = 0;
        otherTotalMessages = 0;
        userMultimedia = 0;
        otherMultimedia = 0;
    }
}
