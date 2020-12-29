package coding.challenge;

import coding.challenge.run.IterativeRun;


public class Main {

    public static void main(String[] args) {
        //new iterativeRun("file:data/trucks.json", "file:data/items.json", "resultIterative.json", ".", 1).run();
        new IterativeRun("file:data/trucks.json", "file:data/items.json", "resultIterative10.json", ".", 10).run();
        new IterativeRun("file:data/trucks.json", "file:data/items.json", "resultIterative100.json", ".", 100).run();
    }
}
