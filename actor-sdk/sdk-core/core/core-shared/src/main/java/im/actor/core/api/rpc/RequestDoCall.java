package im.actor.core.api.rpc;
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
import im.actor.core.api.*;

public class RequestDoCall extends Request<ResponseDoCall> {

    public static final int HEADER = 0xa25;
    public static RequestDoCall fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestDoCall(), data);
    }

    private ApiOutPeer peer;
    private Long timeout;

    public RequestDoCall(@NotNull ApiOutPeer peer, @Nullable Long timeout) {
        this.peer = peer;
        this.timeout = timeout;
    }

    public RequestDoCall() {

    }

    @NotNull
    public ApiOutPeer getPeer() {
        return this.peer;
    }

    @Nullable
    public Long getTimeout() {
        return this.timeout;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiOutPeer());
        this.timeout = values.optLong(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        if (this.timeout != null) {
            writer.writeLong(2, this.timeout);
        }
    }

    @Override
    public String toString() {
        String res = "rpc DoCall{";
        res += "peer=" + this.peer;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
