const Photos=require("../models/Photos")

const createNewPhotos=async(req,res)=>{
    const{title,imgUrl}=req.body
    if(!title)
    {
        return res.status(400).json({message:"title is require"})
    }
    const photos=await Photos.create({title,imgUrl})

    if(photos)
    {
        return res.status(201).json({massage:"new photos created"})
    }
    else{
        return res.status(400).json({message:"invalid photos"})
    }
}
const getAllPhotos=async(req,res)=>{
    const photos=await Photos.find().lean()
    res.json(photos)
 }
// const getPhotosById =async(req,res)=>{
//     const {id}=req.params
//     if(!id){
//         return res.status(400).json({message:"no photos found"})
//     }
//     const photos=await Photos.findById(id).exec()
//     res.json(photos)
// }

const updatePhotos=async(req,res)=>{
    const{_id,title,imgUrl}=req.body
    if(!_id||!title){
        return res.status(400).json({message:"field required"})
    }
    const photos=await Photos.findById(_id).exec()
    if(!photos){
        return res.status(400).json({message:"photos not found"})
    }
    photos.title=title
    photos.imgUrl=imgUrl


    const updatedPhotos=await photos.save()
    res.json(`${updatedPhotos.title} update`)
}

const deletePhotos=async(req,res)=>{
    const{id}=req.body
    const photos=await Photos.findById(id).exec()
    if(!photos){
        return res.status(400).json({message:"photos not found"})
    }

    const result=await Photos.deleteOne()

    const reply=`photos  ${result.id}  deleted`
    res.json(reply)
}

module.exports={getAllPhotos,createNewPhotos,updatePhotos,deletePhotos}

