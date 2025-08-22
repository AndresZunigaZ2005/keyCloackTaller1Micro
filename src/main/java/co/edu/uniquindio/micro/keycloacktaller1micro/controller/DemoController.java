package co.edu.uniquindio.micro.keycloacktaller1micro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class DemoController {

    @GetMapping("/public/hello")
    public String helloPublic() {
        return "Hola, esta ruta es pública 🚀";
    }

    @GetMapping("/secure/hello")
    public String helloSecure(Principal principal) {
        return "Hola " + principal.getName() + ", accediste con un token válido 🔑";
    }


}
