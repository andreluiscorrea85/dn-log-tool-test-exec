package be.dn.logs.logtool.exec.main;

import be.dn.logs.logtool.base.regex.enums.ELogLineTypes;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineAdditionalMessageExceptionStacktrace;
import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineAdditionalMessageSimple;
import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineEventGeneral;
import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineEventGetRendering;
import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineEventStartRenderingRequest;
import static be.dn.logs.logtool.base.regex.RegexMachineApp.regexPatternAppLogLineEventStartRenderingResponse;
import static be.dn.logs.logtool.base.regex.enums.ELogLineTypes.ADDITIONAL_MESSAGE_EXCEPTION_STACKTRACE;
import static be.dn.logs.logtool.base.regex.enums.ELogLineTypes.ADDITIONAL_MESSAGE_SIMPLE;
import static be.dn.logs.logtool.base.regex.enums.ELogLineTypes.EVENT_GENERAL;
import static be.dn.logs.logtool.base.regex.enums.ELogLineTypes.EVENT_GET_RENDERING;
import static be.dn.logs.logtool.exec.apache.ApacheLogExec.apacheLogFilePatternReceiverExec;

@Slf4j
@UtilityClass
public final class ProjectExecDnLogTool {

	public static final void main(final String[] args) {
		// alcExecLogLineTypeEventStartRenderingRequest();
		// alcExecLogLineTypeEventStartRenderingResponse();
		// alcExecLogLineTypeEventGetRendering();
		// alcExecLogLineTypeEventGeneral();
		// alcExecLogLineTypeAdditionalMessageExceptionStacktrace();
		alcExecLogLineTypeAdditionalMessageSimple();

		// apacheLogEventExec();
	}

	public static final void alcExecLogLineTypeEventStartRenderingRequest() {
		final var logLineType = ELogLineTypes.EVENT_START_RENDERING_REQUEST;
		final var regexPattern = regexPatternAppLogLineEventStartRenderingRequest();
		final var lineText =
			"2010-10-06 09:01:13,631 [WorkerThread-2] INFO  [ServiceProvider]: Executing request startRendering with arguments [114466, 0] on service object" +
			" " +
			"{" +
			" ReflectionServiceObject -> com.dn.gaverzicht.dms.services.DocumentService@4a3a4a3a }";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLineTypeEventStartRenderingResponse() {
		final var logLineType = ELogLineTypes.EVENT_START_RENDERING_RESPONSE;
		final var regexPattern = regexPatternAppLogLineEventStartRenderingResponse();
		final var lineText = "2010-10-06 09:01:13,634 [WorkerThread-2] INFO  [ServiceProvider]: Service startRendering returned 1286373733634-5423";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLineTypeEventGetRendering() {
		final var logLineType = EVENT_GET_RENDERING;
		final var regexPattern = regexPatternAppLogLineEventGetRendering();
		final var lineText =
			"2010-10-06 09:01:14,825 [WorkerThread-0] INFO  [ServiceProvider]: Executing request getRendering with arguments [1286373733634-5423] on service" +
			" object { ReflectionServiceObject -> com.dn.gaverzicht.dms.services.DocumentService@4a3a4a3a }";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLineTypeEventGeneral() {
		final var logLineType = EVENT_GENERAL;
		final var regexPattern = regexPatternAppLogLineEventGeneral();
		final var lineText =
			"2010-10-06 09:02:10,357 [WorkerThread-5] DEBUG [DmsObjectDeterminator]: Object to encode for ObjectId { com.dn.gaverzicht.dms.models" +
			".DocumentStatus - 19537 } (encoding depth = 1): { DocumentStatus: 19537 }";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLineTypeAdditionalMessageExceptionStacktrace() {
		final var logLineType = ADDITIONAL_MESSAGE_EXCEPTION_STACKTRACE;
		final var regexPattern = regexPatternAppLogLineAdditionalMessageExceptionStacktrace();
		final var lineText = "   at System.Drawing.Graphics.DrawImage(Image image, Int32 x, Int32 y, Int32 width, Int32 height)";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLineTypeAdditionalMessageSimple() {
		final var logLineType = ADDITIONAL_MESSAGE_SIMPLE;
		final var regexPattern = regexPatternAppLogLineAdditionalMessageSimple();
		final var lineText = "java.net.SocketException: Connection reset";

		alcExecLogLine(logLineType, regexPattern, lineText);
	}

	public static final void alcExecLogLine(final ELogLineTypes logLineType, final Pattern regexPattern, final String lineText) {
		log.info("##############################");
		log.info("");

		log.info("logLineType: {}", logLineType.name());
		log.info("");

		log.info("regexPattern: {}", regexPattern);
		log.info("");

		log.info("lineText: {}", lineText);
		log.info("");

		log.info("regexString: {}", regexPattern.pattern());
		log.info("");

		log.info("regexMatcher: {}", regexPattern.matcher(lineText));
		log.info("");

		log.info("isRegexMatcherMatched: {}", regexPattern.matcher(lineText).matches());
		log.info("");

		log.info("regexMatcherGroupCount: {}", regexPattern.matcher(lineText).groupCount());
		log.info("");

		log.info("isRegexMatcherFound: {}", regexPattern.matcher(lineText).find());
		log.info("");

		final var regexMatcher = regexPattern.matcher(lineText);

		while (regexMatcher.find()) {
			for (var i = 0; i <= regexMatcher.groupCount(); i++) {
				log.info("matcherGroupItem: [{}] - group: {}", i, regexMatcher.group(i));
			}
		}

		log.info("##############################");
		log.info("");
	}

	public static final void apacheLogEventExec() {
		apacheLogFilePatternReceiverExec();
	}

}
