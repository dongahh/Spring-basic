package hello.core.Member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        //memberRepository 구현체에 뭐가 들어갈지 생성자를 통해서 얻어올 수 있음.
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
