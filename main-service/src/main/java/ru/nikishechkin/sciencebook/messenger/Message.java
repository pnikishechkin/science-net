package ru.nikishechkin.sciencebook.messenger;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.nikishechkin.sciencebook.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message reply;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @Column(name = "message", nullable = false)
    @Length(min = 1, max = 400)
    private String text;

    @Column(name = "date")
    private LocalDateTime date;
}
