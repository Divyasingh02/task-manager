# task-manager
This project is for case study to complete FSE

Project Submission Details:
1. Front End code zipped file.
   For Front End I have used Angular 2 and bootstrap libraries.
2. Middleware Server Side.
   For backend code I have used Sprint Boot 2.1.6.
3. Databse Table and Testing screenshots.
    I have provided the basic table structure I used in this project.
    Databse used in=s MySql.
    To retrieve data from database from Service layer, I have used JpaRepository.
4. Deployment.
    I have provided the war file for task-manager project.
5. Final Submission.
    Link to the git repository and steps to run application.
    
Steps to run:

1. Need to run the executable war I have provided with the below command:
    java -jar task-manager-0.0.1-SNAPSHOT.war
    This will make the service up and available to use from the Front end
2. Need to go to root folder of UI code where package.json is available and run below command:
      npm install
    This will install all the dependency required. Once completed, run below command to start UI application:
      ng serve
    Once the console shows "Compiled Successfully" go to the browser and type below url to see the UI:
      http://localhost:4200/
    We should see the home page with two tabs "Add Task" and "View Task".
    Our Home page is the "Add Task" page.
    
Now the application is running and we can perform ant Operation we want from task-manager.
