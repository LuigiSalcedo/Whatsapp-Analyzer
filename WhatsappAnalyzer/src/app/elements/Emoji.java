package app.elements;

/**
 *
 * @author Luigi Salcedo
 */
public class Emoji 
{
    // Atributos
    private String value;
    private int appaerances;
    
    public Emoji(String value)
    {
        this.value = value;
        appaerances = 0;
    }
    
    public int getAppaerances()
    {
        return appaerances;
    }
    
    public String getValue()
    {
        return value;
    }
}
