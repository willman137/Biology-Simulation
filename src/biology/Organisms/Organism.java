/*

* To change this template, choose Tools | Templates

* and open the template in the editor.

*/

package biology.Organisms;

import biology.simulation.BiologySimulation;

import biology.simulation.GUI;

import biology.simulation.Grave;

import info.gridworld.actor.Actor;

import info.gridworld.actor.Bug;

import info.gridworld.grid.Grid;

import info.gridworld.grid.Location;
import java.awt.BorderLayout;

import java.awt.Color;

import java.util.ArrayList;

import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**

*

* @author Will

*/

public class Organism extends Bug{

    public String genotype, gender, name, diet, testGene, wingType;

    public int cipher, death, key, generation, numLimbs;
    
    public static int rec, dom, het;
    
    private boolean id, reproducing, oneChild;
    
    public int age, lagPeriod, maxSteps, steps;
    static int x = 700,y = 450;
    public boolean isCarnivorous, isVegetarian, isOmnivorous, genderLocked, dietLocked;

    public static String [] testAlleles = {"Aa", "Ii", "Nn"};
    
    private ArrayList<Organism> genes = new ArrayList<>();

    public static String[] diets = {"Omnivorous", "Vegetarian", "Carnivorous"}, names = {"Alouette", "Beta", "Gamma", "Rho"}, genders = {"Female", "Male"};

    public static int[] direction = {Location.NORTH, Location.EAST,Location.SOUTH,Location.WEST,Location.NORTHEAST, Location.NORTHWEST, Location.SOUTHEAST, Location.SOUTHWEST};

    public static Color color[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.WHITE, Color.YELLOW, Color.RED};

    public Organism() {

        int ranName = (int) (Math.random() * names.length);

        int ranGender = (int) (Math.random() * genders.length);

        int ranDiet = (int) (Math.random() * diets.length);

        int ranDirec = (int) (Math.random() * direction.length);

        this.age = 1;

        this.lagPeriod = 0;

        this.name = names[ranName];

        this.genotype = "";

        this.diet = diets[ranDiet];

        this.dietLocked = false;

        this.gender = genders[ranGender];

        this.genderLocked = false;

        this.genes = null;

        this.reproducing = false;

        this.generation = 1;

        this.oneChild = false;

        this.maxSteps = (int) (Math.random() * 300) + 100;

        this.death = this.maxSteps;

        this.setDirection(ranDirec);

        this.testGene = "";

        this.wingType = "";

        this.numLimbs = 6;

        BiologySimulation.orgCount++;

}

    public static ArrayList newMetricTonOfOrganisms() {

       int ran = (int) (Math.random() * 50);

       ArrayList<Organism> metric = new ArrayList<>();

       for (int n = 0; n < ran; n++) {

           Organism org = new Organism();

           int ranDiet = (int) (Math.random() * diets.length);

           int ranName = (int) (Math.random() * names.length);

           int ranGender = (int) (Math.random() * genders.length);

           int ranDirec = (int) (Math.random() * direction.length);

           org.setName(names[ranName] + " " + n);

           org.setGender(genders[ranGender]);

           org.setDiet(diets[ranDiet]);

           org.setDirection(direction[ranDirec]);

           metric.add(org);

           org.id = true;

       }

       return metric;

    }

    public static ArrayList newMetricTonOfOrganisms(int num) {

       ArrayList<Organism> metric = new ArrayList<>();

       Arrays.sort(names);

       for (int n = 0; n < num; n++) {

           Organism org = new Organism();

           int ranDiet = (int) (Math.random() * diets.length);

           int ranName = (int) (Math.random() * names.length);

           int ranGender = (int) (Math.round(Math.random()));

           int ranDirec = (int) (Math.random() * direction.length);

           org.setRandomGenoType();

           org.setName(names[ranName] + " " + n);

           org.setGender(genders[ranGender]);

           org.setDiet(diets[ranDiet]);

           org.setDirection(direction[ranDirec]);

           metric.add(org);

       }

       return metric;

    }

    public void setName(String name) {

       this.name = name;

    }

    public void mutate()//implement later

    {

       int ran = (int) (Math.random());

    }

    public void setGender(String gender) {

       if (this.genderLocked != false) {

           GUI.remAppend("Gender is Locked");

       } else {

           String temp = this.gender;

           temp.toLowerCase();

           if (temp.equalsIgnoreCase("female") || temp.equalsIgnoreCase("male")) {
               this.gender = gender;
               this.genderLocked = true;
               GUI.remAppend("Gender is not locked, locking " + this.name + "'s gender now ");
           } else {

               GUI.remAppend("Not valid, now go find wool");
           }

       }

    }

