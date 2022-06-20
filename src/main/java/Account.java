public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name != null) {
            return (name.length() >= 3 &&
                    name.length() <= 19 &&
                    name.matches("\\p{L}+\\s\\p{L}+"));
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "name = '" + name + '\'';
    }
}
