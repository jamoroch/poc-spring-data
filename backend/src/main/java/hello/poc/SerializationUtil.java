package hello.poc;

import java.io.*;
import java.util.Base64;

final public class SerializationUtil {

    private SerializationUtil(){

    }

    private static Base64.Encoder encoder = Base64.getEncoder();

    private static Base64.Decoder decoder = Base64.getDecoder();

    public static String toString(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return encoder.encodeToString(baos.toByteArray());
    }


    public static  <T> T fromString(String s,  Class<T> clazz) throws IOException, ClassNotFoundException {

        byte [] data = decoder.decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return clazz.cast(o);
    }


}
