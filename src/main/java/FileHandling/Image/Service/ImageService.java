package FileHandling.Image.Service;

import FileHandling.Image.Dto.Image;
import FileHandling.Image.Entities.Imagedata;
import FileHandling.Image.Repositories.ImageRepoistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {


    @Autowired
    ImageRepoistory imageRepoistory;

    private final String FOLDER_PATH="C:\\Users\\Developer\\Desktop\\Image\\";
    public String addImage(MultipartFile multipartFile) throws IOException {

        String filepath=FOLDER_PATH+multipartFile.getOriginalFilename();
        Imagedata imagedata=imageRepoistory.save(Imagedata.builder()
                        .name(multipartFile.getOriginalFilename())
                        .type(multipartFile.getContentType())
                        .filePaths(filepath).build());
        multipartFile.transferTo(new File(filepath));

        if(filepath!=null)
        {
            return "File uploaded Successfully"+filepath;
        }
        return null;


    }

    public byte[] getImage(String filename) throws IOException {
        Optional<Imagedata> imagedata=imageRepoistory.findByName(filename);
        String filepath=imagedata.get().getFilePaths();
        byte[] images= Files.readAllBytes(new File(filepath).toPath());
        return images;

    }

    public List<Imagedata> imageDetails() {
        return imageRepoistory.findAll();
    }
}
