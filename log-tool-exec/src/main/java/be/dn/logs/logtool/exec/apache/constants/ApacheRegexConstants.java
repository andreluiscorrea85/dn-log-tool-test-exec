package be.dn.logs.logtool.exec.apache.constants;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public final class ApacheRegexConstants {

	public static final String TIMESTAMP_LOG_REGEX = "%date{yyyy-MM-dd HH:mm:ss,SSS}";

	public static final String THREAD_LOG_REGEX = "%thread";

	public static final String LEVEL_LOG_REGEX = "%-5level";

	public static final String LOGGER_LOG_REGEX = "%logger{0}";

	public static final String MESSAGE_LOG_REGEX = "%msg";

	public static final String LINE_BREAK_LOG_REGEX = "%n";

	// ##########

	// %date{yyyy-MM-dd HH:mm:ss,SSS} [%thread] %-5level [%logger{0}]: %msg%n
	public static final String EVENT_LOG_REGEX =
		TIMESTAMP_LOG_REGEX + ' ' +
		'[' + THREAD_LOG_REGEX + ']' + ' ' +
		LEVEL_LOG_REGEX + ' ' +
		'[' + LOGGER_LOG_REGEX + ']' + ':' + ' ' +
		MESSAGE_LOG_REGEX +
		LINE_BREAK_LOG_REGEX;

}
