package pl.sdacademy.prog.template;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.TimeUnit;

public abstract class PerformanceTestTemplate {

    abstract void testIteration();

    abstract int getWarmupIterationsNum();

    abstract int getIterationsNum();

    abstract void iteration();

    public void run() {
        for (int iterationIdx = 0; iterationIdx < getWarmupIterationsNum(); iterationIdx++) {
            iteration();
        }

        final List<Duration> iterationsExecutionTimes = new ArrayList<>();
        for (int iterationIdx = 0; iterationIdx < getWarmupIterationsNum(); iterationIdx++) {
            final LocalDateTime start = LocalDateTime.now();
            iteration();
            final LocalDateTime end = LocalDateTime.now();
            iterationsExecutionTimes.add(Duration.between(start, end));
        }
        final OptionalDouble average = iterationsExecutionTimes.stream()
                .mapToDouble(duration -> TimeUnit.NANOSECONDS.toMillis(duration.getNano()))
                .average();
        System.out.println(average.getAsDouble());
    }

}
