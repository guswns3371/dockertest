package com.example.dockertest;

import com.mysql.cj.log.LogFactory;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberRepository memberRepository;

    @GetMapping("/save")
    public void test(){
        Member m1 = new Member("m1");
        memberRepository.save(m1);
    }

    @GetMapping("/get")
    public String getM1() {
        return memberRepository.findAll().toString();
    }

    @GetMapping("/")
    public String hello() {
        return "docker hello";
    }

    @GetMapping("/v2")
    public String docker_jenkins() {
        logger.trace("Trace Level 테스트");
        logger.debug("DEBUG Level 테스트");
        logger.info("INFO Level 테스트");
        logger.warn("Warn Level 테스트");
        logger.error("ERROR Level 테스트");

        return "docker jenkins success!!";
    }
}
