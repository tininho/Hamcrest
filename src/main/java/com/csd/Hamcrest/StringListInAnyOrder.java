package com.csd.Hamcrest;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StringListInAnyOrder extends TypeSafeMatcher<List<String>> {

	private List<String> lista2;

	public StringListInAnyOrder(List<String> expected) {
		this.lista2 = expected;
	}

	public void describeTo(Description description) {
		description.appendText("list ignoring order ");
		description.appendValue(lista2);
	}

	@Override
	protected boolean matchesSafely(List<String> lista1) {
		if (lista1.size()>0) {
			for (String element : lista1) {
					if (!listContainsElement(element)){
						return false;
					}
			}
			return true;
		}
		return areEmptyLists(lista1);
	}

	private boolean listContainsElement(String element) {
		return lista2.contains(element);
	}

	private boolean areEmptyLists(List<String> lista1) {
		return lista1.isEmpty() && lista2.isEmpty();
	}

	@Factory
	public static Matcher<List<String>> stringListInAnyOrder(
			List<String> expected) {
		return new StringListInAnyOrder(expected);
	}
}
