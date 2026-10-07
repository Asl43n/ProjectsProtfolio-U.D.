/**
 * Coding Project ausgeführt durch die Lernplattform Coddy
 *
 */

// Create the Task interface
interface Task {
    id: number, 
    title: string,
    status: "todo" | "in-progress" | "done",
}

// Create the task variables
let firstTask: Task = {
    id: 1,
    title: "Learn TypeScript interfaces",
    status: "todo"
}
let secondTask: Task={
    id:2,
    title: "Build task management app",
    status: "in-progress",
}
let thirdTask: Task ={
    id: 3,
    title: "Write unit tests",
    status: "done",
}

// Create the getTaskInfo function
function getTaskInfo(task: Task): string{
    return `Task ${task.id}: ${task.title} - ${task.status}`
}
//Createing function addTask()
function addTask(taskList: Task[], title: string): Task[]{
    let newTask: Task = {
        id: taskList.length+1,
        title: title,
        status: "todo",
    }
    let newList = [...taskList]
    newList.push(newTask)
    return newList
}

let initialTasks: Task[] = [firstTask, secondTask]
let updateTasks = addTask(initialTasks, "Review code changes")

//creating function to change task status
function changeTaskStatus(taskList: Task[], taskId: number, newStatus: "todo" | "in-progress" | "done"): Task[]{
    let newList: Task[] = taskList.map(task => ({...task}))

    for(let i = 0; i < newList.length; i++){

        if(newList[i].id === taskId){
            newList[i].status = newStatus
            return newList
        }
            
    }
    return taskList
}

let testTask: Task[] = [firstTask, secondTask, thirdTask]
let progresssTasks = changeTaskStatus(testTask, 1, "in-progress")
let completedTask = changeTaskStatus(testTask, 2, "done")


// list TaskByState func.
function listTasksByStatus(taskList: Task[], status: "todo"|"in-progress"|"done"): Task[]{
    let filterArr = taskList.filter(task => task.status === status)

    return filterArr
}

let mixedTasks: Task[]= [firstTask, secondTask, thirdTask]
let todoTasks = listTasksByStatus(mixedTasks, "todo")
let inProgressTasks = listTasksByStatus(mixedTasks, "in-progress")
let doneTasks = listTasksByStatus(mixedTasks, "done")


//PrintFunction
function printTaskSummary(task: Task): void{
    console.log(`ID: ${task.id}, Title: ${task.title}, Status: ${task.status}`)
}

function printAllTaskSummaries(taskList: Task[]): void{
    for(let i = 0; i < taskList.length ; i++){
        printTaskSummary(taskList[i])
    }
}

let sampleTasks: Task[] = [
        {id: 101, title: "Design user interface", status: "todo"},
        {id: 102, title: "Implement authentication", status: "in-progress"},
        {id: 103, title: "Deploy to production", status: "done"},
    ]


//comprehensive task managment workflow

let projectTasks: Task[] = [
    {id: 201, title: "Setup development environment", status: "done"},
    {id:202, title: "Create project structure", status: "todo"}
]

let expandendTasks = addTask(projectTasks, "Write documentation")
let updatedProjectTasks = changeTaskStatus(expandendTasks, 202, "in-progress")
let finalTasks = changeTaskStatus(updatedProjectTasks, 3, "done")
let completedProkejctTasks = listTasksByStatus(finalTasks, "done")



// Print the required outputs
// console.log(getTaskInfo(firstTask))
// console.log(getTaskInfo(secondTask))
// console.log(getTaskInfo(thirdTask))
// console.log(firstTask.status)
// console.log(secondTask.title)

// console.log(initialTasks.length)
// console.log(updateTasks.length)
// console.log(getTaskInfo(updateTasks[updateTasks.length - 1]))
// console.log(updateTasks[updateTasks.length - 1].title)
// console.log(updateTasks[updateTasks.length - 1].status)

// console.log(getTaskInfo(testTask[0]))
// console.log(getTaskInfo(progresssTasks[0]))
// console.log(getTaskInfo(completedTask[1]))
// console.log(testTask[0].status)
// console.log(completedTask[1].status)

// console.log(mixedTasks.length)
// console.log(todoTasks.length)
// console.log(inProgressTasks.length)
// console.log(doneTasks.length)
// console.log(getTaskInfo(todoTasks[0]))
// console.log(getTaskInfo(inProgressTasks[0]))
// console.log(getTaskInfo(doneTasks[0]))

// printTaskSummary(firstTask)
// printTaskSummary(sampleTasks[1])
// printAllTaskSummaries(sampleTasks)
// printTaskSummary(doneTasks[doneTasks.length - 1])


console.log(projectTasks.length)
console.log(finalTasks.length)
console.log(completedProkejctTasks.length)
printTaskSummary(completedProkejctTasks[0])
printTaskSummary(completedProkejctTasks[completedProkejctTasks.length - 1])
printAllTaskSummaries(finalTasks)
