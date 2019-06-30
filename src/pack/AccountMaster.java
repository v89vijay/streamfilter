package pack;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountMaster {
	private String accNo;
	private String bankCode;
	private String branchCode;
	private BigInteger accId;
	private BigDecimal shadowBalance;

	public AccountMaster() {
		super();
	}

	public AccountMaster(String accNo, String bankCode, String branchCode, BigInteger accId, BigDecimal shadowBalance) {
		super();
		this.accNo = accNo;
		this.bankCode = bankCode;
		this.branchCode = branchCode;
		this.accId = accId;
		this.shadowBalance = shadowBalance;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public BigInteger getAccId() {
		return accId;
	}

	public void setAccId(BigInteger accId) {
		this.accId = accId;
	}

	public BigDecimal getShadowBalance() {
		return shadowBalance;
	}

	public void setShadowBalance(BigDecimal shadowBalance) {
		this.shadowBalance = shadowBalance;
	}

	@Override
	public String toString() {
		return "AccountMaster [accNo=" + accNo + ", bankCode=" + bankCode + ", branchCode=" + branchCode + ", accId="
				+ accId + ", shadowBalance=" + shadowBalance + "]";
	}
}
