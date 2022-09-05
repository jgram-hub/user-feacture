package kr.submit.userfeature.user.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.submit.userfeature.core.security.dto.UserPrincipal;
import kr.submit.userfeature.core.security.service.SecurityUserDetailService;
import kr.submit.userfeature.user.application.UserService;
import kr.submit.userfeature.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "나의 정보")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/my-info")
public class MyInfoController {

    private final UserService userService;
    private final SecurityUserDetailService userDetailService;

    @Operation(summary = "나의정보 조회")
    @GetMapping("/")
    public UserResponse findByMyInfo(@AuthenticationPrincipal UserPrincipal principal) {
        return userService.findByUserId(principal.getUserId());
    }

    @Operation(summary = "패스워드 수정")
    @PatchMapping("/password/{password}")
    public void updatePassword(@PathVariable Long userId, @PathVariable String password, @AuthenticationPrincipal UserPrincipal principal) {
        userDetailService.updatePassword(principal, password);
    }
}