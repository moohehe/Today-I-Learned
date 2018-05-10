// http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html

public class EnumTest3
{
	public static void main(String[] args)
	{
		
		// STEP2. 상태와 행위를 한곳에서 관리
		// 서로 다른 계산식을 적용해야할 경우
		// 예를 들어, cal_a는 그대로의 값을, calc_b는 *10한 값을, calc_c는 *3한 값을 입력하는 
		
		// DB의 테이블에서 뽑은 특정 값은 지정된 메소드와 관계가 있다.
		
		@Columns
		@Enumrated(EnumType.STRING); // Enum 필드가 테이블에 저장시 숫자형인 1,2,3이 아닌 Enum의 name에 저장된다.
		private CalculatorType calculatorType;
		
		CalculatorType code = selectType();
		long originValue = 10000L;
		long result = code.calculate(originValue);
		
		assertThat(result, is(10000L));
		
		
		
		
	}
}

public enum CalculatorType {
	CALC_A(value -> value),
	CALC_B(value -> value*10),
	CALC_C(value -> value*3),
	CALC_ETC(value -> 0L);
	
	private Function<Long,Long> expression;
	
	CalculatorType(Function<Long, Long> expression) {
		this.expression = expression;
	}
	
	public long calculator(Long long) {
		return expression.apply(value);
	}
	
}