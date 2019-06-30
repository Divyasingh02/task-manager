package org.divyasingh.fse.service;

import java.util.List;
import java.util.Optional;

import org.divyasingh.fse.model.Task;
import org.divyasingh.fse.repository.TaskManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {
	
	@Autowired
	TaskManagerRepository taskManagerRepository;

	@Override
	public List<Task> getAllTasks() {
		List<Task> taskList = taskManagerRepository.findAll();
		return taskList;
	}

	@Override
	public Task deleteTask(Integer taskId) {
		Optional<Task> optionalTask = taskManagerRepository.findById(taskId);
		Task task = optionalTask.get();
		if(task ==null)
			return null;
		taskManagerRepository.delete(task);
		return task;
	}

	@Override
	public Task getTaskById(Integer taskId) {
		Optional<Task> optionalTask = taskManagerRepository.findById(taskId);
		Task task = optionalTask.get();
		if(task ==null)
			return null;
		return task;
	}

	@Override
	public Task saveTask(Task task) {
		taskManagerRepository.save(task);
		return task;
		
		/*if(task.getTaskId() == -1){
			task.setTaskId(1);
			taskManagerRepository.save(task);
		} else {
			taskManagerRepository.deleteById(task.getTaskId());
			taskManagerRepository.save(task);
		}*/
		 
	}

	@Override
	public String findFinished(Integer taskId) {
		Optional<Task> task = taskManagerRepository.findById(taskId);
		String retVal="";
		if(task != null){
			retVal = task.get().getFinished();
			return retVal;
		}
		return "N";
	}

	@Override
	public Task updateTask(Integer taskId, Task task) {
		Optional<Task> opTask = taskManagerRepository.findById(taskId);
		Task currentTask = new Task();
		if(opTask != null) {
			currentTask = opTask.get();
			currentTask.setTask(task.getTask());
			currentTask.setParentTask(task.getParentTask());
			currentTask.setPriority(task.getPriority());
			currentTask.setStartDate(task.getStartDate());
			currentTask.setEndDate(task.getEndDate());
			return taskManagerRepository.save(currentTask);
		}
		return null;
	}
	

	@Override
	public Task finishTask(Integer taskId) {
		Optional<Task> opTask = taskManagerRepository.findById(taskId);
		Task currentTask = new Task();
		if(opTask != null) {
			currentTask = opTask.get();
			currentTask.setFinished("Y");
			return taskManagerRepository.save(currentTask);
		}
		return null;
	}

}
