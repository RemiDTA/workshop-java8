package java8.ex01;

import java8.data.Data;
import java8.data.domain.Order;
import java8.data.domain.Pizza;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Recherche
 */
public class Stream_01_Test {

	@Test
	public void test_stream_filter() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();

		// TODO récupérer la liste des pizzas dont le prix est >= 1300
		// TODO utiliser l'API Stream
		List<Pizza> pizzaSup1300 = new ArrayList<>();

		pizzaSup1300 = pizzas.stream().filter(p -> p.getPrice() >= 1300).collect(Collectors.toList());

		List<Pizza> result = pizzaSup1300;

		assertThat(result, hasSize(3));
		assertThat(result, everyItem(hasProperty("price", anyOf(equalTo(1300), greaterThan(1300)))));
	}

	@Test
	public void test_stream_anyMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// TODO valider si au moins une pizza à un prix >= 1300
		boolean pizzaSup1300 = false;

		pizzaSup1300 = pizzas.stream().anyMatch(p -> p.getPrice() >= 1300);

		Boolean result1 = pizzaSup1300;

		// TODO valider si au moins une pizza à un prix >= 2000
		boolean pizzaSup2000 = false;

		pizzaSup2000 = pizzas.stream().anyMatch(p -> p.getPrice() >= 2000);

		Boolean result2 = pizzaSup2000;

		assertThat(result1, is(true));
		assertThat(result2, is(false));
	}

	@Test
	public void test_stream_allMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();

		// TODO valider que toutes les pizzas ont un prix >= 1300
		boolean pizzaSup1300 = false;

		pizzaSup1300 = pizzas.stream().allMatch(p -> p.getPrice() >= 1300);
		Boolean result1 = pizzaSup1300;

		// TODO valider que toutes les pizzas ont un prix >= 900
		boolean pizzaSup900 = false;

		pizzaSup900 = pizzas.stream().allMatch(p -> p.getPrice() >= 900);

		Boolean result2 = pizzaSup900;

		assertThat(result1, is(false));
		assertThat(result2, is(true));
	}

	@Test
	public void test_stream_noneMatch() throws Exception {

		List<Pizza> pizzas = new Data().getPizzas();
		boolean pizzaSup2000 = false;
		// TODO valider qu'aucune pizza n'a un prix >= 2000
		pizzaSup2000 = pizzas.stream().noneMatch(p -> p.getPrice() >= 2000);
		Boolean result1 = pizzaSup2000;

		assertThat(result1, is(true));
	}

	@Test
	public void test_stream_filter_and_match() throws Exception {

		List<Order> orders = new Data().getOrders();

		// TODO récupérer toutes les commandes dont
		// TODO le prénom du client est "Johnny"
		// TODO dont au moins une pizza a un prix >= 1300
		List <Order> pizzaJohnny = orders.stream()
				.filter(o->o.getCustomer().getFirstname().equals("Johnny"))
				.filter(o->o.getPizzas().stream().anyMatch(p->p.getPrice()>1300))
				.collect(Collectors.toList());


		List<Order> result = pizzaJohnny;

		assertThat(result, hasSize(1));
		assertThat(result.get(0), hasProperty("id", is(8)));
	}

	@Test
	public void test_stream_findFirst() throws Exception {
		List<Order> orders = new Data().getOrders();

		// TODO récupérer une commande faite par un client dont le prénom est
		// "Sophie"
		Optional <Order> pizzaSophie = orders.stream().filter(o->o.getCustomer().getFirstname().equals("Sophie")).findFirst();
		Optional<Order> result = pizzaSophie;

		assertThat(result.isPresent(), is(false));
	}

	@Test
	public void test_stream_max() throws Exception {
		List<Pizza> pizzas = new Data().getPizzas();
		Comparator <Pizza> comparator = (p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice());
		// TODO Trouver la pizza la plus chère
		Optional <Pizza> pizzaChere = pizzas.stream().max(comparator);
		Optional<Pizza> result = pizzaChere;

		assertThat(result.isPresent(), is(true));
		assertThat(result.get(), hasProperty("id", is(5)));
		assertThat(result.get(), hasProperty("name", is("La Cannibale")));
		assertThat(result.get(), hasProperty("price", is(1550)));
	}

	@Test
	public void test_stream_min() throws Exception {
		List<Order> orders = new Data().getOrders();

		List<Pizza> pizzas = new Data().getPizzas();
		
		Comparator <Pizza> comparator = (p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice());
		
		// TODO Trouver la pizza la moins chère dont le prix est >= 950
		Optional <Pizza> pizzaPasChere = pizzas.stream().filter(p->p.getPrice()>=950).min(comparator);
		
		Optional<Pizza> result = pizzaPasChere;

		assertThat(result.isPresent(), is(true));
		assertThat(result.get(), hasProperty("id", is(3)));
		assertThat(result.get(), hasProperty("name", is("La Reine")));
		assertThat(result.get(), hasProperty("price", is(1000)));
	}
}
