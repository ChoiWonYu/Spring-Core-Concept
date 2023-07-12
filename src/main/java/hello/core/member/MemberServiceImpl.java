package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //테스트용 코드
    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        return;
    }

    @Override
    public Member findMember(Long memberId) {
        Member member = memberRepository.findById(memberId);
        return member;
    }
}
