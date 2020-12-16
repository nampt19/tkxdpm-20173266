package com.oms.bean.test;


import com.oms.serverapi.test.BookApiTest;
import com.oms.serverapi.test.CompactDiscApiTest;
import com.oms.serverapi.test.ParameterizedBookApiTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TotalCostBlackBoxTest.class, TotalCostWhiteBoxTest.class })
public class TotalCostTestSuit {
}
