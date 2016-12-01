package pl.codeme.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileExample {

	public static void main(String[] args) {
		FileExample prog = new FileExample();
		
		switch (args[1].toLowerCase()) {
			case "wczytajbinarnie":
				prog.loadBinaryFile(args[0]);
				break;
			case "zapiszbinarnie":
				String data[] = new String[args.length-2];
				int i;
				for (i=2; i<args.length; i++) {
					data[i-2] = args[i];
				}
				prog.saveBinaryFile(args[0], data);
				break;
			case "wczytajtekstowo":
				prog.loadTextFile(args[0]);
				break;
			case "wczytajbinarnietekstowo":
				prog.inputStreamReaderExample(args[0]);
				break;
			case "podajinformacje":
				prog.getFileInfo(args[0]);
				break;
			default:
				System.out.println("Podałeś złe parametry...");
		}
	}
	
	private void getFileInfo(String fileName) {
		File f = new File(fileName);
		
		System.out.println(f.getAbsolutePath() + "(" + f.length() + ")");
	}

	private void inputStreamReaderExample(String fileName) {
		try {
			BufferedReader in = new BufferedReader(
	//				new InputStreamReader(System.in)
					new InputStreamReader(new FileInputStream(fileName))
			);
			System.out.println(in.readLine());
		} catch (IOException ex) {
			// TODO: !!!
		}
		
	}
	
	private void loadTextFile(String fileName) {
		int character;
		try (FileReader in = new FileReader(fileName)) {
			do {
				character = in.read();
				if (character != -1) {
					System.out.print((char)character);
				}
			} while (character != -1);
		} catch (IOException ex) {
			// TODO: !!!
		}
	}
	
	private void loadBinaryFile(String fileName) {
		
		try (FileInputStream in = new FileInputStream(fileName)) {
			int character;
			do {
				character = in.read();
				if (character != -1) {
					System.out.print((char)character);
				}
			} while (character != -1);
		} catch (IOException ex) {
			// TODO: !!!
		}
		
	}

	private void saveBinaryFile(String fileName, String data[]) {
		try (FileOutputStream out = new FileOutputStream(fileName)) {
			for (String line :  data) {
				char lineByte[] = line.toCharArray();
				int i;

				for(i=0; i<lineByte.length; i++) {
					out.write(lineByte[i]);
				}
				
				out.write('\r');
			}
		} catch (IOException ex) {
			// TODO: !!!
		}
		
	}
}
