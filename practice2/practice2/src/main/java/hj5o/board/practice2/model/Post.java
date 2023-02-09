package hj5o.board.practice2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@DynamicInsert INSERT를 생성할 때, null인 변수는 제외시킨다.
//@DynamicUpdate UPDATE를 생성할 때, null인 변수는 제외시킨다.
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    // 대용량 데이터 저장을 위해 @Lob로 설정함
    // 나중에 summernote를 적용하면 많은 <html> 태그들이 포함된다.
    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;

    private int cnt;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    @OrderBy("id desc")
    private List<Reply> replyList;

}

