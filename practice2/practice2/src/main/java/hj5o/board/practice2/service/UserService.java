package hj5o.board.practice2.service;

import hj5o.board.practice2.model.RoleType;
import hj5o.board.practice2.model.User;
import hj5o.board.practice2.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Transactional
    public void insertUser(User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getUser(String username) {
//		// 검색 결과가 없다면 빈 객체를 리턴한다.(일반 코드)
//		User findUser = userRepository.findByUsername(username).orElseGet(
//			new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		});

        // 검색 결과가 없다면 빈 객체를 리턴한다.(람다식)
        User findUser = userRepository.findByUsername(username).orElseGet(()->{
            return new User();
        });
        return findUser;
    }

}
