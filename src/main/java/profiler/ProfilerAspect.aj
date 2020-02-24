package profiler;


import static profiler.Profiler.beforeMethod;
import static profiler.Profiler.afterMethod;

public aspect ProfilerAspect {
    pointcut methodCall(): call(* example.*.*(..));

    before(): methodCall() {
        String fullName = String.format("%s.%s",
                thisJoinPointStaticPart.getSignature().getDeclaringTypeName(),
                thisJoinPointStaticPart.getSignature().getName()
        );
        beforeMethod(fullName);
    }

    after(): methodCall() {
        String fullName = String.format("%s.%s",
                thisJoinPointStaticPart.getSignature().getDeclaringTypeName(),
                thisJoinPointStaticPart.getSignature().getName()
        );
        afterMethod(fullName);
    }
}
