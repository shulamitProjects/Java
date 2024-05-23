import * as React from 'react';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Axios from "axios"
import { useState } from 'react';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import FavoriteBorder from '@mui/icons-material/FavoriteBorder';
import Favorite from '@mui/icons-material/Favorite';
import BookmarkBorderIcon from '@mui/icons-material/BookmarkBorder';
import BookmarkIcon from '@mui/icons-material/Bookmark';
import Heart from "react-animated-heart";

const label = { inputProps: { 'aria-label': 'Checkbox demo' } };

export default function BasicCardPost(props) {

    const [isClick, setClick] = useState(false);
    const [count, setCount] = useState(0);

  const[title,setTitle]=useState("")
  const[body,setBody]=useState("")

  const [open, setOpen] = React.useState(false);

  const handleClose = () => {
    setOpen(false);
  };



  return (
    <>
  
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
      
      <Typography variant="h5" component="div">
      {props.title}
        </Typography>
        <Typography variant="h8" component="div">
        {props.body}
        </Typography>

        {/* <div>
      {/* <Checkbox icon={<FavoriteBorder />} /> */}
      {/* <Checkbox
         icon={<FavoriteBorder />}
        
      />
    </div> */} 


      <Heart isClick={isClick} onClick={() => {setClick(!isClick);setCount(count+1)}} />
      <Typography variant="h8" component="div">
        </Typography>
    


        <Typography variant="body2">       
          <br />
        </Typography>
      </CardContent>
      <CardActions>

        <Button size="small" onClick = {async()=>{
          console.log(props.id);
            const res=await Axios.delete(`http://localhost:1123/posts/del/${props.id}`)
            
            props.refetch();
        }}>delete</Button>

<Button size="small" onClick = {()=>{ setOpen(true) }}>update</Button>
  <React.Fragment>
     <Dialog open={open} onClose={handleClose}>
            <DialogTitle>update</DialogTitle>
            <DialogContent>
              <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter title"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setTitle(e.target.value)}
              />
              <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter body"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setBody(e.target.value)}
              />
            </DialogContent>
            <DialogActions>
              <Button onClick={handleClose}>Cancel</Button>
            <Button onClick={async()=>{
              console.log(title,body, props.id)
        const res=await Axios.put(`http://localhost:1123/posts`,
                            {
                              "_id": props.id,
                              "title":title,
                              "body":body
                            })
                            props.refetch();
                            handleClose()
                      }
                      }>update</Button>
              

            </DialogActions>
          </Dialog>
  </React.Fragment>

</CardActions>

    </Card>
 </> )
}