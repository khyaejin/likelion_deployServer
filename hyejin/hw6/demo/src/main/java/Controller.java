import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.response.CustomAPIResponse;

@RestController
@RequestMapping("/api")
public class Controller{

    @GetMapping("/hello")
    public ResponseEntity<CustomAPIResponse<?>> printSubmissionNotice() {
        CustomAPIResponse<?> res = CustomAPIResponse.createSuccess(HttpStatus.OK.value(), null, "김혜진 hw6 과제 제출합니다.");
        return ResponseEntity.ok(res);
    }
}