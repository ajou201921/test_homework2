import lombok.Data;

@Data
public class Book {

    // 도서관리 번호
    private int num;
    // 도서 제목
    private String title;
    // 도서 저자
    private String author;

    public Book(int num, String title, String author) {
        super();
        this.num = num;
        this.title = title;
        this.author = author;
    }
    public String toString() {
        return "Book{ [num : "+this.num+"] [title : " +this.title +"] [author : " + this.author + "]}";
    }
}

