package org.archimetrix.architecturepreview.ui.util;

import java.util.HashMap;
import java.util.Map;

import org.archimetrix.commons.wizards.WizardConst;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.somox.sourcecodedecorator.ComponentImplementingClassesLink;
import org.somox.sourcecodedecorator.SourceCodeDecoratorRepository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * This class contains helper methods for components.
 * 
 * @author mcp
 * 
 */
public final class ComponentsUtil {
    /**
     * String source segment.
     */
    private static final String RESOURCE_SEGMENT = "resource";

    /**
     * instance.
     */
    private static ComponentsUtil instance = null;

    /**
     * SCD repository.
     */
    private SourceCodeDecoratorRepository scd;

    /**
     * repository.
     */
    private Repository samm;

    /**
     * map of component classes.
     */
    private Map<BasicComponent, ComponentImplementingClassesLink> componentClasses; // ComponentType
                                                                                    // changed to
                                                                                    // BasicComponen
    /**
     * the constructor.
     */
    private ComponentsUtil() {
    }

    /**
     * Get method for the static instance.
     * @return instance
     */
    public static ComponentsUtil get() {
        if (instance == null) {
            instance = new ComponentsUtil();
        }
        return instance;
    }

    /**
     * Returns the componentImplementingClassesLink that belongs to the given component.
     * 
     * @param component
     *            a primitive component from a SAMM
     * @return a component implementing classes link of the according SCDM
     */
    public ComponentImplementingClassesLink getComponentImplementingClassesLinkForComponent(
            final BasicComponent component) // PrimitivComponent changed to BasicComponent
    {
        if (this.componentClasses == null) {
            this.componentClasses = new HashMap<BasicComponent, ComponentImplementingClassesLink>(); // ComponentType
                                                                                                     // changed
                                                                                                     // to
                                                                                                     // BasicCompoment
        }
        ComponentImplementingClassesLink componentImplementingClassesLink = this.componentClasses.get(component);
        if (componentImplementingClassesLink != null) {
            return componentImplementingClassesLink;
        } else {
            SourceCodeDecoratorRepository scd = getSourceCodeDecoratorModel((Repository) component.eContainer());
            for (ComponentImplementingClassesLink link : scd.getComponentImplementingClassesLink()) {
                EcoreUtil.resolveAll(link.getComponent());
                if (link.getComponent().getId().equals(component.getId())) {
                    this.componentClasses.put(component, link);
                    return link;
                }
            }
        }
        return null;
    }

    /**
     * Creates a short name from the component name generated by SoMoX.
     * 
     * @param component repository component
     * @return short component name
     */
    public String createShortComponentName(final RepositoryComponent component) {
        String[] componentNameArray = component.getEntityName().split(" ");
        String componentName = componentNameArray[1] + " " + componentNameArray[3];
        return componentName;
    }

    /**
     * Returns scdm.
     * @param sammRepository repository
     * @return scd repository
     */
    private SourceCodeDecoratorRepository getSourceCodeDecoratorModel(final Repository sammRepository) {
        if (this.scd == null || sammRepository != this.samm) {
            this.samm = sammRepository;
            StringBuilder path = createSCDMPath(sammRepository);
            URI scdmFileUri = URI.createPlatformResourceURI(path.toString(), true);
            ResourceSet scdmRess = new ResourceSetImpl();
            Resource scdmRes = scdmRess.getResource(scdmFileUri, true);
            this.scd = (SourceCodeDecoratorRepository) scdmRes.getContents().get(0);
        }
        return this.scd;
    }

    /**
     * Creates SCDM path.
     * @param sammRepository repository
     * @return path
     */
    private StringBuilder createSCDMPath(final Repository sammRepository) {
        String resourceUriPath = sammRepository.eResource().getURI().path();
        String modelsPath = resourceUriPath.split(RESOURCE_SEGMENT)[1].split("\\.")[0];
        StringBuilder path = new StringBuilder(modelsPath);
        path.append(".");
        path.append(WizardConst.WizardConstants_SOURCECODEDECORATOR_FILE_EXTENSION);
        return path;
    }
}
