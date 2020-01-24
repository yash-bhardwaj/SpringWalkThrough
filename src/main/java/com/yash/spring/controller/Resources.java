package com.yash.spring.controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yash.spring.impl.Executor;
import com.yash.spring.impl.RestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenge")
public class Resources {

    @Autowired
    Executor executor;

    @GetMapping("/input")
    public ResponseEntity<String> getInput(@RequestHeader String userId) {
        System.out.println(userId);
        System.out.println("=>>>>>>>>>>>>>>>>>>>>>>>");
        final String body = "{\n" + "        \"input\": {\n"
                + "            \"text\": \"This specification does not indicate the behavior, rendering or otherwise, of space characters other than those explicitly identified here as white space characters. For this reason, authors should use appropriate elements and styles to achieve visual formatting effects that involve white space, rather than space characters.For all HTML elements except PRE, sequences of white space separate 'words' (we use the term 'word' here to mean 'sequences of non-white space characters'). When formatting text, user agents should identify these words and lay them out according to the conventions of the particular written language (script) and target medium.\"\n"
                + "        }\n" + "    }";
        return ResponseEntity.ok(body);
    }

    @PostMapping("/output")
    public ResponseEntity<String> getOutput(@RequestBody final String request, @RequestHeader String userId) {
        System.out.println(userId);
        System.out.println(request);
        final String body = "{\n" + "        \"output\": {\n" + "            \"count\": 653\n" + "        }\n" + "    }";
        return ResponseEntity.ok(body);
    }

    @GetMapping("/execute")
    public ResponseEntity<String> execute(@RequestHeader String userId) throws IOException {
        System.out.println(userId);
        final String body = executor.execute();
        return ResponseEntity.ok(body);
    }
}
