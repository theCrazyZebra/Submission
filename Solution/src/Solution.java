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
        Element content;
        Elements tableItems = null;
        JSONObject jsonParentObject;
        
        try
        {
            doc = Jsoup.connect("https://github.com/egis/handbook/blob/master/Tech-Stack.md").get();
            
            
            //Programming Stack:
            tableItems = doc.getElementsByTag("td");
            
            for (Element tableItem : tableItems) 
            {
                String linkHref = tableItem.attr("td");
                String linkText = tableItem.text();
                
            }
            
            jsonParentObject = new JSONObject();
        
        for (Element table : doc.select("table")) 
        {
            for (Element row : table.select("tr")) 
            {
                JSONObject jsonObject = new JSONObject();
                
                Elements tds = row.select("td");
                
                String tech = tds.get(0).text();
                String reason = tds.get(1).text();
                String lifeCycle = tds.get(2).text();      
                jsonObject.put("Tech", tech);
                jsonObject.put("Reason", reason);
                jsonObject.put("Life Cycle", lifeCycle);
                jsonParentObject.put("",jsonObject);
             }
        }
            System.out.println(jsonParentObject.toString());
        }
        
        catch(IOException i)
        {
            System.out.println("Encountered an Exception. Unable to parse the document");
        }
        catch(Exception e)
        {
            System.out.println("Encountered an Exception. Unable to convert document to JSON format");
        }
    
        String title = doc.title();
        
        System.out.println(title);
        
        tableItems.toArray();
        
        for(int i = 0; i < tableItems.size(); i = i + 3 )
        {
            Element ti = tableItems.get(i);
            System.out.println(ti.text());
        }
    }
    
    
    
}
