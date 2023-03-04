package factories;

import com.github.javafaker.Faker;
import lombok.var;
import models.client;
import utilities.TimestampBuilder;

public class ClientFactory {

    //private static final String DEFAULT_PASSWORD = "thesecret";
    private static final Faker faker;

    static {
        faker = new Faker();
    }

    public static client createDefault() {
        var cl = new client();

        cl.setFirstName(faker.name().firstName());
        cl.setLastName(faker.name().lastName());
        cl.setEmail(TimestampBuilder.buildUniqueTextByPrefix(faker.internet().safeEmailAddress()));
        cl.getMySelf();
        cl.getInterMediaries();
        cl.getMyBusiness();
        return cl;
    }

}
