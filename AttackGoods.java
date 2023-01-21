public class AttackGoods extends Goods {
    private int value;
 
 
    AttackGoods(String name, int value) {
        //スーパークラスのコンストラクタが引数を要求するので，渡す
        super(name);
        this.value = value;
    }
 
    //道具の効果（ふるまい）を記述する
    //Characterクラスに，recoverメソッドが定義されている必要がある
    //recover(a)でaだけHPが回復するような実装にしておく
    @Override
    protected void executeImpl(Character executer, Character target) {
        System.out.println(executer.getName() + "は" + name() + "をつかった！");
        target.damaged(value);
        System.out.println(executer.getName() + "は" + target.getName() + "に" + value + "ポイントのダメージをあたえた!");
    }
 }
