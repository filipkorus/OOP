package lab4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;

public class FileAndURLCopy {
	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Brak argumentów programu.\n" +
					  "Użycie: java FileCopy <src> <dst>");
			System.exit(1);
		}

		File src = new File(args[0]), dst = new File(args[1]);

		if (!isValidURL(args[0])) {
			if (!src.exists()) {
				System.out.println("Plik " + src.getName() + " nie istnieje.");
				System.exit(1);
			}

			if (src.isDirectory()) {
				System.out.println("Plik " + src.getName() + " jest katalogiem.");
				System.exit(1);
			}

			if (!src.canRead()) {
				System.out.println("Brak dostępu do pliku " + src.getName() + ".");
				System.exit(1);
			}
		}

		if (dst.isDirectory()) {
			if (!dst.canWrite()) {
				System.out.println("Brak wymaganych uprawnień do katalogu " + dst.getName() + ".");
				System.exit(1);
			}

			String filename = String.valueOf(Paths.get(src.getName()).getFileName());
			dst = new File(dst.getName() + "/" + filename);
		}

		if (dst.exists() && !dst.canWrite()) {
			System.out.println("Nie można nadpisać pliku " + dst.getName() + ".");
			System.exit(1);
		}

		try {
			if (isValidURL(args[0])) {
				URL url = new URL(args[0]);
				copy(url, dst);
			} else {
				copy(src, dst);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static boolean isValidURL(String urlString) {
		try {
			URL url = new URL(urlString);
			url.toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private static void copy(File src, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);

			// buffer size 1K
			byte[] buf = new byte[1024];

			int bytesRead;
			while ((bytesRead = is.read(buf)) > 0) {
				os.write(buf, 0, bytesRead);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	private static void copy(URL url, File dest) throws IOException {

		HttpURLConnection huc =  ( HttpURLConnection )  url.openConnection();
		huc.setRequestMethod ("GET");
		huc.connect() ;
		int code = huc.getResponseCode();
		if (code < 200 || code > 299) {
			System.out.println("Adres " + url.toString() + " zwraca status " + code + ".");
			System.exit(1);
		}

		FileOutputStream os = null;

		try {
			ReadableByteChannel is = Channels.newChannel(url.openStream());
			os = new FileOutputStream(dest);

			os.getChannel().transferFrom(is, 0, Long.MAX_VALUE);
		} finally {
			os.close();
		}
	}
}
