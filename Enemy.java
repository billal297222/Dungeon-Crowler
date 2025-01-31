import java.util.Random;

class Enemy
{
    public int health;
    public boolean isAlive;
    public Enemy(){
        ResumeManager  resumeManager = new ResumeManager();
        Random random = new Random();
        if(resumeManager.resumeStatus()){
          int itemPos[] = resumeManager.getResumeData();
          health=itemPos[5];
        }else{
            health = random.nextInt(50) + 10;
        }
        isAlive = true;      
    }

    public int getHealth()
    {
        return health;
    }
    public boolean isAlive()
    {
        return isAlive;
    }
    public void takedamage(int damage)
    {
        if(health<damage)
        {
            health-=health;
        }
        else
        {
            health-=damage;
        }
        
        if(health==0)
        {
            isAlive=false;
        }
    }
    public void attack(Player player) {
       
        int damage = new Random().nextInt(10);
        if (player.getHealth() < damage) {
            System.out.println("\u001B[31mEnemy attacked player for \u001B[0m" + player.getHealth() + "\u001B[31m damage.\u001B[0m");
        } else {
            System.out.println("\u001B[31mEnemy attacked player for \u001B[0m" + damage + " \u001B[31mdamage.\u001B[0m");
        }
        player.tokedamage(damage);
    }
}