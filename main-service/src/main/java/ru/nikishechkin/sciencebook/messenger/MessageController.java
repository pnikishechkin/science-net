package ru.nikishechkin.sciencebook.messenger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Slf4j
@Validated
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public List<Message> getMessages(@RequestParam Long senderId,
                                     @RequestParam Long recipientId,
                                     @RequestParam(defaultValue = "0") Integer pageNumber,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        return messageService.getMessages(senderId, recipientId, pageNumber, pageSize);
    }
}
