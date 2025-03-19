package ru.nikishechkin.sciencebook.messenger;

import java.util.List;

public interface MessageService {
    List<Message> getMessages(Long senderId, Long recipientId, Integer pageNumber, Integer pageSize);
}
