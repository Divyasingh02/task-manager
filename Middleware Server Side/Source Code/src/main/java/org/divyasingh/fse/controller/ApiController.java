package org.divyasingh.fse.controller;

import java.util.List;

import org.divyasingh.fse.model.HelloBean;
import org.divyasingh.fse.model.Task;
import org.divyasingh.fse.service.TaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ApiController {
	
	@Autowired
	TaskManagerService taskManagerService;

	@GetMapping(path="/hello")
	public String hello(){
		throw new RuntimeException("Some error occurred. Please contact support");
		//return "Hello World";
	}
	
	@GetMapping(path="/hello-bean")
	public HelloBean helloBean(){
		return new HelloBean("Hello Bean");
	}
	
	@GetMapping(path="/hello-bean/pathvariable/{name}")
	public HelloBean helloBeanPathvariable(@PathVariable String name){
		return new HelloBean(String.format("Hello %s", name));
	}
	
	@GetMapping(path="/getAllTasks")
	public List<Task> getAllTasks(){
		return taskManagerService.getAllTasks();
	}
	
	@GetMapping(path="/getTaskById/{taskId}")
	public Task getTaskById(@PathVariable Integer taskId){
		return taskManagerService.getTaskById(taskId);
	}
	
	@PutMapping(path="/editTask/{taskId}")
	public ResponseEntity<Task> editTask(@PathVariable Integer taskId, @RequestBody Task task) {
		Task updatedTask = taskManagerService.updateTask(taskId, task);
		return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/finishTask/{taskId}")
	public ResponseEntity<Task> finishTask(@PathVariable Integer taskId) {
		Task updatedTask = taskManagerService.finishTask(taskId);
		return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
	}
	
	@PostMapping(path="/saveTask")
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task updatedTask = taskManagerService.saveTask(task);
		return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteTask/{taskId}")
	public ResponseEntity<Void> deleteTask(@PathVariable Integer taskId){
		System.out.println("Task Id in delete Task: " + taskId);
		Task task = taskManagerService.deleteTask(taskId);
		if(task != null)
			return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
}
