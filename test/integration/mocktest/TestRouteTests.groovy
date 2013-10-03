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

import java.util.concurrent.TimeUnit

class TestRouteTests extends CamelTestSupport {
  
  def CamelContext camelContext
  def ProducerTemplate producerTemplate

  @Before
  void setUp(){
    camelContext.setTracing(true)

    Tracer tracer = new Tracer()

    DefaultTraceFormatter formatter = new DefaultTraceFormatter()
    formatter.setShowOutBody(true);
    formatter.setShowOutBodyType(true);
    // set to use our formatter
    tracer.setFormatter(formatter)

    tracer.setLogLevel(LoggingLevel.WARN)

    camelContext.addInterceptStrategy(tracer)

    super.setUp()
  }

  @Test
  void testSomething() {
    def mockEndpoint
    mockEndpoint = camelContext.getEndpoint('mock:bar') // this works
    //mockEndpoint = getMockEndpoint('mock:bar') // this does not

    mockEndpoint.expectedMessageCount(1)
    producerTemplate.sendBody('direct:foo', "Hello World")

    //assertMockEndpointsSatisfied(1, TimeUnit.SECONDS)
    mockEndpoint.assertIsSatisfied()
  }
}
