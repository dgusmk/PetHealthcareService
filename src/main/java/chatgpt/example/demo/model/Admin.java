package chatgpt.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADMIN")
@Getter
@Setter
public class Admin {
    @Id                                                                 
    @GeneratedValue(strategy = GenerationType.IDENTITY)                 
    private Long id;                                                    

    @Column(name = "USERNAME")
    private String username;
    private String password;
    private String role;
}
