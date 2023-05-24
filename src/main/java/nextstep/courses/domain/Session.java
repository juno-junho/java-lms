package nextstep.courses.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static nextstep.courses.domain.SessionStatus.OPENED;

public class Session {

    private final Set<Student> students = new HashSet<>();
    private Long maxNumOfStudent;
    private SessionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
    private String coverImageInfo;
    private SessionType type;

    public Session() {

    }

    public void add(Student student) {
        if (this.maxNumOfStudent <= this.students.size()) {
            throw new CannotEnrollException("강의 수강 신청 인원이 다 찼습니다!");
        }
        if (this.status != OPENED) {
            throw new CannotEnrollException("모집 중일때만 신청 가능합니다!");
        }
        students.add(student);
    }

    public int totalStudentNum() {
        return students.size();
    }

    public void setMaxNumOfStudent(Long maxNumOfStudent) {
        this.maxNumOfStudent = maxNumOfStudent;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }
}