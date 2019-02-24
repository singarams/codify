package com.sing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Pojo for the received data from backend systems
 */
@Getter
public class ReceivedDataObjectMapper {


    @Expose
    @Builder.Default
    public String name = StringUtils.EMPTY;
    @Expose
    public List<Car> cars = null;

}
