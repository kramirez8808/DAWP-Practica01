package dawp.practica01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dawp.practica01.domain.Arbol;
import dawp.practica01.service.ArbolService;
import dawp.practica01.impl.FirebaseStorageServiceImpl;

@Controller
@RequestMapping("/arbol")
public class ArbolController {
    
    @Autowired
    ArbolService arbolService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Arbol> listado = arbolService.getArboles();
        model.addAttribute("arboles", listado);
        model.addAttribute("totalArboles", listado.size());
        return "/arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo (Arbol arbol) {
        return "/arbol/editar";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol, @RequestParam("imagenFile") MultipartFile imagenFile) {
            if (!imagenFile.isEmpty()) {
                arbolService.save(arbol);
                arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                        imagenFile,
                        "arboles",
                        arbol.getIdArbol()
                    )
                );
            }
            arbolService.save(arbol);
            return "redirect:/arbol/listado";
    
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/editar/{idArbol}")
    public String arbolEditar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/editar";
        
    }

}
