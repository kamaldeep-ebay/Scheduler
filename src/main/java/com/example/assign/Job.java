package com.example.assign;

// POJO

public class Job {

	String id;
	String command;
	String parent;
	
	public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }	
	    public String getCommand() {
	        return command;
	    }
	    public void setName(String command) {
	        this.command = command;
	    }
	    public String getParent() {
	        return parent;
	    }
	    public void setParent(String parent) {
	        this.parent = parent;
	    }
	
	@Override
	public String toString() {
		return "ID:" +id+"\nCommand:"+command+"\nParent:"+parent;
	}
	
	// fix hashCode() later
	
	/*@Override
	public boolean equals(Object o){
	    if(o == null)                return false;
	  //  if(!(o instanceof) Job) return false;

	    Job other = (Job) o;
	    
	    if(this.getId().equals(other.getId())) return true;
	    

	    return false;
	  }
	
	@Override
	 public int hashCode(){
	    return (int) Integer.valueOf(this.getId());
	  }*/
}

