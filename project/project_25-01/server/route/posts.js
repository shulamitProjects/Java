const express = require("express")
const router = express.Router()

const PostsController = require("../controllers/PostsController");

router.get("/",PostsController.getAllPosts)
router.get("/:id",PostsController.getPostsById)
router.post("/",PostsController.createNewPosts)
router.delete("/del/:id",PostsController.deletePosts)
router.put("/",PostsController.updatePosts)

module.exports = router