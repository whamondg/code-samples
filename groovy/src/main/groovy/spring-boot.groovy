@RestController
class ExampleController {
   @RequestMapping("/")
   String home() {
       return "Hello World!"
   }
}
