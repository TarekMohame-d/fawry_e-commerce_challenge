package Contract.Repository;

import Entities.Review;

import java.util.Optional;
import java.util.UUID;

public interface IReviewRepository extends IGenericRepository<Review>{
    Optional<Review> getReviewDetails(UUID id);
}
