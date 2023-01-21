import java.util.ArrayList;
//import java.util.Collection;

public abstract class Character {
    private String name;
    private int hp;
    private int mp;
    private int attack;
    private boolean isdeath = false;
    ArrayList<Action> actions = new ArrayList<>();

    String getName(){return name;}
    int getHp(){return hp;}
    int getMp(){return mp;}
    int getAttack(){return attack;}
    ArrayList<Action> getActions(){return actions;}
    boolean getIsdeath(){return isdeath;}
 
    ArrayList<Action> actionlist = new ArrayList<>();
 
    Character(String name, int hp, int mp, int attack, boolean isdeath) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.isdeath = isdeath;
    }
 
 
    void addAction(Action action) {
        actionlist.add(action);
    }

    void addGoods(Action action){
        actionlist.add(action);
    }
 
    void showStatus() {
        System.out.printf("%s:HP %d  MP %d\n", name, hp, mp);
    }
 
    void damaged(int damage) {
        hp -= damage;
        if(hp<=0){
            this.isdeath = true;
        }
     }
     
     void comsumeMp(int comsumemp) {
        mp -= comsumemp;
     }

     void recover(int recoverd){
        hp += recoverd;
     }
     /*
      * void isDeath() {
        if(hp<=0){
            this.isdeath = true;
        }
     }
      */
     
    //影響を与える可能性のあるオブジェクトの参照を引数として受け取る
    abstract void act(ArrayList<Character> targets); //サブクラスで定義する
    /*public Collection<? extends Action> getActions() {
        return null;
    }*/
 }
 