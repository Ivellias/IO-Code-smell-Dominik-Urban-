interface CurrencyType{
	public String format(int amount);
}
class USDCurrency implements CurrencyType{
	public String format(int amount){
		return amount+"$$$";
	}
}
class RMBCurrency implements CurrencyType{
	public String format(int amount){
		return amount+"RMB";
	}
}
class ESCUDOCurrency implements CurrencyType{
	public String format(int amount){
		return amount+"ESC";
	}
}
class Currency {
	private CurrencyType currencyType;
	public Currency(CurrencyType currencyType) {
		this.currencyType=currencyType;
	}
	public String format(int amount) {
		return currencyType.format(amount);
	}
}