package ru.nikishechkin.sciencebook.messenger;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderIdAndRecipientIdOrderByDateAsc(Long senderId, Long recipientId, Pageable pageable);
}
