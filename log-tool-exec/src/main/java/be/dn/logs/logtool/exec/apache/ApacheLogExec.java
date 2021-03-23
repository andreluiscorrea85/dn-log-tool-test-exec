package be.dn.logs.logtool.exec.apache;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.LoggerRepositoryExImpl;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggerRepository;

import static be.dn.logs.logtool.exec.apache.constants.ApacheKeywordsConstants.EVENT_LOG_KEYWORD;
import static be.dn.logs.logtool.exec.main.constants.TestFilesConstants.TEST_FILE_URL_02;
import static be.dn.logs.logtool.regex.constants.TemporalFormatsConstants.YYYY_MM_DD_HH_MM_SS_SSS_24H;

@Slf4j
@UtilityClass
public final class ApacheLogExec {

	public static void apacheLogFilePatternReceiverExec() {
		// See: http://svn.apache.org/viewvc/logging/log4j/companions/extras/tags/apache-log4j-extras-1.2
		//.17/src/main/java/org/apache/log4j/receivers/varia/LogFilePatternReceiver.java?revision=1531830&view=markup

		final var rootLogger = Logger.getRootLogger();
		final var appender = new ConsoleAppender(new SimpleLayout());
		appender.setName("console");
		rootLogger.addAppender(appender);
		// final var receiver = new LogFilePatternReceiver();
		final var receiver = new ApacheLogToolReceiver();
		final LoggerRepository repo = new LoggerRepositoryExImpl(LogManager.getLoggerRepository());
		receiver.setLoggerRepository(repo);
		// receiver.setLogFormat("PROP(RELATIVETIME) [THREAD] LEVEL LOGGER * - MESSAGE");
		receiver.setLogFormat(EVENT_LOG_KEYWORD);
		receiver.setTailing(false);
		receiver.setAppendNonMatches(true);
		// receiver.setTimestampFormat("yyyy-MM-d HH:mm:ss,SSS");
		receiver.setTimestampFormat(YYYY_MM_DD_HH_MM_SS_SSS_24H);
		// receiver.setFileURL("file:///C:/log/test.log");
		receiver.setFileURL(TEST_FILE_URL_02);
		// receiver.initialize();
		receiver.initLogReceiver();
		receiver.activateOptions();
	}

}
