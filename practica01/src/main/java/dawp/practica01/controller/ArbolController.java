package dawp.practica01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.storage.Storage.BucketAccessControls.List;

@Controller
@RequestMapping("/arboles")
public class ArbolController {
    
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Arbol> litsado = arbolService.getArboles();
    }
}
