package com.example.complexeSportif.entities.Enum;

public enum SubscriptionType {
  ONE_MONTH("One Month", 1),
  THREE_MONTHS("Three Months", 3),
  SIX_MONTHS("Six Months", 6),
  ONE_YEAR("One Year", 12);

  private final String label;
  private final int durationInMonths;

  SubscriptionType(String label, int durationInMonths) {
    this.label = label;
    this.durationInMonths = durationInMonths;
  }

  public String getLabel() {
    return label;
  }

  public int getDurationInMonths() {
    return durationInMonths;
  }

}
