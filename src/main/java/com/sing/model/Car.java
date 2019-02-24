package com.sing.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @SerializedName("make")
    @Expose
    @Builder.Default
    public String make = StringUtils.EMPTY;
    @SerializedName("model")
    @Expose
    @Builder.Default
    public String model = StringUtils.EMPTY;

}