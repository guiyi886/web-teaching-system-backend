package teaching.system.backend.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目
 * @TableName wenxiang
 */
@TableName(value ="wenxiang")
@Data
public class Wenxiang implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * student2
     */
    private String studentAccount;

    /**
     * 实验1.3 其他实验
     */
    private String experimentTitle;

    /**
     * 用户名
     */
    private String username;

    /**
     * 实验内容2
     */
    private String experimentContent;

    /**
     * 用户名
     */
    private String experimentRemarks;

    /**
     * 用户名
     */
    private String code;

    /**
     * 用户名
     */
    private String rightcode;

    /**
     * 0 1 2  代码批改状态0 未提交 1已提交未批改 2 已提交已批改
     */
    private String status;

    /**
     * 2024-06-21
     */
    private String deadline;

    /**
     * 2024-06-20
     */
    private String submissiontime;

    /**
     * 代码评价
     */
    private String codereview;

    /**
     * 分数
     */
    private String goal;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除(0-未删, 1-已删)
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Wenxiang other = (Wenxiang) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStudentAccount() == null ? other.getStudentAccount() == null : this.getStudentAccount().equals(other.getStudentAccount()))
            && (this.getExperimentTitle() == null ? other.getExperimentTitle() == null : this.getExperimentTitle().equals(other.getExperimentTitle()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getExperimentContent() == null ? other.getExperimentContent() == null : this.getExperimentContent().equals(other.getExperimentContent()))
            && (this.getExperimentRemarks() == null ? other.getExperimentRemarks() == null : this.getExperimentRemarks().equals(other.getExperimentRemarks()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getRightcode() == null ? other.getRightcode() == null : this.getRightcode().equals(other.getRightcode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getSubmissiontime() == null ? other.getSubmissiontime() == null : this.getSubmissiontime().equals(other.getSubmissiontime()))
            && (this.getCodereview() == null ? other.getCodereview() == null : this.getCodereview().equals(other.getCodereview()))
            && (this.getGoal() == null ? other.getGoal() == null : this.getGoal().equals(other.getGoal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStudentAccount() == null) ? 0 : getStudentAccount().hashCode());
        result = prime * result + ((getExperimentTitle() == null) ? 0 : getExperimentTitle().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getExperimentContent() == null) ? 0 : getExperimentContent().hashCode());
        result = prime * result + ((getExperimentRemarks() == null) ? 0 : getExperimentRemarks().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getRightcode() == null) ? 0 : getRightcode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getSubmissiontime() == null) ? 0 : getSubmissiontime().hashCode());
        result = prime * result + ((getCodereview() == null) ? 0 : getCodereview().hashCode());
        result = prime * result + ((getGoal() == null) ? 0 : getGoal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", studentAccount=").append(studentAccount);
        sb.append(", experimentTitle=").append(experimentTitle);
        sb.append(", username=").append(username);
        sb.append(", experimentContent=").append(experimentContent);
        sb.append(", experimentRemarks=").append(experimentRemarks);
        sb.append(", code=").append(code);
        sb.append(", rightcode=").append(rightcode);
        sb.append(", status=").append(status);
        sb.append(", deadline=").append(deadline);
        sb.append(", submissiontime=").append(submissiontime);
        sb.append(", codereview=").append(codereview);
        sb.append(", goal=").append(goal);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}