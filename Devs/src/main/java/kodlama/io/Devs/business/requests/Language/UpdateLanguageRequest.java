package kodlama.io.Devs.business.requests.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageRequest {
	private String oldName;
	private String newName;

}
