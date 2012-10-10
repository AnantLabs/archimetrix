package org.storydriven.modeling.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.storydriven.modeling.diagram.providers.SDMElementTypes;

/**
 * @generated
 */
public class LinkVariableItemSemanticEditPolicy extends
		SDMBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LinkVariableItemSemanticEditPolicy() {
		super(SDMElementTypes.LinkVariable_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}