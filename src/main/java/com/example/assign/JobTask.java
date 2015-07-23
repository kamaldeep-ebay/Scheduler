package com.example.assign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
    
    
public class JobTask extends RecursiveTask<String> {

/*	private long workLoad = 0;

    public Scheduler(long workLoad) {
        this.workLoad = workLoad;
    }
*/
	ArrayList<Integer> ids;
	
	public JobTask(ArrayList<Integer> ids){
		this.ids=ids;
	}

	protected String compute() {

    		if(ids.size()>2){
    			
                System.out.println("Splitting commands : " );

                List<JobTask> subtasks = new ArrayList<JobTask>();
                for(Integer id:ids){
                	ArrayList<Integer> singletask = new ArrayList<Integer>();
                	singletask.add(id);
                	JobTask task = new JobTask(singletask);
                	subtasks.add(task);
                }
                 
                for(JobTask subtask : subtasks){
                    subtask.fork();
                }

                String result = "";
                for(JobTask subtask : subtasks) {
                    result.concat(subtask.join());
                }
    	    	return result;
    	    	
    		}else{
    			String command_out = "";
    			System.out.println("running single process");
    			try {
					command_out = ProcessRunner.runCommand(ParseJSON.map.get(String.valueOf(ids.get(0))));
					
					//if(ids.get(0)==3)
						//throw new InterruptedException("test excep from Job ID" + ids.get(0));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}
    			return command_out;
    		}
    		
    	
	}
    	
}