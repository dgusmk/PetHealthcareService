package chatgpt.example.demo.model;

public class pet_profile {
    private String PET_SRN;
    private String USER_ID;
    private String PET_NM;
    private String PET_CD;
    private String PET_WGT_KG;
    private String PET_WGT_LB;
    private String PET_SEX;
    private String PET_BIRTH;
    private String FILE_CODE;
    private String REG_ID;

    public pet_profile() {
    }

    public pet_profile(String PET_SRN, String USER_ID, String PET_NM, String PET_CD, String PET_WGT_KG,
                       String PET_WGT_LB, String PET_SEX, String PET_BIRTH, String FILE_CODE, String REG_ID) {
        this.PET_SRN = PET_SRN;
        this.USER_ID = USER_ID;
        this.PET_NM = PET_NM;
        this.PET_CD = PET_CD;
        this.PET_WGT_KG = PET_WGT_KG;
        this.PET_WGT_LB = PET_WGT_LB;
        this.PET_SEX = PET_SEX;
        this.PET_BIRTH = PET_BIRTH;
        this.FILE_CODE = FILE_CODE;
        this.REG_ID = REG_ID;
    }

    public String getPET_SRN() {
        return PET_SRN;
    }

    public void setPET_SRN(String PET_SRN) {
        this.PET_SRN = PET_SRN;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getPET_NM() {
        return PET_NM;
    }

    public void setPET_NM(String PET_NM) {
        this.PET_NM = PET_NM;
    }

    public String getPET_CD() {
        return PET_CD;
    }

    public void setPET_CD(String PET_CD) {
        this.PET_CD = PET_CD;
    }

    public String getPET_WGT_KG() {
        return PET_WGT_KG;
    }

    public void setPET_WGT_KG(String PET_WGT_KG) {
        this.PET_WGT_KG = PET_WGT_KG;
    }

    public String getPET_WGT_LB() {
        return PET_WGT_LB;
    }

    public void setPET_WGT_LB(String PET_WGT_LB) {
        this.PET_WGT_LB = PET_WGT_LB;
    }

    public String getPET_SEX() {
        return PET_SEX;
    }

    public void setPET_SEX(String PET_SEX) {
        this.PET_SEX = PET_SEX;
    }

    public String getPET_BIRTH() {
        return PET_BIRTH;
    }

    public void setPET_BIRTH(String PET_BIRTH) {
        this.PET_BIRTH = PET_BIRTH;
    }

    public String getFILE_CODE() {
        return FILE_CODE;
    }

    public void setFILE_CODE(String FILE_CODE) {
        this.FILE_CODE = FILE_CODE;
    }

    public String getREG_ID() {
        return REG_ID;
    }

    public void setREG_ID(String REG_ID) {
        this.REG_ID = REG_ID;
    }
}
