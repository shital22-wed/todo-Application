package com.task;

public class Task {
	public int taskid;
	public String taskname;
	public String description;
	public String status;
	public Task(int taskid,String taskname, String description, String status) {
		
		this.taskid=taskid;
		this.taskname = taskname;
		this.description = description;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [taskname=" + taskname + ", description=" + description + ", status=" + status + "]";
	}
	
	
	
	
	
	

}
