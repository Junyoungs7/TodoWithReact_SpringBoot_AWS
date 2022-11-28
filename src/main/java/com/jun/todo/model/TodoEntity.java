package com.jun.todo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder//메소드로 변경 후 메소드 이름 지정 + 업데이트 메소드 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED)//매개변수 없는 생성자 생서 제한
@AllArgsConstructor//이거 삭제하고 빌더를 클래스에서 메소드로 변경
@Data//setter 삭제
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
