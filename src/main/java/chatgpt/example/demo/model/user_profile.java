package chatgpt.example.demo.model;

public class user_profile {

    private String USER_ID;
    private String USER_NM;
    private String USER_PW;
    private String USER_PHONE;
    private String USER_SEX;
    private String USER_BIRTH;

    public user_profile(){
    }
    public user_profile(String USER_ID, String USER_NM, String USER_PW, String USER_PHONE, String USER_SEX, String USER_BIRTH) {
        this.USER_ID = USER_ID;
        this.USER_NM = USER_NM;
        this.USER_PW = USER_PW;
        this.USER_PHONE = USER_PHONE;
        this.USER_SEX = USER_SEX;
        this.USER_BIRTH = USER_BIRTH;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NM() {
        return USER_NM;
    }

    public void setUSER_NM(String USER_NM) {
        this.USER_NM = USER_NM;
    }

    public String getUSER_PW() {
        return USER_PW;
    }

    public void setUSER_PW(String USER_PW) {
        this.USER_PW = USER_PW;
    }

    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    public void setUSER_PHONE(String USER_PHONE) {
        this.USER_PHONE = USER_PHONE;
    }

    public String getUSER_SEX() {
        return USER_SEX;
    }

    public void setUSER_SEX(String USER_SEX) {
        this.USER_SEX = USER_SEX;
    }

    public String getUSER_BIRTH() {
        return USER_BIRTH;
    }

    public void setUSER_BIRTH(String USER_BIRTH) {
        this.USER_BIRTH = USER_BIRTH;
    }

}
