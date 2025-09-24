package se.jensen.robin.tarningsspel;

public class Player {

    String firstName;
    String lastName;
    int score = 0;

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal first name please try again!");
        } else {
            this.firstName = name;
        }
    }

    public void setLastName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Illegal last name please try again!");
        } else {
            this.lastName = name;
        }
    }

    public int addToScore(int score) {
        this.score += score;
        return score;
    }

    public int getScore() {
        return this.score;
    }
}
