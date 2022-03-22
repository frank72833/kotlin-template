package com.fransan.kotlintemplate.domain

import com.fransan.kotlintemplate.infrastructure.Message
import com.fransan.kotlintemplate.infrastructure.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun getMessages(): List<Message> {
        return messageRepository.getMessages()
    }

    fun sendMessage(message: Message): Message {
        return messageRepository.save(message)
    }
}