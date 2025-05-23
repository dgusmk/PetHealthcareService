package chatgpt.example.demo.model;

public class hospital {

    private String hospitalName;         // 동물병원 이름
    private String address;              // 주소
    private String specialty;            // 전문 분야
    private String phoneNumber;          // 전화번호
    private int recommendationCount;     // 추천 수

    // 기본 생성자
    public hospital() {
    }

    // 모든 필드를 포함하는 생성자
    public hospital(String hospitalName, String address, String specialty, String phoneNumber, int recommendationCount) {
        this.hospitalName = hospitalName;
        this.address = address;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.recommendationCount = recommendationCount;
    }

    // Getter와 Setter 메서드
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(int recommendationCount) {
        this.recommendationCount = recommendationCount;
    }
}
