package com.example.complexeSportif.services.Impl;

import com.example.complexeSportif.entities.Enum.PaymentType;
import com.example.complexeSportif.entities.Enum.SubscriptionType;
import com.example.complexeSportif.entities.Pool;
import com.example.complexeSportif.entities.SalleMuscu;
import com.example.complexeSportif.entities.Subscriptions;
import com.example.complexeSportif.repositories.PoolRepo;
import com.example.complexeSportif.repositories.SalleMuscuRepo;
import com.example.complexeSportif.repositories.SubscriptionRepo;
import com.example.complexeSportif.services.SubscriptionService;
import com.example.complexeSportif.user.User;
import com.example.complexeSportif.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImp implements SubscriptionService {

    private final SubscriptionRepo subscriptionRepo;
    private final UserRepo userRepository;
    private final SalleMuscuRepo salleMuscuRepository;
    private final PoolRepo poolRepository;
    @Override
    public List<Subscriptions> getAllSubscriptions() {
        return subscriptionRepo.findAll();
    }
    @Override

    public Optional<Subscriptions> getSubscriptionById(Long id) {
        return subscriptionRepo.findById(id);
    }
    @Override

    public Subscriptions saveSubscription(Subscriptions subscriptions) {
        return subscriptionRepo.save(subscriptions);
    }
    @Override

    public void deleteSubscription(Long id) {
        subscriptionRepo.deleteById(id);
    }

    // create a subscription

    @Override
    public Subscriptions createSubscription(Long userId, Long salleMuscuId, Long poolId, SubscriptionType subscriptionType) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé"));

        SalleMuscu salleMuscu = null;
        Pool pool = null;

        if (salleMuscuId != null) {
            salleMuscu = salleMuscuRepository.findById(salleMuscuId)
                    .orElseThrow(() -> new IllegalArgumentException("Salle de musculation non trouvée"));
        }

        if (poolId != null) {
            pool = poolRepository.findById(poolId)
                    .orElseThrow(() -> new IllegalArgumentException("Piscine non trouvée"));
        }

        double costs = calculateCosts(subscriptionType, salleMuscu, pool); // Calculer les coûts en fonction du type d'abonnement et des options de pack

        Date dateStart = new Date(); // Date de début de l'abonnement
        Date dateEnd = calculateEndDate(dateStart, subscriptionType); // Calculer la date de fin de l'abonnement

        Subscriptions subscription = Subscriptions.builder()
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .costs(costs)
                .subscriptionType(subscriptionType)
                .paymentType(PaymentType.CREDIT_CARD) // Exemple de type de paiement
                .user(user)
                .salleMuscu(salleMuscu)
                .pool(pool)
                .build();

        return subscriptionRepo.save(subscription);
    }

    private double calculateCosts(SubscriptionType subscriptionType, SalleMuscu salleMuscu, Pool pool) {
        // Implémenter la logique pour calculer les coûts en fonction du type d'abonnement et des options de pack
        double baseCost = getBaseCost(subscriptionType); // Coût de base en fonction de la durée de l'abonnement

        // Exemple simplifié : ajouter des coûts supplémentaires pour chaque option sélectionnée
        double additionalCost = 0.0;
        if (salleMuscu != null) {
            additionalCost += 50.0; // Coût supplémentaire pour l'accès à la salle de musculation
        }
        if (pool != null) {
            additionalCost += 30.0; // Coût supplémentaire pour l'accès à la piscine
        }

        return baseCost + additionalCost;
    }

    private double getBaseCost(SubscriptionType subscriptionType) {
        // Implémenter la logique pour récupérer le coût de base en fonction du type d'abonnement
        // Exemple simplifié avec un coût de base fixe pour chaque type d'abonnement
        switch (subscriptionType) {
            case ONE_MONTH:
                return 50.0;
            case THREE_MONTHS:
                return 120.0;
            case SIX_MONTHS:
                return 220.0;
            case ONE_YEAR:
                return 400.0;
            default:
                throw new IllegalArgumentException("Type d'abonnement non pris en charge: " + subscriptionType);
        }
    }

    private Date calculateEndDate(Date startDate, SubscriptionType subscriptionType) {
        // Implémenter la logique pour calculer la date de fin en fonction du type d'abonnement
        // Exemple simplifié avec une durée fixe ajoutée à la date de début
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        switch (subscriptionType) {
            case ONE_MONTH:
                calendar.add(Calendar.MONTH, 1);
                break;
            case THREE_MONTHS:
                calendar.add(Calendar.MONTH, 3);
                break;
            case SIX_MONTHS:
                calendar.add(Calendar.MONTH, 6);
                break;
            case ONE_YEAR:
                calendar.add(Calendar.YEAR, 1);
                break;
            default:
                throw new IllegalArgumentException("Type d'abonnement non pris en charge: " + subscriptionType);
        }
        return calendar.getTime();
    }

}
