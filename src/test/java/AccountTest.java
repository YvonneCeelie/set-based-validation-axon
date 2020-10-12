import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.command.aggregate.Account;
import com.example.command.api.AccountCreatedEvent;
import com.example.command.api.ChangeEmailAddressCommand;
import com.example.command.api.CreateAccountCommand;
import com.example.command.api.EmailAddressChangedEvent;
import com.example.command.persistence.EmailJpaEntity;

public class AccountTest {
    public static final UUID UUID = java.util.UUID.randomUUID();
    public static final String EMAIL_ADDRESS = "bob@gmail.com";
    public static final String EMAIL_ADDRESS_CHANGED = "bob2@gmail.com";

    private FixtureConfiguration<Account> fixture;

    @BeforeEach
    void setup() {
        fixture = new AggregateTestFixture<>(Account.class);
        fixture.registerInjectableResource(new EmailJpaEntity(EMAIL_ADDRESS, UUID));
    }

    @Test
    void shouldCreateAccount() {
        fixture.givenNoPriorActivity()
               .when(new CreateAccountCommand(UUID, EMAIL_ADDRESS))
               .expectEvents(new AccountCreatedEvent(UUID, EMAIL_ADDRESS));
    }

    @Test
    void shouldUpdateEmailAddress() {
        fixture.given(new AccountCreatedEvent(UUID, EMAIL_ADDRESS))
               .when(new ChangeEmailAddressCommand(UUID, EMAIL_ADDRESS_CHANGED))
               .expectEvents(new EmailAddressChangedEvent(UUID, EMAIL_ADDRESS_CHANGED));
    }

    @Test
    void shouldNotUpdateDuplicateEmailAddress() {
        fixture.given(new AccountCreatedEvent(UUID, EMAIL_ADDRESS))
               .when(new ChangeEmailAddressCommand(UUID, EMAIL_ADDRESS))
               .expectNoEvents();
    }


}
