package com.pgs.junit5.examples.condition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ContainerExecutionCondition;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;
import org.junit.platform.commons.util.StringUtils;

import java.lang.reflect.AnnotatedElement;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class DisabledOnFridayCondition implements ContainerExecutionCondition, TestExecutionCondition {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled(
            "@DisabledOnFriday is not present");

    @Override
    public ConditionEvaluationResult evaluate(final ContainerExtensionContext context) {
        return evaluate(context.getElement());
    }

    @Override
    public ConditionEvaluationResult evaluate(final TestExtensionContext context) {
        return evaluate(context.getElement());
    }

    private ConditionEvaluationResult evaluate(Optional<AnnotatedElement> element) {
        Optional<DisabledOnFriday> disabled = findAnnotation(element, DisabledOnFriday.class);
        if (disabled.isPresent() && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            String reason = disabled.map(DisabledOnFriday::value).filter(StringUtils::isNotBlank).orElseGet(
                    () -> element.get() + " is @DisabledOnFriday");
            return ConditionEvaluationResult.disabled(reason);
        }

        return ENABLED;
    }
}
