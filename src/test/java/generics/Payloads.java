package generics;

import java.util.HashMap;

public class Payloads {

	public static HashMap<String, String> newUserCreation()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("name", "rajkumar");
		map.put("trips", "9");
		map.put("airline", "2");
		
		return map;
		
	}
	
	public static HashMap<String, String> passengerDetailsUpdate(String name,String trips,String airline)
	{
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("name", name);
		map.put("trips", trips);
		map.put("airline", airline);
		
		return map;
		
    }
	
	public static HashMap<String, String> partialPassengerDetailsUpdate()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("name", "rajkumar");
		map.put("trips", "15");
		map.put("airline", "30");
		
		return map;
	
	}
	
		public static String complexJsonArrayPayload()
		{
			return "{\r\n"
					+ "  \"dashboard\" : {\r\n"
					+ "    \"purchaseAmount\" : 6125,\r\n"
					+ "    \"website\" : \"rajkumar89@gmail.com\"\r\n"
					+ "  },\r\n"
					+ "  \r\n"
					+ "  \"courses\" : [\r\n"
					+ "    {\r\n"
					+ "      \"title\" : \"selenium\",\r\n"
					+ "      \"price\" : 50,\r\n"
					+ "      \"copies\" : 6\r\n"
					+ "    },\r\n"
					+ "    \r\n"
					+ "    {\r\n"
					+ "      \"title\" : \"cypress\",\r\n"
					+ "      \"price\" : 40,\r\n"
					+ "      \"copies\" : 4\r\n"
					+ "    },\r\n"
					+ "    \r\n"
					+ "    {\r\n"
					+ "      \"title\" : \"RPA\",\r\n"
					+ "      \"price\" : 45,\r\n"
					+ "      \"copies\" : 10\r\n"
					+ "    }\r\n"
					+ "]\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "";
		}
	}
