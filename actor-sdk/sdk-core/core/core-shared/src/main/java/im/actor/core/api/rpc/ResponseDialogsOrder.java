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

public class ResponseDialogsOrder extends Response {

    public static final int HEADER = 0xeb;
    public static ResponseDialogsOrder fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseDialogsOrder(), data);
    }

    private int seq;
    private byte[] state;
    private List<ApiDialogGroup> groups;

    public ResponseDialogsOrder(int seq, @NotNull byte[] state, @NotNull List<ApiDialogGroup> groups) {
        this.seq = seq;
        this.state = state;
        this.groups = groups;
    }

    public ResponseDialogsOrder() {

    }

    public int getSeq() {
        return this.seq;
    }

    @NotNull
    public byte[] getState() {
        return this.state;
    }

    @NotNull
    public List<ApiDialogGroup> getGroups() {
        return this.groups;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.seq = values.getInt(1);
        this.state = values.getBytes(2);
        List<ApiDialogGroup> _groups = new ArrayList<ApiDialogGroup>();
        for (int i = 0; i < values.getRepeatedCount(3); i ++) {
            _groups.add(new ApiDialogGroup());
        }
        this.groups = values.getRepeatedObj(3, _groups);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(2, this.state);
        writer.writeRepeatedObj(3, this.groups);
    }

    @Override
    public String toString() {
        String res = "response DialogsOrder{";
        res += "seq=" + this.seq;
        res += ", state=" + byteArrayToString(this.state);
        res += ", groups=" + this.groups;
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}