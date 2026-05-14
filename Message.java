package com.example.demo;

public class Message {
       private  String text;
       private String sender;

       public Message(String sender, String text) {
           this.text = text;
           this.sender = sender;
       }

       public String getText() {
           return text;
       }

       public void setText(String text) {
           this.text = text;
       }

       public String getSender() {
           return sender;
       }

       public void setSender(String sender) {
           this.sender = sender;
       }

       public String toString() {
           return sender + ":" + text;
       }
}
