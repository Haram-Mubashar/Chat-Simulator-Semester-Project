package com.example.demo;

import java.util.ArrayList;

public class Chat {

      private String user1;
      private String user2;

      ArrayList<Message> messages=new ArrayList<>();

      public Chat(String user1, String user2) {
          this.user1 = user1;
          this.user2 = user2;
      }

      public void sendMessage(String text, String s) {
             messages.add((new Message(text)));
      }

      public String getUser1() {
          return user1;
      }

      public String getUser2() {
          return user2;
      }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void setUser2(String user2) {
          this.user2 = user2;
    }
}
