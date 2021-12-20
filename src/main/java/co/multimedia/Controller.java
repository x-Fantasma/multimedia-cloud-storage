package co.multimedia;

import com.google.cloud.storage.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/multi")
public class Controller {

    @PostMapping("/upload")
    public static void uploadObject() throws IOException {
        // The ID of your GCP project
        String projectId = "sistemaapoyobeneficiariodllo";

        // The ID of your GCS bucket
        String bucketName = "sistemaapoyobeneficiariodllo.appspot.com";

        // The ID of your GCS object
        String objectName = "COSITA1.jpeg";

        // The path to your file to upload
        String filePath = "C:/Users/brayan.oviedo/Downloads/Imagen.jpg";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("image/jpeg").build();
        storage.create(blobInfo, Files.readAllBytes(Paths.get(filePath)));

        System.out.println(
                "File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
    }

    @GetMapping("/get")
    public static void getObject() throws IOException {
        // The ID of your GCP project
        String projectId = "sistemaapoyobeneficiariodllo";

        // The ID of your GCS bucket
        String bucketName = "sistemaapoyobeneficiariodllo.appspot.com";

        // The ID of your GCS object
        String objectName = "COSITA1.jpeg";

        // The path to which the file should be downloaded
        String destFilePath = "C:/Users/brayan.oviedo/Downloads/cosita.jpeg";

        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

        Blob blob = storage.get(BlobId.of(bucketName, objectName));
        blob.downloadTo(Paths.get(destFilePath));

        System.out.println(
                "Downloaded object "
                        + objectName
                        + " from bucket name "
                        + bucketName
                        + " to "
                        + destFilePath);
    }
}
