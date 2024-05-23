const express = require("express")
const router = express.Router()

const PhotosController = require("../controllers/PhotosController");

router.get("/",PhotosController.getAllPhotos)
router.post("/",PhotosController.createNewPhotos)
router.delete("/",PhotosController.deletePhotos)
router.put("/",PhotosController.updatePhotos)

module.exports = router