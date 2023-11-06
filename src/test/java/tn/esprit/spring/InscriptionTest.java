package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISkierRepository;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.SubscriptionServicesImpl;



    @SpringBootTest
    @ExtendWith(MockitoExtension.class)

    public class InscriptionTest {
        @InjectMocks
        private SubscriptionServicesImpl subscriptionServices;

        @Mock
        private ISubscriptionRepository subscriptionRepository;

        @Mock
        private ISkierRepository skierRepository;

        @Test
        public void testAddSubscription() {
            Subscription subscription = new Subscription();
            subscription.setStartDate(LocalDate.now());
            subscription.setTypeSub(TypeSubscription.MONTHLY);

            when(subscriptionRepository.save(subscription)).thenReturn(subscription);

            Subscription savedSubscription = subscriptionServices.addSubscription(subscription);

            assertNotNull(savedSubscription);

        }

        @Test
        public void testUpdateSubscription() {
            Subscription subscription = new Subscription();


            when(subscriptionRepository.save(subscription)).thenReturn(subscription);

            Subscription updatedSubscription = subscriptionServices.updateSubscription(subscription);

            assertNotNull(updatedSubscription);

        }

        @Test
        public void testRetrieveSubscriptionById() {
            Long numSubscription = 1L;
            Subscription subscription = new Subscription();


            when(subscriptionRepository.findById(numSubscription)).thenReturn(Optional.of(subscription));

            Subscription retrievedSubscription = subscriptionServices.retrieveSubscriptionById(numSubscription);

            assertNotNull(retrievedSubscription);

        }

        @Test
        public void testGetSubscriptionByType() {
            TypeSubscription type = TypeSubscription.MONTHLY;
            Set<Subscription> subscriptions = new HashSet<>();

            when(subscriptionRepository.findByTypeSubOrderByStartDateAsc(type)).thenReturn(subscriptions);

            Set<Subscription> retrievedSubscriptions = subscriptionServices.getSubscriptionByType(type);

            assertNotNull(retrievedSubscriptions);
            // Add more assertions as needed
        }

        @Test
        public void testRetrieveSubscriptionsByDates() {
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = LocalDate.now().plusMonths(3);
            List<Subscription> subscriptions = new ArrayList<>();

            when(subscriptionRepository.getSubscriptionsByStartDateBetween(startDate, endDate)).thenReturn(subscriptions);

            List<Subscription> retrievedSubscriptions = subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate);

            assertNotNull(retrievedSubscriptions);
            // Add more assertions as needed
        }

        // Add test cases for the scheduled methods if needed
    }


