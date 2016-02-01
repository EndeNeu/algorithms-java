package com.ebusiello.algorithms;

import com.ebusiello.algorithms.quick.find.QuickFindSpec;
import com.ebusiello.algorithms.quick.union.QuickUnionSpec;
import com.ebusiello.algorithms.quick.weighted.QuickUnionWeightedSpec;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ QuickFindSpec.class, QuickUnionSpec.class, QuickUnionWeightedSpec.class})
public class AllTests {

}