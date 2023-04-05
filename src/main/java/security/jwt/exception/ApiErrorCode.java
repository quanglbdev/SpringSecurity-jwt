package security.jwt.exception;


public enum ApiErrorCode {
    UNAUTHORIZED(-1, "Unauthorized"),
    LOGIN_FAILED(-2, "Username or password is incorrect."),
    ACTION_INVALID(-3, "Action invalid"),
    INPUT_INVALID(-4, "Params is not empty!"),
    BALANCE_NOT_ENOUGH(-5, "Your balance is not enough"),
    USERNAME_NOT_EXIST(-6, "Username not exist."),
    INCORRECT_HEADER_REQUEST(-7, "Incorrect header request"),
    USER_NOT_EXIST(-8, "User not exist."),
    SIGNATURE_INCORRECT(-9, "signature incorrect"),
    TIME_OVERDUE_VERIFY(-10, "Time overdue for verification"),
    NONCE_NOT_FOUND(-11, "Nonce not found!"),
    OBJECT_NOT_FOUND(-12, "Object is not found"),
    TOKEN_EXPIRED(-13, "Token expired."),
    USER_NOT_ACTIVE(-14, "User not active"),
    USER_EXIST(-15, "User exist."),
    LIMIT_EMAIL_QUANTITY(-16, "The number of request has been exceeded!"),
    EMAIL_NOT_EMPTY(-17, "Email not empty!"),
    OTP_NOT_EMPTY(-18, "Otp not empty!"),
    EMAIL_OTP_EXPIRED(-19, "Email OTP is expired!"),
    ACCOUNT_NOT_VERIFY(-20, "Unverified account"),
    ADDRESS_NOT_FOUND(-21, "Address is not found"),
    EMAIL_OTP_INCORRECT(-22, "Email OTP is incorrect!"),
    PASSWORD_FORMAT_INCORRECT(-23, "Password contain only a-z, A-Z, 0-9, 8 to 30 chars!"),
    USER_VERIFIED(-24, "!"),
    RESOURCES_TYPE_NOT_FOUND(-25, "Resources groupId not found!"),

    WOOD_INSUFFICIENT(-26, "Wood insufficient!"),
    FOOD_INSUFFICIENT(-27, "Food insufficient!"),
    STONE_INSUFFICIENT(-28, "Stone insufficient!"),
    GOLD_INSUFFICIENT(-29, "Gold insufficient!"),
    RUBY_INSUFFICIENT(-30, "Ruby insufficient!"),

    POSITION_ALREADY_EXISTS(-31, "Position already exists!"),
    POSITION_NOT_FOUND(-32, "Position not found!"),
    LAND_NOT_FOUND(-33, "Land not found!"),
    BUILDING_NOT_FOUND(-34, "Building not found!"),
    LEVEL_NOT_FOUND(-35, "Level building not found!"),
    UPGRADE_FAILED(-36, "upgrade failed"),
    LEVEL_INCORRECT(-37, "Level incorrect"),
    BUILDING_IS_UPGRADE(-38, "building is upgrade"),
    USERNAME_NOT_EMPTY(-39, "Username is empty!"),
    PASSWORD_NOT_EMPTY(-40, "Password is empty!"),
    INVALID_EMAIL(-41, "Invalid email!"),
    INVALID_USERNAME(-42, "Invalid username!"),
    USERNAME_IN_USE(-43, "Username already in use."),
    ;

    private final Integer errorCode;
    private final String message;

    ApiErrorCode(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}