import org.apache.camel.builder.RouteBuilder

class TestRoute extends RouteBuilder {

  def grailsApplication

  @Override 
  void configure(){
    from("direct:foo").to("mock:bar")
  }
}