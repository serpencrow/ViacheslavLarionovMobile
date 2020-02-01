package hw3.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.HashMap;

import static hw3.constants.MobileCloudApiConstants.*;

public class MobileCloudApi {

    private HashMap<String, String> params = new HashMap<>();
    private File appForInstallation;

    private MobileCloudApi() {
    }

    // Builder-pattern for manipulations with mobile cloud
    public static class MobileCloudApiBuilder {
        MobileCloudApi api;

        private MobileCloudApiBuilder(MobileCloudApi api) {
            this.api = api;
        }

        // Set serial number of device for using
        public MobileCloudApiBuilder serial(String serialNumber) {
            api.params.put(SERIAL_NUMBER, serialNumber);
            return this;
        }

        // Add file for installation on device
        public MobileCloudApiBuilder file(File appFile) {
            api.appForInstallation = appFile;
            return this;
        }

        // Takes selected device in use
        public Response getDeviceBy(String serialId) {
            return RestAssured
                    .given(requestSpecification())
                    .with()
                    .log().all()
                    .post(ROOT_PATH + DEVICE + serialId).prettyPeek();
        }

        // Install file on selected device
        public Response installApp(String serialId) {
            return RestAssured
                    .given(requestSpecification())
                    .with()
                    .queryParams(api.params)
                    .multiPart(FILE_TYPE, api.appForInstallation)
                    .contentType(FILE_CONTENT_TYPE)
                    .log().all()
                    .post(ROOT_PATH + INSTALL + serialId).prettyPeek();
        }
    }

    // Form api builer
    public static MobileCloudApiBuilder mobileCloudApiBuilder() {
        MobileCloudApi mobileCloudApi = new MobileCloudApi();
        return new MobileCloudApiBuilder(mobileCloudApi);
    }

    // Set request specifications for future responses
    private static RequestSpecification requestSpecification() {
        String token = System.getenv(TOKEN_ENV_VARIABLE);
        return new RequestSpecBuilder()
                .setContentType(CONTENT_TYPE)
                .setAccept(CONTENT_TYPE)
                .setRelaxedHTTPSValidation()
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }
}
