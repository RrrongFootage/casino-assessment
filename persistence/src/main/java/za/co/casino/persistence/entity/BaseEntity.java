package za.co.casino.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
    @Column(name = "modified_date")
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    protected BaseEntity(final BaseEntity baseEntity){
        this.createdDate = baseEntity.getCreatedDate();
        this.modifiedDate = baseEntity.getModifiedDate();
    }

}
