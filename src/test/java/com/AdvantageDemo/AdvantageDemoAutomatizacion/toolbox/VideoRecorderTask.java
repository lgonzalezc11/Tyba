package com.AdvantageDemo.AdvantageDemoAutomatizacion.toolbox;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
public class VideoRecorderTask {

	public static final String USER_DIR = "user.dir";
	public static final String DOWNLOADED_FILES_FOLDER = "downloadFiles";

	private ScreenRecorder screenRecorder;

	public void startRecording(String prueba) throws Exception {
		File file = new File(System.getProperty(USER_DIR) + File.separator
				+ DOWNLOADED_FILES_FOLDER);
System.out.println(file);

		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new ScreenRecorder(gc,
				gc.getBounds(),
				new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						DepthKey, 24, FrameRateKey, Rational.valueOf(15),
						QualityKey, 1.0f,
						KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null,
				new File(DOWNLOADED_FILES_FOLDER));
		this.screenRecorder.start();

		/*this.screenRecorder = new SpecializedScreenRecorderTask(
				gc,null,
				new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
				new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey,
						ENCODING_QUICKTIME_JPEG,
						CompressorNameKey,
						ENCODING_QUICKTIME_JPEG, DepthKey, 24,
						FrameRateKey, Rational.valueOf(1), QualityKey, 0.5f,
						KeyFrameIntervalKey, 15 * 60 ), new Format(MediaTypeKey,
								FormatKeys.MediaType.VIDEO, EncodingKey, "black", FrameRateKey,
						Rational.valueOf(15)), null, file, prueba);
		this.screenRecorder.start();*/

	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}
}