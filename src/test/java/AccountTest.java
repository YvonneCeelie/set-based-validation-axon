import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.command.aggregate.Account;
import com.example.command.api.AccountCreatedEvent;
import com.example.command.api.CreateAccountCommand;

public class AccountTest {
    public static final UUID UUID = java.util.UUID.randomUUID();
    public static final String EMAIL_ADDRESS = "bob@gmail.com";
    private FixtureConfiguration<Account> fixture;

    @BeforeEach
    void setup() {
        fixture = new AggregateTestFixture<>(Account.class);
    }

    @Test
    void shouldCreateAccount() {
        fixture.givenNoPriorActivity()
               .when(new CreateAccountCommand(UUID, EMAIL_ADDRESS))
               .expectEvents(new AccountCreatedEvent(UUID, EMAIL_ADDRESS));
    }
}
