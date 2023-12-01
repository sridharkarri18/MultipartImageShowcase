package FileHandling.Image.Entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name="imagedetails")
@Entity
@Data
@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class Imagedata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private  String name;

    @Column(name = "filepath")
    private String filePaths;
}
