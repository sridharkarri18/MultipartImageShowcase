package FileHandling.Image.Repositories;

import FileHandling.Image.Entities.Imagedata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepoistory extends JpaRepository<Imagedata,Integer> {
    Optional<Imagedata> findByName(String filename);
}
