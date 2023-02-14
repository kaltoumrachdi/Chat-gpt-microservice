package org.sid.chatgptmicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private String id;

    private String object;

    private int created;

    private String model;

    private Choices choices;

    public Choices getChoices()
    {
        return choices;
    }

    public void setChoices(Choices choice)
    {
        this.choices = choice;
    }
}

