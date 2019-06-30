package org.divyasingh.fse.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parenttask")
public class ParentTask {
	
	@Id
	@Column(name="parent_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentId;
	
	@Column(name="parent_task")
	private String parentTask;
	
	public ParentTask(){
	}

	public ParentTask(int parentId, String parentTask) {
		super();
		this.parentId = parentId;
		this.parentTask = parentTask;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
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
		return "ParentTask [parentId=" + parentId + ", parentTask=" + parentTask +  "]";
	}
	
}
