package be.dn.logs.logtool.exec.main.constants;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public final class TestFilesConstants {

	private static final String DEFAULT_FILE_SCHEME = "file://";

	private static final String DEFAULT_DIRECTORY_TEST_FILES = "/C:/ALC/WinFolders/Downloads/TestDN/";

	private static final String DEFAULT_FILE_NAME_PREFIX = "server-simple-test-";

	private static final String DEFAULT_FILE_EXTENSION = ".log";

	// ##########

	private static final String TEST_FILE_NAME_01 = DEFAULT_FILE_NAME_PREFIX + "01" + DEFAULT_FILE_EXTENSION;

	private static final String TEST_FILE_NAME_02 = DEFAULT_FILE_NAME_PREFIX + "02" + DEFAULT_FILE_EXTENSION;

	// ##########

	public static final String TEST_FILE_URL_01 = DEFAULT_FILE_SCHEME + DEFAULT_DIRECTORY_TEST_FILES + TEST_FILE_NAME_01;

	public static final String TEST_FILE_URL_02 = DEFAULT_FILE_SCHEME + DEFAULT_DIRECTORY_TEST_FILES + TEST_FILE_NAME_02;

}
