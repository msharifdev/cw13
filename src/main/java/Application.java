import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.BaseRepositoryImpl;

public class Application {
    static void main() {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default")) {
            EntityManager em = emf.createEntityManager();
            System.out.println("dcbjdbcjbcni");

            
        }
    }
}
