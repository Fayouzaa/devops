package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.*;
import tn.esprit.spring.services.SkierServicesImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SkierServicesImplTest {

    @InjectMocks
    private SkierServicesImpl skierServices;

    @Mock
    private ISkierRepository skierRepository;

    @Mock
    private IPisteRepository pisteRepository;

    @Mock
    private ICourseRepository courseRepository;

    @Mock
    private IRegistrationRepository registrationRepository;

    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @Test
    public void testAddSkier() {
        Skier skier = new Skier();
        Subscription subscription = new Subscription();
        subscription.setTypeSub(TypeSubscription.ANNUAL); // Set the subscription type as needed
        skier.setSubscription(subscription);

        when(skierRepository.save(skier)).thenReturn(skier);

        Skier savedSkier = skierServices.addSkier(skier);

        assertNotNull(savedSkier);
        // Add more assertions as needed
    }

    @Test
    public void testAssignSkierToSubscription() {
        Long numSkier = 1L; // Set to the desired skier ID
        Long numSubscription = 2L; // Set to the desired subscription ID
        Skier skier = new Skier();
        Subscription subscription = new Subscription();

        when(skierRepository.findById(numSkier)).thenReturn(Optional.of(skier));
        when(subscriptionRepository.findById(numSubscription)).thenReturn(Optional.of(subscription));
        when(skierRepository.save(skier)).thenReturn(skier);

        Skier assignedSkier = skierServices.assignSkierToSubscription(numSkier, numSubscription);

        assertNotNull(assignedSkier);
        // Add more assertions as needed
    }

    // Add test cases for other methods similarly
}
