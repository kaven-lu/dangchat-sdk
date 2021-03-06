package im.actor.core.api;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ApiExtension extends BserObject {

    private int id;
    private byte[] data;

    public ApiExtension(int id, @NotNull byte[] data) {
        this.id = id;
        this.data = data;
    }

    public ApiExtension() {

    }

    public int getId() {
        return this.id;
    }

    @NotNull
    public byte[] getData() {
        return this.data;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.id = values.getInt(1);
        this.data = values.getBytes(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.id);
        if (this.data == null) {
            throw new IOException();
        }
        writer.writeBytes(2, this.data);
    }

    @Override
    public String toString() {
        String res = "struct Extension{";
        res += "id=" + this.id;
        res += ", data=" + byteArrayToString(this.data);
        res += "}";
        return res;
    }

}
