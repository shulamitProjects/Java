import React from "react";
 import {Routes,Route, Link} from 'react-router-dom'
import Todo from "./todo";
import Posts from "./posts";
import User from "./user";
import Photo from "./photo";


const Home=()=>{

    return(
    <>
    <Routes>
        <Route path="/todo" element={<Todo />}/>
        <Route path="/posts" element={<Posts />}/>
        <Route path="/user" element={<User />}/>
        <Route path="/photo" element={<Photo />}/>

    </Routes> 

    </>
    )
}

export default Home