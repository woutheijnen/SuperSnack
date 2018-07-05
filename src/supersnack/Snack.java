/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersnack;

import java.util.Random;

/**
 *
 * @author Wout
 */
public class Snack {
    private String name = "Null";
    private int price = 0;
    private int id = 0;
    private String type = "";
    
    public Snack(int i, String n, int p, String t)
    {
        id = i;
        name = n;
        price = p;
        type = t;
        snackHandler();
    }
    
    private void snackHandler()
    {
        Random r = new Random();
        
        if(!"".equals(type))
        {
            if("f".equals(type))
            {
                if(r.nextBoolean())
                    setSize("Klein", 0);
                else
                    setSize("Groot", 100);
            }
            if("a".equals(type))
            {
                switch(r.nextInt(3))
                {
                    case 0: setSize("Classic", 0);
                        break;
                    case 1: setSize("Cheese", 50);
                        break;
                    default: setSize("Bacon", 100);
                        break;
                }
            }
            if("l".equals(type))
            {
                if(r.nextBoolean())
                    setSize("Klein", 0);
                else
                    setSize("Groot", 130);
            }
            if("p".equals(type))
            {
                switch(r.nextInt(7))
                {
                    case 0: setSize("Margerita", 0);
                        break;
                    case 1: setSize("Prosciutto", 100);
                        break;
                    case 2: setSize("Funghi", 100);
                        break;
                    case 3: setSize("Salami", 100);
                        break;
                    case 4: setSize("Hawai", 170);
                        break;
                    case 5: setSize("Pommier", 220);
                        break;
                    default: setSize("Vegetarien", 220);
                        break;
                }
            }
        }
        
        if((r.nextBoolean() || "l".equals(type)) && !"".equals(type))
        {
            if("s".equals(type) || "f".equals(type) || "a".equals(type) || "l".equals(type))
            {
                switch(r.nextInt(7))
                {
                    case 0: addSauce("Mayonese", 30);
                        break;
                    case 1: addSauce("Ketchup", 30);
                        break;
                    case 2: addSauce("Curry", 30);
                        break;
                    case 3: addSauce("Mosterd", 30);
                        break;
                    case 4: addSauce("Pinda", 70);
                        break;
                    case 5: addSauce("Speciaal", 70);
                        break;
                    default: addSauce("Oorlog", 70);
                        break;
                }
            }
            if("p".equals(type))
            {
                int supp = 0;
                do
                {
                    supp ++;
                }while(r.nextBoolean());
                addSauce(supp+" supplementen",(50*supp));
            }
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public String getType()
    {
        return type;
    }
    
    private void addSauce(String n, int p)
    {
        name += " met "+n;
        price += p;
    }
    
    private void setSize(String n, int p)
    {
        name += " "+n;
        price += p;
    }
    
    public int getId()
    {
        return id;
    }
}
