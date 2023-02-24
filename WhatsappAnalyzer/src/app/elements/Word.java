package app.elements;

/**
 *
 * @author Luigi Salcedo
 */
public class Word 
{
    // Atributos
    private String value;
    private int appearances;
    
    // Constructor
    public Word(String value)
    {
        this.value = value;
        appearances = 1;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public int getAppearances()
    {
        return appearances;
    }
    
    public void incrementAppearances()
    {
        appearances++;
    }
}
