import org.apache.camel.builder.RouteBuilder
import org.apache.camel.LoggingLevel

class TestRoutes extends RouteBuilder {

  def grailsApplication

  @Override 
  void configure(){
    from("direct:foo").
      routeId('testRoute').
      log(LoggingLevel.WARN, "org.apache.camel", '${body}').
      to("mock:bar")
  }
}