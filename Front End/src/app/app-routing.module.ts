import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AddTaskComponent } from "./add-task/add-task.component";
import { ViewTaskComponent } from "./view-task/view-task.component";
import { ErrorComponent } from './error/error.component';
import { UpdateTaskComponent } from './update-task/update-task.component';

const routes: Routes = [
  { path: "addtask", component: AddTaskComponent },
  { path: "viewtask", component: ViewTaskComponent },
  { path: "edittask/:id", component: UpdateTaskComponent },
  { path: "", component: AddTaskComponent },
  { path: "**", component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
