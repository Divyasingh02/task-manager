import { Component, OnInit } from "@angular/core";

import { Task } from '../model/task';
import { TaskDataService } from '../service/data/task-data.service';
import { Router } from '@angular/router';
import { Pipe, PipeTransform } from '@angular/core';
import { FilterPipe } from 'ngx-filter-pipe';

@Component({
  selector: "app-view-task",
  templateUrl: "./view-task.component.html",
  styleUrls: ["./view-task.component.css"]
})
export class ViewTaskComponent implements OnInit {

  taskList: Task[]

  taskFilterProp: any = { task: '', parentTask: '', startDate: '', endDate: '', priority: '' }

  constructor(private service: TaskDataService, private router: Router, private filterPipe: FilterPipe) { }

  ngOnInit() {
    this.getAllTasks()
  }

  deleteTask(id) {
    console.log(`deleteTask Id ${id}`)
    this.service.deleteTask(id).subscribe(
      response => {
        console.log(`Delete successful for Task Id ${id}`)
        this.getAllTasks()
      }
    )
  }

  finishTask(id) {
    console.log(`finishTask Id ${id}`)
    this.service.finishTask(id).subscribe(
      response => {
        console.log(`Delete successful for Task Id ${id}`)
        this.getAllTasks()
      }
    )
  }

  getAllTasks() {
    this.service.getAllTasks().subscribe(
      response => {
        console.log(response)
        this.taskList = response
      }
    )
  }

  editTask(id) {
    console.log(`Edit task ${id}`)
    this.router.navigate(['edittask', id])
  }

}
