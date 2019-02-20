package streamTest;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakingStreams {

    public static void main(String...args) throws Exception{
        
        // Stream.of
        Stream<String> stream = Stream.of("Java8", "Lambdas", "SangHyun");
        stream.map(String::toUpperCase).forEach(System.out::println);
        // result : UpperCase
        
        // Arrays.stream
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(numbers).sum());
        // result : 15
        
        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
              .limit(5)
              .forEach(System.out::println);
        // result : 0 2 4 6 8
        
        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
              .limit(10)
              .forEach(System.out::println);
        // result : random data
        
        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                 .limit(5)
                 .forEach(System.out::println);
        // result : 1 1 1 1 1 
        
        IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        }).limit(5)
          .forEach(System.out::println);
        // result : 2 2 2 2 2

        // 피보나치 수열
        IntSupplier fib = new IntSupplier(){
                  private int previous = 0;
                  private int current = 1;
                  public int getAsInt(){
                      int nextValue = this.previous + this.current;
                      this.previous = this.current;
                      this.current = nextValue;
                      return this.previous;
                  }
              };
         IntStream.generate(fib).limit(10).forEach(System.out::println);
         // result : 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
         
         // 유니크 단어 카운트
         long uniqueWords = Files.lines(Paths.get("data2.txt"), Charset.defaultCharset())
                                 .flatMap(line -> Arrays.stream(line.split(" ")))
                                 .distinct()
                                 .count();

         System.out.println("There are " + uniqueWords + " unique words in data2.txt");
    }
}
