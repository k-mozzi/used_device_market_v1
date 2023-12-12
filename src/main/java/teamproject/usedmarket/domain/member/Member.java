package teamproject.usedmarket.domain.member;

import lombok.Data;

@Data
public class Member {

    private Long memberId;
    private String loginId;
    private String memberName;
    private String password;

    public Member() {
    }

    public Member(Long memberId, String loginId, String memberName, String password) {
        this.memberId = memberId;
        this.loginId = loginId;
        this.memberName = memberName;
        this.password = password;
    }
}
