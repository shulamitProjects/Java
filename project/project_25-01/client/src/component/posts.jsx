import * as React from 'react';
import Button from '@mui/material/Button';
import { useState } from 'react';
import useAxios from 'axios-hooks';
import BasicCardPost from './todoPost';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Stack from '@mui/material/Stack';
import { Icon, SpeedDialIcon, SvgIcon } from '@mui/material';
import Axios from "axios"


const Posts=()=>{

  const [title, setTitle] = useState("")
  const [body, setBody] = useState("")

  const [{data, loading, error},  refetch] = useAxios(
    {url: 'http://localhost:1123/posts',
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
    }}
)

  React.useEffect(() => { console.log('data111', data)}, [data])
  React.useEffect(() => { console.log('error', error) }, [error])
  React.useEffect(() => { console.log('loading', loading) }, [loading])

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

    return(
        <>

<Stack direction="row" spacing={4}> 
      <Button onClick={()=>{setOpen(true)}} variant="outlined" startIcon={<SpeedDialIcon/>}> Add</Button>

        <React.Fragment>
          <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Add post</DialogTitle>
        <DialogContent>
          <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="title"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setTitle(e.target.value)}
          />

          <DialogContentText>
          </DialogContentText>
          <TextField
            autoFocus
            margin="dense"
            id="name"
            label="body"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setBody(e.target.value)}
          />

        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={async()=>{
              const res=await Axios.post(`http://localhost:1123/posts`,
                        {
                          "title":title,
                          "body":body
                        })
                        refetch();
                        handleClose()
                        
          }}>Add</Button>
        </DialogActions>
      </Dialog>


        </React.Fragment>


          {}
      {data &&data.map((post,index)=>{return <BasicCardPost key = {index} refetch = {refetch} id= {post._id} title = {post.title} body = {post.body}></BasicCardPost>})}


    </Stack >



        </>
    )
}

export default Posts