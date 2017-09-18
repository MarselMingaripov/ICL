package com.ICL;

import freemarker.template.*;

import java.io.*;
import java.util.*;


public class XmlGenerator {

    private static Configuration configuration = null;

    static {
        configuration = new Configuration(new Version("2.3.0"));
    }

    public static void main(String[] args) {
        try {
            Template template = configuration.getTemplate("src/main/resources/view/ftl/XmlTemplate.ftl");
            Map<String, Object> templateData = new HashMap<String, Object>();
            templateData.put("name", "Java");
            List<Book> ListOfBooks = Arrays.asList(
                    new Book("Войны мага", "Перумов"),
                    new Book("Хроники Сиалы", "Пехов"),
                    new Book("Спектр", "Лукьяненко"),
                    new Book("Завтра война", "Зорич"),
                    new Book("Му-Му", "Тургенев")
            );

            Scanner scanner = new Scanner(System.in);
            System.out.println("Сколько файлов генерировать?");
            Integer amount = scanner.nextInt();
            List<Book> lastList = new ArrayList<Book>();

            for (int i = 0; i < amount; i++) {
                for (int j = 0; j < ListOfBooks.size(); j++) {
                    Integer num = (int) (Math.random() * ListOfBooks.size());
                    lastList.add(i, ListOfBooks.get(num));

                }
                templateData.put("books", lastList);
                StringWriter out = new StringWriter();
                template.process(templateData, out);
                System.out.println( out.getBuffer().toString() );
                out.flush();

               /* Writer file = new FileWriter(new File("C:\\Users\\Марс\\FreeMarkerExample\\Example.txt"));
                template.process(templateData, file);
                file.flush();
                file.close();
                templateData.clear();*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
