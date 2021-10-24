# Wemakeprice-Test

## HTML Filter 프로세스
![Image of Yaktocat](image.png)

## 문제정의
1. URL를 통해 HTML을 읽어 온다.
2. HTML 태그는 옵션을 통해 제거한다. 
   * 선택하지 않으면 전체 Text를 읽는다. 
3. 영어, 숫자만 추출한다. 
4. 오름차순으로 정렬한다. 
    * 영어: AaBbCc...YyZz
    * 숫자: 01234
   
5. 영어와 숫자를 한글자씩 교차하여 섞는다.
   * 영어, 숫자, 영어, 숫자 예) a1b2c3
   
6. 입력받은 출력 묶음으로 몫, 나머지로 나누어 출력한다. 

## 문제풀이

Processor라는 객체가 chain 방식으로 next형태로 Filter를 추가하여 처리하는 구현했습니다.
```java
public DivideResult process(String input, int groupCount) {
    verify(input, groupCount);
    return Processor.start(input)
            .next(new HTMLCharacterFilter())
            .next(new AlphaAndNumberFilter())
            .next(new SortIgnoreCase())
            .next(new MixAlphabetNumberFilter())
            .end(new DivisionFilter(groupCount));
}
```
새로운 필터가 변경되거나 순서가 변경된다면 application의 `StringFilterProcessor`만 변경하면되니 유연성을 갖을 수 있을것이라고 생각합니다.
각각의 필터는 독립성을 가지고 있기 때문에 다른프로세스에서 그대로 사용되어도 영향이 없을것이라고 생각됩니다. 
