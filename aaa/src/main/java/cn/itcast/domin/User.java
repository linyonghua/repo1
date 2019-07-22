package cn.itcast.domin;

import java.util.List;

public class User {
    private String name;
    private Integer age;
    private String password;
    private String username;
    private Account account;
    private List<Account> list;

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public User() {
    }

    public User(String name, Integer age, String password, String username) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.username = username;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", account=" + account +
                ", list=" + list +
                '}';
    }
}
