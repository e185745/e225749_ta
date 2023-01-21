import java.util.ArrayList;

public class Player extends Character {
    private ArrayList<Goods> goods = new ArrayList<Goods>();
    private Equipment weapon;

    Player(String name, int hp, int mp, int attack, boolean isdeath) {
        super(name, hp, mp, attack, isdeath);
    }
 
    @Override
    public ArrayList<Action> getActions() {
        //アクションリストのコピーを生成する
        var integrated_actions = new ArrayList<Action>(super.getActions());

        //全持ち物をアクションリストに追加する
        integrated_actions.addAll(goods);

        //統合したアクションリストを返す
        return integrated_actions;
    }

    public int getAttack() {
        //Optionalが使えるならその方がスマートかも
        if( weapon == null) { //武器を持っていなければ影響なし
            return super.getAttack();
        }else {
            return super.getAttack()+weapon.getAttack();
        }
    }
    
    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }
 
 
 

    @Override
    void act(ArrayList<Character> targets) {
        //とりあえずテスト用の単純なコード
        //actionsに何か入っていると信じて．．．
        //targets[1]は敵であると信じて．．．
        var command_selector = new CommandSelector();
        
       //選択肢を用意する
        for(var action: actionlist) {
            command_selector.addCommand(action.name());
        }
       //ユーザの選択を待つ
        var command_number = command_selector.waitForUsersCommand("コマンド？");

       //ターゲットも同様に入力
        command_selector.clearCommands();
        for(var target: targets) {
            command_selector.addCommand(target.getName());
        }
        var target_number = command_selector.waitForUsersCommand("ターゲット？");


        actionlist.get(command_number).execute(this, targets.get(target_number));
    }
 
}
