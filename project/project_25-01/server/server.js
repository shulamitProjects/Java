require("dotenv").config()
const express=require("express")
const cors=require("cors")
const corsOptions=require("./config/corsOptions")
const connectDB=require("./config/dbConn")
const { log } = require("console")
const { default: mongoose } = require("mongoose")
const PORT=process.env.PORT||1122
const app=express()
connectDB()

app.use(cors(corsOptions))

app.use(express.json())

app.use("/users",require("./route/users"))
app.use("/todos",require("./route/todos"))
app.use("/posts",require("./route/posts"))
app.use("/photos",require("./route/photos"))
// const cors = require('cors');

app.use(express.static("public"))

console.log(corsOptions.origin);

app.get("/",(req,res)=>{
    res.send("This is the home page,OK?")
})
console.log(process.env.NODE_ENV);

mongoose.connection.once('open',()=>{
    console.log("Connected to DB")
app.listen(PORT,()=>{
    console.log(`Server running on port ${PORT}`)})
})

mongoose.connection.on('error',err=>{
    console.log(err);
})

