import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookTest{

    @Mock
    private BookManagement bookManagement;

    @Test
    public void 책_작가_이름_저장(){
        Book book = mock(Book.class);
        book.setAuthor("베르나르 베르베르");
        verify(book).setAuthor(anyString());
    }
    @Test
    public void 책_번호가_맞는지(){
        given(bookManagement.findBook(2)).willReturn(new Book(2, "어린왕자", "생택쥐베리"));
        Book book = bookManagement.findBook(2);
        assertThat(book.getNum(), is(2));
    }

    @Test
    public void 책번호로찾기_적어도_한번_실행되는지() {
        given(bookManagement.findBook(1)).willReturn(new Book(1, "개미", "베르나르 베르베르"));
        Book book = bookManagement.findBook(1);
        verify(bookManagement, atLeast(1)).findBook(1);
    }
}
