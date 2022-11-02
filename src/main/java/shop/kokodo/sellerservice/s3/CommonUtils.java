package shop.kokodo.sellerservice.s3;

public class CommonUtils {
    private static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final String PRODUCT_PREFIX = "/";
    private static final String TIME_SEPARATOR = "_";

    public static String buildFileName(String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        String fileExtension = originalFileName.substring(fileExtensionIndex);
        String fileName = originalFileName.substring(0, fileExtensionIndex);
        String now = String.valueOf(System.currentTimeMillis());

        return PRODUCT_PREFIX + fileName + TIME_SEPARATOR + now + fileExtension;
    }
}
