package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to Account information"
)
public class AccountsDto {

    @NotEmpty(message="AccountNumber cannot be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account number of Eazy Bank account",example="3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message="AccountType")
    @Schema(description = "Account type of eazy bank account", example="Savings")
    private String accountType;

    @NotEmpty(message = "BranchAddress cannot be a null or empty")
    @Schema(description = "Branch Address of eazy bank account", example="123 NewYork")
    private String branchAddress;

}
