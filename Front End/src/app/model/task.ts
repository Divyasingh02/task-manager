export class Task {
  // constructor(){}

  constructor(
    public taskId: number,
    public parentId: number,
    public task: string,
    public parentTask: string,
    public priority: number,
    public startDate: Date,
    public endDate: Date,
    public finished: string
  ) { }
}
