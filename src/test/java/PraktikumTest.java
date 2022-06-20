import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
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

    @Parameterized.Parameters(name = "{index}:  CardHolderName: {0}, expected: {1}")
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
                {"", false},
                {null, false},
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

    @Step("Проверка <" + "{account.name}" + "> для эмбоссирования")
    private void assertString(Account account) {
        Assert.assertEquals(expectedCheckNameToEmboss, account.checkNameToEmboss());
    }
}