package com.arturo.linearyscrollbar.Modelos;

public class ModeloItemsRandom {
    private int id;
    private String nombre;
    private int costo;
    private int physicalPower;
    private int magicalPower;
    private int mana;
    private int attackSpeed;
    private int health;
    private int coolDown;
    private int movementSpeed;
    private int MPS;
    private int penetration;
    private int magicalProtection;
    private int physicalProtection;
    private int lifeSteal;
    private int criticalStrikeChance;
    private int crowdControlReduction;
    private int HPS;
    private String pasive;
    private String pasivees;
    private String tipo;


    public ModeloItemsRandom(){}

    public ModeloItemsRandom(int id, String nombre, int costo, int physicalPower, int magicalPower, int mana, int attackSpeed, int health, int coolDown,
                             int movementSpeed, int MPS, int penetration, int magicalProtection, int lifeSteal, int criticalStrikeChance, int crowdControlReduction,
                             int HPS, String pasive, String tipo,int PhysicalProtection,String pasivees) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.physicalPower = physicalPower;
        this.magicalPower = magicalPower;
        this.mana = mana;
        this.attackSpeed = attackSpeed;
        this.health = health;
        this.coolDown = coolDown;
        this.movementSpeed = movementSpeed;
        this.MPS = MPS;
        this.penetration = penetration;
        this.magicalProtection = magicalProtection;
        this.lifeSteal = lifeSteal;
        this.criticalStrikeChance = criticalStrikeChance;
        this.crowdControlReduction = crowdControlReduction;
        this.HPS = HPS;
        this.pasive = pasive;
        this.tipo = tipo;
        this.physicalProtection = PhysicalProtection;
        this.pasivees = pasivees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getPhysicalPower() {
        return physicalPower;
    }

    public void setPhysicalPower(int physicalPower) {
        this.physicalPower = physicalPower;
    }

    public int getMagicalPower() {
        return magicalPower;
    }

    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getMPS() {
        return MPS;
    }

    public void setMPS(int MPS) {
        this.MPS = MPS;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public int getMagicalProtection() {
        return magicalProtection;
    }

    public void setMagicalProtection(int magicalProtection) {
        this.magicalProtection = magicalProtection;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public void setLifeSteal(int lifeSteal) {
        this.lifeSteal = lifeSteal;
    }

    public int getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    public void setCriticalStrikeChance(int criticalStrikeChance) {
        this.criticalStrikeChance = criticalStrikeChance;
    }

    public int getCrowdControlReduction() {
        return crowdControlReduction;
    }

    public void setCrowdControlReduction(int crowdControlReduction) {
        this.crowdControlReduction = crowdControlReduction;
    }

    public int getHPS() {
        return HPS;
    }

    public void setHPS(int HPS) {
        this.HPS = HPS;
    }

    public String getPasive() {
        return pasive;
    }

    public void setPasive(String pasive) {
        this.pasive = pasive;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPhysicalProtection() {
        return physicalProtection;
    }

    public void setPhysicalProtection(int physicalProtection) {
        this.physicalProtection = physicalProtection;
    }

    public String getPasivees() {
        return pasivees;
    }

    public void setPasivees(String pasivees) {
        this.pasivees = pasivees;
    }
}
