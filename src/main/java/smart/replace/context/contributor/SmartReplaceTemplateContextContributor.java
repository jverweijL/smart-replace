package smart.replace.context.contributor;

import com.liferay.portal.kernel.template.TemplateContextContributor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author jverweij
 */
@Component(
	immediate = true,
	property = {"type=" + TemplateContextContributor.TYPE_GLOBAL},
	service = TemplateContextContributor.class
)
public class SmartReplaceTemplateContextContributor
	implements TemplateContextContributor {

	HashMap<String, String> smartLabels = new HashMap<String, String>();

	@Override
	public void prepare(
		Map<String, Object> contextObjects, HttpServletRequest request) {

		// ways to add smartlabels...
		// ... hardcode in this module
		// ... through json-files stored in document and media library or in this module
		// ... select right config based on hostname, url or other logic
		// ... use language capabilities and language module

		smartLabels.put("sample_text", "This is some sample text.");
		smartLabels.put("global.sample_link", "https://liferay.com");
		smartLabels.put("sample_link", "https://liferay.nl");

		for (String key: smartLabels.keySet()){
			contextObjects.put(key, smartLabels.get(key));
		}

		contextObjects.put("smartReplace", this);
	}

	public String smartReplaceAll(String content){

		for (String key: smartLabels.keySet()){
			content = content.replaceAll("\\$\\{" + key + "\\}",smartLabels.get(key));
		}
		return content;
	}

}