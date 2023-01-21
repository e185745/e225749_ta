import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Character {
    Enemy(String name, int hp, int mp, int attack, boolean isdeath) {
        super(name, hp, mp, attack, isdeath);
    }

    @Override
    void act(ArrayList<Character> targets) {
        //テスト用コード
        //actionlist.get(0)はたたかうのはず．．．
        //targets.get(0)はプレーヤのはず．．．

        //addAction自体がactionsに追加するメソッドなのでそのまま描く
        //ArrayListもCharacterで既にインスタンス化されている
        addAction(new AttackMagic("火球",20,10));
        addAction(new AttackMagic("大火球", 30, 20));
        addAction(new HealingMagic("自己再生", 10, 10));

        var rand = new Random();
        int index = rand.nextInt(actionlist.size()); //ランダムに選択されたインデクス
        var selected_action = actionlist.get(index);

        selected_action.execute(this, targets.get(0));
        //actionlist.get(0).execute(this, targets.get(0));
    }
 }
 
