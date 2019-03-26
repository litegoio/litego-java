package io.litego.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.litego.api.enums.Currency;
import io.litego.api.enums.Mode;
import io.litego.api.enums.Status;
import io.litego.api.enums.Withdrawals;
import io.litego.api.exception.*;
import io.litego.api.model.*;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Litego {
    final static private String AUTHENTICATE = "/api/v1/merchant/authenticate";
    final static private String REFRESH_AUTH = "/api/v1/merchant/me/refresh-auth";
    final static private String CHARGES = "/api/v1/charges";
    final static private String MERCHANT_SUMMARY = "/api/v1/merchant/me";
    final static private String WITHDRAWAL_ADDRESS = "/api/v1/merchant/me/withdrawal/address";
    final static private String WITHDRAW_MANUALLY = "/api/v1/merchant/me/withdrawal/manual";
    final static private String WITHDRAW_LIGHTNING = "/api/v1/merchant/me/withdrawal/lightning-invoice";
    final static private String WITHDRAW_TOCHANNEL = "/api/v1/merchant/me/withdrawal/lightning-channel";
    final static private String LIST_WITHDRAWALS = "/api/v1/merchant/me/withdrawals";
    final static private String NOTIFICATION_URL = "/api/v1/merchant/me/notification-url";
    final static private String LIST_NOTIFICATION_RESPONSES = "/api/v1/merchant/me/notification-responses";
    final static private String WITHDRAWAL_SETTINGS = "/api/v1/merchant/withdrawal/settings";
    final static private String LISTREFERRAL_PAYMENTS = "/api/v1/merchant/me/referral-payments";
    final static private String SUBSCRIBE_PAYMENT = "/api/v1/payments/subscribe";
    final static private String SUBSCRIBE_PAYMENT_SINGLE = "/api/v1/payments/subscribe/";
    final static private String VALIDATE_LIGHTNING = "/api/v1/utils/payment_request_status";

    final static private String SEND_COINS = "/api/v1/currency/sendcoins";
    final static private String SEND_MANY = "/api/v1/currency/sendmany";
    final static private String SUBSCRIBE_WALLET_TRANSACTION = "/api/v1/currency/transfers/subscribe";
    final static private String GENERATE_ADDRESS = "/api/v1/currency/address";
    final static private String WALLET_TRANSFER = "/api/v1/currency/transfer";
    final static private String WALLENT_BALANCE = "/api/v1/currency/balance";

    final static private String LITEGO_MAINNET_URL = "https://api.litego.io:9000";
    final static private String LITEGO_TESTNET_URL = "https://sandbox.litego.io:9000";

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private String endpoint;
    final private Gson gson = new Gson();
    final private OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build();


    private static final Map<Mode, String> modesMap = new HashMap<>();

    static {
        modesMap.put(Mode.TEST_URL, LITEGO_TESTNET_URL);
        modesMap.put(Mode.LIVE_URL, LITEGO_MAINNET_URL);
    }

    public Litego(Mode mode) {
        endpoint = modesMap.get(mode);
    }

    public PaginatedListResponse<Notification> getListOfNotificationResponses(String token) throws Exception {
        Response response = doGetRequestAuth(token, LIST_NOTIFICATION_RESPONSES);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<Notification>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public NotificationResponse setNotificationUrl(String token, String url) throws Exception {
        String json = String.format("{\"url\":\"%s\"}", url);
        Response response = doPostRequestAuth(token, NOTIFICATION_URL, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), NotificationResponse.class);
    }

    public PaginatedListResponse<WithdrawalTransactionResponse> getListWithdrawals(String token, Status status, int page, int pageSize) throws Exception {
        String url = String.format("%s?status=%s&page=%d&page_size=%d", LIST_WITHDRAWALS, status.name().toLowerCase(), page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<WithdrawalTransactionResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<WithdrawalTransactionResponse> getListWithdrawals(String token) throws Exception {
        Response response = doGetRequestAuth(token, LIST_WITHDRAWALS);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<WithdrawalTransactionResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<WithdrawalTransactionResponse> getListWithdrawals(String token, Status status) throws Exception {
        String url = String.format("%s?status=%s", LIST_WITHDRAWALS, status.name().toLowerCase());
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<WithdrawalTransactionResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<WithdrawalTransactionResponse> getListWithdrawals(String token, int page, int pageSize) throws Exception {
        String url = String.format("%s?page=%d&page_size=%d", LIST_WITHDRAWALS, page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<WithdrawalTransactionResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public WithdrawalTransactionResponse withdrawManually(String token) throws Exception {
        Response response = doPutRequestAuth(token, WITHDRAW_MANUALLY);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalTransactionResponse.class);
    }

    public WithdrawalTransactionResponse withdrawToLightning(String invoice, Long amount, String token) throws Exception {
        String json = String.format("{\"payment_request\":\"%s\",\"amount_satoshi\":%d}", invoice, amount);
        Response response = doPostRequestAuth(token, WITHDRAW_LIGHTNING, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalTransactionResponse.class);
    }

    public WithdrawalTransactionResponse withdrawToChannel(String address, Long amount, String token) throws Exception {
        String[] keyHost = address.split("@");
        String json = String.format("{\"public_key\":\"%s\",\"host\":\"%s\",\"amount_sat\":%d}", keyHost[0], keyHost[1], amount);
        Response response = doPostRequestAuth(token, WITHDRAW_TOCHANNEL, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalTransactionResponse.class);
    }

    public WithdrawalTransactionResponse withdrawToChannel(String address, String token) throws Exception {
        String[] keyHost = address.split("@");
        String json = String.format("{\"public_key\":\"%s\",\"host\":\"%s\"}", keyHost[0], keyHost[1]);
        Response response = doPostRequestAuth(token, WITHDRAW_TOCHANNEL, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalTransactionResponse.class);
    }

    public WithdrawalAddressResponse setWithdrawalAddress(String token, String address, Withdrawals type) throws Exception {
        String json = String.format("{\"type\":\"%s\",\"value\":\"%s\"}", type, address);
        Response response = doPostRequestAuth(token, WITHDRAWAL_ADDRESS, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalAddressResponse.class);
    }

    public MerchantInfoResponse getMerchantSummary(String token) throws Exception {
        Response response = doGetRequestAuth(token, MERCHANT_SUMMARY);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), MerchantInfoResponse.class);
    }

    public ChargeResponse getCharge(String token, String chargeId) throws Exception {
        String url = String.format("%s/%s", CHARGES, chargeId);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), ChargeResponse.class);
    }

    public PaginatedListResponse<ChargeResponse> chargesList(String token, boolean isPaid, int page, int pageSize) throws Exception {
        String url = String.format("%s?paidOnly=%b&page=%d&pageSize=%d", CHARGES, isPaid, page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ChargeResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<ChargeResponse> chargesList(String token) throws Exception {
        Response response = doGetRequestAuth(token, CHARGES);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ChargeResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<ChargeResponse> chargesList(String token, boolean isPaid) throws Exception {
        String url = String.format("%s?paidOnly=%b", CHARGES, isPaid);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ChargeResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<ChargeResponse> chargesList(String token, int page, int pageSize) throws Exception {
        String url = String.format("%s?page=%d&pageSize=%d", CHARGES, page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ChargeResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public ChargeResponse createCharge(String token, String description, int amount) throws Exception {
        String json = String.format("{\"description\":\"%s\",\"amount_satoshi\":%d}", description, amount);
        Response response = doPostRequestAuth(token, CHARGES, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), ChargeResponse.class);
    }

    public AuthTokenResponse refreshAuthToken(String token) throws Exception {
        Response response = doPutRequestAuth(token, REFRESH_AUTH);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), AuthTokenResponse.class);
    }

    public AuthResponse authenticate(String id, String secretKey) throws Exception {
        String json = String.format("{\"merchant_id\":\"%s\",\"secret_key\":\"%s\"}", id, secretKey);
        Response response = doPostRequest(AUTHENTICATE, json);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), AuthResponse.class);
    }

    public WithdrawalSettingsResponse getWithdrawalSettings(String token) throws Exception {
        Response response = doGetRequestAuth(token, WITHDRAWAL_SETTINGS);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WithdrawalSettingsResponse.class);
    }

    public PaginatedListResponse<ReferralPayment> getReferralPayments(String token, int page, int pageSize) throws Exception {
        String url = String.format("%s?page=%d&pageSize=%d", LISTREFERRAL_PAYMENTS, page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ReferralPayment>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<ReferralPayment> getReferralPayments(String token) throws Exception {
        Response response = doGetRequestAuth(token, LISTREFERRAL_PAYMENTS);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<ReferralPayment>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public ValidateResponse validate(String token, ValidateRequest validateRequest) throws Exception {
        Response response = doPostRequestAuth(token, VALIDATE_LIGHTNING, gson.toJson(validateRequest));
        checkResponseError(response);
        return gson.fromJson(response.body().string(), ValidateResponse.class);
    }

    public WalletAddressResponse generateAddress(String token, Currency currency) throws Exception {
        String subUrl = createSubUrl(GENERATE_ADDRESS, "currency", currency.name());
        Response response = doPutRequestAuth(token, subUrl);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WalletAddressResponse.class);
    }

    public WalletSendCoinsResponse sendCoins(String token, SendCoinsRequest sendCoinsRequest) throws Exception {
        String subUrl = createSubUrl(SEND_COINS, "currency", sendCoinsRequest.currency.name());
        Response response = doPostRequestAuth(token, subUrl, gson.toJson(sendCoinsRequest));
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WalletSendCoinsResponse.class);
    }

    public SendManyResponse sendMany(String token, SendManyRequest sendCoinsRequest) throws Exception {
        String subUrl = createSubUrl(SEND_MANY, "currency", sendCoinsRequest.currency.name());
        Response response = doPostRequestAuth(token, subUrl, gson.toJson(sendCoinsRequest));
        checkResponseError(response);
        return gson.fromJson(response.body().string(), SendManyResponse.class);
    }

    public TransferResponse getTransfer(String token, UUID transferId, Currency currency) throws Exception {
        String subUrl = createSubUrl(WALLET_TRANSFER, "currency", currency.name());
        String url = String.format("%s/%s", subUrl, transferId);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), TransferResponse.class);
    }

    public PaginatedListResponse<TransferResponse> getTransfers(String token, int page, int pageSize, Currency currency) throws Exception {
        String subUrl = createSubUrl(WALLET_TRANSFER, "currency", currency.name());
        String url = String.format("%s?page=%d&page_size=%d", subUrl, page, pageSize);
        Response response = doGetRequestAuth(token, url);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<TransferResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public PaginatedListResponse<TransferResponse> getTransfers(String token, Currency currency) throws Exception {
        String subUrl = createSubUrl(WALLET_TRANSFER, "currency", currency.name());
        Response response = doGetRequestAuth(token, subUrl);
        checkResponseError(response);
        Type listType = new TypeToken<PaginatedListResponse<TransferResponse>>() {}.getType();
        return gson.fromJson(response.body().string(), listType);
    }

    public WalletBalanceResponse getWalletBalance(String token, Currency currency) throws Exception {
        String subUrl = createSubUrl(WALLENT_BALANCE, "currency", currency.name());
        Response response = doGetRequestAuth(token, subUrl);
        checkResponseError(response);
        return gson.fromJson(response.body().string(), WalletBalanceResponse.class);
    }

    public OkHttpClient receiveWalletTransferEventListener(Mode mode, String authToken, Currency currency, WebSocketListener listener) {
        String subUrl = createSubUrl(SUBSCRIBE_WALLET_TRANSACTION, "currency", currency.name());
        Request request = new Request.Builder()
                .url(modesMap.get(mode) + subUrl)
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        httpClient.newWebSocket(request, listener);
        return httpClient;
    }

    public OkHttpClient addPaymentsEventSubscribeListener(Mode mode, String authToken, WebSocketListener listener) {
        Request request = new Request.Builder()
                .url(modesMap.get(mode) + SUBSCRIBE_PAYMENT)
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        httpClient.newWebSocket(request, listener);
        return httpClient;
    }

    public OkHttpClient addPaymentsEventSubscribeListenerSingle(Mode mode, String authToken, String chargeId, WebSocketListener listener) {
        Request request = new Request.Builder()
                .url(modesMap.get(mode) + SUBSCRIBE_PAYMENT_SINGLE + chargeId)
                .addHeader("Authorization", "Bearer " + authToken)
                .build();
        httpClient.newWebSocket(request, listener);
        return httpClient;
    }

    private void checkResponseError(Response response) throws Exception {
        if (response.code() != 200) {
            ErrorResoponse errorResoponse = gson.fromJson(response.body().string(), ErrorResoponse.class);
            switch (response.code()) {
                case 400:
                    throw new BadRequestException(response.code(), errorResoponse.detail);
                case 401:
                    throw new UnauthorizedException(response.code(), errorResoponse.detail);
                case 402:
                    throw new PaymentRequiredException(response.code(), errorResoponse.detail);
                case 403:
                    throw new AuthenticationException(response.code(), errorResoponse.detail);
                case 404:
                    throw new PageNotFoundException(response.code(), errorResoponse.detail);
                case 405:
                    throw new MethodNotAllowedException(response.code(), errorResoponse.detail);
                case 406:
                    throw new NotAcceptable(response.code(), errorResoponse.detail);
                case 429:
                    throw new TooManyRequestsException(response.code(), errorResoponse.detail);
                default:
                    throw new ServerErrorException(response.code(), errorResoponse.detail);
            }
        }
    }

    private Response doPutRequestAuth(String token, String url) throws IOException {
        RequestBody body = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .header("Authorization", token)
                .url(endpoint + url)
                .put(body)
                .build();
        return httpClient.newCall(request).execute();
    }

    private Response doPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(endpoint + url)
                .post(body)
                .build();
        return httpClient.newCall(request).execute();
    }

    private Response doPostRequestAuth(String token, String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .header("Authorization", token)
                .url(endpoint + url)
                .post(body)
                .build();
        return httpClient.newCall(request).execute();
    }

    private Response doGetRequestAuth(String token, String url) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization", token)
                .url(endpoint + url)
                .build();
        return httpClient.newCall(request).execute();
    }

    private String createSubUrl(String where, String oldSubString, String newSubString) {
        return where.replace(oldSubString, newSubString.toLowerCase());
    }
}

