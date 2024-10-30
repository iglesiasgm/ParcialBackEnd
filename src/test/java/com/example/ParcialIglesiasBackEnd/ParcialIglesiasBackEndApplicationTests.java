package com.example.ParcialIglesiasBackEnd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import services.MutantService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ParcialIglesiasBackEndApplicationTests {

	private final MutantService mutantService = new MutantService();

	@Test
	public void testIsMutantWithMutantDna() {
		String[] mutantDna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
		assertTrue(mutantService.isMutant(mutantDna), "Expected mutant DNA to return true");
	}

	@Test
	public void testIsMutantWithHumanDna() {
		String[] humanDna = {"TTGCAA", "CAGTGC", "TTATGT", "AGAAGG", "TCCCTA", "TCACTG"};
		assertFalse(mutantService.isMutant(humanDna), "Expected human DNA to return false");
	}
}
