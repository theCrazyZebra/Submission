/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stacey.pasqualbyrne
 */
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import net.sf.json.JSONObject;

public class Solution
{
    /**
     * 1) Create a script or class that parses this HTML link:  https://github.com/egis/handbook/blob/master/Tech-Stack.md
     * 2) Print to stdout in JSON format the list of technologies by area (Programming, Build, Infrastructure)
     *      -Need h2 for headings
     *      -Need td for technologies (first column only)
    */
    
    public static void main(String[] args)
    {
        Document doc = new Document("");
        Elements headings = null;
        JSONFormatter jFormat = null;
        int num = 1;
        String formatted = "";
        
        
        try
        {
            doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();
            
            
            //Gettings the Headings:
            headings = doc.getElementsByTag("h2");
                        
            //Getting the table data:
            for (Element table : doc.getElementsByTag("table")) 
            {
                Elements rows = table.getElementsByTag("tr");
                
                for (Element row : rows) 
                {       
                    jFormat = new JSONFormatter(rows);

                 }

                formatted = jFormat.format(headings.get(num).text());
                System.out.println(formatted);
                num++;
            }
        }
        
        catch(IOException i)
        {
            System.out.println("Encountered an Exception. Unable to parse the document");
        }
        catch(Exception e)
        {
            System.out.println("Encountered an Exception. Unable to convert document to JSON format");
        }
            
    }
    
    
    
}
