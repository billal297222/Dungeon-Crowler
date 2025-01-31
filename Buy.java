import java.util.Scanner;
class Buy
 {
     Scanner sc=new Scanner(System.in);

    public void buy(Player player){  

         Clear.clearScreen(); 
         System.out.println("\u001B[33m\nDo you want to Buy health??\u001B[0m");
         System.out.println("\u001B[33m\ntype yes or no\u001B[0m");
         String st=sc.next();
         System.out.println(st);
       if(st.equalsIgnoreCase("YES"))
         {
             if(player.health>15){
                Clear.clearScreen(); 
                  System.out.println("\u001B[32mReamaining enough health\u001B[0m");
                  try {
                    Thread.sleep(2000);
                  } catch (InterruptedException e) {
                       e.printStackTrace(); 
                     }
                      Clear.clearScreen(); 
               }
             else if(player.coins<20 && player.health<15){
                Clear.clearScreen(); 

                 System.out.println("\u001B[31minsufficient coins\u001B[0m");
             }
             else {
                 Clear.clearScreen(); 
                 player.health+=10;
                 player.coins-=20;
                 System.out.println("\u001B[32m\nSuccesfully\u001B[0m");
              }
        }
       else if(st.equalsIgnoreCase("NO")) 
      {

        Clear.clearScreen(); 
        System.out.println("\u001B[33m\nback to the field\u001B[0m");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
                  e.printStackTrace(); 
                }
          Clear.clearScreen(); 
      }
      else 
      {
          Clear.clearScreen(); 
        System.out.println("\u001B[31m\nType mistake\u001B[0m");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
             e.printStackTrace(); 
            }
          Clear.clearScreen(); 
      }

    }
}