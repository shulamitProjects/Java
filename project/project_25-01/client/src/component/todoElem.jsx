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
export default function BasicCard(props) {


  const[title,setTitle]=useState("")
  const[tags,setTags]=useState("")
  const[complete,setComplete]=useState("")
  const [checked, setChecked] = React.useState(true);
  const [open, setOpen] = React.useState(false);
  let f=false;
  //  const [checked, setChecked] = React.useState(true);
   let checked1=true;
   const [checked2, setChecked2] = React.useState(true);

   const handleChange1 = (event) => {
     setChecked2(event.target.checked);
   };
// React.useEffect(()=>{

// },[checked])



  const handleClose = () => {
    setOpen(false);
  };
  const handleChange = (event) => {
    setChecked(event.target.checked);
  };


  const check= () => {
    
      if(props.complete=="false") {
        checked1=false;
      }
      else{
        checked1=true;
      }
    
  }


  return (
    <>
    <br></br><br></br><br></br>
    
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
      
      <Typography variant="h5" component="div">
      {props.title}
        </Typography>
        {/* <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
          {props.title}
        </Typography> */}
        <Typography variant="h5" component="div">
        {props.tags}
        </Typography>

        <Typography variant="h6" component="div">
        {props.create}
        </Typography>

        <Typography variant="h5" component="div">

      {check()}
      <Checkbox
      checked={checked1}
      // onChange={handleChange}
      // onChange={async()=>{
      //   await Axios.put(`http://localhost:1123/todos/${props.id}`)
      // }}
       inputProps={{ 'aria-label': 'controlled' }}
    />

        </Typography>

        <Typography sx={{ mb: 1.5 }} color="text.secondary">
        {props.createdAt}
          {/* <h3>crate at: </h3> */}
        </Typography>
        <Typography variant="body2">       
          <br />
        </Typography>
      </CardContent>
      <CardActions>

        <Button size="small" onClick = {async()=>{
          console.log(props.id);
            const res=await Axios.delete(`http://localhost:1123/todos/del/${props.id}`)
            
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
                label="enter tags"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setTags(e.target.value)}
              />

              {/* <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter complete"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setComplete(e.target.value)}
              /> */}
    <Checkbox
      checked={checked}
      onChange={handleChange}
      inputProps={{ 'aria-label': 'controlled' }}
    />
            
            </DialogContent>
            <DialogActions>
              <Button onClick={handleClose}>Cancel</Button>
            <Button onClick={async()=>{
              console.log(title,tags,complete, props.id)
        const res=await Axios.put(`http://localhost:1123/todos`,
                            {
                              "_id": props.id,
                              "title":title,
                              "tags":tags,
                              "completed":checked
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