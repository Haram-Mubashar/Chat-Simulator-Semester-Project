package com.example.demo;

import java.util.ArrayList;

public class ChatManager {

        ArrayList<User> users=new  ArrayList<>();
        ArrayList<Chat> chats=new  ArrayList<>();

        public void addUser(User user){
            if(!users.contains(user))
                users.add(user);
        }

        public void addChat(Chat chat){
            if(!chats.contains(chat))
                chats.add(chat);
        }

}
