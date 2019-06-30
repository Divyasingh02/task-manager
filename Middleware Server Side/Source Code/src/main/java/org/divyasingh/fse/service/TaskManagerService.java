package org.divyasingh.fse.service;

import java.util.List;

import org.divyasingh.fse.model.Task;

public interface TaskManagerService {
	
	List<Task> getAllTasks();
	
	Task finishTask(Integer taskId);
	
	Task deleteTask(Integer taskId);
	
	Task getTaskById(Integer taskId);
	
	Task saveTask(Task task);
	
	String findFinished(Integer taskId);
	
	Task updateTask(Integer taskId, Task task);

}
