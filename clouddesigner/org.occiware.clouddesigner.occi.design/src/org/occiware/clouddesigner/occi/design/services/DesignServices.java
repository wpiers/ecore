package org.occiware.clouddesigner.occi.design.services;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.occiware.clouddesigner.occi.Action;
import org.occiware.clouddesigner.occi.Attribute;
import org.occiware.clouddesigner.occi.Category;
import org.occiware.clouddesigner.occi.Extension;
import org.occiware.clouddesigner.occi.Kind;
import org.occiware.clouddesigner.occi.Mixin;
import org.occiware.clouddesigner.occi.design.dialog.LoadExtensionDialog;

public class DesignServices {

	// service:isEDataType
	public Boolean isEDataType(EObject eObj) {
		return eObj.eClass() == EcorePackage.eINSTANCE.getEDataType();
	}

	/**
	 * Computes the label of an Action.
	 */
	public String render(Action action) {
		StringBuilder sb = new StringBuilder();
		sb.append(action.getTerm());
		sb.append('(');
		boolean first = true;
		for (Attribute param : action.getAttributes()) {
			if (!first) {
				sb.append(", "); //$NON-NLS-1$
			} else {
				first = false;
			}
			sb.append(param.getName())
					.append(" : ").append(param.getType().getName()); //$NON-NLS-1$
		}
		sb.append(')');
		return sb.toString();
	}

	/**
	 * Computes the initial term of an Action.
	 */
	public String initialActionTerm(Action action) {
	  Object container = action.eContainer();
	  int nb = 0;
	  if(container instanceof Kind) {
		  nb = ((Kind)container).getActions().size();
	  } else if(container instanceof Mixin) {
		  nb = ((Mixin)container).getActions().size();
	  }
	  return "action" + nb;
	}

	/**
	 * Computes the initial scheme of an Action.
	 */
	public String initialActionScheme(Action action) {
	  Category category = (Category)action.eContainer();
	  String scheme = category.getScheme();
	  return scheme.substring(0, scheme.length()-1) + "/" + category.getTerm() + "/action#";
	}

	public void importExtension(Extension extension) {
		Shell shell = Display.getCurrent().getActiveShell();
		Session session = SessionManager.INSTANCE.getSession(extension);
				LoadExtensionDialog dialog = new LoadExtensionDialog(shell,
				session.getTransactionalEditingDomain());
		dialog.open();

		for (URI uri : dialog.getURIs()) {
			session.addSemanticResource(uri, new NullProgressMonitor());
			Resource resource = session.getTransactionalEditingDomain()
					.getResourceSet().getResource(uri, true);
			if (!resource.getContents().isEmpty()
					&& (resource.getContents().get(0) instanceof Extension)
					&& !extension.getImport().contains(
							resource.getContents().get(0))) {
				extension.getImport().add(
						(Extension) resource.getContents().get(0));
			}
		}

	}
}
