package com.example.hello.controller;


import com.example.hello.dto.UserRequest;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSOutput;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String Hello(){

        return "get Hello";
    }

    //get / post / put /delete 모두 걸림
    @RequestMapping(path = "/allHi")
    public String allHi(){
        return "allHi";
    }

    //get http:localhost:9090/api/get/hi
    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    //path에는 대소문자 구분이 안되기 떄문에 가독서을 위해 - 사용
    // http:localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("pathVariable : " + name);

        return name;
    }
//변수명을 다르게 받아오고 싶을 땐 아래와 같이 사용
/*    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String Rname){
        System.out.println("pathVariable : " + Rname);

        return Rname;
    }*/

    //쿼리 파라미터 -> 주소창에 ?붙으면서 키와 value형태로 붙은 것

    // http:localhost:9090/api/get/query-param?user=steve&mail=steve@name
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

            StringBuilder sb = new StringBuilder();

            queryParam.entrySet().forEach( entry -> {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("\n");

                sb.append(entry.getKey() + " = "+entry.getValue()+ "\n");
            });

        return sb.toString();
    }
    @GetMapping("query-param02")
    public String queryParam02(@RequestParam String name,@RequestParam String email, @RequestParam int age){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }
}
