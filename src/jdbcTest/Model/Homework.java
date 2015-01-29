package jdbcTest.Model;

/**
 * Created by online on 15-1-24.
 */
public class Homework {
    private Integer homeworkid ;
    private String answer ;
    private Integer owner ;
    private Integer score ;

    public Integer getHomeworkid() {
        return homeworkid;
    }

    public void setHomeworkid(Integer homeworkid) {
        this.homeworkid = homeworkid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getowner() {
        return owner;
    }

    public void setowner(Integer owner) {
        this.owner = owner;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
