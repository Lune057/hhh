package com.example.a2048_game;

public class User {
    private int id;
    private String username;
    private String otherInfo; // 假设还有其他信息

    public User(int id, String username, String otherInfo) {
        this.id = id;
        this.username = username;
        this.otherInfo = otherInfo;
    }

    // Getter和Setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getOtherInfo() { return otherInfo; }
    public void setOtherInfo(String otherInfo) { this.otherInfo = otherInfo; }
}
