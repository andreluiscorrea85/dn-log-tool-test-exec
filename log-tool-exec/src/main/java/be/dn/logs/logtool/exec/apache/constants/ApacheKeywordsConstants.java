package be.dn.logs.logtool.exec.apache.constants;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public final class ApacheKeywordsConstants {

	public static final String TIMESTAMP_LOG_KEYWORD = "TIMESTAMP";

	public static final String RELATIVE_TIME_LOG_KEYWORD = "RELATIVETIME";

	public static final String THREAD_LOG_KEYWORD = "THREAD";

	public static final String LEVEL_LOG_KEYWORD = "LEVEL";

	public static final String LOGGER_LOG_KEYWORD = "LOGGER";

	public static final String MESSAGE_LOG_KEYWORD = "MESSAGE";

	public static final String PROP_LOG_KEYWORD = "PROP";

	// ##########

	// PROP(RELATIVETIME) [THREAD] LEVEL [LOGGER]: MESSAGE
	public static final String EVENT_LOG_KEYWORD =
		PROP_LOG_KEYWORD + '(' + RELATIVE_TIME_LOG_KEYWORD + ')' + ' ' +
		'[' + THREAD_LOG_KEYWORD + ']' + ' ' +
		LEVEL_LOG_KEYWORD + ' ' +
		'[' + LOGGER_LOG_KEYWORD + ']' + ':' + ' ' +
		MESSAGE_LOG_KEYWORD;

}
