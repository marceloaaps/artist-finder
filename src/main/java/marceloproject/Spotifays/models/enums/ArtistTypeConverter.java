package marceloproject.Spotifays.models.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class ArtistTypeConverter implements AttributeConverter<ArtistType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ArtistType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
    }

    @Override
    public ArtistType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return ArtistType.fromCode(dbData);
    }
}