    public String setGender_returnString(String gender) {

       String ret;

       if (this.genderLocked != false) {

           ret = ("Gender is Locked");

       } else {

           String temp = this.gender;

           temp.toLowerCase();

           if (!temp.equalsIgnoreCase("female") || !temp.equalsIgnoreCase("male")) {

               ret = ("Not a valid name. Try again");

           } else {

               this.gender = gender;

               this.genderLocked = true;

               ret = ("Gender is not locked, locking " + this.name + "'s gender now now");

           }

       }

       return ret;

    }

    public void setDiet(String diet) {

       for (int i = 0; i < diets.length; i++) {

           if (diet.equalsIgnoreCase((diets[i]))) {

               this.diet = diets[i];

           }

       }

    }

    private static double[] pundit(String allele_1, String allele_2)//omit for now

    {

       int p1 = allele_1.length(), p2 = allele_2.length();

       String[][] alleles = new String[p2][p1];

       double[] prog = {0.0};

       return prog;

    }

    private void setRandomGenoType() {

       int chromNum = testAlleles.length;

       for (int n = 0; n < chromNum; n++){

           String comp = testAlleles[n];

          

           for(int q = 0; q < comp.length(); q++)

           {

               int indx = (int) (Math.random() * (comp.length()));

               if(indx >1)

                   indx = 1;

               this.genotype += testAlleles[n].charAt(indx);

           }

      

       }

    }

    private void reproduce(Organism parent, Organism parent_2) {

       Organism offspring = new Organism();

       Location loc;

       //int rndmColor = (int) (Math.random() * this.color.length);

       if (parent.getGender().equals("female")){

           loc = parent.getLocation();

       } else {

           loc = parent_2.getLocation();

       }

       ArrayList<Location> emptyAdjLocs = getGrid().getEmptyAdjacentLocations(loc);

       Grid<Actor> grid = parent.getGrid();

       //offspring.setColor(color[rndmColor]);

       offspring.generation = parent.generation + 1;// -0.1 and 0.1

       if (parent.age > 100 && parent_2.age > 100) {

           offspring.maxSteps = (int) ((1 + (Math.random() * 0.2) - 0.1) * ((parent.steps + parent_2.steps) / 2));

           offspring.death = offspring.maxSteps;

       } else {

           offspring.maxSteps = (int) ((1 + (Math.random() * 0.2) - 0.1) * ((parent.steps + parent_2.steps + (this.maxSteps + 200)) / 2));

           offspring.death = offspring.maxSteps;

       }

       offspring.crossOver(parent, parent_2);

       offspring.genotypeScanner();

       GUI.remAppend("Max Steps of Offspring: " + offspring.maxSteps);

       if (emptyAdjLocs.size() >= 1) {

           offspring.putSelfInGrid(grid, emptyAdjLocs.get((int) (Math.random() * emptyAdjLocs.size())));

       }

    }

    private void crossOver(Organism p1, Organism p2) {
       int num = (int)((p1.genotype.length()+p2.genotype.length())/4);
       int genoLength = (int)((p1.genotype.length()+p2.genotype.length())/2);
       String tempGenotype[] = new String[num];
       int i = 0;

       for (int n = 0; n < genoLength; n+=2) {
           if ((n + 2) >= genoLength) {
               tempGenotype[i] = p1.genotype.substring(n);
           } else {
               tempGenotype[i] = p1.genotype.substring(n, n + 2);
           }
           //--------------
           int rndm = (int) Math.round(Math.random());
           this.genotype += tempGenotype[i].charAt(rndm);
           //---------------

           if ((n + 2) >= genoLength) {
               tempGenotype[i] = p2.genotype.substring(n);
           } else {
               tempGenotype[i] = p2.genotype.substring(n, n + 2);
           }

           //-------------

           int rndm2 = (int) Math.round(Math.random());
           this.genotype += tempGenotype[i].charAt(rndm2);

           //---------------

           i++;

       }

    }

    //Mix together parent genotypes

    //Compare in pairs - Take 1 letter from each parent randomly - if parent only can give A (only has AA in genotype), give A

