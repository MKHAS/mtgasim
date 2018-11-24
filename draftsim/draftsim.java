import java.util.*;
public class draftsim{
    public static void main(String[] args){
        double winrate = 0.50;
        while(winrate<=0.75){
            simulateRuns(winrate);
            System.out.println();
            winrate+=0.02;
        }
    }
    public static void simulateRuns(Double winrate){
        int samplesize = 10000;
        double avgpacks = 0;
        double avggems = 0;
        double avgwins = 0;
        gamerun[] totalruns = new gamerun[samplesize];

        for(int i=0;i<samplesize;i++){
            gamerun currentrun = new gamerun();
            //playing the run
            while(!currentrun.runEnd()){
                double matchresult = Math.random();
                if(matchresult<=winrate) currentrun.win();
                else currentrun.lose();
            }
            currentrun.reward();
            totalruns[i] = currentrun;
        }

        for(int i=0;i<samplesize;i++){
            avgpacks += totalruns[i].packs;
            avggems += totalruns[i].gems;
            avgwins += totalruns[i].wins;
        }
        avgpacks = avgpacks/samplesize;
        avggems = avggems/samplesize;
        avgwins = avgwins/samplesize;
        double totalreturns = avggems+avgpacks*200;
        
        String output = "Winrate: "+winrate+"\nWins: "+avgwins+"\nGems: "+avggems+"\nPacks: "+avgpacks+"\nTotal Returns: "+totalreturns;
        System.out.println(output);
    }
}
