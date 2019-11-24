package jp.ac.uryukyu.ie.e195767;

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead(){
        return dead;
    }

    public String getName(){
        return name;
    }

    public void attack(LivingThing opponent){
        if(dead) {
            int damage = 0;
            opponent.wounded(damage);
        }
        else{
            int damage = (int)(Math.random() * attack);
            opponent.wounded(damage);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        }

    }

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}
