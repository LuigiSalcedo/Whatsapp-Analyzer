package app.elements;

import java.util.ArrayList;

/**
 *
 * @author Luigi Salcedo
 */
public class ChatDay 
{
    // Elementos "estáticos"
    private static final String [] months = new String[]
    {
        "enero", 
        "febrero", 
        "marzo", 
        "abril", 
        "mayo", 
        "junio", 
        "julio", 
        "agosto", 
        "septiembre", 
        "octubre", 
        "noviembre", 
        "diciembre"
    };
    
    // Atributos
    private String date;
    private ArrayList<String> messages;
    private String day;
    private String month;
    private String year;
    
    public ChatDay(String dateInfo)
    {
	this.date = dateInfo;

	messages = new ArrayList<>();        
    }
    
    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    // Getters
    public static String[] getMonths() {
        return months;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
    
    @Override
    public String toString()
    {
        return date;
    }    
    
    public static String convertStringToDate(String dateInfo)
    {
	String date = dateInfo;
		
	String [] dayInfo = date.split("/");
		
	String day = dayInfo[0];
	String month = dayInfo[1];
	String year = dayInfo[2];
        
        return day + " de " + ChatDay.months[Integer.parseInt(month)-1] + " del " + year;
        
    }
}
