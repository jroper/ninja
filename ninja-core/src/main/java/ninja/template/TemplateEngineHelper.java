package ninja.template;

import ninja.Result;
import ninja.Route;
import ninja.utils.NinjaConstant;

/**
 * Helper methods for template engines
 *
 * @author James Roper
 */
public class TemplateEngineHelper {

    public String getTemplateForResult(Route route, Result result, String suffix) {
        if (result.getTemplate() == null) {
            Class controller = route.getControllerClass();

            // Calculate the correct path of the template.
            // We always assume the template in the subdir "views"

            // 1) If we are in the main project =>
            // /views/ControllerName/templateName.ftl.html
            // 2) If we are in a plugin / subproject
            // =>
            // some/packages/submoduleName/views/ControllerName/templateName.ftl.html

            // So let's calculate the parent package of the controller:
            String controllerPackageName = controller.getPackage().getName();
            // This results in something like controllers or
            // some.package.controllers

            // Let's remove "controllers" so we cat all parent packages:
            String parentPackageOfController = controllerPackageName
                    .replaceAll(NinjaConstant.CONTROLLERS_DIR, "");

            // And now we rewrite everything from "." notation to directories /
            String parentControllerPackageAsPath = parentPackageOfController
                    .replaceAll("\\.", "/");

            // and the final path of the controller will be something like:
            // some/package/views/ControllerName/templateName.ftl.html
            return String.format("%sviews/%s/%s%s",
                    parentControllerPackageAsPath, controller.getSimpleName(),
                    route.getControllerMethod().getName(), suffix);
        } else {
            return result.getTemplate();
        }
    }

}
