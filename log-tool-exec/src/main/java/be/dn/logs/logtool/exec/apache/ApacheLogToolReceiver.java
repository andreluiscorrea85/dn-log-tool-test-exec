package be.dn.logs.logtool.exec.apache;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.receivers.varia.LogFilePatternReceiver;

@Slf4j
public final class ApacheLogToolReceiver extends LogFilePatternReceiver {

	public ApacheLogToolReceiver() {
		super();
	}

	public final void initLogReceiver() {
		this.initialize();
	}

}
