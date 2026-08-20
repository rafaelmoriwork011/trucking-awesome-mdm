package com.truckingawesome.mdm.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DataListResponseDto<T> {
    private List<T> data;

    public static <T> DataListResponseDto<T> of(List<T> data) {
        return DataListResponseDto.<T>builder().data(data).build();
    }
}