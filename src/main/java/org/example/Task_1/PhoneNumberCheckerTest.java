package org.example.Task_1;

import java.io.File;

public class PhoneNumberCheckerTest {
    public static void main(String[] args) {
        PhoneNumberChecker phoneNumberChecker = new PhoneNumberCheckerImpl(new File("src/files/task_1.txt"));
        phoneNumberChecker.doChecking();
    }
}
