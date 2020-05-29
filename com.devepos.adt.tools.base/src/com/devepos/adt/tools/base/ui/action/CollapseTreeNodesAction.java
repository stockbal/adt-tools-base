package com.devepos.adt.tools.base.ui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

import com.devepos.adt.tools.base.AdtToolsBaseResources;
import com.devepos.adt.tools.base.IAdtToolsBaseImages;
import com.devepos.adt.tools.base.internal.messages.Messages;

/**
 * Action to collapse the tree for a specific node
 *
 * @author stockbal
 */
public class CollapseTreeNodesAction extends Action {
	private final TreeViewer viewer;

	public CollapseTreeNodesAction(final TreeViewer viewer) {
		super(Messages.Actions_CollapseNode_xtol, AdtToolsBaseResources.getImageDescriptor(IAdtToolsBaseImages.COLLAPSE_ALL));
		this.viewer = viewer;
	}

	@Override
	public void run() {
		final IStructuredSelection selection = this.viewer.getStructuredSelection();
		if (selection == null) {
			return;
		}
		for (final Object sel : selection.toList()) {
			this.viewer.collapseToLevel(sel, TreeViewer.ALL_LEVELS);
		}
	}
}