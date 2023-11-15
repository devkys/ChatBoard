package com.example.chat_board.reply;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="reply")
@AllArgsConstructor
@NoArgsConstructor
public class Reply {

    @Id
    @Column(name = "reply_id")
    @NotNull
    long reply_id;
    @Column(name = "user_id")
    @NotNull
    String user_id;
    @Column(name = "reply_content")
    @NotNull
    String reply_contents;
    @Column(name = "board_id")
    @NotNull
    String board_id;

}
