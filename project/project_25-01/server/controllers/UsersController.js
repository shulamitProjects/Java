const Users=require("../models/Users")

const createNewUsers=async(req,res)=>{
    const{name,userName,email,address,phone}=req.body
    if(!name)
    {
        return res.status(400).json({message:"name is require"})
    }
    const users=await Users.create({name,userName,email,address,phone})

    if(users)
    {
        return res.status(201).json({massage:"new users created"})
    }
    else{
        return res.status(400).json({message:"invalid users"})
    }
}
const getAllUsers=async(req,res)=>{
    const users=await Users.find().lean()
    res.json(users)
}

// const getUserByParams =async(req,res)=>{
//     const {name,userName,email,address,phone}=req.body
//     const obj=Todos.find({name:name,userName:userName,email:email,address:address,phone:phone})
//     res.json(obj)
// }
const getUsersById =async(req,res)=>{
    const {id}=req.params
    if(!id){
        return res.status(400).json({message:"no users found"})
    }
    const users=await Users.findById(id).exec()
    res.json(users)
}





const updateUsers=async(req,res)=>{
    const{_id,name,userName,email,address,phone}=req.body
    if(!_id||!name){
        return res.status(400).json({message:"fields required"})
    }
    const users=await Users.findById(_id).exec()
    if(!users){
        return res.status(400).json({message:"users not found"})
    }
    users.name=name
    users.userName=userName
    users.email=email
    users.address=address
    users.phone=phone

    const updatedUsers=await users.save()
    res.json(`${updatedUsers.name} update`)
}

const deleteUsers=async(req,res)=>{
    const{id}=req.params
    const users=await Users.findById(id).exec()
    if(!users){
        return res.status(400).json({message:"users not found"})
    }

    const result=await users.deleteOne()
    const reply=`users  ${result.id}  deleted`
    res.json(reply)
}

module.exports={getAllUsers,createNewUsers,getUsersById,updateUsers,deleteUsers}

