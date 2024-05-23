const express = require("express")
const router = express.Router()

const TodosController = require("../controllers/TodosController");

router.get("/",TodosController.getAllTodos)
router.get("/:id",TodosController.getTodoById)
router.post("/",TodosController.createNewTodo)
router.delete("/",TodosController.deleteTodos)
router.delete("/del/:id",TodosController.deleteTodosById)
router.put("/",TodosController.updateTodos)
router.put("/:id",TodosController.updateTodosCompleted)
module.exports = router