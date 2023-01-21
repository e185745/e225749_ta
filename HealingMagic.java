public class HealingMagic implements Action{
        //魔法は個別の名前を持つ
        String name;
        int heal; //攻撃力
        int consumption; //消費MP
     
        HealingMagic(String name, int heal, int consumption) {
            this.name = name;
            this.heal = heal;
            this.consumption = consumption;
        }
     
        @Override
        public String name() {
            return name;
        }
     
        @Override
        public void execute(Character executer, Character target) {
            System.out.println(executer.getName() + "は" + name + "をとなえた!!");
            target.recover(heal); //これもよくない例です．次週修正
            executer.comsumeMp(consumption);
            System.out.println(target.getName()+"は体力が"+heal+"ポイント回復!!");
        }
}
