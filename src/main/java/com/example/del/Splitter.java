package com.example.del;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
    
    
public class Splitter extends RecursiveTask<Long> {

	private long workLoad = 0;

    public Splitter(long workLoad) {
        this.workLoad = workLoad;
    }

	
    protected Long compute() {

        // split if num process > 4
        if(this.workLoad > 1) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<Splitter> subtasks =
                new ArrayList<Splitter>();
            subtasks.addAll(createSubtasks());

            for(Splitter subtask : subtasks){
                subtask.fork();
            }

            long result = 0;
            for(Splitter subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<Splitter> createSubtasks() {
        List<Splitter> subtasks =
        new ArrayList<Splitter>();

        // read json here and have each one as subtask
        Splitter subtask1 = new Splitter(this.workLoad / 2);
        Splitter subtask2 = new Splitter(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
    
    public static void main(String[] args){
    	
    	Splitter myRecursiveTask = new Splitter(4);
    	// current system 4 cpu core 
    	ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    	long mergedResult = forkJoinPool.invoke(myRecursiveTask);

    	System.out.println("mergedResult = " + mergedResult);
    }
}