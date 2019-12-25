package com.thirdparty.examples.fastjson;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class NonPojo {
    private String name;
    private String alias;
    private Integer age;

    public NonPojo() {}
}
