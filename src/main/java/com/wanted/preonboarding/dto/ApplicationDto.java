package com.wanted.preonboarding.dto;

import com.wanted.preonboarding.domain.Application;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto implements Serializable {

    private long jobId;
    private long userId;

    public static ApplicationDto toDto(Application application) {
        return new ApplicationDto(
                application.getJobOpening().getJobId(),
                application.getUser().getUserId()
        );
    }

}
