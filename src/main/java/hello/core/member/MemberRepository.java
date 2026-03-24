package hello.core.member;

public interface MemberRepository {
    //인터페이스 ,  구현체는 따로 만들어야함.
    void save(Member member);

    Member findById(Long memberId);
}
