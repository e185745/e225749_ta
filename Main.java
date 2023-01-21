public class Main {

    public static void main(String[] args) {
        var master = new GameMaster();
   
        while(master.isDeath() == false) {
             master.showStatus();
             master.battle();
         }

    } 
}
