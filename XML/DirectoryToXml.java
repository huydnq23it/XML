package XML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryToXml {
    public static void main(String[] args) {
        String directoryPath = "D:\\\\codejava\\\\LapTrinhJava\\\\src\\\\XML";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            StringBuilder xmlContent = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlContent.append("<directory>\n");

            // Duyệt qua tất cả các tệp tin và thư mục trong thư mục hiện tại
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    xmlContent.append("    <folder name=\"").append(file.getName()).append("\">\n");
                    // Duyệt qua các tệp tin trong thư mục con
                    for (File subFile : file.listFiles()) {
                        xmlContent.append("        <file name=\"").append(subFile.getName()).append("\"/>\n");
                    }
                    xmlContent.append("    </folder>\n");
                }
            }

            xmlContent.append("</directory>");

            // Ghi xmlContent vào tệp tin XML
            try {
                FileWriter writer = new FileWriter("caythumuc.xml");
                writer.write(xmlContent.toString());
                writer.close();
                System.out.println("Đã tạo thành công tệp tin caythumuc.xml!");
            } catch (IOException e) {
                System.err.println("Lỗi khi ghi tệp tin XML: " + e.getMessage());
            }
        } else {
            System.err.println("Thư mục không tồn tại hoặc không phải là thư mục!");
        }
    }
}
