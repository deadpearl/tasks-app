package kz.pearl.tasks_service.repository;

import kz.pearl.tasks_service.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Users, Long>, CrudRepository<Users, Long> {
    Optional<Users> findByLogin(String username);
}
