package com.fransan.kotlintemplate.application

import com.fransan.kotlintemplate.domain.MessageService
import com.fransan.kotlintemplate.infrastructure.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageResource(val messageService: MessageService) {

    @GetMapping
    fun getMessages(): List<Message> {
        return messageService.getMessages()
    }

    @PostMapping
    fun sendMessage(@RequestBody message: Message): Message {
        return messageService.sendMessage(message)
    }
}