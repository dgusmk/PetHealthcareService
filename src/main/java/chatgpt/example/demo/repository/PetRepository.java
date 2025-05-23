package chatgpt.example.demo.repository;

import chatgpt.example.demo.model.diagnosis;
import chatgpt.example.demo.model.hospital;
import chatgpt.example.demo.model.pet_profile;
import chatgpt.example.demo.model.user_profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {

    private final JdbcTemplate jdbcTemplate;

    public PetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String nullIfEmpty(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value;
    }
    public List<user_profile> findUP() {
        String sql = "SELECT * FROM user_profile";
        return jdbcTemplate.query(sql, new RowMapper<user_profile>() {
            @Override
            public user_profile mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new user_profile(rs.getString("USER_ID"), rs.getString("USER_NM"), rs.getString("USER_PW"),
                        rs.getString("USER_PHONE"), rs.getString("USER_SEX"), rs.getString("USER_BIRTH"));
            }
        });
    }

    public List<user_profile> searchUP(user_profile searchCriteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user_profile WHERE 1=1");
        List<Object> params = new ArrayList<>();

        // USER_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_ID() != null && !searchCriteria.getUSER_ID().trim().isEmpty()) {
            sql.append(" AND USER_ID LIKE ?");
            params.add("%" + searchCriteria.getUSER_ID().trim() + "%");
        }

        // USER_NM가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_NM() != null && !searchCriteria.getUSER_NM().trim().isEmpty()) {
            sql.append(" AND USER_NM LIKE ?");
            params.add("%" + searchCriteria.getUSER_NM().trim() + "%");
        }

        // USER_PW가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_PW() != null && !searchCriteria.getUSER_PW().trim().isEmpty()) {
            sql.append(" AND USER_PW LIKE ?");
            params.add("%" + searchCriteria.getUSER_PW().trim() + "%");
        }

        // USER_PHONE이 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_PHONE() != null && !searchCriteria.getUSER_PHONE().trim().isEmpty()) {
            sql.append(" AND USER_PHONE LIKE ?");
            params.add("%" + searchCriteria.getUSER_PHONE().trim() + "%");
        }

        // USER_SEX가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_SEX() != null && !searchCriteria.getUSER_SEX().trim().isEmpty()) {
            sql.append(" AND USER_SEX LIKE ?");
            params.add("%" + searchCriteria.getUSER_SEX().trim() + "%");
        }

        // USER_BIRTH가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_BIRTH() != null && !searchCriteria.getUSER_BIRTH().trim().isEmpty()) {
            sql.append(" AND USER_BIRTH LIKE ?");
            params.add("%" + searchCriteria.getUSER_BIRTH().trim() + "%");
        }


        // SQL 실행 및 결과 반환
        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<user_profile>() {
            @Override
            public user_profile mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new user_profile(rs.getString("USER_ID"), rs.getString("USER_NM"), rs.getString("USER_PW"),
                        rs.getString("USER_PHONE"), rs.getString("USER_SEX"), rs.getString("USER_BIRTH"));
            }
        });
    }

    public void insertUP(user_profile userProfile) {
        String sql = "INSERT INTO user_profile (USER_ID, USER_NM, USER_PW, USER_PHONE, USER_SEX, USER_BIRTH) VALUES (?, ?, ?, ?, ?, ?)";
        List<Object> userProfileValues = new ArrayList<>();

        userProfileValues.add(nullIfEmpty(userProfile.getUSER_ID()));
        userProfileValues.add(nullIfEmpty(userProfile.getUSER_NM()));
        userProfileValues.add(nullIfEmpty(userProfile.getUSER_PW()));
        userProfileValues.add(nullIfEmpty(userProfile.getUSER_PHONE()));
        userProfileValues.add(nullIfEmpty(userProfile.getUSER_SEX()));
        userProfileValues.add(nullIfEmpty(userProfile.getUSER_BIRTH()));

        jdbcTemplate.update(sql, userProfileValues.toArray());
    }

    public String deleteUP(user_profile userProfile) {
        StringBuilder sql = new StringBuilder("DELETE FROM user_profile WHERE 1=1");
        List<Object> userProfileValues = new ArrayList<>();

        // USER_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_ID() != null && !userProfile.getUSER_ID().trim().isEmpty()) {
            sql.append(" AND USER_ID = ?");
            userProfileValues.add(userProfile.getUSER_ID());
        }

        // USER_NM가 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_NM() != null && !userProfile.getUSER_NM().trim().isEmpty()) {
            sql.append(" AND USER_NM = ?");
            userProfileValues.add(userProfile.getUSER_NM());
        }

        // USER_PW가 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_PW() != null && !userProfile.getUSER_PW().trim().isEmpty()) {
            sql.append(" AND USER_PW = ?");
            userProfileValues.add(userProfile.getUSER_PW());
        }

        // USER_PHONE이 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_PHONE() != null && !userProfile.getUSER_PHONE().trim().isEmpty()) {
            sql.append(" AND USER_PHONE = ?");
            userProfileValues.add(userProfile.getUSER_PHONE());
        }

        // USER_SEX가 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_SEX() != null && !userProfile.getUSER_SEX().trim().isEmpty()) {
            sql.append(" AND USER_SEX = ?");
            userProfileValues.add(userProfile.getUSER_SEX());
        }

        // USER_BIRTH가 null이 아니고 빈 문자열이 아닌 경우
        if (userProfile.getUSER_BIRTH() != null && !userProfile.getUSER_BIRTH().trim().isEmpty()) {
            sql.append(" AND USER_BIRTH = ?");
            userProfileValues.add(userProfile.getUSER_BIRTH());
        }

        int success = jdbcTemplate.update(sql.toString(), userProfileValues.toArray());

        if (success > 0)
            return "데이터가 성공적으로 삭제되었습니다!";
        else
            return "삭제할 데이터가 존재하지 않습니다!";
    }


    public List<pet_profile> findPP() {
        String sql = "SELECT * FROM pet_profile";
        return jdbcTemplate.query(sql, new RowMapper<pet_profile>() {
            @Override
            public pet_profile mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new pet_profile(rs.getString("PET_SRN"), rs.getString("USER_ID"), rs.getString("PET_NM"),
                        rs.getString("PET_CD"),rs.getString("PET_WGT_KG"),rs.getString("PET_WGT_KG"),
                rs.getString("PET_SEX"), rs.getString("PET_BIRTH"), rs.getString("FILE_CODE"), rs.getString("REG_ID"));
            }
        });
    }

    public List<pet_profile> searchPP(pet_profile searchCriteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM pet_profile WHERE 1=1");
        List<Object> params = new ArrayList<>();

        // PET_SRN가 null이 아닌 경우
        if (searchCriteria.getPET_SRN() != null) {
            sql.append(" AND PET_SRN LIKE ?");
            params.add("%" + searchCriteria.getPET_SRN() + "%");
        }

        // USER_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getUSER_ID() != null && !searchCriteria.getUSER_ID().trim().isEmpty()) {
            sql.append(" AND USER_ID LIKE ?");
            params.add("%" + searchCriteria.getUSER_ID().trim() + "%");
        }

        // PET_NM가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getPET_NM() != null && !searchCriteria.getPET_NM().trim().isEmpty()) {
            sql.append(" AND PET_NM LIKE ?");
            params.add("%" + searchCriteria.getPET_NM().trim() + "%");
        }

        // PET_CD가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getPET_CD() != null && !searchCriteria.getPET_CD().trim().isEmpty()) {
            sql.append(" AND PET_CD LIKE ?");
            params.add("%" + searchCriteria.getPET_CD().trim() + "%");
        }

        // PET_WGT_KG가 null이 아닌 경우
        if (searchCriteria.getPET_WGT_KG() != null) {
            sql.append(" AND PET_WGT_KG LIKE ?");
            params.add("%" + searchCriteria.getPET_WGT_KG() + "%");
        }

        // PET_WGT_LB가 null이 아닌 경우
        if (searchCriteria.getPET_WGT_LB() != null) {
            sql.append(" AND PET_WGT_LB LIKE ?");
            params.add("%" + searchCriteria.getPET_WGT_LB() + "%");
        }

        // PET_SEX가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getPET_SEX() != null && !searchCriteria.getPET_SEX().trim().isEmpty()) {
            sql.append(" AND PET_SEX LIKE ?");
            params.add("%" + searchCriteria.getPET_SEX().trim() + "%");
        }

        // PET_BIRTH가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getPET_BIRTH() != null && !searchCriteria.getPET_BIRTH().trim().isEmpty()) {
            sql.append(" AND PET_BIRTH LIKE ?");
            params.add("%" + searchCriteria.getPET_BIRTH().trim() + "%");
        }

        // FILE_CODE가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getFILE_CODE() != null && !searchCriteria.getFILE_CODE().trim().isEmpty()) {
            sql.append(" AND FILE_CODE LIKE ?");
            params.add("%" + searchCriteria.getFILE_CODE().trim() + "%");
        }

        // REG_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (searchCriteria.getREG_ID() != null && !searchCriteria.getREG_ID().trim().isEmpty()) {
            sql.append(" AND REG_ID LIKE ?");
            params.add("%" + searchCriteria.getREG_ID().trim() + "%");
        }

        // SQL 실행 및 결과 반환
        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<pet_profile>() {
            @Override
            public pet_profile mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new pet_profile(rs.getString("PET_SRN"), rs.getString("USER_ID"), rs.getString("PET_NM"),
                        rs.getString("PET_CD"),rs.getString("PET_WGT_KG"),rs.getString("PET_WGT_KG"),
                        rs.getString("PET_SEX"), rs.getString("PET_BIRTH"), rs.getString("FILE_CODE"), rs.getString("REG_ID"));
            }
        });
    }

    public void insertPP(pet_profile petProfile) {
        String sql = "INSERT INTO pet_profile (PET_SRN, USER_ID, PET_NM, PET_CD, PET_WGT_KG, PET_WGT_LB, PET_SEX, PET_BIRTH, FILE_CODE, REG_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<Object> petProfileValues = new ArrayList<>();

        petProfileValues.add(nullIfEmpty(petProfile.getPET_SRN()));
        petProfileValues.add(nullIfEmpty(petProfile.getUSER_ID()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_NM()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_CD()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_WGT_KG()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_WGT_LB()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_SEX()));
        petProfileValues.add(nullIfEmpty(petProfile.getPET_BIRTH()));
        petProfileValues.add(nullIfEmpty(petProfile.getFILE_CODE()));
        petProfileValues.add(nullIfEmpty(petProfile.getREG_ID()));
        jdbcTemplate.update(sql, petProfileValues.toArray());
    }

    public String deletePP(pet_profile petProfile) {
        StringBuilder sql = new StringBuilder("DELETE FROM pet_profile WHERE 1=1");
        List<Object> petProfileValues = new ArrayList<>();

        // PET_SRN가 null이 아니고 빈 값이 아닌 경우
        if (petProfile.getPET_SRN() != null) {
            sql.append(" AND PET_SRN = ?");
            petProfileValues.add(petProfile.getPET_SRN());
        }

        // USER_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getUSER_ID() != null && !petProfile.getUSER_ID().trim().isEmpty()) {
            sql.append(" AND USER_ID = ?");
            petProfileValues.add(petProfile.getUSER_ID());
        }

        // PET_NM가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getPET_NM() != null && !petProfile.getPET_NM().trim().isEmpty()) {
            sql.append(" AND PET_NM = ?");
            petProfileValues.add(petProfile.getPET_NM());
        }

        // PET_CD가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getPET_CD() != null && !petProfile.getPET_CD().trim().isEmpty()) {
            sql.append(" AND PET_CD = ?");
            petProfileValues.add(petProfile.getPET_CD());
        }

        // PET_WGT_KG가 null이 아닌 경우
        if (petProfile.getPET_WGT_KG() != null) {
            sql.append(" AND PET_WGT_KG = ?");
            petProfileValues.add(petProfile.getPET_WGT_KG());
        }

        // PET_WGT_LB가 null이 아닌 경우
        if (petProfile.getPET_WGT_LB() != null) {
            sql.append(" AND PET_WGT_LB = ?");
            petProfileValues.add(petProfile.getPET_WGT_LB());
        }

        // PET_SEX가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getPET_SEX() != null && !petProfile.getPET_SEX().trim().isEmpty()) {
            sql.append(" AND PET_SEX = ?");
            petProfileValues.add(petProfile.getPET_SEX());
        }

        // PET_BIRTH가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getPET_BIRTH() != null && !petProfile.getPET_BIRTH().trim().isEmpty()) {
            sql.append(" AND PET_BIRTH = ?");
            petProfileValues.add(petProfile.getPET_BIRTH());
        }

        // FILE_CODE가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getFILE_CODE() != null && !petProfile.getFILE_CODE().trim().isEmpty()) {
            sql.append(" AND FILE_CODE = ?");
            petProfileValues.add(petProfile.getFILE_CODE());
        }

        // REG_ID가 null이 아니고 빈 문자열이 아닌 경우
        if (petProfile.getREG_ID() != null && !petProfile.getREG_ID().trim().isEmpty()) {
            sql.append(" AND REG_ID = ?");
            petProfileValues.add(petProfile.getREG_ID());
        }

        int success = jdbcTemplate.update(sql.toString(), petProfileValues.toArray());

        if (success > 0)
            return "데이터가 성공적으로 삭제되었습니다!";
        else
            return "삭제할 데이터가 존재하지 않습니다!";
    }

    public List<hospital> findHospital() {
        String sql = "SELECT * FROM hospital";
        return jdbcTemplate.query(sql, new RowMapper<hospital>() {
            @Override
            public hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new hospital(
                        rs.getString("hospital_name"),         // 동물병원 이름
                        rs.getString("address"),               // 주소
                        rs.getString("specialty"),             // 전문 분야
                        rs.getString("phone_number"),          // 전화번호
                        rs.getInt("recommendation_count")      // 추천 수
                );
            }
        });
    }

    public List<hospital> searchHospital(hospital searchCriteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM hospital WHERE 1=1");
        List<Object> params = new ArrayList<>();

        // 병원 이름 검색 조건 추가
        if (searchCriteria.getHospitalName() != null && !searchCriteria.getHospitalName().trim().isEmpty()) {
            sql.append(" AND hospital_name LIKE ?");
            params.add("%" + searchCriteria.getHospitalName().trim() + "%");
        }

        // 주소 검색 조건 추가
        if (searchCriteria.getAddress() != null && !searchCriteria.getAddress().trim().isEmpty()) {
            sql.append(" AND address LIKE ?");
            params.add("%" + searchCriteria.getAddress().trim() + "%");
        }

        // 전문 분야 검색 조건 추가
        if (searchCriteria.getSpecialty() != null && !searchCriteria.getSpecialty().trim().isEmpty()) {
            sql.append(" AND specialty LIKE ?");
            params.add("%" + searchCriteria.getSpecialty().trim() + "%");
        }

        // 전화번호 검색 조건 추가
        if (searchCriteria.getPhoneNumber() != null && !searchCriteria.getPhoneNumber().trim().isEmpty()) {
            sql.append(" AND phone_number LIKE ?");
            params.add("%" + searchCriteria.getPhoneNumber().trim() + "%");
        }


        // SQL 쿼리 실행 및 결과 매핑
        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<hospital>() {
            @Override
            public hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new hospital(
                        rs.getString("hospital_name"),         // 병원 이름
                        rs.getString("address"),               // 주소
                        rs.getString("specialty"),             // 전문 분야
                        rs.getString("phone_number"),          // 전화번호
                        rs.getInt("recommendation_count")      // 추천 수
                );
            }
        });
    }


    public void insertHospital(hospital hospitalData) {
        String sql = "INSERT INTO hospital (hospital_name, address, specialty, phone_number, recommendation_count) VALUES (?, ?, ?, ?, ?)";
        List<Object> hospitalValues = new ArrayList<>();

        hospitalValues.add(nullIfEmpty(hospitalData.getHospitalName()));        // 병원 이름
        hospitalValues.add(nullIfEmpty(hospitalData.getAddress()));            // 주소
        hospitalValues.add(nullIfEmpty(hospitalData.getSpecialty()));          // 전문 분야
        hospitalValues.add(nullIfEmpty(hospitalData.getPhoneNumber()));        // 전화번호
        hospitalValues.add(hospitalData.getRecommendationCount());             // 추천 수

        jdbcTemplate.update(sql, hospitalValues.toArray());
    }


    public String deleteHospital(hospital hospitalData) {
        StringBuilder sql = new StringBuilder("DELETE FROM hospital WHERE 1=1");
        List<Object> hospitalValues = new ArrayList<>();

        // 병원 이름 조건 추가
        if (hospitalData.getHospitalName() != null && !hospitalData.getHospitalName().trim().isEmpty()) {
            sql.append(" AND hospital_name = ?");
            hospitalValues.add(hospitalData.getHospitalName().trim());
        }

        // 주소 조건 추가
        if (hospitalData.getAddress() != null && !hospitalData.getAddress().trim().isEmpty()) {
            sql.append(" AND address = ?");
            hospitalValues.add(hospitalData.getAddress().trim());
        }

        // 전문 분야 조건 추가
        if (hospitalData.getSpecialty() != null && !hospitalData.getSpecialty().trim().isEmpty()) {
            sql.append(" AND specialty = ?");
            hospitalValues.add(hospitalData.getSpecialty().trim());
        }

        // 전화번호 조건 추가
        if (hospitalData.getPhoneNumber() != null && !hospitalData.getPhoneNumber().trim().isEmpty()) {
            sql.append(" AND phone_number = ?");
            hospitalValues.add(hospitalData.getPhoneNumber().trim());
        }

        // 추천 수 조건 추가
        if (hospitalData.getRecommendationCount() > 0) {
            sql.append(" AND recommendation_count = ?");
            hospitalValues.add(hospitalData.getRecommendationCount());
        }

        // DELETE 쿼리 실행
        int success = jdbcTemplate.update(sql.toString(), hospitalValues.toArray());

        // 결과 메시지 반환
        if (success > 0) {
            return "데이터가 성공적으로 삭제되었습니다!";
        } else {
            return "삭제할 데이터가 존재하지 않습니다!";
        }
    }


    public List<diagnosis> findDiagnosis() {
        String sql = "SELECT * FROM diagnosis";
        return jdbcTemplate.query(sql, new RowMapper<diagnosis>() {
            @Override
            public diagnosis mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new diagnosis(
                        rs.getString("NAME"),                      // 성명
                        rs.getString("ADDRESS"),                   // 주소
                        rs.getString("PLACE_OF_CARE"),             // 사육장소
                        rs.getString("SPECIES"),                   // 종류
                        rs.getString("BREED"),                     // 품종
                        rs.getString("ANIMAL_NAME"),               // 동물명(동물등록번호)
                        rs.getString("GENDER"),                    // 성별
                        rs.getString("AGE"),                       // 연령
                        rs.getString("COAT_COLOR"),                // 모색
                        rs.getString("CHARACTERISTICS"),           // 특징
                        rs.getString("DISEASE_NAME"),              // 병명
                        rs.getString("ONSET_DATE"),                // 발병 연월일
                        rs.getString("DIAGNOSIS_DATE"),            // 진단 연월일
                        rs.getString("MAIN_SYMPTOMS"),             // 주요 증상
                        rs.getString("TREATMENT_NAME"),            // 치료 명칭
                        rs.getString("ADMISSION_DISCHARGE_DATE"),  // 입원*퇴원일
                        rs.getString("PROGNOSIS"),                 // 예후 소견
                        rs.getString("ADDITIONAL_INFO"),           // 그 밖의 사항
                        rs.getString("CLINIC_NAME"),               // 동물병원 명칭
                        rs.getString("CLINIC_ADDRESS"),            // 동물병원 주소
                        rs.getString("PHONE_NUMBER"),              // 전화번호
                        rs.getString("LICENSE_NUMBER"),            // 면허번호
                        rs.getString("VET_NAME")                   // 수의사 성명
                );
            }
        });
    }


    public List<diagnosis> searchDiagnosis(diagnosis searchCriteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM diagnosis WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (searchCriteria.getNAME() != null && !searchCriteria.getNAME().trim().isEmpty()) {
            sql.append(" AND NAME LIKE ?");
            params.add("%" + searchCriteria.getNAME().trim() + "%");
        }

        if (searchCriteria.getADDRESS() != null && !searchCriteria.getADDRESS().trim().isEmpty()) {
            sql.append(" AND ADDRESS LIKE ?");
            params.add("%" + searchCriteria.getADDRESS().trim() + "%");
        }

        if (searchCriteria.getPLACE_OF_CARE() != null && !searchCriteria.getPLACE_OF_CARE().trim().isEmpty()) {
            sql.append(" AND PLACE_OF_CARE LIKE ?");
            params.add("%" + searchCriteria.getPLACE_OF_CARE().trim() + "%");
        }

        if (searchCriteria.getSPECIES() != null && !searchCriteria.getSPECIES().trim().isEmpty()) {
            sql.append(" AND SPECIES LIKE ?");
            params.add("%" + searchCriteria.getSPECIES().trim() + "%");
        }

        if (searchCriteria.getBREED() != null && !searchCriteria.getBREED().trim().isEmpty()) {
            sql.append(" AND BREED LIKE ?");
            params.add("%" + searchCriteria.getBREED().trim() + "%");
        }

        if (searchCriteria.getANIMAL_NAME() != null && !searchCriteria.getANIMAL_NAME().trim().isEmpty()) {
            sql.append(" AND ANIMAL_NAME LIKE ?");
            params.add("%" + searchCriteria.getANIMAL_NAME().trim() + "%");
        }

        if (searchCriteria.getGENDER() != null && !searchCriteria.getGENDER().trim().isEmpty()) {
            sql.append(" AND GENDER LIKE ?");
            params.add("%" + searchCriteria.getGENDER().trim() + "%");
        }

        if (searchCriteria.getAGE() != null && !searchCriteria.getAGE().trim().isEmpty()) {
            sql.append(" AND AGE LIKE ?");
            params.add("%" + searchCriteria.getAGE().trim() + "%");
        }

        if (searchCriteria.getCOAT_COLOR() != null && !searchCriteria.getCOAT_COLOR().trim().isEmpty()) {
            sql.append(" AND COAT_COLOR LIKE ?");
            params.add("%" + searchCriteria.getCOAT_COLOR().trim() + "%");
        }

        if (searchCriteria.getCHARACTERISTICS() != null && !searchCriteria.getCHARACTERISTICS().trim().isEmpty()) {
            sql.append(" AND CHARACTERISTICS LIKE ?");
            params.add("%" + searchCriteria.getCHARACTERISTICS().trim() + "%");
        }

        if (searchCriteria.getDISEASE_NAME() != null && !searchCriteria.getDISEASE_NAME().trim().isEmpty()) {
            sql.append(" AND DISEASE_NAME LIKE ?");
            params.add("%" + searchCriteria.getDISEASE_NAME().trim() + "%");
        }

        if (searchCriteria.getONSET_DATE() != null && !searchCriteria.getONSET_DATE().trim().isEmpty()) {
            sql.append(" AND ONSET_DATE LIKE ?");
            params.add("%" + searchCriteria.getONSET_DATE().trim() + "%");
        }

        if (searchCriteria.getDIAGNOSIS_DATE() != null && !searchCriteria.getDIAGNOSIS_DATE().trim().isEmpty()) {
            sql.append(" AND DIAGNOSIS_DATE LIKE ?");
            params.add("%" + searchCriteria.getDIAGNOSIS_DATE().trim() + "%");
        }

        if (searchCriteria.getMAIN_SYMPTOMS() != null && !searchCriteria.getMAIN_SYMPTOMS().trim().isEmpty()) {
            sql.append(" AND MAIN_SYMPTOMS LIKE ?");
            params.add("%" + searchCriteria.getMAIN_SYMPTOMS().trim() + "%");
        }

        if (searchCriteria.getTREATMENT_NAME() != null && !searchCriteria.getTREATMENT_NAME().trim().isEmpty()) {
            sql.append(" AND TREATMENT_NAME LIKE ?");
            params.add("%" + searchCriteria.getTREATMENT_NAME().trim() + "%");
        }

        if (searchCriteria.getADMISSION_DISCHARGE_DATE() != null && !searchCriteria.getADMISSION_DISCHARGE_DATE().trim().isEmpty()) {
            sql.append(" AND ADMISSION_DISCHARGE_DATE LIKE ?");
            params.add("%" + searchCriteria.getADMISSION_DISCHARGE_DATE().trim() + "%");
        }

        if (searchCriteria.getPROGNOSIS() != null && !searchCriteria.getPROGNOSIS().trim().isEmpty()) {
            sql.append(" AND PROGNOSIS LIKE ?");
            params.add("%" + searchCriteria.getPROGNOSIS().trim() + "%");
        }

        if (searchCriteria.getADDITIONAL_INFO() != null && !searchCriteria.getADDITIONAL_INFO().trim().isEmpty()) {
            sql.append(" AND ADDITIONAL_INFO LIKE ?");
            params.add("%" + searchCriteria.getADDITIONAL_INFO().trim() + "%");
        }

        if (searchCriteria.getCLINIC_NAME() != null && !searchCriteria.getCLINIC_NAME().trim().isEmpty()) {
            sql.append(" AND CLINIC_NAME LIKE ?");
            params.add("%" + searchCriteria.getCLINIC_NAME().trim() + "%");
        }

        if (searchCriteria.getCLINIC_ADDRESS() != null && !searchCriteria.getCLINIC_ADDRESS().trim().isEmpty()) {
            sql.append(" AND CLINIC_ADDRESS LIKE ?");
            params.add("%" + searchCriteria.getCLINIC_ADDRESS().trim() + "%");
        }

        if (searchCriteria.getPHONE_NUMBER() != null && !searchCriteria.getPHONE_NUMBER().trim().isEmpty()) {
            sql.append(" AND PHONE_NUMBER LIKE ?");
            params.add("%" + searchCriteria.getPHONE_NUMBER().trim() + "%");
        }

        if (searchCriteria.getLICENSE_NUMBER() != null && !searchCriteria.getLICENSE_NUMBER().trim().isEmpty()) {
            sql.append(" AND LICENSE_NUMBER LIKE ?");
            params.add("%" + searchCriteria.getLICENSE_NUMBER().trim() + "%");
        }

        if (searchCriteria.getVET_NAME() != null && !searchCriteria.getVET_NAME().trim().isEmpty()) {
            sql.append(" AND VET_NAME LIKE ?");
            params.add("%" + searchCriteria.getVET_NAME().trim() + "%");
        }

        return jdbcTemplate.query(sql.toString(), params.toArray(), new RowMapper<diagnosis>() {
            @Override
            public diagnosis mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new diagnosis(
                        rs.getString("NAME"),                      // 성명
                        rs.getString("ADDRESS"),                   // 주소
                        rs.getString("PLACE_OF_CARE"),             // 사육장소
                        rs.getString("SPECIES"),                   // 종류
                        rs.getString("BREED"),                     // 품종
                        rs.getString("ANIMAL_NAME"),               // 동물명(동물등록번호)
                        rs.getString("GENDER"),                    // 성별
                        rs.getString("AGE"),                       // 연령
                        rs.getString("COAT_COLOR"),                // 모색
                        rs.getString("CHARACTERISTICS"),           // 특징
                        rs.getString("DISEASE_NAME"),              // 병명
                        rs.getString("ONSET_DATE"),                // 발병 연월일
                        rs.getString("DIAGNOSIS_DATE"),            // 진단 연월일
                        rs.getString("MAIN_SYMPTOMS"),             // 주요 증상
                        rs.getString("TREATMENT_NAME"),            // 치료 명칭
                        rs.getString("ADMISSION_DISCHARGE_DATE"),  // 입원*퇴원일
                        rs.getString("PROGNOSIS"),                 // 예후 소견
                        rs.getString("ADDITIONAL_INFO"),           // 그 밖의 사항
                        rs.getString("CLINIC_NAME"),               // 동물병원 명칭
                        rs.getString("CLINIC_ADDRESS"),            // 동물병원 주소
                        rs.getString("PHONE_NUMBER"),              // 전화번호
                        rs.getString("LICENSE_NUMBER"),            // 면허번호
                        rs.getString("VET_NAME")                   // 수의사 성명
                );
            }
        });
    }


    public int insertDiagnosis(diagnosis diagnosisData) {
        String sql = "INSERT INTO diagnosis (NAME, ADDRESS, PLACE_OF_CARE, SPECIES, BREED, ANIMAL_NAME, GENDER, AGE, COAT_COLOR, CHARACTERISTICS, DISEASE_NAME, ONSET_DATE, DIAGNOSIS_DATE, MAIN_SYMPTOMS, TREATMENT_NAME, ADMISSION_DISCHARGE_DATE, PROGNOSIS, ADDITIONAL_INFO, CLINIC_NAME, CLINIC_ADDRESS, PHONE_NUMBER, LICENSE_NUMBER, VET_NAME) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        List<Object> diagnosisValues = new ArrayList<>();
        if(!((diagnosisData.getNAME() == null || diagnosisData.getNAME().trim().isEmpty()) &&
                (diagnosisData.getADDRESS() == null || diagnosisData.getADDRESS().trim().isEmpty()) &&
                (diagnosisData.getPLACE_OF_CARE() == null || diagnosisData.getPLACE_OF_CARE().trim().isEmpty()) &&
                (diagnosisData.getSPECIES() == null || diagnosisData.getSPECIES().trim().isEmpty()) &&
                (diagnosisData.getBREED() == null || diagnosisData.getBREED().trim().isEmpty()) &&
                (diagnosisData.getANIMAL_NAME() == null || diagnosisData.getANIMAL_NAME().trim().isEmpty()) &&
                (diagnosisData.getGENDER() == null || diagnosisData.getGENDER().trim().isEmpty()) &&
                (diagnosisData.getAGE() == null || diagnosisData.getAGE().trim().isEmpty()) &&
                (diagnosisData.getCOAT_COLOR() == null || diagnosisData.getCOAT_COLOR().trim().isEmpty()) &&
                (diagnosisData.getCHARACTERISTICS() == null || diagnosisData.getCHARACTERISTICS().trim().isEmpty()) &&
                (diagnosisData.getDISEASE_NAME() == null || diagnosisData.getDISEASE_NAME().trim().isEmpty()) &&
                (diagnosisData.getONSET_DATE() == null || diagnosisData.getONSET_DATE().trim().isEmpty()) &&
                (diagnosisData.getDIAGNOSIS_DATE() == null || diagnosisData.getDIAGNOSIS_DATE().trim().isEmpty()) &&
                (diagnosisData.getMAIN_SYMPTOMS() == null || diagnosisData.getMAIN_SYMPTOMS().trim().isEmpty()) &&
                (diagnosisData.getTREATMENT_NAME() == null || diagnosisData.getTREATMENT_NAME().trim().isEmpty()) &&
                (diagnosisData.getADMISSION_DISCHARGE_DATE() == null || diagnosisData.getADMISSION_DISCHARGE_DATE().trim().isEmpty()) &&
                (diagnosisData.getPROGNOSIS() == null || diagnosisData.getPROGNOSIS().trim().isEmpty()) &&
                (diagnosisData.getADDITIONAL_INFO() == null || diagnosisData.getADDITIONAL_INFO().trim().isEmpty()) &&
                (diagnosisData.getCLINIC_NAME() == null || diagnosisData.getCLINIC_NAME().trim().isEmpty()) &&
                (diagnosisData.getCLINIC_ADDRESS() == null || diagnosisData.getCLINIC_ADDRESS().trim().isEmpty()) &&
                (diagnosisData.getPHONE_NUMBER() == null || diagnosisData.getPHONE_NUMBER().trim().isEmpty()) &&
                (diagnosisData.getLICENSE_NUMBER() == null || diagnosisData.getLICENSE_NUMBER().trim().isEmpty()) &&
                (diagnosisData.getVET_NAME() == null || diagnosisData.getVET_NAME().trim().isEmpty()))) {
            diagnosisValues.add(nullIfEmpty(diagnosisData.getNAME()));                 // 성명
            diagnosisValues.add(nullIfEmpty(diagnosisData.getADDRESS()));              // 주소
            diagnosisValues.add(nullIfEmpty(diagnosisData.getPLACE_OF_CARE()));        // 사육장소
            diagnosisValues.add(nullIfEmpty(diagnosisData.getSPECIES()));              // 종류
            diagnosisValues.add(nullIfEmpty(diagnosisData.getBREED()));                // 품종
            diagnosisValues.add(nullIfEmpty(diagnosisData.getANIMAL_NAME()));          // 동물명
            diagnosisValues.add(nullIfEmpty(diagnosisData.getGENDER()));               // 성별
            diagnosisValues.add(nullIfEmpty(diagnosisData.getAGE()));                  // 연령
            diagnosisValues.add(nullIfEmpty(diagnosisData.getCOAT_COLOR()));           // 모색
            diagnosisValues.add(nullIfEmpty(diagnosisData.getCHARACTERISTICS()));      // 특징
            diagnosisValues.add(nullIfEmpty(diagnosisData.getDISEASE_NAME()));         // 병명
            diagnosisValues.add(nullIfEmpty(diagnosisData.getONSET_DATE()));           // 발병 연월일
            diagnosisValues.add(nullIfEmpty(diagnosisData.getDIAGNOSIS_DATE()));       // 진단 연월일
            diagnosisValues.add(nullIfEmpty(diagnosisData.getMAIN_SYMPTOMS()));        // 주요 증상
            diagnosisValues.add(nullIfEmpty(diagnosisData.getTREATMENT_NAME()));       // 치료 명칭
            diagnosisValues.add(nullIfEmpty(diagnosisData.getADMISSION_DISCHARGE_DATE())); // 입원*퇴원일
            diagnosisValues.add(nullIfEmpty(diagnosisData.getPROGNOSIS()));            // 예후 소견
            diagnosisValues.add(nullIfEmpty(diagnosisData.getADDITIONAL_INFO()));      // 그 밖의 사항
            diagnosisValues.add(nullIfEmpty(diagnosisData.getCLINIC_NAME()));          // 동물병원 명칭
            diagnosisValues.add(nullIfEmpty(diagnosisData.getCLINIC_ADDRESS()));       // 동물병원 주소
            diagnosisValues.add(nullIfEmpty(diagnosisData.getPHONE_NUMBER()));         // 전화번호
            diagnosisValues.add(nullIfEmpty(diagnosisData.getLICENSE_NUMBER()));       // 면허번호
            diagnosisValues.add(nullIfEmpty(diagnosisData.getVET_NAME()));             // 수의사 성명

            jdbcTemplate.update(sql, diagnosisValues.toArray());
            return 1;
        }
        else
            return 0;
    }


    public String deleteDiagnosis(diagnosis diagnosisData) {
        StringBuilder sql = new StringBuilder("DELETE FROM diagnosis WHERE 1=1");
        List<Object> diagnosisValues = new ArrayList<>();
        int flag = 0;

        if (diagnosisData.getNAME() != null && !diagnosisData.getNAME().trim().isEmpty()) {
            sql.append(" AND NAME = ?");
            diagnosisValues.add(diagnosisData.getNAME());
            flag = 1;
        }

        if (diagnosisData.getADDRESS() != null && !diagnosisData.getADDRESS().trim().isEmpty()) {
            sql.append(" AND ADDRESS = ?");
            diagnosisValues.add(diagnosisData.getADDRESS());
            flag = 1;
        }

        if (diagnosisData.getPLACE_OF_CARE() != null && !diagnosisData.getPLACE_OF_CARE().trim().isEmpty()) {
            sql.append(" AND PLACE_OF_CARE = ?");
            diagnosisValues.add(diagnosisData.getPLACE_OF_CARE());
            flag = 1;
        }

        if (diagnosisData.getSPECIES() != null && !diagnosisData.getSPECIES().trim().isEmpty()) {
            sql.append(" AND SPECIES = ?");
            diagnosisValues.add(diagnosisData.getSPECIES());
            flag = 1;
        }

        if (diagnosisData.getBREED() != null && !diagnosisData.getBREED().trim().isEmpty()) {
            sql.append(" AND BREED = ?");
            diagnosisValues.add(diagnosisData.getBREED());
            flag = 1;
        }

        if (diagnosisData.getANIMAL_NAME() != null && !diagnosisData.getANIMAL_NAME().trim().isEmpty()) {
            sql.append(" AND ANIMAL_NAME = ?");
            diagnosisValues.add(diagnosisData.getANIMAL_NAME());
            flag = 1;
        }

        if (diagnosisData.getGENDER() != null && !diagnosisData.getGENDER().trim().isEmpty()) {
            sql.append(" AND GENDER = ?");
            diagnosisValues.add(diagnosisData.getGENDER());
            flag = 1;
        }

        if (diagnosisData.getAGE() != null && !diagnosisData.getAGE().trim().isEmpty()) {
            sql.append(" AND AGE = ?");
            diagnosisValues.add(diagnosisData.getAGE());
            flag = 1;
        }

        if (diagnosisData.getCOAT_COLOR() != null && !diagnosisData.getCOAT_COLOR().trim().isEmpty()) {
            sql.append(" AND COAT_COLOR = ?");
            diagnosisValues.add(diagnosisData.getCOAT_COLOR());
            flag = 1;
        }

        if (diagnosisData.getCHARACTERISTICS() != null && !diagnosisData.getCHARACTERISTICS().trim().isEmpty()) {
            sql.append(" AND CHARACTERISTICS = ?");
            diagnosisValues.add(diagnosisData.getCHARACTERISTICS());
            flag = 1;
        }

        if (diagnosisData.getDISEASE_NAME() != null && !diagnosisData.getDISEASE_NAME().trim().isEmpty()) {
            sql.append(" AND DISEASE_NAME = ?");
            diagnosisValues.add(diagnosisData.getDISEASE_NAME());
            flag = 1;
        }

        if (diagnosisData.getONSET_DATE() != null && !diagnosisData.getONSET_DATE().trim().isEmpty()) {
            sql.append(" AND ONSET_DATE = ?");
            diagnosisValues.add(diagnosisData.getONSET_DATE());
            flag = 1;
        }

        if (diagnosisData.getDIAGNOSIS_DATE() != null && !diagnosisData.getDIAGNOSIS_DATE().trim().isEmpty()) {
            sql.append(" AND DIAGNOSIS_DATE = ?");
            diagnosisValues.add(diagnosisData.getDIAGNOSIS_DATE());
            flag = 1;
        }

        if (diagnosisData.getMAIN_SYMPTOMS() != null && !diagnosisData.getMAIN_SYMPTOMS().trim().isEmpty()) {
            sql.append(" AND MAIN_SYMPTOMS = ?");
            diagnosisValues.add(diagnosisData.getMAIN_SYMPTOMS());
            flag = 1;
        }

        if (diagnosisData.getTREATMENT_NAME() != null && !diagnosisData.getTREATMENT_NAME().trim().isEmpty()) {
            sql.append(" AND TREATMENT_NAME = ?");
            diagnosisValues.add(diagnosisData.getTREATMENT_NAME());
            flag = 1;
        }

        if (diagnosisData.getADMISSION_DISCHARGE_DATE() != null && !diagnosisData.getADMISSION_DISCHARGE_DATE().trim().isEmpty()) {
            sql.append(" AND ADMISSION_DISCHARGE_DATE = ?");
            diagnosisValues.add(diagnosisData.getADMISSION_DISCHARGE_DATE());
            flag = 1;
        }

        if (diagnosisData.getPROGNOSIS() != null && !diagnosisData.getPROGNOSIS().trim().isEmpty()) {
            sql.append(" AND PROGNOSIS = ?");
            diagnosisValues.add(diagnosisData.getPROGNOSIS());
            flag = 1;
        }

        if (diagnosisData.getADDITIONAL_INFO() != null && !diagnosisData.getADDITIONAL_INFO().trim().isEmpty()) {
            sql.append(" AND ADDITIONAL_INFO = ?");
            diagnosisValues.add(diagnosisData.getADDITIONAL_INFO());
            flag = 1;
        }

        if (diagnosisData.getCLINIC_NAME() != null && !diagnosisData.getCLINIC_NAME().trim().isEmpty()) {
            sql.append(" AND CLINIC_NAME = ?");
            diagnosisValues.add(diagnosisData.getCLINIC_NAME());
            flag = 1;
        }

        if (diagnosisData.getCLINIC_ADDRESS() != null && !diagnosisData.getCLINIC_ADDRESS().trim().isEmpty()) {
            sql.append(" AND CLINIC_ADDRESS = ?");
            diagnosisValues.add(diagnosisData.getCLINIC_ADDRESS());
            flag = 1;
        }

        if (diagnosisData.getPHONE_NUMBER() != null && !diagnosisData.getPHONE_NUMBER().trim().isEmpty()) {
            sql.append(" AND PHONE_NUMBER = ?");
            diagnosisValues.add(diagnosisData.getPHONE_NUMBER());
            flag = 1;
        }

        if (diagnosisData.getLICENSE_NUMBER() != null && !diagnosisData.getLICENSE_NUMBER().trim().isEmpty()) {
            sql.append(" AND LICENSE_NUMBER = ?");
            diagnosisValues.add(diagnosisData.getLICENSE_NUMBER());
            flag = 1;
        }

        if (diagnosisData.getVET_NAME() != null && !diagnosisData.getVET_NAME().trim().isEmpty()) {
            sql.append(" AND VET_NAME = ?");
            diagnosisValues.add(diagnosisData.getVET_NAME());
            flag = 1;
        }

        if (flag == 1) {
            int success = jdbcTemplate.update(sql.toString(), diagnosisValues.toArray());
            if (success > 0) {
                return "데이터가 성공적으로 삭제되었습니다!";
            }
            else{
                return "데이터를 삭제하는데 실패하였습니다!";
            }
        }
        else {
            return "삭제할 데이터를 입력해 주세요!";
        }
    }

    public void recommend(String name){
        String sql = "UPDATE hospital SET recommendation_count = recommendation_count + 1 WHERE hospital_name = ?";
        int rowsAffected = jdbcTemplate.update(sql, name);
    }
}