package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadURLUtil {

	public static List<String> readURL(String anyUrl) {
		ArrayList<String> list = new ArrayList<String>();
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		InputStream inputStream = null;

		try {
			URL url = new URL(anyUrl);
			inputStream = url.openStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			String record = "";
			while ((record = bufferedReader.readLine()) != null) {
				list.add(record);
			}
			// Delete header
			list.remove(0);
		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		return list;

	}
}
