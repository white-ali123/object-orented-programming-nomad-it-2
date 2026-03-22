import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class array5 {
    public static void main(String[] args) {
        List<Book> library = List.of(
                new Book("Сын кузнеца", "Касымалы Баялинов"),
                new Book("Среди гор", "Аалы Токомбаев"),
                new Book("Первый учитель", "Чингиз Айтматов"),
                new Book("Материнское поле", "Чингиз Айтматов")
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя автора для поиска: ");
        String searchAuthor = scanner.nextLine();

        List<String> results = library.stream()
                .filter(book -> book.author.equalsIgnoreCase(searchAuthor))
                .map(book -> book.title)
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("Книг данного автора не найдено.");
        } else {
            System.out.println("Результаты поиска для автора \"" + searchAuthor + "\":");
            results.forEach(title -> System.out.println("- " + title));
        }
    }
}