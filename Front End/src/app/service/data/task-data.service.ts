import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HelloBean } from 'src/app/model/helloBean';
import { Task } from '../../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {

  constructor(private http: HttpClient) { }


  getAllTasks() {
    return this.http.get<Task[]>(`http://localhost:8080/getAllTasks`)
  }

  deleteTask(id) {
    return this.http.delete(`http://localhost:8080/deleteTask/${id}`)
  }

  getTask(id) {
    return this.http.get<Task>(`http://localhost:8080/getTaskById/${id}`)
  }

  editTask(id, task) {
    return this.http.put(`http://localhost:8080/editTask/${id}`, task)
  }

  saveTask(task: Task) {
    return this.http.post(`http://localhost:8080/saveTask/`, task)
  }

  finishTask(id) {
    return this.http.delete(`http://localhost:8080/finishTask/${id}`)
  }
}
