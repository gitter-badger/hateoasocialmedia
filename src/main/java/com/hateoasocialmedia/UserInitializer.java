package com.hateoasocialmedia;

import com.hateoasocialmedia.user.User;
import com.hateoasocialmedia.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        populateTestUsers();
    }

    private void populateTestUsers() {
        List<User> users = new ArrayList<>();
        users.add(createUser("Jean-Luc", "Picard", "Jean-Luc Picard", "@Jean-Luc", "https://upload.wikimedia.org/wikipedia/en/2/20/Captain_Picard_Chair.jpg"));
        users.add(createUser("William", "Riker", "William Riker", "@NumberOne", null));
        users.add(createUser("Geordi", "La Forge", "Geordi La Forge", "@Geordi", null));
        users.add(createUser("Worf", null, "Worf", "@Worf", null));
        userRepository.save(users);
    }

    private User createUser(String theFirstName, String theLastName, String theDisplayName, String theHandle, String theUserImageUrl) {
        User aUser = new User();
        aUser.setFirstName(theFirstName);
        aUser.setLastName(theLastName);
        aUser.setUserDisplayName(theDisplayName);
        aUser.setHandle(theHandle);
        aUser.setUserImageUrl(theUserImageUrl);
        return aUser;
    }
}
