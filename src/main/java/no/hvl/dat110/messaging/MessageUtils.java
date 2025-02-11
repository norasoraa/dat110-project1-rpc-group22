package no.hvl.dat110.messaging;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

		byte[] segment = null;
		byte[] data;

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer

		data = message.getData();

		if (data == null || data.length >= SEGMENTSIZE) {
			throw new IllegalArgumentException(
					"The message cannot be null or contain more than 127 bytes.");
		}

		segment = new byte[SEGMENTSIZE];
		segment[0] = (byte) data.length;

		System.arraycopy(data, 0, segment, 1, data.length);

		return segment;

	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;

		// decapsulate segment and put received payload data into a message

		if (segment.length != SEGMENTSIZE) {
			throw new IllegalArgumentException(
					"Unvalid segmentsize. Must be fixed-sized segments of 128 bytes.");
		}

		int length = segment[0];
		byte[] data = new byte[length];

		System.arraycopy(segment, 1, data, 0, length);

		message = new Message(data);

		return message;

	}

}
