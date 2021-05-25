package ir.ac.kntu.person;

public class User {
    private String userName;
    private String passWord;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public boolean logIn(String userName, String passWord) {
        return this.userName.equals(userName) && this.passWord.equals(passWord);
    }


    public void forgetPassWord() {

    }
}
