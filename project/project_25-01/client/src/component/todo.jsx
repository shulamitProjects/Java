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

// {title,tags,completed}
const Todo = () => {
  const [title, setTitle] = useState("")
  const [tags, setTags] = useState("")
  const [completed, setCompleted] = useState(false)
  const [len, setLen] = useState(0)



const [{data, loading, error},  refetch] = useAxios(
    {url: 'http://localhost:1123/todos',
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
    }}
)

  useEffect(() => { console.log('data123', data)}, [data])
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
        <DialogTitle>Add task</DialogTitle>
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
            label="tags"
            type="string"
            fullWidth
            variant="standard"
            onChange={(e) => setTags(e.target.value)}
          />
          <DialogContentText>
          </DialogContentText>
          <Checkbox
      checked={checked}
      onChange={handleChange}
      inputProps={{ 'aria-label': 'controlled' }}
    />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancel</Button>
          <Button onClick={async()=>{
              const res=await Axios.post(`http://localhost:1123/todos`,
                        {
                          "title":title,
                          "tags":tags,
                          "completed":checked
                        })
                        refetch();
                        handleClose()
                        
          }}>Add</Button>
        </DialogActions>
      </Dialog>


        </React.Fragment>


          {}
      {data &&data.map((task,index)=>{return <BasicCard key = {index} refetch = {refetch} id= {task._id} title = {task.title} tags = {task.tags} complete = {task.completed} create={task.createdAt}></BasicCard>})}


    </Stack >

  </>
}


export default Todo;