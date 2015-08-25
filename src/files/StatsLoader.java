package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import logic.Main;

/**
 * @author Inderpreet
 * @date Started 21-Apr-2013 continued 3-Aug-2015
 */
public class StatsLoader {

	private BufferedReader reader;
	private BufferedWriter writer;
	private File scoreFile, coinFile;

	public StatsLoader() {
		try {
			if (Main.filepath == "src\\") {
				scoreFile = new File(Main.filepath + "files\\score.txt");
				coinFile = new File(Main.filepath + "files\\coins.txt");
			} else {
				scoreFile = new File("score.txt");
				coinFile = new File("coins.txt");
				
				scoreFile.createNewFile();
				coinFile.createNewFile();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Reads score from a file
	 *
	 * @return The score
	 */
	public int getScore() {
		int score = 0;
		try {
			reader = new BufferedReader(new FileReader(scoreFile));

			String encryptedScore = reader.readLine().trim();

			score = Integer.parseInt(Main.encrypter.decrypt(encryptedScore));
		} catch (Exception e) {
			System.out.println(e);
		}
		return score;
	}

	/**
	 * Writes a score to the file
	 *
	 * @param score
	 *            The score to be written to the file
	 */
	public void writeScore(int score) {
		try {
			writer = new BufferedWriter(new FileWriter(scoreFile));

			String encryptedScore = Main.encrypter.encrypt(String
					.valueOf(score));

			writer.write(encryptedScore);
			writer.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Gets coin score
	 * 
	 * @return The coin score
	 */
	public int getCoins() {
		int score = 0;
		try {
			reader = new BufferedReader(new FileReader(coinFile));

			String encryptedScore = reader.readLine().trim();

			score = Integer.parseInt(Main.encrypter.decrypt(encryptedScore));
		} catch (Exception e) {
			System.out.println(e);
		}
		return score;
	}

	/**
	 * Stores the coin score
	 * 
	 * @param score
	 *            The coin score
	 */
	public void writeCoins(int score) {
		try {
			writer = new BufferedWriter(new FileWriter(coinFile));

			String encryptedScore = Main.encrypter.encrypt(String
					.valueOf(score));

			writer.write(encryptedScore);
			writer.flush();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}