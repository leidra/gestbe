package net.leidra.gestbe.customer.customer.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchTests;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = CustomerArchTest.CUSTOMER_BASE_PACKAGE,
    importOptions = { ImportOption.DoNotIncludeTests.class })
public final class CustomerArchTest {
    public static final String CUSTOMER_BASE_PACKAGE = "net.leidra.gestbe.customer.customer";
    @ArchTest
    static Architectures.OnionArchitecture onionArchitecture = Architectures.onionArchitecture()
            .domainModels(CUSTOMER_BASE_PACKAGE + ".domain..")
            .domainServices(CUSTOMER_BASE_PACKAGE + ".domain..")
            .applicationServices(CUSTOMER_BASE_PACKAGE + ".application..")
            .adapter("infrastructure", CUSTOMER_BASE_PACKAGE + ".infrastructure..");
    @ArchTest
    static ArchTests codingRules = ArchTests.in(CodingRules.class);
}
