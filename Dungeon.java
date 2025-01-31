import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Dungeon {

    public static void main(String[] args) {
        GameBoard game = new GameBoard();
        Dungeon dungeon = new Dungeon();
        Buy by = new Buy();
        ResumeManager resumeManager = new ResumeManager(); 
        game.CreateBoard(resumeManager);
        Player player = new Player();
        Enemy enemy = new Enemy();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        StopMenu stopMenu = new StopMenu();
        int count;
        boolean check=false;

        if(resumeManager.resumeStatus()){
          int itemPos[] = resumeManager.getResumeData();
          count=itemPos[7];
        }else{
          count=0;
        }
        
        int missAttack=0;
        System.out.println("\n\n\t\t\t\u001B[32mWelcome to\n\n\t\t\tDUNGEON CRAWLER\u001B[0m");
        try {
          Thread.sleep(2000);
          } catch (InterruptedException e) {
          e.printStackTrace(); 
          }
          Clear.clearScreen();

while (running) {

    if (!stopMenu.isStoped()) {

            game.PrintBoard();
            System.out.println("\u001B[31mPlayer Health: \u001B[0m" + player.getHealth());
            System.out.println("\u001B[31mEnemy Health:  \u001B[0m" + enemy.getHealth()+"\n");
            System.out.println("\u001B[32mpress 1 to attack:\u001B[0m\t\t\t\t\t\u001B[32mEnemy Killed:  \u001B[0m" + count);
            System.out.println("\u001B[32mpress 2 to run:\u001B[0m\t\t\t\t\t\t\u001B[32mcollect coins: \u001B[0m" + player.getCoin());
            System.out.println("\u001B[32mpress 3 to buy: \u001B[0m\t\t\t\t\t\u001B[32mScore = \u001B[0m" + (count * 10));
            System.out.println("\u001B[32mpress 4 to stop:\u001B[0m");
            System.out.println("\u001B[32mpress 5 to Exit:\u001B[0m");

            resumeManager.setResumeData(game.prow, game.pcol, game.erow, game.ecol,player.getHealth(),enemy.getHealth(),player.getCoin(),count,(count * 10));
            
            System.out.print("\u001B[33mEnter your choice: \u001B[0m");
        



             int choice;
                 try {
                     choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                          System.out.println("Invalid input");
                          sc.nextLine();
                          continue;
                       }

            switch (choice) {

                case 1:
                    Clear.clearScreen(); 
                    if ((game.prow) == (game.erow)||game.pcol==game.ecol) {

                            if((game.ecol!=game.pcol)&&game.pcol<game.ecol ){
                                  for(int j=(game.pcol)+1;j<game.ecol;j++){                             
                                     game.board[game.prow][j] = '-';
                                    }
                              
                                    game.PrintBoard();
                            
                                 try {
                                     Thread.sleep(2000);
                                    } catch (InterruptedException e) {
                                          e.printStackTrace(); 
                                        }
                                     Clear.clearScreen();
                                    for(int j=(game.pcol)+1;j<game.ecol;j++){
                                     
                                      game.board[game.prow][j] = ' ';
                                    }

                            }  
                            else if((game.ecol!=game.pcol)&&game.pcol>game.ecol){
                                  for(int j=(game.pcol)-1;j>game.ecol;j--){                             
                                     game.board[game.prow][j] = '-';
                                    }

                               game.PrintBoard();
                            
                                try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                         for(int j=(game.pcol)-1;j>game.ecol;j--){                             
                                          game.board[game.prow][j] = ' ';
                                        }
                            }
                            else if((game.erow!=game.prow)&&game.prow>game.erow){
                                  for(int j=(game.prow)-1;j>game.erow;j--){                             
                                     game.board[j][game.pcol] = '|';
                                     }

                                 game.PrintBoard();
                            
                                  try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                    for(int j=(game.prow)-1;j>game.erow;j--){                             
                                     game.board[j][game.pcol] = ' ';
                                     }           
                                }

                                else{ 
                                  for(int j=(game.prow)+1;j<game.erow;j++){                             
                                     game.board[j][game.pcol] = '|';
                                    }

                                    game.PrintBoard();
                            
                                  try {
                                     Thread.sleep(2000);
                                   }catch (InterruptedException e) {
                                      e.printStackTrace(); 
                                    }
                                    Clear.clearScreen();
                                    for(int j=(game.prow)+1;j<game.erow;j++){                             
                                     game.board[j][game.pcol] = ' ';
                                     }           
                                }
                        
                        enemy.attack(player);
                        player.attack(enemy);
                       try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                              e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                        
                       game.board[game.erow][game.ecol] = ' ';
                       game.AddEnemy();

                        if (!enemy.isAlive()) {
                            System.out.println(" ");
                            //
                            Clear.clearScreen();                        
                            System.out.println("\u001B[32mEnemy defeated! :(\u001B[0m");
                            System.out.println("\u001B[32m HORRY :(\u001B[0m");
                            count++;                           
                            Random random = new Random();
                            player.collectCoin(random.nextInt(1, 15));
                            System.out.println("\u001B[32mNew Enemy Appeared \u001B[0m");
                            enemy = new Enemy();
                            game.board[game.erow][game.ecol] = ' ';
                         try {
                             Thread.sleep(2000);
                           } catch (InterruptedException e) {
                                  e.printStackTrace(); 
                                }
                         Clear.clearScreen(); 
                         game.AddEnemy();      
                        }
                        break;
                    } 
                    
                    else 
                    {
                      if(game.pcol<game.ecol && Math.abs(game.pcol-game.ecol)>Math.abs(game.prow-game.erow))
                       {
                          for(int j=(game.pcol)+1;j<game.Col-1;j++){
                                game.board[game.prow][j] = '-';                               
                            } 
                          game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                            for(int j=(game.pcol)+1;j<game.Col-1;j++)
                               {
                                game.board[game.prow][j] = ' ';
                            }

                    }
                     else if(game.ecol<game.pcol && Math.abs(game.pcol-game.ecol)>Math.abs(game.prow-game.erow))
                       {
                          for(int j=(game.pcol)-1;j>0;j--){
                                game.board[game.prow][j] = '-';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                            for(int j=(game.pcol)-1;j>0;j--)
                               {
                                game.board[game.prow][j] = ' ';
                            }

                    }    

                    else if((Math.abs(game.pcol-game.ecol))<(Math.abs(game.prow-game.erow))&&game.erow<game.prow)
                       {
                          for(int j=(game.prow)-1;j>0;j--){
                                game.board[j][game.pcol] = '|';                               
                            } 
                       game.PrintBoard();
                       try {              
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                            for(int j=(game.prow)-1;j>0;j--)
                               {
                                game.board[j][game.pcol]= ' ';
                            }

                    }       
                   else if((Math.abs(game.pcol-game.ecol))<(Math.abs(game.prow-game.erow))&&game.erow>game.prow)
                       {
                          for(int j=(game.prow)+1;j<game.Row-1;j++){
                                game.board[j][game.pcol] = '|';                               
                            } 
                       game.PrintBoard();
                       try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                             e.printStackTrace(); 
                            }
                        Clear.clearScreen();
                            for(int j=(game.prow)+1;j<game.Row-1;j++)
                               {
                                game.board[j][game.pcol]= ' ';
                            }

                    }       

                         player.Penalty();
                         Clear.clearScreen(); 
                         System.out.println("\u001B[31mPlayer loss his 5 health for penalty ):\n\u001B[0m");
                          System.out.println("\u001B[31mOOh sad!! ):\u001B[0m");
                         try {
                         Thread.sleep(2000);
                        } catch (InterruptedException e) {
                         e.printStackTrace(); 
                         }
                          missAttack++;
                        if(missAttack==15){
                          running=false;
                          break;
                        }
                        Clear.clearScreen();
                        game.board[game.erow][game.ecol] = ' ';
                        game.AddEnemy();


                   
                    }
                    break;

                case 2:

                    Clear.clearScreen(); 
                    game.PrintBoard();
                    player.Run(game);
                    break;

                case 3:
                    by.buy(player);
                    break;

                case 5:
                    running = false;
                    check=true;
                    break;
                case 4:
                      stopMenu.stop();
                        break;  

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
    
            if (!player.PlayerIsAlive()) {
                break;
            }
      } 
          else 
          {  
            Clear.clearScreen();
             System.out.println("\u001B[33mGame stop. Press 4 to resume.\u001B[0m");
             
                int choice;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                     Clear.clearScreen();
                    System.out.println("Invalid input");
                   
                    sc.nextLine();
                    continue;
                }
                if (choice== 4) {
                    Clear.clearScreen();
                    stopMenu.stop();
                    
                }
          }
    }  
       if(check==false){
          resumeManager.clearResumeFile();
       }
        Clear.clearScreen(); 
        System.out.println("\u001B[31mThe Game is Over (:\u001B[0m");
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace(); 
            }
         Clear.clearScreen(); 
        System.out.println("\u001B[32m\t\t\t\t\t\t\t Final Score = \u001B[0m" + count * 10);
    }
}