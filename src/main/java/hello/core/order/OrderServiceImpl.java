package hello.core.order;


import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final 붙은 필드에 대한 생성자를 만들어준다
public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private DiscountPolicy discountPolicy = new RateDiscountPolicy(); --DIP 위반
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    //수정자
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//
//        this.discountPolicy = discountPolicy;
//    }
//    //수정자
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

//    생성자
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {

        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트용
    public MemberRepository memberRepository() {
        return memberRepository;
    }
}
