package FileHandling.Image.Controller;

import FileHandling.Image.Entities.Imagedata;
import FileHandling.Image.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/addimage")
    public ResponseEntity<?> UploadImagetoDb(@RequestParam("image")MultipartFile multipartFile) throws IOException {
        String uploadImage= imageService.addImage(multipartFile);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable("filename") String filename) throws IOException {
        byte[] imagedata=imageService.getImage(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imagedata);
    }

    @GetMapping("all")
    public List<Imagedata> allImageDetails()
    {
        return imageService.imageDetails();
    }


}
