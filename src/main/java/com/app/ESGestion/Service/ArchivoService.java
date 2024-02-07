package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Archivo;
import com.app.ESGestion.Model.Cliente;
import com.app.ESGestion.Model.Profesional;
import com.app.ESGestion.Repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private IProfesionalService profesionalService;

    @Autowired
    private IClienteService clienteService;

    public String uploadAndAssociateFile(MultipartFile file, Long profesionalId, Long clienteId) throws Exception {
        try {
            Profesional profesional = profesionalService.findProfesional(profesionalId);
            Cliente cliente = clienteService.findCliente(clienteId);

            if (profesional == null || cliente == null) {
                throw new Exception("Profesional o cliente no encontrado");
            }

            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();
            long maxSize = 5 * 1024 * 1024;

            if (fileSize > maxSize) {
                return "El tamaño del archivo debe ser menor o igual a 5MB";
            }

            if (!fileOriginalName.endsWith(".docx") &&
                    !fileOriginalName.endsWith(".jpg") &&
                    !fileOriginalName.endsWith(".pdf") &&
                    !fileOriginalName.endsWith(".xlsx")) {
                return "No puedes agregar ese tipo de archivo";
            }

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            File folder = new File("src/main/resources/archivos");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Path path = Paths.get("src/main/resources/archivos/" + newFileName);
            Files.write(path, bytes);

            Archivo archivo = new Archivo();
            archivo.setNombreArchivo(fileOriginalName);
            archivo.setProfesional(profesional);
            archivo.setCliente(cliente);

            archivoRepository.save(archivo);

            return "Archivo subido correctamente y asociado con el profesional y cliente.";
        } catch (Exception e) {
            throw new Exception("Error al subir y asociar el archivo: " + e.getMessage());
        }
    }
}

