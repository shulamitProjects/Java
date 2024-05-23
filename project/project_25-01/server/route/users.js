const express = require("express")
const router = express.Router()

const UsersController = require("../controllers/UsersController");

router.get("/",UsersController.getAllUsers)
router.get("/:id",UsersController.getUsersById)
router.post("/",UsersController.createNewUsers)
router.delete("/del/:id",UsersController.deleteUsers)
router.put("/",UsersController.updateUsers)
module.exports = router