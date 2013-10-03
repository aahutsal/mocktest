import org.apache.camel.builder.RouteBuilder

class TestRoutes extends RouteBuilder {
  @Override 
  void configure(){
    from("direct:foo").
      to("mock:bar")
  }
}