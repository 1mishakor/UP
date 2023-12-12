package Misha.Week1.N4;

public class Main {
    public static void main(String[] args) {
        BlueRayDisc blueRayDisc = new BlueRayDisc("C:", "C:/Users/ko-ma/Desktop/Пока Не Нужное/ЛПЗ по Плешкову",
                "1_4_Optimizatsia_BD_2","docx",33792, "02.03.2023","15:03");
        BlueRayDisc.WorkWithCatalogs workWithCatalogs = blueRayDisc.new WorkWithCatalogs();
        System.out.println(workWithCatalogs.FileSizeConverter(new BytesConvert().KBytes));
        System.out.println(workWithCatalogs.FullDirectory());
        System.out.println(workWithCatalogs.FullDirectoryAndOther());
        System.out.println(blueRayDisc.toString());

    }
}
