package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
	interface PersonToAccountMapper {
        Account map(Person p);
        
    }
	interface PersonToFirstName {
        String map(Person p);
        
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
	private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
    	List<Account> compte = new ArrayList<Account>();
    	for (Person p: personList)
    	{
    		compte.add(mapper.map(p));
    		
    	}
        return compte;
    }
	private List<String> map(List<Person> personList, PersonToFirstName mapper) {
    	List<String> prenoms = new ArrayList<String>();
    	for (Person p: personList)
    	{
    		prenoms.add(mapper.map(p));
    		
    	}
        return prenoms;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        PersonToAccountMapper mapper = p -> {
        	Account acc = new Account();
        	acc.setOwner(p);
        	acc.setBalance(100);
        	return acc;
        };
        
        List<Account> result = map(personList, mapper);

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms
        PersonToFirstName mapper = p -> p.getFirstname();
        List<String> result = map(personList, mapper);

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
