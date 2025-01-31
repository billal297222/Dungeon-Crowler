import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
class Player
{
    public int health;
    public int coins;
    public  boolean PlayerIsAlive;
    Scanner sc=new Scanner(System.in);
    ResumeManager  resumeManager = new ResumeManager();

    public  Player()
    {

        if(resumeManager.resumeStatus()){
          int itemPos[] = resumeManager.getResumeData();
          health=itemPos[4];
          coins=itemPos[6];
        }else{
          health=100;
          coins=0;
        }



        PlayerIsAlive=true;
    }

    public void Run(GameBoard game)
    {
        boolean run=true;

            while(run){
                  System.out.println("\u001B[38;5;130mpress 1 to move up:\u001B[0m");
                  System.out.println("\u001B[38;5;130mpress 2 to mode down:\u001B[0m");
                  System.out.println("\u001B[38;5;130mpress 3 to moe left:\u001B[0m");
                  System.out.println("\u001B[38;5;130mpress 4 to move right\u001B[0m");
                  System.out.println("\u001B[38;5;130mpress 5 to Exit:\u001B[0m");
                  System.out.print("\u001B[33mEnter your choice:\u001B[0m");
                try{

                    int Choice = sc.nextInt();
                    switch (Choice) {
                              case 1: 
                                    game.MoveUp();
                                    game.PrintBoard();
                                    break;
                              case 2:
                   
                                    game.MoveDown();
                                    game.PrintBoard();
                                    break;
                              case 3:
                                    game.MoveLeft();
                                    game.PrintBoard();  
                                    break;
                               case 4:

                                    game.MoveRight();
                                     game.PrintBoard();
                                     break;  
                               case 5:
                                     Clear.clearScreen(); 
                                     run=false;
                                     break;
                              default:
                                      System.out.println("\u001B[32mInvalid choice.\u001B[0m");
                                       break;
                            }
                }
                catch(InputMismatchException e)
                  {
                    Clear.clearScreen(); 
                     System.out.println("\u001B[32mInvalid input.\u001B[0m");
                     game.PrintBoard();
                     sc.next();

                }
         }
    }


    public int getHealth()
    {
        return health;
    }

    public int getCoin()
    {
        return coins;
    }

    public boolean PlayerIsAlive()
    {
        return PlayerIsAlive;
    }

    public void collectCoin(int collect)
    {
        coins+=collect;
    }
    
    public void attack(Enemy enemy)
    { 

        Random random=new Random();
        int damage=random.nextInt(1,25)+5;
       System.out.println(" "); 
       if(enemy.health<damage)
       {
       System.out.println(" \u001B[32mPlayer attacked enemy for \u001B[0m" +enemy.health + "\u001B[32m damage.\u001B[0m");
       }
       else {
        System.out.println("\u001B[32mPlayer attacked enemy for \u001B[0m" + damage + "\u001B[32m damage.\u001B[0m");
       }
        enemy.takedamage(damage);
        
      }
      public void tokedamage(int damage) {
        if(health<damage)
        {
            health-=health;
        }
        else
        {
             health -= damage;
        }   
        if (health == 0) {
            PlayerIsAlive=false;
            System.out.println("\u001B[32mPlayer has been defeated! ):\u001B[0m");
          
        }
    }

    public void Penalty()
    {
        health-=5;
    }
 }

