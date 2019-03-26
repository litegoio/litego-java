# litego-java

Simple Litego API wrapper class, in Java.
Litego API documentation can be found here https://litego.io/documentation/

## Requirements

Java 1.8 or later.

## Dependencies

- [Gson](https://sites.google.com/site/gson/gson-user-guide) Java library that can be used to convert Java Objects into their JSON representation.
- [OkHttp](http://square.github.io/okhttp/) An HTTP & HTTP/2 client for Android and Java applications

## Installation    

To use litego-java as a dependency in your project, the easiest way right now is to clone and publish it locally. Simply run:

```bash
git clone https://github.com/litegoio/litego-java.git
cd litego-java
mvn install
```
and then add to pom.xml

```xml
<dependencies>
    <dependency>
        <groupId>io.litego</groupId>
        <artifactId>litego-java</artifactId>
        <version>0.2</version>
    </dependency>
</dependencies>
```

## Examples

Creating an instance with test/live mode
```java
Litego litego = new Litego(Mode.TEST_URL);
```
or
```java
Litego litego = new Litego(Mode.LIVE_URL);
```
After registration on https://litego.io and getting secret key and merchant ID values try to authenticate (get auth token for other requests)
Two ways how to get auth token:
- secret key and merchant ID
- refresh token (if exists). 

```java
AuthResponse authResponse = litego.authenticate(merchantId, secretKey);
```        
or get new if expired
```java
AuthTokenResponse tokenResponse = litego.refreshAuthToken(refreshToken);
```
You will get auth token and refresh token values. Auth token will be used then for other API requests. Refresh token should be saved for reauthentication when auth token is expired.

Create charge
```java
ChargeResponse chargeResponse = litego.createCharge(authToken, description, amount_satoshi)
```

Charges list 
```java
PaginatedListResponse<ChargeResponse> chargeList = litego.chargesList(authToken, isPaid, page, pageSize);
```

Get charge
```java
ChargeResponse charge = litego.getCharge(authToken, chargeId);
```

Get information about authenticated merchant
```java
MerchantInfoResponse merchantInfo = getMerchantSummary(authToken);
```

Set withdrawal address
```java
WithdrawalAddressResponse address = litego.setWithdrawalAddress(authToken, someAddress, Withdrawals.REGULAR_ADDRESS_TYPE);
```

Get withdrawal settings
```java
WithdrawalSettingsResponse settingsResponse = litego.getWithdrawalSettings(authToken);
```

Request manual withdrawal
```java
WithdrawalTransactionResponse transaction = litego.withdrawManually(authToken);
```

Withdrawals list
```java
PaginatedListResponse<WithdrawalTransactionResponse> withdrawalList = litego.getListWithdrawals(authToken);
```

Set webhook URL
```java
NotificationResponse notification = litego.setNotificationUrl(authToken, "http://litego.io");
```

List responses from webhook
```java
PaginatedListResponse<Notification> responsesList = litego.getListOfNotificationResponses(authToken);
```

List referral payments
```java
PaginatedListResponse<ReferralPayment> paymentsResponse = litego.getReferralPayments(authToken, page, pageSize);
```

Validate lightning invoice
```java
ValidateResponse validateResponse = litego.validate(authToken, new ValidateRequest(someInvoice, amountSat));
```

Withdrawal to lightning
```java
WithdrawalTransactionResponse withdrawalTransactionResponse = litego.withdrawToLightning(someInvoice, amountSat, authToken);
```

Withdrawal to channel
```java
WithdrawalTransactionResponse transactionResponse = litego.withdrawToChannel("03b882dcd309adaf4d66d1aadfbc6e85764bd65c6bdaf03689c55f1abd13f53fc5@nodetestnet.litego.io:9735", amountSat, authToken);
```

### Wallet

Generate address
```java
WalletAddressResponse address = litego.generateAddress(authToken, Currency.BTC);
```

Send coins
```java
WalletSendCoinsResponse withdrawResponse = litego.sendCoins(authToken, new SendCoinsRequest(accountToSend, amountEosDouble, someMemo, Currency.EOS));
```

Send many
```java
SendManyResponse manyResponse = litego.sendMany(authToken, new SendManyRequest(comment, Currency.BTC,
                        new SendCoinsRequest(address1, amountSat),
                        new SendCoinsRequest(address2, amountSat)
                ));
```

Get transfer
```java
TransferResponse transferResponse = litego.getTransfer(authToken, transferId, Currency.EOS);
```

Get transfers
```java
PaginatedListResponse<TransferResponse> chargeListResponse = litego.getTransfers(authToken, Currency.EOS);
```

Get wallet balance
```java
WalletBalanceResponse balanceResponse1 = litego.getWalletBalance(authToken, Currency.EOS);
```

### Websocket subscriptions

You can subscribe to topics with payments of all your charges or a single charge by it's ID
just registering event listeners, which are objects that implement 
an interface WebSocketListener.

Subscribe for payments
```java
litego.addPaymentsEventSubscribeListener(Mode.TEST_URL, authToken, new WebSocketListener() {
    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Receive: " + text);
    }
});
```

Subscribe for payment of single charge
```java
litego.addPaymentsEventSubscribeListenerSingle(Mode.TEST_URL, authToken, "2f551fc0-1faa-11e9-90e2-df42b3b425c0", new WebSocketListener() {
    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Receive: " + text);
    }
});
```

Subscribe for receive wallet transfer
```java
litego.receiveWalletTransferEventListener(Mode.TEST_URL, authToken, Currency.BTC, new WebSocketListener() {
    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println("Receive: " + text);
    }
});
```
