package kr.project.userfeature.user.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import kr.project.userfeature.core.validation.annotation.EmailPattern;
import kr.project.userfeature.core.validation.annotation.PasswordPattern;
import kr.project.userfeature.core.validation.annotation.PhoneNumberPattern;
import kr.project.userfeature.user.domain.code.RoleType;
import kr.project.userfeature.verify.domain.code.VerifyUsage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Accessors(chain = true)
@Getter
@Setter
@ToString
public class UserRequest {

    @JsonView
    private Long userId;

    @Schema(description = "패스워드", example = "dfgdf1234")
    @PasswordPattern(groups = UserView.Create.class)
    @JsonView(UserView.Create.class)
    private String password;

    @Schema(description = "닉네임", example = "닉네임을위행")
    @JsonView({UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    @NotBlank(groups = {UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    private String nickname;

    @Schema(description = "이름", example = "이름을위행")
    @JsonView({UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    @NotBlank(groups = {UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    private String name;

    @Schema(description = "이메일", example = "test@gmaisss.com")
    @EmailPattern(groups = {UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    @JsonView({UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    private String email;

    @Schema(description = "이메일 인증아이디")
    @JsonView({UserView.Update.class, UserView.MyInfo.class})
    private Long emailVerifyId;

    @Schema(description = "핸드폰번호", example = "01911112222")
    @JsonView({UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    @PhoneNumberPattern(groups = {UserView.Create.class, UserView.Update.class, UserView.MyInfo.class})
    private String phoneNumber;

    @Schema(description = "핸드폰번호 인증아이디")
    @JsonView({UserView.Update.class, UserView.MyInfo.class})
    private Long phoneNumberVerifyId;

    @JsonView
    private RoleType roleType;

    @JsonView
    private VerifyUsage verifyUsage;

}