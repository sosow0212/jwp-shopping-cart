package cart.domain.member;

public class Member {

    private Long id;
    private final Email email;
    private final Password password;

    private Member(final Long id, final Email email, final Password password) {
        this.email = email;
        this.password = password;
    }

    public static Member from(final Long id, final String email, final String password) {
        return new Member(id, new Email(email), new Password(password));
    }

    public static Member from(final String email, final String password) {
        return new Member(null, new Email(email), new Password(password));
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getPassword() {
        return password.getPassword();
    }
}
