package io.litego.api;

import com.google.gson.Gson;
import io.litego.api.enums.Currency;
import io.litego.api.enums.Mode;
import io.litego.api.enums.Status;
import io.litego.api.model.*;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.function.Consumer;

public class Application {
    public static void main(String[] args) {

        Litego litego = new Litego(Mode.TEST_URL);

        String merchantId = "55e4969e-03cf-453a-9e6d-6aa65d1e4cdf";
        String secretKey = "m1uk7dmd1hbqu43bp8htrkih95";

//        String merchantId = "5eba9919-3ab0-453d-8e81-3f96a863d1ae";
//        String secretKey = "bcmpeh0ebr52iv2n0vdk2nr6bu";


        try {
            Gson gson = new Gson();

            AuthResponse authResponse = litego.authenticate(merchantId, secretKey);
            String authToken = authResponse.auth_token;


//            String authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkMmFiMTg1Yi00ODAzLTQ0MjQtOThiNS00Nj" +
//                    "JhMGE4YzhmMjQiLCJleHAiOjE1NDgxNjEwNjksImlhdCI6MTU0ODA3NDY2OSwicm9sZXMiOltdLCJpc1JlZnJlc2hUb2t" +
//                    "lbiI6ZmFsc2V9.fwmfKijUTHre8bx3S8OHFxTj9ENTvVJIE4EdyhCZUTpEzuauHS8AO4KPRU_jqgfdOHXAdt8MhrSAUNg_" +
//                    "G9WRFQ";
//            System.out.println(authToken);

//            WithdrawalAddressResponse address = litego.setWithdrawalAddress(authToken, "2MuN5yzwGtiPk5gdExB1NRMpDhZdQ9DsdcW", Withdrawals.REGULAR_ADDRESS_TYPE);
//            System.out.println(address);

//            MerchantInfoResponse merchantInfoResponse = litego.getMerchantSummary(authToken);
//            System.out.println(gson.toJson(merchantInfoResponse));


//            WithdrawalTransactionResponse transactionResponse = litego.withdrawToBlockchain(authToken);
//            System.out.println(transactionResponse);

//            ExecutorService executorService = Executors.newFixedThreadPool(3);

//            ChargeResponse chargeResponse = litego.createCharge(authToken, "buy TV", 60000);
//            System.out.println(chargeResponse);

//            PaginatedListResponse<ChargeResponse> chargeListResponse = litego.chargesList(authToken);
//            System.out.println(gson.toJson(chargeListResponse));

//            PaginatedListResponse<WithdrawalTransactionResponse> listResponse = litego.getListWithdrawals(authToken, Status.CONFIRMED);
//            System.out.println(gson.toJson(listResponse));

//            ValidateResponse validateResponse = litego.validate(authToken, new ValidateRequest("lntb10u1pwf3r45pp5f637luj3cxftpz8j90waqgg4purlte6qyjr9uj53ywpvnrj85znqdpzwfjkvun9vajhyct5daezq6twwehkjcm9xycqzysxqrrsszs3ns6z96p56j6hh5d9l7zekp8w3wn2e5ne9qpklrsa0fxk4u64qp9s5u6u9wdu8qrcy9xwlsf9hp8sc3l7wffclufvyxv4syly4nvqqaj5wyd", 100));
//            System.out.println(gson.toJson(validateResponse));
//            NotificationResponse notificationResponse = litego.setNotificationUrl(authToken, "http://localhost:9000");
//            System.out.println(notificationResponse);

//            PaginatedListResponse<Notification> responsesList = litego.getListOfNotificationResponses(authToken);
//            System.out.println(gson.toJson(responsesList));

//            WithdrawalSettingsResponse settingsResponse = litego.getWithdrawalSettings(authToken);
//            System.out.println(gson.toJson(settingsResponse));

            PaginatedListResponse<ReferralPayment> paymentsResponse = litego.getReferralPayments(authToken);
            System.out.println(gson.toJson(paymentsResponse));

           /* ChargeResponse chargeResponse = litego.createCharge(authToken, "buy TV", 60000);
            System.out.println(gson.toJson(chargeResponse));

            litego.addPaymentsEventSubscribeListener(Mode.TEST_URL, authToken, new WebSocketListener() {
                @Override
                public void onMessage(WebSocket webSocket, String text) {
                    System.out.println("Receiving : " + text);
                    SettledInvoiceEvent event = gson.fromJson(text, SettledInvoiceEvent.class);
                    System.out.println(gson.toJson(event));
                }
            });*/


//            chargeResponse = litego.createCharge(authToken, "buy TV2", 65000);
//            System.out.println(gson.toJson(chargeResponse));

//            litego.receiveWalletTransferEventListener(Mode.TEST_URL, authToken, Currency.BTC, new WebSocketListener() {
//                @Override
//                public void onClosing(WebSocket webSocket, int code, String reason) {
//                    System.out.println("??????????????????????????");
//                    System.out.println(code);
//                    System.out.println(reason);
//                    System.out.println("??????????????????????????");
//                }
//
//                @Override
//                public void onFailure(WebSocket webSocket, Throwable t, Response response) {
//                    System.out.println("+++++++++++++++++++++");
//                    System.out.println(response);
//                    System.out.println("+++++++++++++++++++++");
//                }
//
//                @Override
//                public void onOpen(WebSocket webSocket, Response response) {
//                    System.out.println("=====================");
//                    System.out.println(response);
//                    System.out.println("=====================");
//                }
//
//                @Override
//                public void onMessage(WebSocket webSocket, String text) {
//                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ " + text);
//                }
//            });
        /*    ExecutorService executorService = Executors.newFixedThreadPool(3);

            Runnable runnable1 = () -> {
                try {
                    litego.sendCoins(authToken, new WithdrawEos("litegolitego", 0.0001, "{\"id\":\"d2ab185b-4803-4424-98b5-462a0a8c8f24\",\"data\":\"1\"}"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Runnable runnable2 = () -> {
                try {
                    litego.sendCoins(authToken, new WithdrawEos("litegolitego", 0.0001, "{\"id\":\"d2ab185b-4803-4424-98b5-462a0a8c8f24\",\"data\":\"2\"}"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Runnable runnable3 = () -> {
                try {
                    litego.sendCoins(authToken, new WithdrawEos("litegolitego", 0.0001, "{\"id\":\"d2ab185b-4803-4424-98b5-462a0a8c8f24\",\"data\":\"3\"}"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable1);
            executorService.execute(runnable2);
            executorService.execute(runnable3);*/

//            WithdrawalTransactionResponse withdrawalTransactionResponse = litego.withdrawToLightning("lntb1u1pwf3npdpp5s88l035z0qp47sppfrdkpexm" +
//                    "d9vszp3c4l5mjry3zk5q82xqr4xsdpzwfjkvun9vajhyct5daezq6twwehkjcm9xycqzysxqrrsswtam2hqw6kjp6fq3l9l5ewug2cxp29cfts9eaejz2dze4uskc7" +
//                    "530y52jmkhxsgml7dhrvkm4y6kqhrt4qvw6myasxuhqqg6ryap8vcqt7jqvm", 100L, authToken);
//            System.out.println(gson.toJson(withdrawalTransactionResponse));

//            WalletAddressResponse address1 = litego.generateAddress(authToken, Currency.EOS);
//            WalletAddressResponse address2 = litego.generateAddress(authToken, Currency.EOS);
//            System.out.println("address: " + address1);
//            System.out.println("address: " + address2);

//            WalletBalanceResponse balanceResponse = litego.getWalletBalance(authToken, Currency.EOS);
//            System.out.println("getWalletBalance: " + gson.toJson(balanceResponse));

//            WalletSendCoinsResponse withdrawResponse = litego.sendCoins(authToken, new SendCoinsRequest("eostestner12", 0.0001, "from java lib", Currency.EOS));
//            System.out.println("sendCoins: " + gson.toJson(withdrawResponse));

//            WalletSendCoinsResponse withdrawResponse = litego.sendCoins(authToken, new SendCoinsRequest(address1, 600, "from libs", Currency.EOS));
//            System.out.println("sendCoins: " + gson.toJson(withdrawResponse));

//            try {
//                SendManyResponse manyResponse = litego.sendMany(authToken, new SendManyRequest("send many", Currency.EOS,
//                        new SendCoinsRequest(address1.address, 700),
//                        new SendCoinsRequest(address2.address, 750)
//                ));
//                System.out.println("sendMany: " + gson.toJson(manyResponse));

//            } catch (Exception e) {

//            }

//            Thread.sleep(15000);
//            TransferResponse transferResponse = litego.getTransfer(authToken, withdrawResponse.id, Currency.EOS);
//            System.out.println("getTransfer: " + gson.toJson(transferResponse));

//            PaginatedListResponse<TransferResponse> chargeListResponse = litego.getTransfers(authToken, Currency.EOS);
//            System.out.println("getTransfers: " + gson.toJson(chargeListResponse));

//            WalletBalanceResponse balanceResponse1 = litego.getWalletBalance(authToken, Currency.EOS);
//            System.out.println("getWalletBalance: " + gson.toJson(balanceResponse1));

//            WithdrawalTransactionResponse transactionResponse = litego.withdrawToChannel(
//                    "03b882dcd309adaf4d66d1aadfbc6e85764bd65c6bdaf03689c55f1abd13f53fc5@nodetestnet.litego.io:9735", 250000L, authToken);
//            System.out.println(gson.toJson(transactionResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
