package jp.ac.uryukyu.ie.e175737;

/**
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */


public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;


    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      名前
     * @param maximumHP HP
     * @param attack    攻撃力
     */

    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、.wounded()によりダメージ処理を実行。
     */

    public void attack(LivingThing opponent) {
        if (isDead() == false) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        } else {
            int damage = 0;
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     *
     * @param damage 受けたダメージ
     */

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }


    /**
     * getterメソッド、setterメソッド。
     */

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}

