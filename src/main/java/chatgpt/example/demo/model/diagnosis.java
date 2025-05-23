package chatgpt.example.demo.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class diagnosis {
    private String NAME;                 // 성명
    private String ADDRESS;              // 주소
    private String PLACE_OF_CARE;        // 사육장소
    private String SPECIES;              // 종류
    private String BREED;                // 품종
    private String ANIMAL_NAME;          // 동물명(동물등록번호)
    private String GENDER;               // 성별
    private String AGE;                  // 연령
    private String COAT_COLOR;           // 모색
    private String CHARACTERISTICS;      // 특징
    private String DISEASE_NAME;         // 병명
    private String ONSET_DATE;           // 발병 연월일
    private String DIAGNOSIS_DATE;       // 진단 연월일
    private String MAIN_SYMPTOMS;        // 주요 증상
    private String TREATMENT_NAME;       // 치료 명칭
    private String ADMISSION_DISCHARGE_DATE; // 입원*퇴원일
    private String PROGNOSIS;            // 예후 소견
    private String ADDITIONAL_INFO;      // 그 밖의 사항
    private String CLINIC_NAME;          // 동물병원 명칭
    private String CLINIC_ADDRESS;       // 동물병원 주소
    private String PHONE_NUMBER;         // 전화번호
    private String LICENSE_NUMBER;       // 면허번호
    private String VET_NAME;             // 수의사 성명

    // 기본 생성자
    public diagnosis() {
    }

    // 모든 필드를 포함한 생성자
    public diagnosis(String NAME, String ADDRESS, String PLACE_OF_CARE, String SPECIES, String BREED,
                     String ANIMAL_NAME, String GENDER, String AGE, String COAT_COLOR, String CHARACTERISTICS,
                     String DISEASE_NAME, String ONSET_DATE, String DIAGNOSIS_DATE, String MAIN_SYMPTOMS,
                     String TREATMENT_NAME, String ADMISSION_DISCHARGE_DATE, String PROGNOSIS, String ADDITIONAL_INFO,
                     String CLINIC_NAME, String CLINIC_ADDRESS, String PHONE_NUMBER, String LICENSE_NUMBER, String VET_NAME) {
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.PLACE_OF_CARE = PLACE_OF_CARE;
        this.SPECIES = SPECIES;
        this.BREED = BREED;
        this.ANIMAL_NAME = ANIMAL_NAME;
        this.GENDER = GENDER;
        this.AGE = AGE;
        this.COAT_COLOR = COAT_COLOR;
        this.CHARACTERISTICS = CHARACTERISTICS;
        this.DISEASE_NAME = DISEASE_NAME;
        this.ONSET_DATE = ONSET_DATE;
        this.DIAGNOSIS_DATE = DIAGNOSIS_DATE;
        this.MAIN_SYMPTOMS = MAIN_SYMPTOMS;
        this.TREATMENT_NAME = TREATMENT_NAME;
        this.ADMISSION_DISCHARGE_DATE = ADMISSION_DISCHARGE_DATE;
        this.PROGNOSIS = PROGNOSIS;
        this.ADDITIONAL_INFO = ADDITIONAL_INFO;
        this.CLINIC_NAME = CLINIC_NAME;
        this.CLINIC_ADDRESS = CLINIC_ADDRESS;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.LICENSE_NUMBER = LICENSE_NUMBER;
        this.VET_NAME = VET_NAME;
    }

    // Getter와 Setter 메서드
    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getPLACE_OF_CARE() {
        return PLACE_OF_CARE;
    }

    public void setPLACE_OF_CARE(String PLACE_OF_CARE) {
        this.PLACE_OF_CARE = PLACE_OF_CARE;
    }

    public String getSPECIES() {
        return SPECIES;
    }

    public void setSPECIES(String SPECIES) {
        this.SPECIES = SPECIES;
    }

    public String getBREED() {
        return BREED;
    }

    public void setBREED(String BREED) {
        this.BREED = BREED;
    }

    public String getANIMAL_NAME() {
        return ANIMAL_NAME;
    }

    public void setANIMAL_NAME(String ANIMAL_NAME) {
        this.ANIMAL_NAME = ANIMAL_NAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getAGE() {
        return AGE;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public String getCOAT_COLOR() {
        return COAT_COLOR;
    }

    public void setCOAT_COLOR(String COAT_COLOR) {
        this.COAT_COLOR = COAT_COLOR;
    }

    public String getCHARACTERISTICS() {
        return CHARACTERISTICS;
    }

    public void setCHARACTERISTICS(String CHARACTERISTICS) {
        this.CHARACTERISTICS = CHARACTERISTICS;
    }

    public String getDISEASE_NAME() {
        return DISEASE_NAME;
    }

    public void setDISEASE_NAME(String DISEASE_NAME) {
        this.DISEASE_NAME = DISEASE_NAME;
    }

    public String getONSET_DATE() {
        return ONSET_DATE;
    }

    public void setONSET_DATE(String ONSET_DATE) {
        this.ONSET_DATE = ONSET_DATE;
    }

    public String getDIAGNOSIS_DATE() {
        return DIAGNOSIS_DATE;
    }

    public void setDIAGNOSIS_DATE(String DIAGNOSIS_DATE) {
        this.DIAGNOSIS_DATE = DIAGNOSIS_DATE;
    }

    public String getMAIN_SYMPTOMS() {
        return MAIN_SYMPTOMS;
    }

    public void setMAIN_SYMPTOMS(String MAIN_SYMPTOMS) {
        this.MAIN_SYMPTOMS = MAIN_SYMPTOMS;
    }

    public String getTREATMENT_NAME() {
        return TREATMENT_NAME;
    }

    public void setTREATMENT_NAME(String TREATMENT_NAME) {
        this.TREATMENT_NAME = TREATMENT_NAME;
    }

    public String getADMISSION_DISCHARGE_DATE() {
        return ADMISSION_DISCHARGE_DATE;
    }

    public void setADMISSION_DISCHARGE_DATE(String ADMISSION_DISCHARGE_DATE) {
        this.ADMISSION_DISCHARGE_DATE = ADMISSION_DISCHARGE_DATE;
    }

    public String getPROGNOSIS() {
        return PROGNOSIS;
    }

    public void setPROGNOSIS(String PROGNOSIS) {
        this.PROGNOSIS = PROGNOSIS;
    }

    public String getADDITIONAL_INFO() {
        return ADDITIONAL_INFO;
    }

    public void setADDITIONAL_INFO(String ADDITIONAL_INFO) {
        this.ADDITIONAL_INFO = ADDITIONAL_INFO;
    }

    public String getCLINIC_NAME() {
        return CLINIC_NAME;
    }

    public void setCLINIC_NAME(String CLINIC_NAME) {
        this.CLINIC_NAME = CLINIC_NAME;
    }

    public String getCLINIC_ADDRESS() {
        return CLINIC_ADDRESS;
    }

    public void setCLINIC_ADDRESS(String CLINIC_ADDRESS) {
        this.CLINIC_ADDRESS = CLINIC_ADDRESS;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getLICENSE_NUMBER() {
        return LICENSE_NUMBER;
    }

    public void setLICENSE_NUMBER(String LICENSE_NUMBER) {
        this.LICENSE_NUMBER = LICENSE_NUMBER;
    }

    public String getVET_NAME() {
        return VET_NAME;
    }

    public void setVET_NAME(String VET_NAME) {
        this.VET_NAME = VET_NAME;
    }

}
