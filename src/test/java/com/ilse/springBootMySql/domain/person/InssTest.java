package com.ilse.springBootMySql.domain.person;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class InssTest {


    @Test
    public void isInssValid_validInssBefore2000_returns_true() {
        Assertions.assertThat(Inss.isInnsValid("74052931219")).isEqualTo(true);
    }

    @Test
    public void isInssValid_invalidInssBefore2000_returns_false() {
        Assertions.assertThat(Inss.isInnsValid("74052931218")).isEqualTo(false);
    }

    @Test
    public void isInssValid_validInssAfter2000_returns_true() {
        Assertions.assertThat(Inss.isInnsValid("02050900129")).isEqualTo(true);
    }

    @Test
    public void isInssValid_invalidInssAfter2000_returns_false() {
        Assertions.assertThat(Inss.isInnsValid("02050900128")).isEqualTo(false);
    }

    @Test
    public void isInssValid_EmptyInss_returns_true() {
        Assertions.assertThat(Inss.isInnsValid("")).isEqualTo(true);
    }

    @Test
    public void isInssValid_InssNull_returns_true() {
        Assertions.assertThat(Inss.isInnsValid(null)).isEqualTo(true);
    }

}