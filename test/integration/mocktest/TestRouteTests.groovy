package mocktest

import static org.junit.Assert.*
import org.junit.*

import org.apache.camel.CamelContext
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.ProducerTemplate
import org.apache.camel.test.junit4.CamelTestSupport
import org.apache.camel.builder.RouteBuilder

import org.apache.camel.processor.interceptor.Tracer
import org.apache.camel.processor.interceptor.DefaultTraceFormatter
import org.apache.camel.LoggingLevel

class TestRouteTests extends CamelTestSupport {
  
  def CamelContext camelContext
  def ProducerTemplate producerTemplate

  protected CamelContext createCamelContext() throws Exception {
    return camelContext;
  }

  @Test
  void testSomething() {
    def mockEndpoint
    //mockEndpoint = camelContext.getEndpoint('mock:bar') // this works
    mockEndpoint = getMockEndpoint('mock:bar') // this now works also

    mockEndpoint.expectedMessageCount(1)
    producerTemplate.sendBody('direct:foo', "Hello World")

    assertMockEndpointsSatisfied()
  }
}
