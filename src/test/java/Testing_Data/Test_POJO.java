package Testing_Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
public class Test_POJO
{
        @JsonProperty("inputMessage1")
        private String inputMessage1;
        @JsonProperty("inputMessage2")
        private String inputMessage2;
        @JsonProperty("number1")
        private String number1;
        @JsonProperty("number2")
        private String number2;
        @JsonProperty("number3")
        private String number3;
        @JsonProperty("number4")
        private String number4;

        public String getInputMessage2() {
                return inputMessage2;
        }

        public String getInputMessage1(){
                return this.inputMessage1;
        }
        public String getNumber1(){
                return this.number1;
        }
        public String getNumber2(){
                return this.number2;
        }

        public String getNumber3() {
                return number3;
        }

        public String getNumber4() {
                return number4;
        }
}
