# clear-tax-sdk
Unofficial java clear tax sdk

# Installation

In pom.xml add the below : 
1. in dependencies : 

```
<dependency>
    <groupId>com.github.manojcchoudhary<groupId>
    <artifactId>clear-tax-sdk</artifactId>
    <version>v0.0.1</version>
</dependency>
```

2. in repositories : 

```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
# Usage 

Initialize Configuration by 

```
public class ExampleApplication {

    private Validator validator = ClearTaxValidationUtils.getValidator();

    private String host = "<replace_with_your_host_name>";
	private String authToken = "<replace_with_your_auth_token>";
	private String ownerId = "<replace_with_your_owner_id>";
	private String gstin = "<replace_with_your_gstin_id>";

    public static void main(String[] args) {
        ClearTaxConfiguration config = ClearTaxConfiguration.builder()
            .host(host)
            .authToken(authToken)
            .ownerId(ownerId)
            .gstin(gstin)
            .build();
            
        configurationProvider.initialize(config);                

        // ClearInvoiceApi.generateIrn(payload) for generating irn using clear schema
        // ClearInvoiceApi.downloadEInvoice(payload) for downloading e-invoice
    }
}
```