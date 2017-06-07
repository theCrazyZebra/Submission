
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stacey.pasqualbyrne
 */
public class JSONFormatter
{
    Elements theseElements;
    String format = "";
    
    JSONFormatter(Elements e)
    {
        theseElements = e;
    }
    
    String format(String h)
    {
        format = "{ Area : " + h + ", \n{\n";
        
        for(int i=1; i < theseElements.size(); i++)
        {
            format = format + "Tech: " + theseElements.get(i).text() + "\n";
        }
        
        format = format + "\n}";
        
        format = format + "\n}";
        
        return format;
    }
}
