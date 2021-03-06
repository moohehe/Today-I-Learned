
public class EnumTest2
{
	public static void main(String[] args)
	{
		
		// STEP2. 상태와 행위를 한곳에서 관리
		// 서로 다른 계산식을 적용해야할 경우
		// 예를 들어, cal_a는 그대로의 값을, calc_b는 *10한 값을, calc_c는 *3한 값을 입력하는 
		
		
		
		
		
	}
}

public enum TableStatus
{
	// Y, 1, true는 모두 같은 의미를 갖는다.
	// N, 0, false는 모두 같은 의미를 갖는다.
	Y("1", true), N("0", false);

	private String table1Value;
	private boolean table2Value;

	TableStatus(String talbeValue, boolean table2Value)
	{
		this.table1Value = table1Value;
		this.table2Value = table2Value;
	}

	public String getTable1Value()
	{
		return table1Value;
	}

	public boolean isTable2Value()
	{
		return table2Value;
	}
}

public enum CalculatorType {
	CALC_A(value -> value),
	CALC_B(value -> value*10),
	CALC_C(value -> value*3);
	
	private Function<Long,Long> expression;
	
	CalculatorType(Function<Long, Long> expression) {
		this.expression = expression;
	}
	
	public long calculator(Long long) {
		return expression.apply(value);
	}
	
}