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

    public Member( String loginId, String memberName, String password) {
        this.loginId = loginId;
        this.memberName = memberName;
        this.password = password;
    }
}
