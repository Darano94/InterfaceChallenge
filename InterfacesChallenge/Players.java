package InterfacesChallenge;

import java.util.ArrayList;

public class Players implements ISaveable {
    private String name;
    private String weapon;
    private int currentHealth;
    private ArrayList<String> playerFieldAttributes;

    @Override
    public ArrayList valuesToBeSaved() {
        return playerFieldAttributes;
    }

    @Override
    public void populateFields(ArrayList stringArrayList) {
        System.out.println(stringArrayList.size());
        if(stringArrayList.size() > 3 || stringArrayList.size() < 3){
            System.out.println("Three fields to specify. " +
                    "\nThe first field should be a String for the Player name." +
                    "\nThe second field should be a String for the name of the weapon the Player is wielding. " +
                    "\nThe third and final field should be an int to set the value of your current health.");
        }else{
            this.name = (String)stringArrayList.get(0);
            this.weapon = (String)stringArrayList.get(1);
            this.currentHealth = Integer.valueOf((String)stringArrayList.get(2));
            playerFieldAttributes = stringArrayList;
        }
    }

    public Players(){
        this.name = "No NAME specified.";
        this.weapon = "No WEAPON specified.";
        this.currentHealth = 100;
        playerFieldAttributes = new ArrayList<>();
        playerFieldAttributes.add(0, this.name);
        playerFieldAttributes.add(1, this.weapon);
        playerFieldAttributes.add(2, String.valueOf(this.currentHealth));
    }

    public Players(String name, String weapon, int currentHealth) {
        this.name = name;
        this.weapon = weapon;
        playerFieldAttributes = new ArrayList<>();
        playerFieldAttributes.add(0, this.name);
        playerFieldAttributes.add(1, this.weapon);

        if(currentHealth > 0 && currentHealth <= 100){
            this.currentHealth = currentHealth;
        }else{
            System.out.println("The value for currentHealth must be between 0 and 100. " +
                    "\nBy default, your currentHealth field will be set to the max value of 100.");
            this.currentHealth = 100;
        }
        playerFieldAttributes.add(2, String.valueOf(this.currentHealth));
    }

    @Override
    public String toString() {

        return "The player named " + this.name + " is wielding a " + this.weapon +
                ". The player currently has " + this.currentHealth + "/100 hit points for health.";
    }
}
