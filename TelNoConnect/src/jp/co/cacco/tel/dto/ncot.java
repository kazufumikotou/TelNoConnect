package jp.co.cacco.tel.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 検索条件、結果保持用DTO
 * 
 */
@Bean(table = "ncot")
public class ncot implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 電話番号(検索条件) */
    private String telno;
    
	/** 検索結果(1年分) */
    private String flag0;
    private String itentelno0;
    private Date hiduke0;
    private String flag1;
    private String itentelno1;
    private Date hiduke1;
    private String flag2;
    private String itentelno2;
    private Date hiduke2;
    private String flag3;
    private String itentelno3;
    private Date hiduke3;
    private String flag4;
    private String itentelno4;
    private Date hiduke4;
    private String flag5;
    private String itentelno5;
    private Date hiduke5;
    private String flag6;
    private String itentelno6;
    private Date hiduke6;
    private String flag7;
    private String itentelno7;
    private Date hiduke7;
    private String flag8;
    private String itentelno8;
    private Date hiduke8;
    private String flag9;
    private String itentelno9;
    private Date hiduke9;
    private String flag10;
    private String itentelno10;
    private Date hiduke10;
    private String flag11;
    private String itentelno11;
    private Date hiduke11;
    private String flag12;
    private String itentelno12;
    private Date hiduke12;
    
    /**
     * 電話番号取得
     */
    public String getTelNo() {
        return telno;
    }

    /**
     * 電話番号設定
     */
    @Column("telno")
    public void setTelNo(String telno) {
        this.telno = telno;
    }
    
    /**
     * TACSフラグ0取得
     */
    public String getFlag0() {
		return flag0;
	}
    
    /**
     * TACSフラグ0設定
     */
	public void setFlag0(String flag0) {
		this.flag0 = flag0;
	}
	
    /**
     * 移転案内番号0取得
     */
	public String getItentelno0() {
		return itentelno0;
	}
	
    /**
     * 移転案内番号0設定
     */
	public void setItentelno0(String itentelno0) {
		this.itentelno0 = itentelno0;
	}
	
    /**
     * TACS処理日0取得
     */
	public Date getHiduke0() {
		return hiduke0;
	}
	
    /**
     * TACS処理日0設定
     */
	public void setHiduke0(Date hiduke0) {
		this.hiduke0 = hiduke0;
	}

    /**
     * TACSフラグ1取得
     */
	public String getFlag1() {
		return flag1;
	}
	
    /**
     * TACSフラグ1設定
     */
	public void setFlag1(String flag1) {
		this.flag1 = flag1;
	}
	
    /**
     * 移転案内番号1取得
     */
	public String getItentelno1() {
		return itentelno1;
	}
	
    /**
     * 移転案内番号1設定
     */
	public void setItentelno1(String itentelno1) {
		this.itentelno1 = itentelno1;
	}
	
    /**
     * TACS処理日1取得
     */
	public Date getHiduke1() {
		return hiduke1;
	}
	
    /**
     * TACS処理日1設定
     */
	public void setHiduke1(Date hiduke1) {
		this.hiduke1 = hiduke1;
	}
	
    /**
     * TACSフラグ2取得
     */
	public String getFlag2() {
		return flag2;
	}
	
    /**
     * TACSフラグ2設定
     */
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}
	
    /**
     * 移転案内番号2取得
     */
	public String getItentelno2() {
		return itentelno2;
	}
	
    /**
     * 移転案内番号2設定
     */
	public void setItentelno2(String itentelno2) {
		this.itentelno2 = itentelno2;
	}
	
    /**
     * TACS処理日2取得
     */
	public Date getHiduke2() {
		return hiduke2;
	}
	
    /**
     * TACS処理日2設定
     */
	public void setHiduke2(Date hiduke2) {
		this.hiduke2 = hiduke2;
	}
	
    /**
     * TACSフラグ3取得
     */
	public String getFlag3() {
		return flag3;
	}
	
    /**
     * TACSフラグ3設定
     */
	public void setFlag3(String flag3) {
		this.flag3 = flag3;
	}
	
    /**
     * 移転案内番号3取得
     */
	public String getItentelno3() {
		return itentelno3;
	}
	
    /**
     * 移転案内番号3設定
     */
	public void setItentelno3(String itentelno3) {
		this.itentelno3 = itentelno3;
	}
	
    /**
     * TACS処理日3取得
     */
	public Date getHiduke3() {
		return hiduke3;
	}
	
    /**
     * TACS処理日3設定
     */
	public void setHiduke3(Date hiduke3) {
		this.hiduke3 = hiduke3;
	}
	
    /**
     * TACSフラグ4取得
     */
	public String getFlag4() {
		return flag4;
	}
	
    /**
     * TACSフラグ4設定
     */
	public void setFlag4(String flag4) {
		this.flag4 = flag4;
	}
	
    /**
     * 移転案内番号4取得
     */
	public String getItentelno4() {
		return itentelno4;
	}
	
    /**
     * 移転案内番号4設定
     */
	public void setItentelno4(String itentelno4) {
		this.itentelno4 = itentelno4;
	}
	
    /**
     * TACS処理日4取得
     */
	public Date getHiduke4() {
		return hiduke4;
	}
	
    /**
     * TACS処理日4設定
     */
	public void setHiduke4(Date hiduke4) {
		this.hiduke4 = hiduke4;
	}
	
    /**
     * TACSフラグ5取得
     */
	public String getFlag5() {
		return flag5;
	}
	
    /**
     * TACSフラグ5設定
     */
	public void setFlag5(String flag5) {
		this.flag5 = flag5;
	}
	
    /**
     * 移転案内番号5取得
     */
	public String getItentelno5() {
		return itentelno5;
	}
	
    /**
     * 移転案内番号5設定
     */
	public void setItentelno5(String itentelno5) {
		this.itentelno5 = itentelno5;
	}
	
    /**
     * TACS処理日5取得
     */
	public Date getHiduke5() {
		return hiduke5;
	}
	
    /**
     * TACS処理日5設定
     */
	public void setHiduke5(Date hiduke5) {
		this.hiduke5 = hiduke5;
	}
	
    /**
     * TACSフラグ6取得
     */
	public String getFlag6() {
		return flag6;
	}
	
    /**
     * TACSフラグ6設定
     */
	public void setFlag6(String flag6) {
		this.flag6 = flag6;
	}
	
    /**
     * 移転案内番号6取得
     */
	public String getItentelno6() {
		return itentelno6;
	}
	
    /**
     * 移転案内番号6設定
     */
	public void setItentelno6(String itentelno6) {
		this.itentelno6 = itentelno6;
	}
	
    /**
     * TACS処理日6取得
     */
	public Date getHiduke6() {
		return hiduke6;
	}
	
    /**
     * TACS処理日6設定
     */
	public void setHiduke6(Date hiduke6) {
		this.hiduke6 = hiduke6;
	}
	
    /**
     * TACSフラグ7取得
     */
	public String getFlag7() {
		return flag7;
	}
	
    /**
     * TACSフラグ7設定
     */
	public void setFlag7(String flag7) {
		this.flag7 = flag7;
	}
	
    /**
     * 移転案内番号7取得
     */
	public String getItentelno7() {
		return itentelno7;
	}
	
    /**
     * 移転案内番号7設定
     */
	public void setItentelno7(String itentelno7) {
		this.itentelno7 = itentelno7;
	}
	
    /**
     * TACS処理日7取得
     */
	public Date getHiduke7() {
		return hiduke7;
	}
	
    /**
     * TACS処理日7設定
     */
	public void setHiduke7(Date hiduke7) {
		this.hiduke7 = hiduke7;
	}
	
    /**
     * TACSフラグ8取得
     */
	public String getFlag8() {
		return flag8;
	}
	
    /**
     * TACSフラグ8設定
     */
	public void setFlag8(String flag8) {
		this.flag8 = flag8;
	}
	
    /**
     * 移転案内番号8取得
     */
	public String getItentelno8() {
		return itentelno8;
	}
	
    /**
     * 移転案内番号8設定
     */
	public void setItentelno8(String itentelno8) {
		this.itentelno8 = itentelno8;
	}
	
    /**
     * TACS処理日8取得
     */
	public Date getHiduke8() {
		return hiduke8;
	}
	
    /**
     * TACS処理日8設定
     */
	public void setHiduke8(Date hiduke8) {
		this.hiduke8 = hiduke8;
	}
	
    /**
     * TACSフラグ9取得
     */
	public String getFlag9() {
		return flag9;
	}
	
    /**
     * TACSフラグ9設定
     */
	public void setFlag9(String flag9) {
		this.flag9 = flag9;
	}
	
    /**
     * 移転案内番号9取得
     */
	public String getItentelno9() {
		return itentelno9;
	}
	
    /**
     * 移転案内番号9設定
     */
	public void setItentelno9(String itentelno9) {
		this.itentelno9 = itentelno9;
	}
	
    /**
     * TACS処理日9取得
     */
	public Date getHiduke9() {
		return hiduke9;
	}
	
    /**
     * TACS処理日9設定
     */
	public void setHiduke9(Date hiduke9) {
		this.hiduke9 = hiduke9;
	}
	
    /**
     * TACSフラグ10取得
     */
	public String getFlag10() {
		return flag10;
	}
	
    /**
     * TACSフラグ10設定
     */
	public void setFlag10(String flag10) {
		this.flag10 = flag10;
	}
	
    /**
     * 移転案内番号10取得
     */
	public String getItentelno10() {
		return itentelno10;
	}
	
    /**
     * 移転案内番号10設定
     */
	public void setItentelno10(String itentelno10) {
		this.itentelno10 = itentelno10;
	}
	
    /**
     * TACS処理日10取得
     */
	public Date getHiduke10() {
		return hiduke10;
	}
	
    /**
     * TACS処理日10設定
     */
	public void setHiduke10(Date hiduke10) {
		this.hiduke10 = hiduke10;
	}
	
    /**
     * TACSフラグ11取得
     */
	public String getFlag11() {
		return flag11;
	}
	
    /**
     * TACSフラグ11設定
     */
	public void setFlag11(String flag11) {
		this.flag11 = flag11;
	}
	
    /**
     * 移転案内番号11取得
     */
	public String getItentelno11() {
		return itentelno11;
	}
	
    /**
     * 移転案内番号11設定
     */
	public void setItentelno11(String itentelno11) {
		this.itentelno11 = itentelno11;
	}
	
    /**
     * TACS処理日11取得
     */
	public Date getHiduke11() {
		return hiduke11;
	}
	
    /**
     * TACS処理日11設定
     */
	public void setHiduke11(Date hiduke11) {
		this.hiduke11 = hiduke11;
	}
	
    /**
     * TACSフラグ12取得
     */
	public String getFlag12() {
		return flag12;
	}
	
    /**
     * TACSフラグ11設定
     */
	public void setFlag12(String flag12) {
		this.flag12 = flag12;
	}
	
    /**
     * 移転案内番号11取得
     */
	public String getItentelno12() {
		return itentelno12;
	}
	
    /**
     * 移転案内番号11設定
     */
	public void setItentelno12(String itentelno12) {
		this.itentelno12 = itentelno12;
	}
	
    /**
     * TACS処理日11取得
     */
	public Date getHiduke12() {
		return hiduke12;
	}
	
    /**
     * TACS処理日11設定
     */
	public void setHiduke12(Date hiduke12) {
		this.hiduke12 = hiduke12;
	}	

}
