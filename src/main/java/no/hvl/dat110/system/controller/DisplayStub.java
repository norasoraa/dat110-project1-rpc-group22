package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {

	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}

	public void write(String message) {

		byte[] param = RPCUtils.marshallString(message);

		rpcclient.call((byte) Common.READ_RPCID, param);

	}
}
