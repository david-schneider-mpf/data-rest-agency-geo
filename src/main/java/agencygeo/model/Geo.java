package agencygeo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data
class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "data_center")
    private DataCenter dataCenter;
}
