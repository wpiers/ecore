/**
 */
package org.occiware.clouddesigner.occi.docker;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.occiware.clouddesigner.occi.docker.Link#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see org.occiware.clouddesigner.occi.docker.DockerPackage#getLink()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='LinkSourceAsContainer LinkTargetAsContainer LinkCanOnlyConnectColocalizedContainers'"
 * @generated
 */
public interface Link extends org.occiware.clouddesigner.occi.Link {
	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see org.occiware.clouddesigner.occi.docker.DockerPackage#getLink_Alias()
	 * @model dataType="org.occiware.clouddesigner.occi.String"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://occiware.org/docker!Link!alias'"
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link org.occiware.clouddesigner.occi.docker.Link#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv LinkTargetAsContainer:\n *   let severity : Integer[1] = \'Link::LinkTargetAsContainer\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : Boolean[1] = target.oclIsKindOf(Container)\n *       in\n *         \'Link::LinkTargetAsContainer\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkTargetAsContainer));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_docker_c_c_Container_0 = idResolver.getClass(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.CLSSid_Container, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> target = this.getTarget();\n        final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, target, TYP_docker_c_c_Container_0).booleanValue());\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkTargetAsContainer, this, diagnostics, context, severity_0, CAUGHT_status, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean LinkTargetAsContainer(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv LinkSourceAsContainer:\n *   let severity : Integer[1] = \'Link::LinkSourceAsContainer\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let status : Boolean[1] = source.oclIsKindOf(Container)\n *       in\n *         \'Link::LinkSourceAsContainer\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkSourceAsContainer));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_docker_c_c_Container = idResolver.getClass(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.CLSSid_Container, null);\n        final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> source = this.getSource();\n        final /*@Thrown\052/ boolean status = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation%>.INSTANCE.evaluate(evaluator, source, TYP_docker_c_c_Container).booleanValue());\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkSourceAsContainer, this, diagnostics, context, severity_0, CAUGHT_status, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean LinkSourceAsContainer(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='/**\n * \n * inv LinkCanOnlyConnectColocalizedContainers:\n *   let\n *     severity : Integer[1] = \'Link::LinkCanOnlyConnectColocalizedContainers\'.getSeverity()\n *   in\n *     if severity <= 0\n *     then true\n *     else\n *       let\n *         status : Boolean[1] = Contains.allInstances()\n *         ->select(contains | contains.target = self.source).source =\n *         Contains.allInstances()\n *         ->select(contains | contains.target = self.target).source\n *       in\n *         \'Link::LinkCanOnlyConnectColocalizedContainers\'.logDiagnostic(self, diagnostics, context, severity, status, 0)\n *     endif\n \052/\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.evaluation.Evaluator%> evaluator = <%org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal%>.getEvaluator(this);\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.ids.IdResolver%> idResolver = evaluator.getIdResolver();\nfinal /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.IntegerValue%> severity_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation%>.INSTANCE.evaluate(evaluator, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkCanOnlyConnectColocalizedContainers));\nfinal /*@NonInvalid\052/ boolean le = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation%>.INSTANCE.evaluate(evaluator, severity_0, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n/*@NonInvalid\052/ boolean symbol_0;\nif (le) {\n    symbol_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE;\n}\nelse {\n    /*@NonNull\052/ /*@Caught\052/ <%java.lang.Object%> CAUGHT_status;\n    try {\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.Class%> TYP_docker_c_c_Contains_0 = idResolver.getClass(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.CLSSid_Contains, null);\n        final /*@NonNull\052/ /*@NonInvalid\052/ <%org.eclipse.ocl.pivot.values.SetValue%> allInstances_0 = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.classifier.ClassifierAllInstancesOperation%>.INSTANCE.evaluate(evaluator, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.SET_CLSSid_Contains, TYP_docker_c_c_Contains_0));\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.SET_CLSSid_Contains);\n        /*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR_contains = allInstances_0.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> select;\n        while (true) {\n            if (!ITERATOR_contains.hasNext()) {\n                select = accumulator;\n                break;\n            }\n            /*@NonNull\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.occi.docker.Contains%> contains = (<%org.occiware.clouddesigner.occi.docker.Contains%>)ITERATOR_contains.next();\n            /**\n             * contains.target = self.source\n             \052/\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> target = contains.getTarget();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> source = this.getSource();\n            final /*@Thrown\052/ boolean eq = target.equals(source);\n            //\n            if (eq == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                accumulator.add(contains);\n            }\n        }\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.BagValue%>.Accumulator accumulator_0 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createBagAccumulatorValue(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.BAG_CLSSid_Resource);\n        /*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR__1 = select.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.BagValue%> collect;\n        while (true) {\n            if (!ITERATOR__1.hasNext()) {\n                collect = accumulator_0;\n                break;\n            }\n            /*@NonNull\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.occi.docker.Contains%> _1 = (<%org.occiware.clouddesigner.occi.docker.Contains%>)ITERATOR__1.next();\n            /**\n             * source\n             \052/\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> source_0 = _1.getSource();\n            //\n            accumulator_0.add(source_0);\n        }\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%>.Accumulator accumulator_1 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createSetAccumulatorValue(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.SET_CLSSid_Contains);\n        /*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR_contains_0 = allInstances_0.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.SetValue%> select_0;\n        while (true) {\n            if (!ITERATOR_contains_0.hasNext()) {\n                select_0 = accumulator_1;\n                break;\n            }\n            /*@NonNull\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.occi.docker.Contains%> contains_0 = (<%org.occiware.clouddesigner.occi.docker.Contains%>)ITERATOR_contains_0.next();\n            /**\n             * contains.target = self.target\n             \052/\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> target_0 = contains_0.getTarget();\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> target_1 = this.getTarget();\n            final /*@Thrown\052/ boolean eq_0 = target_0.equals(target_1);\n            //\n            if (eq_0 == <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.TRUE_VALUE) {\n                accumulator_1.add(contains_0);\n            }\n        }\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.BagValue%>.Accumulator accumulator_2 = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createBagAccumulatorValue(<%org.occiware.clouddesigner.occi.docker.DockerTables%>.BAG_CLSSid_Resource);\n        /*@NonNull\052/ <%java.util.Iterator%><?> ITERATOR__1_0 = select_0.iterator();\n        /*@NonNull\052/ /*@Thrown\052/ <%org.eclipse.ocl.pivot.values.BagValue%> collect_0;\n        while (true) {\n            if (!ITERATOR__1_0.hasNext()) {\n                collect_0 = accumulator_2;\n                break;\n            }\n            /*@NonNull\052/ /*@NonInvalid\052/ <%org.occiware.clouddesigner.occi.docker.Contains%> _1_0 = (<%org.occiware.clouddesigner.occi.docker.Contains%>)ITERATOR__1_0.next();\n            /**\n             * source\n             \052/\n            final /*@NonNull\052/ /*@Thrown\052/ <%org.occiware.clouddesigner.occi.Resource%> source_1 = _1_0.getSource();\n            //\n            accumulator_2.add(source_1);\n        }\n        final /*@Thrown\052/ boolean status = collect.equals(collect_0);\n        CAUGHT_status = status;\n    }\n    catch (<%java.lang.Exception%> e) {\n        CAUGHT_status = <%org.eclipse.ocl.pivot.utilities.ValueUtil%>.createInvalidValue(e);\n    }\n    final /*@NonInvalid\052/ boolean logDiagnostic = <%org.eclipse.ocl.pivot.utilities.ClassUtil%>.nonNullState(<%org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation%>.INSTANCE.evaluate(evaluator, <%org.eclipse.ocl.pivot.ids.TypeId%>.BOOLEAN, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.STR_Link_c_c_LinkCanOnlyConnectColocalizedContainers, this, diagnostics, context, severity_0, CAUGHT_status, <%org.occiware.clouddesigner.occi.docker.DockerTables%>.INT_0).booleanValue());\n    symbol_0 = logDiagnostic;\n}\nreturn Boolean.TRUE == symbol_0;'"
	 * @generated
	 */
	boolean LinkCanOnlyConnectColocalizedContainers(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Link