package com.csd.Hamcrest;

import static com.csd.Hamcrest.StringListInAnyOrder.stringListInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StringListInAnyOrderTest {
	
	@Test
	public void sameListUnordered() throws Exception {
		List<String> lista1 = Arrays.asList("elm2","elm1");
		List<String> lista2 = Arrays.asList("elm1","elm2");
		assertThat(lista1, stringListInAnyOrder(lista2));
	}
	
	@Test
	public void checkingTwoEmptyList() throws Exception {
		List<String> lista1 = new ArrayList<String>();
		List<String> lista2 = new ArrayList<String>();
		assertThat(lista1, stringListInAnyOrder(lista2));
	}
	
	@Test
	public void checkingTwoOneElementListEquals() throws Exception {
		List<String> lista1 = Arrays.asList("elm1");
		List<String> lista2 = Arrays.asList("elm1");
		assertThat(lista1, stringListInAnyOrder(lista2));
	}
	
	@Test
	public void testName() throws Exception {
		assertTrue(true);
	}
	
}
