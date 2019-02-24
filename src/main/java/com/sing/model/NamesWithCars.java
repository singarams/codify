package com.sing.model;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

/**
 * POJO for cleaning up the received Input from API.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class NamesWithCars {

    @Builder.Default
    private String make = StringUtils.EMPTY;
    @Builder.Default
    private String model = StringUtils.EMPTY;
    private String name;

}
