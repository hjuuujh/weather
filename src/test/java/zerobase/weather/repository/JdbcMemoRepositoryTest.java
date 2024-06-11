package zerobase.weather.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // test가 다진행되면 복구 해줌
class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    @DisplayName("Test INSERT")
    void insertMemoTest() {
        //given
        Memo newMemo = new Memo(1, "this is new memo");

        //when
        jdbcMemoRepository.save(newMemo);

        //then
        assertEquals(jdbcMemoRepository.findById(newMemo.getId()).get().getText(), "this is new memo");
    }

    @Test
    @DisplayName("Test SELECT")
    void findAllMemoTest(){
        //given
        Memo newMemo = new Memo(1, "this is new memo");
        jdbcMemoRepository.save(newMemo);
        newMemo = new Memo(2, "this is new memo");
        jdbcMemoRepository.save(newMemo);
        newMemo = new Memo(3, "this is new memo");
        jdbcMemoRepository.save(newMemo);

        //when
        List<Memo> memos = jdbcMemoRepository.findAll();

        //then
        assertEquals(memos.size(), 3);
    }

}