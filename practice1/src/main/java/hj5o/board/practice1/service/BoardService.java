package hj5o.board.practice1.service;

import hj5o.board.practice1.entity.Board;
import hj5o.board.practice1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void trans(Board board) {
        boardRepository.save(board);
    }

    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    public Board boardView (Integer id) {
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }
}
