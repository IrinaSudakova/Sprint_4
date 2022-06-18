import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PraktikumTest {
    private final String name;
    private final boolean expectedCheckNameToEmboss;

    public PraktikumTest(String name, boolean expectedCheckNameToEmboss) {
        this.name = name;
        this.expectedCheckNameToEmboss = expectedCheckNameToEmboss;
    }

    @Parameterized.Parameters (name = "{index}:  CardHolderName: {0}, expected: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Ирина Иванова", true},
                {"Ирина  Иванова", false},
                {" Ирина Иванова", false},
                {"Ирина Иванова ", false},
                {"ИринаИванова", false},
                {" ИринаИванова", false},
                {"ИринаИванова ", false},
                {"И Л", true},
                {"ИЛ", false},
                {"Ирина ЛучшаяПрелучш", true},
                {"Ирина ЛучшаяПрелучшя", false},
        };
    }

    @Test
    public void paramTest() {
        assertString(createAccount());
    }

    @Step("Создать строку на карте")
    private Account createAccount() {
        return new Account(name);
    }
    @Step("Проверить строку '{account.name}'")
    private void assertString(Account account) {
        Assert.assertEquals(expectedCheckNameToEmboss, account.checkNameToEmboss());

    }
}