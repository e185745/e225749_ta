import java.util.ArrayList;

public class GameMaster {
   ArrayList<Character> order = new ArrayList<>();
   ArrayList<Character> players = new ArrayList<>();
   ArrayList<Character> enemys = new ArrayList<>();
   private boolean pdeath = false;
   private boolean edeath = false;

   boolean getPdeath(){return pdeath;}
   boolean getEdeath(){return edeath;}

   

   GameMaster() {

       var denchu = new Player("デンチウ", 100,20,20,false);
       denchu.addAction(new Attack());
          //インスタンスのパラメータを変えることで攻撃魔法のバリエーションを作る
        denchu.addAction(new AttackMagic("ジューデン", 30, 10));
        denchu.addAction(new AttackMagic("ギガジューデン", 60, 20));
        //ここから追加した攻撃魔法
        denchu.addAction(new AttackMagic("ジゴジューデン",90,30));
        //ここから追加した回復魔法
        denchu.addAction(new HealingMagic("ヒール",20,10));

        var denchi = new HealingGoods("かんでんち", 30);
        denchu.addGoods(denchi);

        var alkalidenchi = new HealingGoods("あるかりでんち", 100);
        denchu.addGoods(alkalidenchi);

        var yabailithiumdenchi = new AttackGoods("やばいりちうむでんち", 150);
        denchu.addGoods(yabailithiumdenchi);

        var konbo = new Equipment("こんぼう", 15);
        denchu.addGoods(konbo);
        denchu.equipWeapon(konbo);

        var houdenantena = new Equipment("ほうでんあんてな", 45);
        denchu.addGoods(houdenantena);
        denchu.equipWeapon(houdenantena);


       var dan = new Enemy("ダンさん", 40,10,10,false);
       dan.addAction(new Attack());
       //dan.addAction(new AttackMagic("ジューデン", 30, 10));

       //アクションの順序を決める
       order.add(denchu);
       order.add(dan);

       players.add(denchu);
       enemys.add(dan);

       
   }

   void showStatus() { //全キャラクタのステータスを表示（テスト用）
       for(var ch : order) {
           ch.showStatus();
       }
   }


   void battle() { //１ターン実行する
       for(var ch : order) {
           ch.act(order);
       }
   }

   boolean isDeath(){
    if(players.get(0).getIsdeath()){
        System.out.printf("%sは倒れてしまった。",players.get(0).getName());
        return players.get(0).getIsdeath();
    }else if(enemys.get(0).getIsdeath()){
        System.out.printf("%sを倒した。",enemys.get(0).getName());
        return enemys.get(0).getIsdeath();
    }
    return false;
   }
   /*void pisDeath(){
    if(players.get(1).getIsdeath() == true){
        pdeath = 1;
    }
   }

   void eisDeath(){
    if(enemys.get(1).getIsdeath() == true){
        edeath = 1;
    }
   }*/


}
