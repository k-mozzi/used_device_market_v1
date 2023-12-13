package teamproject.usedmarket.web.login;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import teamproject.usedmarket.domain.login.LoginService;
import teamproject.usedmarket.domain.member.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Data
@Controller
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인 화면
     * th:object 사용을 위해 loginForm을 넘김
     */
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "login/loginForm";
    }

    /**
     * 로그인 기능
     * 중복 아이디면 로그인 화면으로 돌아감
     */
    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm,
                        BindingResult bindingResult, HttpServletResponse response) {

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        //로그인 실패 로직
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("errors={}", bindingResult);
            return "login/loginForm";
        }

        //로그인 성공 처리
        //쿠키에 시간 정보를 주지 않으면 세션 쿠키로 설정됨(브라우저 종료시 모두 종료)
        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getLoginId()));
        response.addCookie(idCookie);
        return "loginSuccess";
    }
}
