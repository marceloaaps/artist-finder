package marceloproject.spotifays.models.enums;

public enum ArtistType {

    SOLO(1),
    DUO(2),
    TRIO(3),
    BAND(4);

    private final int code;

    ArtistType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ArtistType fromCode(int code) {
        for (ArtistType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Código inválido para ArtistType: " + code);
    }
}