    private void bettercrossOver(Organism p1, Organism p2) {

       String tempGenotype[] = new String[3];

       int i = 0;

       for (int n = 0; n < p1.genotype.length(); n+=2) {

           String chs = (genotype.substring(n)+genotype.substring(n+1));

           if(chs.equals("AA")){
               dom++;
               tempGenotype[i] = p1.genotype.substring(n,n+1);
           }
           else if(chs.equals("aa")){
               rec++;
               tempGenotype[i] = p1.genotype.substring(n,n+1);
           }
           else

           {

               int ran = (int) (Math.random() * n);

           }

           //--------------

           int rndm = (int) Math.round(Math.random());

           this.genotype += tempGenotype[i].charAt(rndm);

           //---------------

           if ((n + 2) >= 6) {

               tempGenotype[i] = p2.genotype.substring(n);

           } else {

               tempGenotype[i] = p2.genotype.substring(n, n + 2);

           }

           //-------------

           int rndm2 = (int) Math.round(Math.random());

           this.genotype += tempGenotype[i].charAt(rndm2);

           //---------------

           i++;

       }

    }   


    public void genotypeScanner(){

       //Checks first two alleles and sets colour accordingly

       switch(this.genotype.substring(0, 2)){

           case "AA":
               
               this.setColor(Color.RED);
               //System.out.println("Color Red with: AA");

               break;

           case "aa":
               
               this.setColor(Color.BLUE);
               //System.out.println("Color Blue with: aa");

               break;

           default:

               this.setColor(Color.GREEN);
               //System.out.println("Color Green with: Aa");

               break;

       }

       switch(this.genotype.substring(2, 4)){

           case "II":

               this.wingType = "Long";
               
               break;

           case "ii":

               this.wingType = "Short";
               break;

           default:

               this.wingType = "Average";
               break;

       }

       switch(this.genotype.substring(4)){

           case "II":

               this.numLimbs = 8;
               break;

           case "ii":

               this.numLimbs = 4;
               break;

           default:

               this.numLimbs = 6;
               break;

       }

}
    public void getAlleleInfo() {
       JFrame info = new JFrame("allele Info");
       JTextArea text = new JTextArea();
       info.setSize(300, 200);
       info.getContentPane().add(BorderLayout.CENTER, text);
       StringBuffer sb = new StringBuffer();
       for(int n = 0; n < BiologySimulation.counts.length; n++)
            sb.append(("Allele "+BiologySimulation.counts[n].name+" Count: "+ BiologySimulation.counts[n].cnt+"\n"));

       text.setEditable(false);
       text.append(sb.toString());
      
       info.setLocation(700,450);       

       info.show(); 
    }
//first two allele sets are colours dominant (A) = red, recessive (a) = blue

// - scanner feature scans in pairs - new method genotypeScanner

//last two are number of legs - int (even numbers) 6 or 8

//middle number wing type (short/long/average) string

    public void getInfo() {
       JFrame info = new JFrame(this.name+"'s Info");
       JTextArea text = new JTextArea();
       info.setSize(300, 200);
       info.getContentPane().add(BorderLayout.CENTER, text);
       StringBuffer sb = new StringBuffer();

       sb.append(("Name: " + this.name + "\n"));
       sb.append(("Gender: " + this.gender + "\n"));
       sb.append(("Diet: " + this.diet + "\n"));
       sb.append(("Steps Taken: " + (this.steps) + "\n"));
       sb.append(("Steps Before Death: " + this.death + "\n"));
       sb.append(("Generation: " + this.generation + "\n"));
       sb.append(("Genotype: ") + this.genotype + "\n");
       sb.append(("Wing type: ") + this.wingType + "\n");
       sb.append(("Limbs: ") + this.numLimbs + "\n");
       text.setEditable(false);
       text.append(sb.toString());
      
       info.setLocation(700,450);       
       x -= 20;
       y += 20;
       info.show(); 
    }

    
    //---------------------------------------------------------------------

    private Location getNextLocation() {

       Location loc = getLocation();

       Location next = loc.getAdjacentLocation(getDirection());

       return next;

    }

    public void BottleNeck()
    {
        ArrayList<Location> loc = getGrid().getOccupiedLocations();
        ArrayList<Organism> orgs = new ArrayList<>();
        int ranSize = (int) (Math.random() *BiologySimulation.orgCount);
        for(int n = 0; n  < loc.size(); n++)
        {
            Object obj = getGrid().get(loc.get(n));
                if (obj instanceof Organism)
                    orgs.add((Organism)obj);
        }
    
        
    }

