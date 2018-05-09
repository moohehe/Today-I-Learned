// http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
public class EnumTest2
{
	public static void main(String[] args)
	{
		// STEP1. 데이터들 간의 연관관계 표현
		
		// given
		TableStatus origin = selectFromOriginalTable();

		// then
		String table1Value = origin.getTable1Value();
		boolean table2Value = origin.isTable2Value();

		assertThat(origin, is(TableStatus.Y));
		assertThat(table1Value, is("1"));
		aseertThat(table2Value, is(true));

		
		
		
		
		
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
