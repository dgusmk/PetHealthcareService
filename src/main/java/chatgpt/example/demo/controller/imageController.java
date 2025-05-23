package chatgpt.example.demo.controller;
import chatgpt.example.demo.model.diagnosis;
import chatgpt.example.demo.repository.PetRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class imageController {

    private final PetRepository repository;
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    public imageController(PetRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<JsonNode> uploadImage(@RequestParam("imageFile") MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (file.isEmpty()) {
            ObjectNode imageError = objectMapper.createObjectNode();
            imageError.put("error", "파일이 없습니다.");
            return new ResponseEntity<>(imageError, HttpStatus.BAD_REQUEST);
        }

        try {
            // 업로드 디렉토리가 없으면 생성
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // 파일 저장 경로 설정
            Path filePath = Paths.get(uploadDir + "userImage.jpg");
            Files.write(filePath, file.getBytes());


            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8000/extraction";

            try {
                // GET 요청 보내기
                String response = restTemplate.getForObject(url, String.class);
                // Json 데이터를 처리하여 텍스트 추출
                JsonNode jsonNode = objectMapper.readTree(response);

                // String text = jsonNode.get("text").asText();
                return new ResponseEntity<JsonNode>(jsonNode, HttpStatus.OK);
            } catch (Exception e) {
                System.err.println("Request failed: " + e.getMessage());
                ObjectNode processError = objectMapper.createObjectNode();
                processError.put("error", "프로세스에 문제가 발생했습니다..");
                return new ResponseEntity<>(processError, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            ObjectNode processError = objectMapper.createObjectNode();
            processError.put("error", "프로세스에 문제가 발생했습니다..");
            return new ResponseEntity<>(processError, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/image/insert")
    public String submitDiagnosis(
            @RequestParam("성명") String name,
            @RequestParam("주소") String address,
            @RequestParam("사육장소") String placeOfCare,
            @RequestParam("종류") String species,
            @RequestParam("품종") String breed,
            @RequestParam("동물명(동물등록번호)") String animalName,
            @RequestParam("성별") String gender,
            @RequestParam("연령") String age,
            @RequestParam("모색") String coatColor,
            @RequestParam("특징") String characteristics,
            @RequestParam("병명") String diseaseName,
            @RequestParam("발병 연월일") String onsetDate,
            @RequestParam("진단 연월일") String diagnosisDate,
            @RequestParam("주요 증상") String mainSymptoms,
            @RequestParam("치료 명칭") String treatmentName,
            @RequestParam("입원*퇴원일") String admissionDischargeDate,
            @RequestParam("예후 소견") String prognosis,
            @RequestParam("그 밖의 사항") String additionalInfo,
            @RequestParam("동물병원 명칭") String clinicName,
            @RequestParam("동물병원 주소") String clinicAddress,
            @RequestParam("전화번호") String phoneNumber,
            @RequestParam("면허번호") String licenseNumber,
            @RequestParam("수의사 성명") String vetName
    ) {
        diagnosis Diagnosis = new diagnosis();
        Diagnosis.setNAME(name);
        Diagnosis.setADDRESS(address);
        Diagnosis.setPLACE_OF_CARE(placeOfCare);
        Diagnosis.setSPECIES(species);
        Diagnosis.setBREED(breed);
        Diagnosis.setANIMAL_NAME(animalName);
        Diagnosis.setGENDER(gender);
        Diagnosis.setAGE(age);
        Diagnosis.setCOAT_COLOR(coatColor);
        Diagnosis.setCHARACTERISTICS(characteristics);
        Diagnosis.setDISEASE_NAME(diseaseName);
        Diagnosis.setONSET_DATE(onsetDate);
        Diagnosis.setDIAGNOSIS_DATE(diagnosisDate);
        Diagnosis.setMAIN_SYMPTOMS(mainSymptoms);
        Diagnosis.setTREATMENT_NAME(treatmentName);
        Diagnosis.setADMISSION_DISCHARGE_DATE(admissionDischargeDate);
        Diagnosis.setPROGNOSIS(prognosis);
        Diagnosis.setADDITIONAL_INFO(additionalInfo);
        Diagnosis.setCLINIC_NAME(clinicName);
        Diagnosis.setCLINIC_ADDRESS(clinicAddress);
        Diagnosis.setPHONE_NUMBER(phoneNumber);
        Diagnosis.setLICENSE_NUMBER(licenseNumber);
        Diagnosis.setVET_NAME(vetName);

        String errorMessage;
        try {
            // repository.insertDiagnosis() 호출
            repository.insertDiagnosis(Diagnosis);
            errorMessage = "데이터가 성공적으로 입력되었습니다!";
            return errorMessage;
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            errorMessage = "잘못된 데이터를 입력하였습니다!";
            return errorMessage;
        }

    }

    @RequestMapping("/symptomClassification/roblox")
    public Map<String, Object> restfulTest(@RequestBody Map<String, Object> text) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/classification";
        url = url + "?text=" + text.get("symptoms");
        System.out.println(url);

        try {
            // GET 요청 보내기
            String response = restTemplate.getForObject(url, String.class);
            // Json 데이터를 처리하여 텍스트 추출
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);
            String classifiedText = jsonNode.get("text").asText();
            System.out.println(classifiedText);
            Map<String, Object> result = new HashMap<>();
            result.put("symptoms", classifiedText);
            return result;
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<>();
            System.err.println("Failed to parse JSON response: ");
            result.put("symptoms", "Request Failed");
            return result;
        }
    }

    @GetMapping("/recommend")
    public void recommend(@RequestParam(value = "name") String name) {
        repository.recommend(name);
    }
}