    private boolean getID(){

       return this.id;

    }

    public ArrayList<Organism> getNeighbourOrganismsFromArrayList(ArrayList<Object> arrList) {

       ArrayList<Organism> orgList = new ArrayList<>();

       for (int n = 0; n < arrList.size(); n++) {

           Object testOrg = arrList.get(n);

           try {

               if (testOrg instanceof Organism) {

                   //System.out.println("Organism at index " + n + "\nNow adding to list");

                   orgList.add((Organism) testOrg);

               } else {

                   //System.out.println("Not an organism at index " + n);

                   continue;

               }

           } catch (Exception E) {

               //System.out.println("Not an organism");

           }

       }

       return orgList;

    }

    public ArrayList<Object> getNeighbours(Location loc) {
       ArrayList<Object> list = new ArrayList<>();
       for (int i = 0; i < this.direction.length; i++) {
           Location adj = loc.getAdjacentLocation(this.direction[i]);
           if (getGrid().isValid(adj) == true) {
               //System.out.println("IsValid");
               list.add(getGrid().get(adj)); //Add the object at the location adj
               //System.out.println("Organism " + this.name + ", direction checked: " + this.direction[i]);
           } else {
               //System.out.println("Location " + this.direction[i] + " is not Valid");
               continue;
           }
       }
       return list;
    }

    public String getGender() {
       return this.gender;
    }

@Override
    public void move() {
       Location next = getNextLocation();
       moveTo(next);
    }

    public void randomTurn() {
       int index = (int) (Math.random() * this.direction.length);
       this.setDirection(direction[index]);
    }

@Override

    public void act() {

       //Checking for adjacent Organisms

       ArrayList<Organism> list = this.getNeighbourOrganismsFromArrayList(getNeighbours(this.getLocation()));

       for (int i = 0; i < list.size(); i++) {

           if (getGender().equalsIgnoreCase(list.get(i).getGender())) {
               //System.out.println(this.name + " has same gender as " + list.get(i).name);
               list.remove(i);
           } else {
               //System.out.println(this.name + " has different gender than " + list.get(i).name);
               continue;
           }
       }

       if (list.size() >= 1) {

           int rndmIndx = (int) (Math.random() * list.size());

           if ((this.generation == (list.get(rndmIndx).generation) && this.oneChild == false && this.age >= 50)) {

              

               if(BiologySimulation.orgCount == 60){

                   GUI.remAppend("Max population reached");

               } else {

                   reproduce(this, list.get(rndmIndx));

                   this.reproducing = true;

                   this.oneChild = true;

                   list.get(rndmIndx).oneChild = true;

                   GUI.remAppend("Number of Organisms in grid: " + BiologySimulation.orgCount + "\n");

               }

           }

       }

       // Random move

       double rndmMove = Math.random();

       if (rndmMove < 0.75 && !reproducing) {

           if (canMove()) {

               move();

               this.steps++;

           } else {

               turn();

           }

       } else {

           randomTurn();

       }

       this.reproducing = false; //Allows organism to reproduce more than once

      

       //Aging - Steps until death

       this.age++;

       if (this.age >= this.maxSteps) {

           Location loc = this.getLocation();

           Grid<Actor> grid = this.getGrid();

           Grave grave = new Grave(this);

           this.removeSelfFromGrid();

           BiologySimulation.orgCount--;

           GUI.remAppend("Number of Organisms in grid: " + BiologySimulation.orgCount + "\n");

           grave.putSelfInGrid(grid, loc);

       }

      

       //Preventing continuous reproduction (takes a break)

       this.lagPeriod--;

       if (this.lagPeriod <= 0){

           this.oneChild = false;

           this.lagPeriod = (int) (this.maxSteps * 0.8);

       }

       this.death--;

    }

}

//does not place flowers

//checks adjacent squares for organism objects

//checks those objects for opposite gender

//if more than 1 adjacent, picks random one

//ReaperBug doesnt die, kills other Organisms to reduce population

//Implement method: "Bottleneck"

//Founder method remove organisms from grid (either killing, or moving to different grid/ActorWorld)

//-Fix crossover method

// 2 int variables - tells program where the alleles are

//first two allele sets are colours dominant (A) = red, recessive (a) = blue

// - scanner feature scans in pairs - new method genotypeScanner

//last two are number of legs - int (even numbers) 6 or 8

//middle number wing type (short/long) string