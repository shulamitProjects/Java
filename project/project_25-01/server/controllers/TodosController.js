const Todos=require("../models/Todos")

const createNewTodo=async(req,res)=>{
    const{title,tags,completed}=req.body
    if(!title)
    {
        return res.status(400).json({message:"title is require"})
    }
    const todo=await Todos.create({title,tags,completed})

    if(todo)
    {
        return res.status(201).json({massage:"new to do created"})
    }
    else{
        return res.status(400).json({message:"invalid todo"})
    }
}
const getAllTodos=async(req,res)=>{
    const todos=await Todos.find().lean()
    res.json(todos)
}
const getTodoById =async(req,res)=>{
    const {id}=req.params
    if(!id){
        return res.status(400).json({message:"no todos found"})
    }
    const todos=await Todos.findById(id).exec()
    res.json(todos)
}
// const getTodoByParams =async(req,res)=>{
//     const {title, tags, completed}=req.body
//     const obj=Todos.find({title:title,tags:tags,completed:completed})
//     res.json(obj)
// }
const updateTodos=async(req,res)=>{
    const{_id,title,tags,completed}=req.body
    if(!_id||!title){
        return res.status(400).json({message:"field required"})
    }
    const todo=await Todos.findById(_id).exec()
    if(!todo){
        return res.status(400).json({message:"todo not found"})
    }
    todo.title=title
    todo.tags=tags
    todo.completed=completed

    const updatedTodo=await todo.save()
    res.json(`${updatedTodo.title} update`)
}

const deleteTodos=async(req,res)=>{
    const{id}=req.body
    const todo=await Todos.findById(id).exec()
    if(!todo){
        return res.status(400).json({message:"todo not found"})
    }

    const result=await todo.deleteOne()

    const reply=`todo  ${result.id}  deleted`
    res.json(reply)
}

const deleteTodosById=async(req,res)=>{
    const{id}=req.params
    const todo=await Todos.findById(id).exec()
    if(!todo){
        return res.status(400).json({message:"todo not found"})
    }

    const result=await todo.deleteOne()

    const reply=`todo  ${result.id}  deleted`
    res.json(reply)
}

const updateTodosCompleted = async (req, res) => {
    const { id } = req.params 
    const todo=await Todos.findById(id).exec()

    if(!todo){
        return res.status(400).json({message:"task not found"})
    }
    todo.compelte=!todo.compelte
    const updatedTodos=await todo.save()

    res.json(`${updatedTodos.title} update`)
}

module.exports={getAllTodos,createNewTodo,updateTodos,deleteTodos,getTodoById,updateTodosCompleted,deleteTodosById}

