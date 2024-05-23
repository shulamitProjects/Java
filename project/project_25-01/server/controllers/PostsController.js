const Posts=require("../models/Posts")

const createNewPosts=async(req,res)=>{
    const{title,body}=req.body
    if(!title)
    {
        return res.status(400).json({message:"title is require"})
    }
    const posts=await Posts.create({title,body})

    if(posts)
    {
        return res.status(201).json({massage:"new posts created"})
    }
    else{
        return res.status(400).json({message:"invalid posts"})
    }
}
const getAllPosts=async(req,res)=>{
    const posts=await Posts.find().lean()
    res.json(posts)
}


// const getPostsByParams =async(req,res)=>{
//     const {title,body}=req.body
//     const obj=Todos.find({title:title,body:body})
//     res.json(obj)
// }
const getPostsById =async(req,res)=>{
    const {id}=req.params
    if(!id){
        return res.status(400).json({message:"no posts found"})
    }
    const posts=await Posts.findById(id).exec()
    res.json(posts)
}

const updatePosts=async(req,res)=>{
    const{_id,title,body}=req.body
    if(!_id||!title){
        return res.status(400).json({message:"fields required"})
    }
    const posts=await Posts.findById(_id).exec()
    if(!posts){
        return res.status(400).json({message:"posts not found"})
    }
    posts.title=title
    posts.body=body

    const updatedPosts=await posts.save()
    res.json(`${updatedPosts.title} update`)
}

const deletePosts=async(req,res)=>{
    const{id}=req.params
    const posts=await Posts.findById(id).exec()
    if(!posts){
        return res.status(400).json({message:"posts not found"})
    }

    const result=await posts.deleteOne()
    const reply=`posts  ${result.id}  deleted`
    res.json(reply)
}

module.exports={getAllPosts,createNewPosts,getPostsById,updatePosts,deletePosts}

