import * as React from 'react';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Stack from '@mui/material/Stack';
import { Icon, SpeedDialIcon, SvgIcon } from '@mui/material';
import { useState, useEffect } from 'react';
import Checkbox from '@mui/material/Checkbox';
import Axios from "axios"
import useAxios from 'axios-hooks'
import BasicCard from './todoElem';
import BasicCardUser from './todoUser';

// {title,tags,completed}name,userName,email,address,phone
const User = () => {
  const [name, setName] = useState("")
  const [userName, setUserName] = useState("")
  const [email, setEmail] = useState("")
  const [address, setAddress] = useState("")
  const [phone, setPhone] = useState(0)


const [{data, loading, error},  refetch] = useAxios(
    {url: 'http://localhost:1123/users',
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
    }}
)

  useEffect(() => { console.log('data12345', data)}, [data])
  useEffect(() => { console.log('error', error) }, [error])
  useEffect(() => { console.log('loading', loading) }, [loading])



  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const [checked, setChecked] = React.useState(true);
  const handleChange = (event) => {
    setChecked(event.target.checked);
  };
  return <>

    <Stack direction="row" spacing={4}> 
      <Button onClick={()=>{setOpen(true)}} variant="outlined" startIcon={<SpeedDialIcon/>}> Add</Button>

        <React.Fragment>
          <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Add user</DialogTitle>
        <DialogContent>
          <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="enter name"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setName(e.target.value)}
          />

          <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="enter userName"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setUserName(e.target.value)}
          />
          <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="enter email"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setEmail(e.target.value)}
          />
                    <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="enter address"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setAddress(e.target.value)}
          />
                    <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="enter phone"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setPhone(e.target.value)}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={async()=>{
              const res=await Axios.post(`http://localhost:1123/users`,
                        {
                          "name":name,
                          "userName":userName,
                          "email":email,
                          "address":address,
                          "phone":phone

                        })
                        refetch();
                        handleClose()
                        
          }}>Add</Button>
        </DialogActions>
      </Dialog>


        </React.Fragment>


          {}
      {data &&data.map((user,index)=>{return <BasicCardUser key = {index} refetch = {refetch} id= {user._id} name = {user.name} userName = {user.userName} email = {user.email} address={user.address} phone={user.phone}></BasicCardUser>})}


    </Stack >

  </>
}

export default User;