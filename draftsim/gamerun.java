import java.util.*;
public class gamerun{
    public int wins = 0;
    public int losses = 0;
    public int gold;
    public int gems;
    public int packs;

    public void win(){
        this.wins++;
    }

    public void lose(){
        this.losses++;
    }

    public String toString(){
        return "W: "+this.wins+"; L: "+this.losses;
    }

    public boolean runEnd(){
        return this.wins==7||this.losses==3;
    }

    public int getPacks(){
        double packchance = Math.random();
        if(wins==0){
            if(packchance<=0.20) return 2;
            return 1;
        }
        if(wins==1){
            if(packchance<=0.22) return 2;
            return 1;
        }
        if(wins==2){
            if(packchance<=0.24) return 2;
            return 1;
        }
        if(wins==3){
            if(packchance<=0.26) return 2;
            return 1;
        }
        if(wins==4){
            if(packchance<=0.30) return 2;
            return 1;
        }
        if(wins==5){
            if(packchance<=0.35) return 2;
            return 1;
        }
        if(wins==6){
            if(packchance<=0.40) return 2;
            return 1;
        }
        return 2;

    }

    public int getGems(){
        if(wins==0) return 50;
        if(wins==1) return 100;
        if(wins==2) return 200;
        if(wins==3) return 300;
        if(wins==4) return 450;
        if(wins==5) return 650;
        if(wins==6) return 850;
        return 950;
    }

    public void reward(){
        this.packs=this.getPacks();
        this.gems=this.getGems();
    }

}
