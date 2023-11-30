import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Entity
class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String funcao;
    private String nomeTime;
    private String patente;

    
}

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Jogador.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        inserirJogadores(sessionFactory);

        imprimirDadosJogadores(sessionFactory);

        buscarJogadorPorId(sessionFactory, 2L); 
        buscarJogadorPorId(sessionFactory, 4L); 

        sessionFactory.close();
    }

    private static void inserirJogadores(SessionFactory sessionFactory) {
       
    }

    private static void imprimirDadosJogadores(SessionFactory sessionFactory) {
        
    }

    private static void buscarJogadorPorId(SessionFactory sessionFactory, Long id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                Jogador jogador = session.find(Jogador.class, id);

                if (jogador != null) {
                    System.out.println("Jogador encontrado por ID " + id + ":");
                    System.out.println("ID: " + jogador.getId());
                    System.out.println("Nome: " + jogador.getNome());
                    System.out.println("Função: " + jogador.getFuncao());
                    System.out.println("Time: " + jogador.getNomeTime());
                    System.out.println("Patente: " + jogador.getPatente());
                    System.out.println("--------------");
                } else {
                    System.out.println("Jogador com ID " + id + " não encontrado.");
                }
            } catch (NoResultException | NonUniqueResultException ex) {
                System.out.println("Jogador com ID " + id + " não encontrado.");
            }
        }
    }
