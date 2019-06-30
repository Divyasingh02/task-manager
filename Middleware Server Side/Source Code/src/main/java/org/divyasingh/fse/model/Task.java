package org.divyasingh.fse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class Task {

	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	
	@Column(name="task")
	private String task;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="finished")
	private String finished = "N";
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name="parent_task")
	private String parentTask;
	
	
	public Task(){
	}
	
	public Task(String task, Date startDate, Date endDate, int priority) {
		super();
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
	}


	public Task(String task, Date startDate, Date endDate, int priority, String parentTask) {
		super();
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.parentTask = parentTask;
	}
	
	public Task(String task, Date startDate, Date endDate, int priority, String parentTask, String finished) {
		super();
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.parentTask = parentTask;
		this.finished = finished;
	}

	public Task(Integer taskId, String task, Date startDate, Date endDate, int priority, String finished,
			String parentTask) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.finished = finished;
		this.parentTask = parentTask;
	}



	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", task=" + task + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priority=" + priority + ", finished=" + finished + ", parentId=" + parentId + ", parentTask="
				+ parentTask + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}
	
	
}
