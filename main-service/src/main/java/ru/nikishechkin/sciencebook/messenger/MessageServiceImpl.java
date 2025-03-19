package ru.nikishechkin.sciencebook.messenger;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public List<Message> getMessages(Long senderId, Long recipientId, Integer pageNumber, Integer pageSize) {
        return messageRepository.findBySenderIdAndRecipientIdOrderByDateAsc(senderId,
                recipientId, PageRequest.of(pageNumber, pageSize));
    }
}
