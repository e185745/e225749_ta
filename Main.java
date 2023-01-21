public class Main {

    public static void main(String[] args) {
        var master = new GameMaster();
   
        for(var i=0; i<3; i++) {
             master.showStatus();
             master.battle();
             if(master.isDeath() == true){
                break;
            }
         }

    } 
}
