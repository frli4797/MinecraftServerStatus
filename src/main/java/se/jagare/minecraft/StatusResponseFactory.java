package se.jagare.minecraft;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import se.jagare.minecraft.dao.StatusResponse;
import se.jagare.minecraft.dao.StatusResponseImpl;
import se.jagare.minecraft.dao.StatusResponseLegacyImpl;

public class StatusResponseFactory {

	private static Gson gson = new Gson();

	public static StatusResponse createServerResponse(String json) {

		JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
		JsonObject version = jsonObject.get("version").getAsJsonObject();
		JsonElement protocol = version.get("protocol");
		Long protocolLong = protocol.getAsLong();

		StatusResponse response;
		if (protocolLong >= 210) {
			response = gson.fromJson(json, StatusResponseImpl.class);
		} else {
			response = gson.fromJson(json, StatusResponseLegacyImpl.class);
		}

		return response;
	}

}
