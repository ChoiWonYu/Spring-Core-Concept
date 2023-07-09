package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository=new MemoryMemberRepository();

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
