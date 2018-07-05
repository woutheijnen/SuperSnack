/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersnack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Wout
 */
public class Menu {
    private ArrayList<Snack> cm = new ArrayList<>();
    private int hsDiffItems = 1;
    private ArrayList<ArrayList<String>> menus = new ArrayList<>();
    
    public void IAmHungry(int a)
    {
        Boolean finished = false;
        
        do{
            while(totalPrice() < a)
            {
                cm.add(randomSnack());
            }
            if(totalPrice() == a)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                int currentDiffItems = 0;
                for(int i=0; i< cm.size(); i++)
                {
                    if(!temp.contains(cm.get(i).getId()))
                    {
                        temp.add(cm.get(i).getId());
                        currentDiffItems ++;
                    }
                }
                
                if(hsDiffItems == currentDiffItems)
                {
                    hsDiffItems ++;
                    ArrayList<String> temp2 = new ArrayList<>();
                    for(int k=0; k<cm.size(); k++)
                    {
                        temp2.add(cm.get(k).getName()+": "+cm.get(k).getPrice());
                    }
                    menus.add(temp2);
                }
                if(hsDiffItems == 7)
                    finished = true;
                cm.clear();
            }
            if(totalPrice() > a)
            {
                cm.clear();
            }
        }while(!finished);
        
        Random r = new Random();
        int index = r.nextInt(6);
        System.out.println("====== MENU ======");
        for(int j=0; j<menus.get(index).size(); j++)
            System.out.println(menus.get(index).get(j));
        System.out.println();
        System.out.println();
    }
    
    private int totalPrice()
    {
        int cp = 0;
        if(cm.size() > 0)
        {
            for(int i=0; i<cm.size(); i++)
            {
                cp += cm.get(i).getPrice();
            }
        }
        return cp;
    }
    
    private Snack randomSnack()
    {
        Random r = new Random();
        switch(r.nextInt(15))
        {
            case 0: return new Snack(1, "Frikandel", 180, "s");
            case 1: return new Snack(2, "Bamiblok", 180, "");
            case 2: return new Snack(3, "Kroket", 160, "s");
            case 3: return new Snack(4, "Mexicano", 210, "");
            case 4: return new Snack(5, "Patat", 200, "f");
            case 5: return new Snack(6, "Berenklauw", 200, "");
            case 6: return new Snack(7, "Bitterballen x8", 400, "");
            case 7: return new Snack(8, "Kip Nuggets x8", 400, "s");
            case 8: return new Snack(9, "American", 500, "a");
            case 9: return new Snack(10, "Hamburger", 450, "");
            case 10: return new Snack(11, "Cheeseburger", 500, "");
            case 11: return new Snack(12, "O' Chicken", 450, "");
            case 12: return new Snack(13, "Royal Bacon", 530, "");
            case 13: return new Snack(14, "Saus", 0, "l");
            default: return new Snack(15, "Pizza", 780, "p");
        }
    }
}
