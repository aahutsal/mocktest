package mocktest

import static org.junit.Assert.*
import org.junit.*

import org.apache.camel.CamelContext
import org.apache.camel.ProducerTemplate
import org.apache.camel.test.junit4.CamelTestSupport

class TestRouteTests extends CamelTestSupport {
  
  def CamelContext camelContext
  def ProducerTemplate producerTemplate

  @Before
  void setUp() {
    // Setup logic here
    super.setUp()
  }

  @After
  void tearDown() {
    // Tear down logic here
  }

  @Test
  void testSomething() {
    
    getMockEndpoint('mock:bar').expectedMessageCount(1)
    producerTemplate.sendBody('direct:foo', "Hello World")

    assertMockEndpointsSatisfied()
  }
}
