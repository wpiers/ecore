/**
 */
package org.occiware.clouddesigner.OCCI;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.occiware.clouddesigner.OCCI.Link#getSource <em>Source</em>}</li>
 *   <li>{@link org.occiware.clouddesigner.OCCI.Link#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.occiware.clouddesigner.OCCI.OCCIPackage#getLink()
 * @model
 * @generated
 */
public interface Link extends Entity {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.occiware.clouddesigner.OCCI.Resource#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Resource)
	 * @see org.occiware.clouddesigner.OCCI.OCCIPackage#getLink_Source()
	 * @see org.occiware.clouddesigner.OCCI.Resource#getLinks
	 * @model opposite="links" required="true" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://schemas.ogf.org/occi!Link!source'"
	 * @generated
	 */
	Resource getSource();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.OCCI.Link#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Resource value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Resource)
	 * @see org.occiware.clouddesigner.OCCI.OCCIPackage#getLink_Target()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://schemas.ogf.org/occi!Link!target'"
	 * @generated
	 */
	Resource getTarget();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.OCCI.Link#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Resource value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv LinkKindIsInParent: kind->closure(parent)->exists(k | k.term = \'link\' and k.scheme = \'http://schemas.ogf.org/occi/core#\')\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator = <%org.eclipse.ocl.examples.pivot.utilities.PivotUtil%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.types.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary%> standardLibrary = idResolver.getStandardLibrary();\n/*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_exists;\ntry {\n    final /*@Nullable\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.OCCI.Kind%> kind = this.getKind();\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> oclAsSet = <%org.eclipse.ocl.examples.domain.utilities.DomainUtil%>.nonNullState(<%org.eclipse.ocl.examples.library.oclany.OclAnyOclAsSetOperation%>.INSTANCE.evaluate(evaluator, <%org.occiware.clouddesigner.OCCI.OCCITables%>.SET_CLSSid_Kind, kind));\n    final /*@NonNull\052/ <%org.eclipse.ocl.examples.domain.elements.DomainType%> TYPE_closure_0 = evaluator.getStaticTypeOf(oclAsSet);\n    final /*@NonNull\052/ <%org.eclipse.ocl.examples.domain.library.LibraryIteration%> IMPL_closure_0 = (<%org.eclipse.ocl.examples.domain.library.LibraryIteration%>)TYPE_closure_0.lookupImplementation(standardLibrary, <%org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibTables%>.Operations._Set__closure);\n    final /*@NonNull\052/ Object ACC_closure_0 = IMPL_closure_0.createAccumulatorValue(evaluator, <%org.occiware.clouddesigner.OCCI.OCCITables%>.SET_CLSSid_Kind, <%org.occiware.clouddesigner.OCCI.OCCITables%>.CLSSid_Kind);\n    /**\n     * Implementation of the iterator body.\n     \052/\n    final /*@NonNull\052/ <%org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation%> BODY_closure_0 = new <%org.eclipse.ocl.examples.domain.library.AbstractBinaryOperation%>()\n    {\n        /**\n         * parent\n         \052/\n        @Override\n        public /*@Nullable\052/ Object evaluate(final /*@NonNull\052/ <%org.eclipse.ocl.examples.domain.evaluation.DomainEvaluator%> evaluator, final /*@NonNull\052/ <%org.eclipse.ocl.examples.domain.ids.TypeId%> typeId, final /*@Nullable\052/ Object oclAsSet, final /*@Nullable\052/ /*@NonInvalid\052/ <%java.lang.Object%> _1) {\n            final /*@Nullable\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.OCCI.Kind%> symbol_0 = (<%org.occiware.clouddesigner.OCCI.Kind%>)_1;\n            if (symbol_0 == null) {\n                throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source for \\\'OCCI::Kind::parent\\\'\");\n            }\n            final /*@Nullable\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.OCCI.Kind%> parent = symbol_0.getParent();\n            return parent;\n        }\n    };\n    final /*@NonNull\052/  <%org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager%> MGR_closure_0 = new <%org.eclipse.ocl.examples.library.executor.ExecutorSingleIterationManager%>(evaluator, <%org.occiware.clouddesigner.OCCI.OCCITables%>.SET_CLSSid_Kind, BODY_closure_0, oclAsSet, ACC_closure_0);\n    final /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.examples.domain.values.SetValue%> closure = (<%org.eclipse.ocl.examples.domain.values.SetValue%>)IMPL_closure_0.evaluateIteration(MGR_closure_0);\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Object%> accumulator = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE;\n    /*@Nullable\052/ <%java.util.Iterator%><?> ITERATOR_k = closure.iterator();\n    /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> exists;\n    while (true) {\n        if (!ITERATOR_k.hasNext()) {\n            if ((accumulator == null) || (accumulator == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE)) {\n                exists = (<%java.lang.Boolean%>)accumulator;\n            }\n            else {\n                throw (<%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>)accumulator;\n            }\n            break;\n        }\n        /*@Nullable\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.OCCI.Kind%> k = (<%org.occiware.clouddesigner.OCCI.Kind%>)ITERATOR_k.next();\n        /**\n         * k.term = \'link\' and k.scheme = \'http://schemas.ogf.org/occi/core#\'\n         \052/\n        /*@Nullable\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_and;\n        try {\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq;\n            try {\n                if (k == null) {\n                    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source for \\\'OCCI::Category::term\\\'\");\n                }\n                final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.String%> term = k.getTerm();\n                final /*@Thrown\052/ boolean eq = term.equals(<%org.occiware.clouddesigner.OCCI.OCCITables%>.STR_link);\n                CAUGHT_eq = eq;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_eq = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n            }\n            /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_eq_0;\n            try {\n                if (k == null) {\n                    throw new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(\"Null source for \\\'OCCI::Category::scheme\\\'\");\n                }\n                final /*@NonNull\052/ /*@Thrown\052/ <%java.lang.String%> scheme = k.getScheme();\n                final /*@Thrown\052/ boolean eq_0 = scheme.equals(<%org.occiware.clouddesigner.OCCI.OCCITables%>.STR_http_c_s_s_schemas_ogf_o);\n                CAUGHT_eq_0 = eq_0;\n            }\n            catch (<%java.lang.Exception%> e) {\n                CAUGHT_eq_0 = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n            }\n            final /*@Nullable\052/ /*@Thrown\052/ <%java.lang.Boolean%> and = <%org.eclipse.ocl.examples.library.logical.BooleanAndOperation%>.INSTANCE.evaluate(CAUGHT_eq, CAUGHT_eq_0);\n            CAUGHT_and = and;\n        }\n        catch (<%java.lang.Exception%> e) {\n            CAUGHT_and = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n        }\n        //\n        if (CAUGHT_and == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\t\t\t\t\t// Normal successful body evaluation result\n            exists = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE;\n            break;\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Stop immediately \n        }\n        else if (CAUGHT_and == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE) {\t\t\t\t// Normal unsuccessful body evaluation result\n            ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Carry on\n        }\n        else if (CAUGHT_and == null) {\t\t\t\t\t\t\t\t// Abnormal null body evaluation result\n            if (accumulator == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.FALSE_VALUE) {\n                accumulator = null;\t\t\t\t\t\t\t\t\t\t// Cache a null failure\n            }\n        }\n        else if (CAUGHT_and instanceof <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>) {\t\t// Abnormal exception evaluation result\n            accumulator = CAUGHT_and;\t\t\t\t\t\t\t\t\t// Cache an exception failure\n        }\n        else {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t// Impossible badly typed result\n            accumulator = new <%org.eclipse.ocl.examples.domain.values.impl.InvalidValueException%>(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.NonBooleanBody, \"exists\");\n        }\n    }\n    CAUGHT_exists = exists;\n}\ncatch (<%java.lang.Exception%> e) {\n    CAUGHT_exists = <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.createInvalidValue(e);\n}\nif (CAUGHT_exists == <%org.eclipse.ocl.examples.domain.values.util.ValuesUtil%>.TRUE_VALUE) {\n    return true;\n}\nif (diagnostics != null) {\n    int severity = CAUGHT_exists == null ? <%org.eclipse.emf.common.util.Diagnostic%>.ERROR : <%org.eclipse.emf.common.util.Diagnostic%>.WARNING;\n    <%java.lang.String%> message = <%org.eclipse.ocl.examples.domain.utilities.DomainUtil%>.bind(<%org.eclipse.ocl.examples.domain.messages.EvaluatorMessages%>.ValidationConstraintIsNotSatisfied_ERROR_, new Object[]{\"Link\", \"LinkKindIsInParent\", <%org.eclipse.emf.ecore.util.EObjectValidator%>.getObjectLabel(this, context)});\n    diagnostics.add(new <%org.eclipse.emf.common.util.BasicDiagnostic%>(severity, <%org.occiware.clouddesigner.OCCI.util.OCCIValidator%>.DIAGNOSTIC_SOURCE, <%org.occiware.clouddesigner.OCCI.util.OCCIValidator%>.LINK__LINK_KIND_IS_IN_PARENT, message, new Object [] { this }));\n}\nreturn false;'"
	 * @generated
	 */
	boolean LinkKindIsInParent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Link