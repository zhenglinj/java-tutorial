package com.spark.examples.unserializabledemo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.spark.examples.unserializabledemo.util.SerializableClass;
import com.spark.examples.unserializabledemo.util.UnserializableClass;
import org.apache.spark.serializer.KryoRegistrator;

public class ToKryoRegistrator implements KryoRegistrator {
    @Override
    public void registerClasses(Kryo kryo) {
        kryo.register(UnserializableClass.class);
        kryo.register(SerializableClass.class);
    }
}
