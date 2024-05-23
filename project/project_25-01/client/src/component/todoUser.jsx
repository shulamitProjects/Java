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

export default function BasicCardUser(props) {

    const [name, setName] = useState("")
    const [userName, setUserName] = useState("")
    const [email, setEmail] = useState("")
    const [address, setAddress] = useState("")
    const [phone, setPhone] = useState(0)


  const [open, setOpen] = React.useState(false);

  const handleClose = () => {
    setOpen(false);
  };


  return (
    <>
    
    <Card sx={{ minWidth: 275 }}>
      <CardContent>
      
      <Typography variant="h5" component="div">
      {props.name}
        </Typography>

        <Typography variant="h5" component="div">
        {props.userName}
        </Typography>

        <Typography variant="h7" component="div">
        {props.email}
        </Typography>

        <Typography variant="h7" component="div">
        {props.address}
        </Typography>

        <Typography variant="h7" component="div">
        {props.phone}
        </Typography>

        <Typography variant="h5" component="div">


        </Typography>

        <Typography variant="body2">       
          <br />
        </Typography>
      </CardContent>
      <CardActions>

        <Button size="small" onClick = {async()=>{
          console.log(props.id);
            const res=await Axios.delete(`http://localhost:1123/users/del/${props.id}`)
            
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
                label="enter name"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setName(e.target.value)}
              />
              <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter userName"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setUserName(e.target.value)}
              />

              <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter email"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setEmail(e.target.value)}
              />
            <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter adrress"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setAddress(e.target.value)}
              />
             <TextField
                autoFocus
                margin="dense"
                id="name"
                label="enter phone"
                type="string"
                fullWidth
                variant="standard"
                onChange={(e)=>setPhone(e.target.value)}
              />
            </DialogContent>
            <DialogActions>
              <Button onClick={handleClose}>Cancel</Button>
            <Button onClick={async()=>{
        const res=await Axios.put(`http://localhost:1123/users`,
                            {
                              "_id": props.id,
                              "name":name,
                              "userName":userName,
                              "email":email,
                              "address":address,
                              "phone":phone
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