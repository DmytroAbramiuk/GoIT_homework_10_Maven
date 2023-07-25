package org.example.Task_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNumberCheckerImpl implements PhoneNumberChecker{
    private final File file;

    public PhoneNumberCheckerImpl(File file) {
        this.file = file;
    }

    private boolean isValid(String phoneNumber) {
        if (phoneNumber.length() != 12 && phoneNumber.length() != 14) {
            return false;
        }

        if (phoneNumber.charAt(0) == '(' && phoneNumber.charAt(4) == ')' && phoneNumber.charAt(5) == ' ' && phoneNumber.charAt(9) == '-') {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (i != 0 && i != 4 && i != 5 && i != 9 && !Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
        } else if (phoneNumber.charAt(3)=='-' && phoneNumber.charAt(7)=='-') {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (i != 3 && i != 7 && !Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public void doChecking(){
        String currentNumber;

        try (Scanner scanner = new Scanner(new FileInputStream(file))){
            while (scanner.hasNextLine()) {
                currentNumber = scanner.nextLine();

                if(isValid(currentNumber)){
                    System.out.println(currentNumber);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
