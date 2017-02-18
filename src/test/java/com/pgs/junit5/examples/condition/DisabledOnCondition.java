package com.pgs.junit5.examples.condition;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.lang.reflect.AnnotatedElement;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class DisabledOnCondition implements ContainerExecutionCondition, TestExecutionCondition {

    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled(
            "@DisabledOnFriday is not present");

    /**
     * Containers are disabled if {@link DisabledOn} is present on the test class.
     */
    @Override
    public ConditionEvaluationResult evaluate(ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }

    /**
     * Tests are disabled if {@link DisabledOn} is present on the test method.
     */
    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        return evaluate(context.getElement());
    }

    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {
        return findAnnotation(element, DisabledOn.class)
                .map(DisabledOn::value)
                .filter(dayOfWeeks -> ArrayUtils.contains(dayOfWeeks, LocalDateTime.now().getDayOfWeek()))
                .map(dayOfWeeks -> element.get() + " is disabled on " + Arrays.toString(dayOfWeeks))
                .map(ConditionEvaluationResult::disabled)
                .orElse(ENABLED);
    }
}
