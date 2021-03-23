package be.dn.logs.logtool.exec.main;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import static be.dn.logs.logtool.exec.apache.ApacheLogExec.apacheLogFilePatternReceiverExec;
import static be.dn.logs.logtool.regex.constants.PatternsConstants.ADDITIONAL_EXCEPTION_MESSAGE_PATTERN;
import static be.dn.logs.logtool.regex.constants.PatternsConstants.EVENT_PATTERN;

@Slf4j
@UtilityClass
public final class ProjectExecDnLogTool {

	public static final void main(final String[] args) {
		alcLogEventExec();

		// apacheLogEventExec();
	}

	public static final void alcLogEventExec() {
		log.info("##############################");

		log.info("");

		final var line =
			"""
			2010-10-06 09:02:10,357 [WorkerThread-5] DEBUG [DmsObjectDeterminator]: Object to encode for ObjectId { com.dn.gaverzicht.dms.models.DocumentStatus - 19537 } (encoding depth = 1): { DocumentStatus: 19537 }
			2010-10-06 09:18:39,352 [WorkerThread-15] INFO  [ServerSession]: Processing command object: {arguments=[Failed to handle image available: Out of memory.,    at System.Drawing.Graphics.CheckErrorStatus(Int32 status)
			   at System.Drawing.Graphics.DrawImage(Image image, Int32 x, Int32 y, Int32 width, Int32 height)
			   at System.Drawing.Bitmap..ctor(Image original, Int32 width, Int32 height)
			   at System.Drawing.Bitmap..ctor(Image original)
			""";

		log.info("Line: {}", line);

		log.info("##############################");
		log.info("");

		log.info("EVENT_PATTERN: {}", EVENT_PATTERN.pattern());
		log.info("EXCEPTION_PATTERN: {}", ADDITIONAL_EXCEPTION_MESSAGE_PATTERN.pattern());

		log.info("##############################");
		log.info("");
		log.info("EVENT");

		final var eventMatcher = EVENT_PATTERN.matcher(line);

		log.info("eventGroupCount: {}", eventMatcher.groupCount());

		while (eventMatcher.find()) {
			for (var i = 0; i <= eventMatcher.groupCount(); i++) {
				log.info("eventGroupItem: ({}) - group: {}", i, eventMatcher.group(i));
			}
		}

		log.info("##############################");
		log.info("");
		log.info("EXCEPTION");

		final var exceptionMatcher = ADDITIONAL_EXCEPTION_MESSAGE_PATTERN.matcher(line);

		log.info("exceptionGroupCount: {}", exceptionMatcher.groupCount());

		while (exceptionMatcher.find()) {
			for (var i = 0; i <= exceptionMatcher.groupCount(); i++) {
				log.info("exceptionGroupItem: ({}) - group: {}", i, exceptionMatcher.group(i));
			}
		}

		log.info("##############################");
		log.info("");
	}

	public static final void apacheLogEventExec() {
		apacheLogFilePatternReceiverExec();
	}

}
