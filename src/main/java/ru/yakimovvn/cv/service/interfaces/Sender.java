package ru.yakimovvn.cv.service.interfaces;

import ru.yakimovvn.cv.dto.MessageDto;

public interface Sender {

    void send(MessageDto message);

}
