public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return (name.length() >= 3 &&
                name.length() <= 19 &&
                name.matches("\\p{L}+\\s\\p{L}+"));
    }
}
