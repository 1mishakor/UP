package Misha.Week1.N5;

public class Main {
    public static void main(String[] args) {
        String string = """
                Задача организации, в особенности же сложившаяся структура организации напрямую зависит от новых предложений!\s
                Значимость этих проблем настолько очевидна, что дальнейшее развитие различных форм деятельности требует определения и\s
                уточнения направлений прогрессивного развития. Повседневная практика показывает, что дальнейшее развитие различных\s
                форм деятельности влечет за собой процесс внедрения и модернизации соответствующих условий активизации.
                                
                Разнообразный и богатый опыт начало повседневной работы по формированию позиции позволяет выполнить важнейшие задания\s
                по разработке соответствующих условий активизации. Разнообразный и богатый опыт дальнейшее развитие различных форм\s
                деятельности требует от нас анализа новых предложений. Значимость этих проблем настолько очевидна, что сложившаяся\s
                структура организации играет важную роль в формировании дальнейших направлений развитая системы массового участия.\s
                Задача организации, в особенности же постоянный количественный рост и сфера нашей активности способствует подготовке\s
                и реализации дальнейших направлений развития проекта?
                                
                Значимость этих проблем настолько очевидна, что консультация с профессионалами из IT способствует\s
                подготовке и реализации всесторонне сбалансированных нововведений! Значимость этих проблем настолько\s
                очевидна, что постоянное информационно-техническое обеспечение нашей деятельности обеспечивает актуальность\s
                новых предложений. Равным образом постоянный количественный рост и сфера нашей активности обеспечивает актуальность\s
                экономической целесообразности принимаемых решений. Задача организации, в особенности же реализация намеченного плана\s
                развития влечет за собой процесс внедрения и модернизации новых предложений!
                                
                С другой стороны рамки и место обучения кадров требует от...
                """;
        SearchWord searchWord = new SearchWord(string);
        String a = "структура";
        System.out.println("Количество слов в тексте \"" + a + "\" равняется: " + searchWord.foundWord(a));
    }
}
