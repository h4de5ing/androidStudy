package com.style.data.http.converter;

import com.style.data.http.response.TokenResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class CustomConverterFactory extends Converter.Factory {

    public static CustomConverterFactory create() {
        return new CustomConverterFactory();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == String.class) {
            return new OriginalStringConverter();
        }
        if (type == RequestBody.class) {
            return new ResponseBodyConverter();
        }
        if (type == TokenResponse.class) {
            return new BadResponseConverter<>(type);
        }
        return new DefaultResponseConverter<>(type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new JsonRequestBodyConverter<>();
    }

}
