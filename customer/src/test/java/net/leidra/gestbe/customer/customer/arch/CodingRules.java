package net.leidra.gestbe.customer.customer.arch;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

public final class CodingRules {
    @ArchTest
    static ArchRule preventFieldInjection = GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
    @ArchTest
    static ArchRule avoidGenericExceptions = GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
    @ArchTest
    static ArchRule doNotUseJodaTime = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;
    @ArchTest
    static ArchRule preventJavaStandardStreamsUsage = GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

}
