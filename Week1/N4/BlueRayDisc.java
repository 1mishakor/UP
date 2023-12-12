package Misha.Week1.N4;

public class BlueRayDisc {
    private String catalog;
    private String Directory;
    private String NameFile;
    private String TypeFile;
    private double FileSizeBytes;
    private String DateOfCreation;
    private String CreationTime;

    public BlueRayDisc(String catalog, String Directory, String NameFile,
                       String TypeFile, double FileSizeBytes, String DateOfCreation,
                       String CreationTime) {
        this.catalog = catalog;
        this.Directory = Directory;
        this.NameFile = NameFile;
        this.TypeFile = TypeFile;
        this.FileSizeBytes = FileSizeBytes;
        this.DateOfCreation = DateOfCreation;
        this.CreationTime = CreationTime;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getDirectory() {
        return Directory;
    }

    public void setDirectory(String directory) {
        Directory = directory;
    }

    public String getNameFile() {
        return NameFile;
    }

    public void setNameFile(String nameFile) {
        NameFile = nameFile;
    }

    public String getTypeFile() {
        return TypeFile;
    }

    public void setTypeFile(String typeFile) {
        TypeFile = typeFile;
    }

    public double getFileSizeBytes() {
        return FileSizeBytes;
    }

    public void setFileSizeBytes(double fileSizeBytes) {
        FileSizeBytes = fileSizeBytes;
    }

    public String getDateOfCreation() {
        return DateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        DateOfCreation = dateOfCreation;
    }

    public String getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(String creationTime) {
        CreationTime = creationTime;
    }

    @Override
    public String toString() {
        return "CatalogFile{" +
                "catalog='" + catalog + '\'' +
                ", Directory='" + Directory + '\'' +
                ", NameFile='" + NameFile + '\'' +
                ", TypeFile='" + TypeFile + '\'' +
                ", FileSizeBite=" + FileSizeBytes +
                ", DateOfCreation='" + DateOfCreation + '\'' +
                ", CreationTime='" + CreationTime + '\'' +
                '}';
    }

    public class WorkWithCatalogs {
        public double FileSizeConverter(byte convert) {
            double sizeConverter;
            switch (convert) {
                case 0 -> {
                    sizeConverter = FileSizeBytes;
                    return sizeConverter;
                }
                case 1 -> {
                    sizeConverter = FileSizeBytes / 1024.0;
                    return sizeConverter;
                }
                case 2 -> {
                    sizeConverter = ((FileSizeBytes / 1024.0) / 1024.0);
                    return sizeConverter;
                }
                case 3 -> {
                    sizeConverter = (((FileSizeBytes / 1024.0) / 1024.0) / 1024.0);
                    return sizeConverter;
                }
                case 4 -> {
                    sizeConverter = ((((FileSizeBytes / 1024.0) / 1024.0) / 1024.0) / 1024.0);
                    return sizeConverter;
                }
                default -> {
                    return 0.0;
                }
            }
        }

        public String FullDirectoryAndOther() {
            return Directory + "/" + NameFile + "." + TypeFile + "|\t|" +
                    FileSizeBytes + " bytes|\t|" + DateOfCreation + "|\t|" + CreationTime+"|";
        }

        public String FullDirectory() {
            return Directory + "/" + NameFile + "." + TypeFile;
        }
    }
}
