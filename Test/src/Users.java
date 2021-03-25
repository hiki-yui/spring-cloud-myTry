public class Users {
    private Long id;
    private String userName;
    private String email;
    private Long phone;
    private String passWord;

    public Users() {
    }

    public Users(Long id, String userName, String email, Long phone, String passWord) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setIdda(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
