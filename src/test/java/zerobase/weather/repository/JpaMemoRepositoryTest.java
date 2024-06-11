package zerobase.weather.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    @DisplayName("test insert")
    void insertMemoTest() {
        //given
        Memo memo = new Memo(10, "this is jpa memo");

        //when
        jpaMemoRepository.save(memo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    @DisplayName("test select")
    void findByIdTest(){
        //given
        Memo newMemo = new Memo(11, "this is jpa memo");

        //when
        Memo memo = jpaMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
        assertEquals(result.get().getText(), "this is jpa memo");
    }

}