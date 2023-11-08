package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import lotto.constants.ErrorMessages;

public class UserInputHandler {
    private static final LinkedList<Void> taskQueue = new LinkedList<>();

    public static Integer getLottoPurchaseAmount() {
        Integer amount = 0;
        do {
            try {
                currentTaskStart();
                amount = convertToInteger(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                addTask();
            }
        } while (isNotEndTask());

        return amount;
    }

    private static boolean isNotEndTask() {
        return !taskQueue.isEmpty();
    }

    private static void currentTaskStart() {
        taskQueue.poll();
    }

    private static void addTask() {
        taskQueue.add(null);
    }

    private static Integer convertToInteger(String userInput) {
        NumberValidator.verifyNumberType(userInput, ErrorMessages.LLOTTO_PURCHASE_AMOUNT_NUMERIC_ONLY);
        return Integer.parseInt(userInput);
    }
}
