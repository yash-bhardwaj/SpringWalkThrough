package com.yash.spring.impl;

import java.io.IOException;

import com.yash.spring.controller.model.OutputSentenceCount;
import com.yash.spring.controller.model.OutputVowelCount;
import com.yash.spring.controller.model.SentenceCount;
import com.yash.spring.controller.model.TextModel;
import com.yash.spring.controller.model.VowelCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Executor {

    @Autowired
    RestHandler restHandler;

    public String execute() throws IOException {
        final TextModel inputBody = restHandler.getInputBody();
        System.out.println(inputBody);
        final VowelCount count = getCharacterCount(inputBody.getText());
        System.out.println(count);
        final OutputVowelCount outputCharCount = new OutputVowelCount();
        outputCharCount.setOutput(count);
        System.out.println(outputCharCount);
        final String body = restHandler.postInputBody(outputCharCount);
        System.out.println(body);
        return body;
//        return null;
    }

    private VowelCount getCharacterCount(final String text) {
        final VowelCount countChar = new VowelCount();
        //countChar.setCount(text.toCharArray().questions);
        final char[] replace = text.toLowerCase().toCharArray();
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        for (final char c : replace) {
            switch (c) {
                case 'a' : ++a; break;
                case 'e' : ++e; break;
                case 'i' : ++i; break;
                case 'o' : ++o; break;
                case 'u' : ++u; break;
                default:
                    System.out.println("Not a vowel");
            }
         }
        countChar.setA(a);
        countChar.setE(e);
        countChar.setI(i);
        countChar.setO(o);
        countChar.setU(u);
        return countChar;
    }
}
