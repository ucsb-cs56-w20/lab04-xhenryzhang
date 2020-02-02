package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void test_get_reciprocal_of_0_1() {
        Rational reciprocal = r_0_1.reciprocalOf();
    }
    
    @Test
    public void test_get_reciprocal_of_neg() {
        Rational r_m2_5 = new Rational(-2, 5);
        Rational r = r_m2_5.reciprocalOf();
        assertEquals("-5/2", r.toString());
    }
    
    @Test
    public void test_get_reciprocal_of_positive() {
        Rational r_10_12 = new Rational(10, 12);
        Rational r1 = r_10_12.reciprocalOf();
        assertEquals("6/5", r1.toString());
        Rational r_m4_m9 = new Rational(-4, -9);
        Rational r2 = r_m4_m9.reciprocalOf();
        assertEquals("9/4", r2.toString());
    }
 
    @Test
    public void test_lcm_of_0_1() {
        assertEquals(0, Rational.lcm(0, 1));
    }

    @Test
    public void test_lcm_of_4_20() {
        assertEquals(20, Rational.lcm(4, 20));

    }

    @Test
    public void test_lcm_of_m9_6() {
        assertEquals(-18, Rational.lcm(-9, 6));
    }

    @Test
    public void test_lcm_of_10_10() {
        assertEquals(10, Rational.lcm(10, 10));
    }

    @Test
    public void test_plus_both_positive() {
        Rational r = r_13_4.plus(new Rational(4, 5));
        assertEquals("81/20", r.toString());
    }

    @Test
    public void test_plus_both_negative() {
        Rational r_m2_9 = new Rational(-2, 9);
        Rational sum = r_m2_9.plus(new Rational(-5, 2));
        assertEquals("-49/18", sum.toString());
    }

    @Test
    public void test_plus_different_sign() {
        Rational r = r_24_6.plus(new Rational(-12, 6));
        assertEquals("2", r.toString());
    }

    @Test
    public void test_sum_both_positive() {
        Rational r = Rational.sum(r_24_6, r_5_15);
        assertEquals("13/3", r.toString());
    }

    @Test
    public void test_sum_both_negative() {
        Rational r = Rational.sum(new Rational(-24, 6), new Rational(-5, 10));
        assertEquals("-9/2", r.toString());
    }

    @Test
    public void test_sum_different_signs() {
        Rational r = Rational.sum(new Rational(-5, 8), r_5_15);
        assertEquals("-7/24", r.toString());
    }

    @Test
    public void test_sum_to_0() {
        Rational r = Rational.sum(r_24_6, new Rational(-4, 1));
        assertEquals("0", r.toString());
    }

    @Test
    public void test_minus_both_positive() {

    }

    @Test
    public void test_minus_both_negative() {

    }

    @Test
    public void test_difference_both_positive() {

    }

    @Test
    public void test_difference_both_negative() {
        
    }

    @Test
    public void test_difference_0() {

    
    }
}
