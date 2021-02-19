package com.example.dockertest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
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
        return "docker jenkins success!!";
    }
}
