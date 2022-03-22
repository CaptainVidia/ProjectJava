package com.mycompany.projectjob;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author George Tang
 */
public class ProjectJob 
{

    public static void main(String[] args) throws IOException 
    {
        // instantiate the URL class
        URL url = new URL("https://fetch-hiring.s3.amazonaws.com/hiring.json");
        //retrieve conetents from the page
        Scanner scanner = new Scanner(url.openStream());
        //instantiate the stringBuffer to hold result
        StringBuffer stringBuffer = new StringBuffer();
        while(scanner.hasNext())
        {
            stringBuffer.append(scanner.next());
            //System.out.println(scanner.next);
        }
        //wait for user to pick an option
        //1 print everything
        // 2 print sorted first by "listId" then by "name"
        // 3 Filter out any items where "name" is blank or null

        //print out everything
                String result = stringBuffer.toString();
                System.out.println(result);
                // remove HTML tags
                result = result.replaceAll("<[^>]","");
                System.out.println("Information: " + result);
                
                //print sorted first by "listID" then by "name"
                FileReader fr = new FileReader("fetchHiring");
                BufferedReader reader = new BufferedReader(fr);
                ArrayList<String> str = new ArrayList<>();
                ArrayList<Integer> listid = new ArrayList<>();
                String line;
                while((line=reader.readLine())!=null)
                {
                    str.add(line);
                }
                reader.close();
                Collections.sort(str);
                System.out.println(str);
                Collections.sort(listid);
                System.out.println(listid);
                
                //Filter out null
                ArrayList<String> filter = new ArrayList<>();
                filter.add("null");
                str.removeAll(filter);
                System.out.println("Filtered List " + str);
                
            
        }
    }
    

class ListD
    {
        int id;
        int list2iD;
        String name;
        public ListD(int id, int list2iD, String name)
        {
            this.id = id;
            this.list2iD = list2iD;
            this.name = name;
        }
    }


    

        


