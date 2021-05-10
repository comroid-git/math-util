package de.kaleidox.euler;

import org.comroid.mutatio.model.RefList;
import org.comroid.mutatio.model.RefPipe;
import org.comroid.mutatio.ref.ReferenceAtlas;
import org.comroid.mutatio.ref.ReferenceList;
import org.comroid.mutatio.ref.ReferenceMap;
import org.comroid.mutatio.ref.ReferencePipe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.LongUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.lang.Math.sqrt;

public class Project {
    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        //The prime factors of 13195 are 5, 7, 13 and 29.
        //What is the largest prime factor of the number 600851475143 ?

        final long num = 600_851_475_143L;
/*
        System.out.println("solving " + 13195);
        solve(13195);
        System.out.println("solving " + num);
        solve(num);*/


        System.out.println("solving " + 13195);
        long[] factors = getFactors(13195);
        System.out.println("factors = " + Arrays.toString(factors));
        System.out.println("solving " + 1092);
        factors = getFactors(1092);
        System.out.println("factors = " + Arrays.toString(factors));
        System.out.println("solving " + num);
        factors = getFactors(num);
        System.out.println("factors = " + Arrays.toString(factors));

        //getFactors(primes, num);

//getPrimes(500);
        //OptionalLong yield = ;

        /* stupido
        OptionalLong max =
                //LongStream.range(1, (long) Math.sqrt(num)).limit(50)
                LongStream.iterate((long) sqrt(num), x -> (long) (x - sqrt(x / 2)))
                //.peek(x -> System.out.println("checking for prime " + x))
                .filter(x -> x != 1 && LongStream.range(2, x).noneMatch(y -> (x % y) == 0))
                //.filter(Project::isPrime) // is prime
                .peek(x -> System.out.println("checking prime " + x))
                .filter(x -> (num % x) == 0) // is prime factor
                .peek(x -> System.out.println("prime factor of " + num + ": " + x))
                .findFirst();
         */

        //System.out.println("max = " + yield.orElse(-1));
    }

    private static long[] getFactors(long num) {
        return getFactors$rec(new long[0], num, findFirst(num));
    }

    private static long[] getFactors$rec(long[] in, long num, long known) {
        if (known == -1)
            throw new IllegalArgumentException("known is -1");

        long div = num / known;

        System.out.println(String.format("run %d; div/num/known = %d / %d / %d", in.length,div,num,known));
        if (isPrime(div)) {
            System.out.println("is prime");
            long[] yield = new long[in.length + 1];
            System.arraycopy(in, 0, yield, 0, in.length);
            yield[in.length] = div;
            System.out.println("done; ");
            return yield;
        } else {
            System.out.println("is not prime");
            long[] base = new long[in.length + 1];
            System.arraycopy(in, 0, base, 0, in.length);
            base[in.length] = known;
            long first = findFirst(div);
            System.out.println(String.format("decending; div = %d; first = %d", div, first));
            return getFactors$rec(base, div, first);
        }
    }

    public static void getDivisors(long number) {
        long hold = number;
        long i = 0;

        if(i % number == 0) {

        }
    }

    public static void getPrimes(long number) {
        long hold = number;
        long i = 0;

        while(i < number) {
            if (isPrime(i)) {
                System.out.println(", " + i);
            }
            i++;
        }
    }

    public static long findFirst(long num) {
        /*
        if (!isPrime(num))
            throw new IllegalArgumentException("is not prime");
         */
        long p = num;
        long yield = num;

        // ifs -> teiler minimieren

        while(p > 0) {
            if (isPrime(p) && num % p == 0) {
                if (p < yield)
                    yield = p;
            }
            p--;
        }
        return yield;
    }

    public static void unresolve(long num) {

    }

    public static boolean isPrime(long number) {
        if (number == 1) {
            return false;
        }

        long hold = number;
        int count = 0;

        while (hold > 0) {
            if (number % hold == 0) {
                count++;
            }
            hold--;
        }

        if (count > 2) {
            return false;
        }
        return true;
    }

    public static void test2() {
        class FibOp implements LongUnaryOperator {
            private long ndLast;

            @Override
            public long applyAsLong(long operand) {
                long y = ndLast + operand;
                ndLast = operand;

                return y;
            }
        }

        long sum = LongStream.iterate(1, new FibOp())
                .limit(92)
                .peek(x -> System.out.println("checking " + x))
                .filter(x -> x < 4_000_000)
                .peek(x -> System.out.println("smaller " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("even " + x))
                .sum();

        System.out.println("sum = " + sum);
    }

    public static void test1() {
        int sum = IntStream.range(1, 1000)
                .peek(x -> System.out.println("checking " + x))
                .filter(x -> x % 3 == 0 || x % 5 == 0)
                .peek(x -> System.out.println("adding " + x))
                .sum();

        System.out.println("sum = " + sum);
    }
}
