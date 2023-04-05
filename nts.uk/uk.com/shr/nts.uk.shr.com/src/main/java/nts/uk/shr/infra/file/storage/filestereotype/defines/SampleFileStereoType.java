package nts.uk.shr.infra.file.storage.filestereotype.defines;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import nts.uk.shr.infra.file.storage.filestereotype.FileStereoTypeDescription;

@Getter
public class SampleFileStereoType implements FileStereoTypeDescription {

	@Override
	public String name() {
		return "samplefile";
	}

	@Override
	public List<String> acceptableExtensions() {
		return Arrays.asList("png", "jpg", "jpeg", "gif");
	}
}
