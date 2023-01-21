public class Equipment extends Goods {
    private int attack;
    Equipment(String name, int attack) {
        super(name);
        this.attack = attack;
    }
    int getAttack() { return attack; }
  
    @Override
    protected void executeImpl(Character executer, Character target) {
        System.out.println("なにも起きなかった");
    }
 }
 