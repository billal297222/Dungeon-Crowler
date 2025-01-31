import java.util.Random;
public class GameBoard
{
    int Row=10;
    int Col=50;
    int prow,pcol,erow,ecol;
    public char[][] board;
    public GameBoard()
    {
      board=new char[Row][Col];  
    }
    public void CreateBoard(ResumeManager resumeManager)
    {
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(i==0 || i==Row-1 || j==0 || j==Col-1){
                    board[i][j] = '*';
                }else{
                    board[i][j] = ' ';
                }
            }
        }


        if(resumeManager.resumeStatus()){
            int itemPos[] = resumeManager.getResumeData();
            prow=itemPos[0];
            pcol=itemPos[1];
            board[prow][pcol]='P';

            erow=itemPos[2];
            ecol=itemPos[3];
            board[erow][ecol]='E';
        }else{
            prow=Row-6;
            pcol=Col-48;
            board[prow][pcol]='P';

            AddEnemy();
        }
        
    }
    public void AddEnemy()
    {
        Random random=new Random();
        erow=random.nextInt(1,Row-1);
        ecol=random.nextInt(5,Col-1);
        board[erow][ecol]='E';
    }

    public void  PrintBoard()
    {
        for(int i=0;i<Row;i++)
        {
            for(int j=0;j<Col;j++){
            System.out.print(board[i][j] + " ");
            }
             System.out.println();
        }  
    }

    public void MoveUp()
    {  
        if(prow==1)
        {
             board[prow][pcol]='P';
             Clear.clearScreen();
             System.out.println("\u001B[31m\nit's top.can't move up\u001B[0m");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                 e.printStackTrace(); 
                }
                Clear.clearScreen();
        }
        else
        {  if(pcol==ecol && erow+1==prow){
              Clear.clearScreen();
              System.out.println("\u001B[31m\ncan't move up\n\u001B[0m");
                try {
                 Thread.sleep(2000);
                } catch (InterruptedException e) {
                     e.printStackTrace(); 
                    }
                Clear.clearScreen();
           }
           else{
             board[prow][pcol]=' ';
             prow=prow-1;
             board[prow][pcol]='P';
             Clear.clearScreen(); 
           }
        }
    }
    public void MoveDown()
    {    
        if(prow==(Row-2))
        {
            board[prow][pcol]='P';
            Clear.clearScreen();
            System.out.println("\u001B[31m\nit's down.can't move down\u001B[0m");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                 e.printStackTrace(); 
                }
                Clear.clearScreen();
        }
        
        else
        {
           if(pcol==ecol && erow-1==prow){
              Clear.clearScreen();
              System.out.println("\u001B[31m\ncan't move down\n\u001B[0m");
                try {
                 Thread.sleep(2000);
                } catch (InterruptedException e) {
                     e.printStackTrace(); 
                    }
                Clear.clearScreen();
           } 
           else{
             board[prow][pcol]=' ';
             prow=prow+1;
             board[prow][pcol]='P';
             Clear.clearScreen(); 
           }
        }

    }  

    public void MoveLeft()
    {
        if(pcol==1)
        {    
              board[prow][pcol]='P';
              Clear.clearScreen();
              System.out.println("\u001B[31m\nit's most left.can't move left\u001B[0m");
                try {
                  Thread.sleep(2000);
                } catch (InterruptedException e) {
                     e.printStackTrace(); 
                    }
                Clear.clearScreen();
        }
        else
        {   if(prow==erow && ecol+1==pcol)
            {
             Clear.clearScreen();   
             System.out.println("\u001B[31m\ncan't move left\n\u001B[0m");
                try {
                 Thread.sleep(2000);
                } catch (InterruptedException e) {
                     e.printStackTrace(); 
                    }
                Clear.clearScreen();
            }
            else{
             board[prow][pcol]=' ';
             pcol=pcol-1;
             board[prow][pcol]='P';
             Clear.clearScreen(); 
            }
        }
    }

    public void MoveRight()
    {   
        if(pcol==(Col-2))
        {
            board[prow][pcol]='P';
             Clear.clearScreen();
             System.out.println("\u001B[31m\nit's most right.can't move right\u001B[0m");
               try {
                 Thread.sleep(2000);
                } catch (InterruptedException e) {
                 e.printStackTrace(); 
                }
                Clear.clearScreen();
        }
        else
        {
           if(prow==erow &&pcol+1==ecol)
            { 
             Clear.clearScreen();   
             System.out.println("\u001B[31m\ncan't move right\n\u001B[0m");
                try {
                  Thread.sleep(2000);
                } catch (InterruptedException e) {
                     e.printStackTrace(); 
                    }
                Clear.clearScreen();
            }
           else{ 
           board[prow][pcol]=' ';
           pcol=pcol+1;
           board[prow][pcol]='P';
           Clear.clearScreen(); 
           }
        }
    }
   
}