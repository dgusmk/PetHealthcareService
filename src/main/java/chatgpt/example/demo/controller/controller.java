package chatgpt.example.demo.controller;

import chatgpt.example.demo.model.diagnosis;
import chatgpt.example.demo.model.hospital;
import chatgpt.example.demo.model.pet_profile;
import chatgpt.example.demo.model.user_profile;
import chatgpt.example.demo.repository.PetRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Controller
public class controller {

    private final OpenAiChatClient chatClient;
    private final PetRepository repository;

    @Autowired
    public controller(OpenAiChatClient chatClient, PetRepository repository) {
        this.chatClient = chatClient;
        this.repository = repository;
    }

    @GetMapping("/ai/generate")
    @ResponseBody
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        System.out.println("Roblox api connect request");
        return Map.of("generation", chatClient.call(message));
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.stream(prompt);
    }

    @RequestMapping("")
    public String home() {
        return "home";
    }

    @RequestMapping("/userprofile")
    public String view_user_profile(Model model) {
        List<user_profile> userlist = repository.findUP();
        model.addAttribute("user_profile", userlist);
        return "userprofile";
    }


    @RequestMapping("/userprofile/search")
    public String search_user_profile(@ModelAttribute user_profile userProfile, Model model) {
        List<user_profile> userlist = repository.searchUP(userProfile);
        model.addAttribute("user_profile", userlist);
        return "userprofile";
    }

    @RequestMapping("/userprofile/insert")
    public String insert_user_profile(@ModelAttribute user_profile userProfile, Model model) {
        try {
            // repository.insertUP() 호출
            repository.insertUP(userProfile);
            model.addAttribute("errorMessage", "데이터가 성공적으로 입력되었습니다!");
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "잘못된 데이터를 입력하였습니다!");
        }
        List<user_profile> userlist = repository.findUP();
        model.addAttribute("user_profile", userlist);
        return "userprofile";
    }

    @RequestMapping("/userprofile/delete")
    public String delete_user_profile(@ModelAttribute user_profile userProfile, Model model) {
        try {
            // repository.deleteUP() 호출
            String message = repository.deleteUP(userProfile);
            model.addAttribute("errorMessage", message);
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "오류가 발생하였습니다!");
        }
        List<user_profile> userlist = repository.findUP();
        model.addAttribute("user_profile", userlist);
        return "userprofile";
    }

    @RequestMapping("/petprofile")
    public String view_pet_profile(Model model) {
        List<pet_profile> petlist = repository.findPP();
        model.addAttribute("pet_profile", petlist);
        return "petprofile";
    }

    @RequestMapping("/petprofile/search")
    public String search_pet_profile(@ModelAttribute pet_profile petProfile, Model model) {
        List<pet_profile> petlist = repository.searchPP(petProfile);
        model.addAttribute("pet_profile", petlist);
        return "petprofile";
    }

    @RequestMapping("/petprofile/insert")
    public String insert_pet_profile(@ModelAttribute pet_profile petProfile, Model model) {
        try {
            // repository.insertPP() 호출
            repository.insertPP(petProfile);
            model.addAttribute("errorMessage", "데이터가 성공적으로 입력되었습니다!");
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "잘못된 데이터를 입력하였습니다!");
        }
        List<pet_profile> petlist = repository.findPP();
        model.addAttribute("pet_profile", petlist);
        return "petprofile";
    }

    @RequestMapping("/petprofile/delete")
    public String delete_pet_profile(@ModelAttribute pet_profile petProfile, Model model) {
        try {
            // repository.deletePP() 호출
            String message = repository.deletePP(petProfile);
            model.addAttribute("errorMessage", message);
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "오류가 발생하였습니다!");
        }
        List<pet_profile> petlist = repository.findPP();
        model.addAttribute("pet_profile", petlist);
        return "petprofile";
    }


    @RequestMapping("/hospital")
    public String view_pet_data(Model model) {
        List<hospital> hospitalList = repository.findHospital();
        model.addAttribute("hospital", hospitalList);
        return "hospital";
    }

    @RequestMapping("/hospital/search")
    public String search_hospital(@ModelAttribute hospital hospital, Model model) {
        List<hospital> hospitalList = repository.searchHospital(hospital);
        model.addAttribute("hospital", hospitalList);
        return "hospital";
    }

    @RequestMapping("/hospital/insert")
    public String insert_hospital(@ModelAttribute hospital hospital, Model model) {
        try {
            // repository.insertHospital() 호출
            repository.insertHospital(hospital);
            model.addAttribute("errorMessage", "데이터가 성공적으로 입력되었습니다!");
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "잘못된 데이터를 입력하였습니다!");
        }
        List<hospital> hospitalList = repository.findHospital();
        model.addAttribute("hospital", hospitalList);
        return "hospital";
    }

    @RequestMapping("/hospital/delete")
    public String delete_hospital(@ModelAttribute hospital hospital, Model model) {
        try {
            // repository.deleteHospital() 호출
            String message = repository.deleteHospital(hospital);
            model.addAttribute("errorMessage", message);
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "오류가 발생하였습니다!");
        }
        List<hospital> hospitalList = repository.findHospital();
        model.addAttribute("hospital", hospitalList);
        return "hospital";
    }

    @RequestMapping("/diagnosis")
    public String view_diagnosis_data(Model model) {
        List<diagnosis> diagnosisList = repository.findDiagnosis();
        model.addAttribute("diagnosis_data", diagnosisList);
        return "diagnosis";
    }

    @RequestMapping("/diagnosis/search")
    public String search_diagnosis_data(@ModelAttribute diagnosis diagnosisData, Model model) {
        List<diagnosis> diagnosisList = repository.searchDiagnosis(diagnosisData);
        model.addAttribute("diagnosis_data", diagnosisList);
        return "diagnosis";
    }

    @RequestMapping("/diagnosis/insert")
    public String insert_diagnosis_data(@ModelAttribute diagnosis diagnosisData, Model model) {
        try {
            // repository.insertDiagnosis() 호출
            int empty = repository.insertDiagnosis(diagnosisData);
            if (empty == 1)
                model.addAttribute("errorMessage", "데이터가 성공적으로 입력되었습니다!");
            else
                model.addAttribute("errorMessage", "데이터가 입력되지 않았습니다!");
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "잘못된 데이터를 입력하였습니다!");
        }
        List<diagnosis> diagnosisList = repository.findDiagnosis();
        model.addAttribute("diagnosis_data", diagnosisList);
        return "diagnosis";
    }

    @RequestMapping("/diagnosis/delete")
    public String delete_diagnosis_data(@ModelAttribute diagnosis diagnosisData, Model model) {
        try {
            // repository.deleteDiagnosis() 호출
            String message = repository.deleteDiagnosis(diagnosisData);
            model.addAttribute("errorMessage", message);
        } catch (Exception e) {
            // 예외 발생 시 오류 메시지 전달
            model.addAttribute("errorMessage", "오류가 발생하였습니다!");
        }
        List<diagnosis> diagnosisList = repository.findDiagnosis();
        model.addAttribute("diagnosis_data", diagnosisList);
        return "diagnosis";
    }

    @RequestMapping("/imageUploader")
    public String imageUploader() {
        return "imageProcess";
    }

    @RequestMapping("/symptomClassification")
    public String symptomClassification() {
        return "symptomClassification";
    }

    @RequestMapping("/symptomClassification/test")
    public String test(@RequestParam("SYMPTOM") String symptom, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/classification";
        url = url + "?text=" + symptom;

        try {
            // GET 요청 보내기
            String response = restTemplate.getForObject(url, String.class);
            // Json 데이터를 처리하여 텍스트 추출
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response);
            String text = jsonNode.get("text").asText();
            // HTML 파일로 전달하기 위해 모델에 추가
            model.addAttribute("test", text);
        } catch (Exception e) {
            System.err.println("Request failed: " + e.getMessage());
        }
        return "symptomClassification";
    }

    @RequestMapping("/userImage")
    public String uploadUserImage() {
        return "userImage";
    }

}