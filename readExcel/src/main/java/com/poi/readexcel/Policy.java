package com.poi.readexcel;

import java.math.BigDecimal;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Policy.
 */
public class Policy {

  /** The product code. */
  // 产品代码
  private String productCode;

  /** The risk code. */
  // 险种代码
  private String productName;

  /** The agent id. */
  // 业务员ID
  private String agentId;

  /** The policy number. */
  // 保单号
  private String policyNumber;

  /** The premium. */
  // 实际保费
  private BigDecimal premium;

  /** The payment year. */
  // 交费期间
  private int paymentYear;

  /**
   * The Enum paymentEnum.
   */
  // 交费方式(年交，趸交)
  private enum paymentEnum {

    /** The annual. */
    ANNUAL,
    /** The single. */
    SINGLE;
  }

  /** The app signed date. */
  // 投保日期
  private Date appSignedDate;

  /** The inception date. */
  // 保险起期
  private Date inceptionDate;

  /** The planned end date. */
  // 保险止期
  private Date plannedEndDate;

  /** The application name. */
  // 投保人姓名
  private String applicationName;

  /** The insurance name. */
  // 被保人姓名
  private String insuranceName;

  /**
   * Gets the product code.
   *
   * @return the product code
   */
  public String getProductCode() {
    return productCode;
  }

  /**
   * Sets the product code.
   *
   * @param productCode the new product code
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  /**
   * Gets the risk code.
   *
   * @return the risk code
   */
  public String getRiskCode() {
    return riskCode;
  }

  /**
   * Sets the risk code.
   *
   * @param riskCode the new risk code
   */
  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }

  /**
   * Gets the agent id.
   *
   * @return the agent id
   */
  public String getAgentId() {
    return agentId;
  }

  /**
   * Sets the agent id.
   *
   * @param agentId the new agent id
   */
  public void setAgentId(String agentId) {
    this.agentId = agentId;
  }

  /**
   * Gets the policy number.
   *
   * @return the policy number
   */
  public String getPolicyNumber() {
    return policyNumber;
  }

  /**
   * Sets the policy number.
   *
   * @param policyNumber the new policy number
   */
  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  /**
   * Gets the premium.
   *
   * @return the premium
   */
  public BigDecimal getPremium() {
    return premium;
  }

  /**
   * Sets the premium.
   *
   * @param premium the new premium
   */
  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }

  /**
   * Gets the payment year.
   *
   * @return the payment year
   */
  public int getPaymentYear() {
    return paymentYear;
  }

  /**
   * Sets the payment year.
   *
   * @param paymentYear the new payment year
   */
  public void setPaymentYear(int paymentYear) {
    this.paymentYear = paymentYear;
  }

  /**
   * Gets the app signed date.
   *
   * @return the app signed date
   */
  public Date getAppSignedDate() {
    return appSignedDate;
  }

  /**
   * Sets the app signed date.
   *
   * @param appSignedDate the new app signed date
   */
  public void setAppSignedDate(Date appSignedDate) {
    this.appSignedDate = appSignedDate;
  }

  /**
   * Gets the inception date.
   *
   * @return the inception date
   */
  public Date getInceptionDate() {
    return inceptionDate;
  }

  /**
   * Sets the inception date.
   *
   * @param inceptionDate the new inception date
   */
  public void setInceptionDate(Date inceptionDate) {
    this.inceptionDate = inceptionDate;
  }

  /**
   * Gets the planned end date.
   *
   * @return the planned end date
   */
  public Date getPlannedEndDate() {
    return plannedEndDate;
  }

  /**
   * Sets the planned end date.
   *
   * @param plannedEndDate the new planned end date
   */
  public void setPlannedEndDate(Date plannedEndDate) {
    this.plannedEndDate = plannedEndDate;
  }

  /**
   * Gets the application name.
   *
   * @return the application name
   */
  public String getApplicationName() {
    return applicationName;
  }

  /**
   * Sets the application name.
   *
   * @param applicationName the new application name
   */
  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * Gets the insurance name.
   *
   * @return the insurance name
   */
  public String getInsuranceName() {
    return insuranceName;
  }

  /**
   * Sets the insurance name.
   *
   * @param insuranceName the new insurance name
   */
  public void setInsuranceName(String insuranceName) {
    this.insuranceName = insuranceName;
  }

  /**
   * Instantiates a new policy.
   *
   * @param productCode the product code
   * @param riskCode the risk code
   * @param agentId the agent id
   * @param policyNumber the policy number
   * @param premium the premium
   * @param paymentYear the payment year
   * @param appSignedDate the app signed date
   * @param inceptionDate the inception date
   */
  public Policy(String productCode, String riskCode, String agentId, String policyNumber,
      BigDecimal premium, int paymentYear, Date appSignedDate, Date inceptionDate) {
    super();
    this.productCode = productCode;
    this.riskCode = riskCode;
    this.agentId = agentId;
    this.policyNumber = policyNumber;
    this.premium = premium;
    this.paymentYear = paymentYear;
    this.appSignedDate = appSignedDate;
    this.inceptionDate = inceptionDate;
  }

  /**
   * Instantiates a new policy.
   *
   * @param productCode the product code
   * @param riskCode the risk code
   * @param agentId the agent id
   * @param policyNumber the policy number
   * @param premium the premium
   * @param paymentYear the payment year
   * @param appSignedDate the app signed date
   * @param inceptionDate the inception date
   * @param plannedEndDate the planned end date
   * @param applicationName the application name
   * @param insuranceName the insurance name
   */
  public Policy(String productCode, String riskCode, String agentId, String policyNumber,
      BigDecimal premium, int paymentYear, Date appSignedDate, Date inceptionDate,
      Date plannedEndDate, String applicationName, String insuranceName) {
    super();
    this.productCode = productCode;
    this.riskCode = riskCode;
    this.agentId = agentId;
    this.policyNumber = policyNumber;
    this.premium = premium;
    this.paymentYear = paymentYear;
    this.appSignedDate = appSignedDate;
    this.inceptionDate = inceptionDate;
    this.plannedEndDate = plannedEndDate;
    this.applicationName = applicationName;
    this.insuranceName = insuranceName;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Policy [productCode=" + productCode + ", riskCode=" + riskCode + ", agentId=" + agentId
        + ", policyNumber=" + policyNumber + ", premium=" + premium + ", paymentYear=" + paymentYear
        + ", appSignedDate=" + appSignedDate + ", inceptionDate=" + inceptionDate
        + ", plannedEndDate=" + plannedEndDate + ", applicationName=" + applicationName
        + ", insuranceName=" + insuranceName + "]";
  }

  /**
   * Instantiates a new policy.
   */
  Policy() {
    super();
  }


}
