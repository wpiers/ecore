/*
 * generated by Xtext
 */
package org.occiware.clouddesigner.occi.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.BasicEMap.Entry;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.occiware.clouddesigner.occi.Action;
import org.occiware.clouddesigner.occi.Attribute;
import org.occiware.clouddesigner.occi.AttributeState;
import org.occiware.clouddesigner.occi.Configuration;
import org.occiware.clouddesigner.occi.Extension;
import org.occiware.clouddesigner.occi.Kind;
import org.occiware.clouddesigner.occi.Link;
import org.occiware.clouddesigner.occi.Mixin;
import org.occiware.clouddesigner.occi.OCCIPackage;
import org.occiware.clouddesigner.occi.Resource;
import org.occiware.clouddesigner.occi.xtext.services.OCCIGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractOCCISemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private OCCIGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == EcorePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EcorePackage.EANNOTATION:
				sequence_DataTypeAnnotations(context, (EAnnotation) semanticObject); 
				return; 
			case EcorePackage.EDATA_TYPE:
				sequence_DataTypeDecl(context, (EDataType) semanticObject); 
				return; 
			case EcorePackage.EENUM:
				sequence_EnumTypeDecl(context, (EEnum) semanticObject); 
				return; 
			case EcorePackage.EENUM_LITERAL:
				sequence_EnumLiteralDecl(context, (EEnumLiteral) semanticObject); 
				return; 
			case EcorePackage.ESTRING_TO_STRING_MAP_ENTRY:
				sequence_DataTypeAnnotation(context, (Entry<?, ?>) semanticObject); 
				return; 
			}
		else if(semanticObject.eClass().getEPackage() == OCCIPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case OCCIPackage.ACTION:
				sequence_ActionDecl(context, (Action) semanticObject); 
				return; 
			case OCCIPackage.ATTRIBUTE:
				if(context == grammarAccess.getAttributeDeclRule()) {
					sequence_AttributeDecl(context, (Attribute) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getParameterDeclRule()) {
					sequence_ParameterDecl(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case OCCIPackage.ATTRIBUTE_STATE:
				sequence_StateDecl(context, (AttributeState) semanticObject); 
				return; 
			case OCCIPackage.CONFIGURATION:
				sequence_ConfigurationDecl(context, (Configuration) semanticObject); 
				return; 
			case OCCIPackage.EXTENSION:
				sequence_ExtensionDecl(context, (Extension) semanticObject); 
				return; 
			case OCCIPackage.KIND:
				sequence_KindDecl(context, (Kind) semanticObject); 
				return; 
			case OCCIPackage.LINK:
				sequence_LinkDecl(context, (Link) semanticObject); 
				return; 
			case OCCIPackage.MIXIN:
				sequence_MixinDecl(context, (Mixin) semanticObject); 
				return; 
			case OCCIPackage.RESOURCE:
				sequence_ResourceDecl(context, (Resource) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (term=ID (attributes+=ParameterDecl attributes+=ParameterDecl*)? title=STRING?)
	 */
	protected void sequence_ActionDecl(EObject context, Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         mutable?='mutable'? 
	 *         required?='required'? 
	 *         name=ID 
	 *         type=[EDataType|QualifiedID] 
	 *         default=STRING? 
	 *         description=STRING?
	 *     )
	 */
	protected void sequence_AttributeDecl(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (use+=[Extension|STRING]* resources+=ResourceDecl*)
	 */
	protected void sequence_ConfigurationDecl(EObject context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (key='minExclusive' value=Integer) | 
	 *         (key='minInclusive' value=Integer) | 
	 *         (key='maxExclusive' value=Integer) | 
	 *         (key='maxInclusive' value=Integer) | 
	 *         (key='totalDigits' value=PositiveInteger) | 
	 *         (key='fractionDigits' value=PositiveInteger) | 
	 *         (key='length' value=PositiveInteger) | 
	 *         (key='minLength' value=PositiveInteger) | 
	 *         (key='maxLength' value=PositiveInteger) | 
	 *         (key='whiteSpace' value=PositiveInteger) | 
	 *         (key='pattern' value=STRING)
	 *     )
	 */
	protected void sequence_DataTypeAnnotation(EObject context, Entry<?, ?> semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     details+=DataTypeAnnotation+
	 */
	protected void sequence_DataTypeAnnotations(EObject context, EAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (serializable?='serializable'? name=ID instanceTypeName=STRING eAnnotations+=DataTypeAnnotations?)
	 */
	protected void sequence_DataTypeDecl(EObject context, EDataType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_EnumLiteralDecl(EObject context, EEnumLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID eLiterals+=EnumLiteralDecl eLiterals+=EnumLiteralDecl*)
	 */
	protected void sequence_EnumTypeDecl(EObject context, EEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID scheme=STRING import+=[Extension|STRING]* (kinds+=KindDecl | mixins+=MixinDecl | types+=DataTypeDecl | types+=EnumTypeDecl)*)
	 */
	protected void sequence_ExtensionDecl(EObject context, Extension semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (term=ID parent=[Kind|QualifiedID]? title=STRING? (attributes+=AttributeDecl | actions+=ActionDecl)*)
	 */
	protected void sequence_KindDecl(EObject context, Kind semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=STRING kind=[Kind|QualifiedID] (mixins+=[Mixin|QualifiedID] mixins+=[Mixin|QualifiedID]*)? target=[Resource|STRING] attributes+=StateDecl*)
	 */
	protected void sequence_LinkDecl(EObject context, Link semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         term=ID 
	 *         (depends+=[Mixin|QualifiedID] depends+=[Mixin|QualifiedID]*)? 
	 *         (applies+=[Kind|QualifiedID] applies+=[Kind|QualifiedID]*)? 
	 *         scheme=STRING? 
	 *         title=STRING? 
	 *         (attributes+=AttributeDecl | actions+=ActionDecl)*
	 *     )
	 */
	protected void sequence_MixinDecl(EObject context, Mixin semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID type=[EDataType|QualifiedID] multiple_values?='*'?)
	 */
	protected void sequence_ParameterDecl(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=STRING kind=[Kind|QualifiedID] (mixins+=[Mixin|QualifiedID] mixins+=[Mixin|QualifiedID]*)? attributes+=StateDecl* links+=LinkDecl*)
	 */
	protected void sequence_ResourceDecl(EObject context, Resource semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_StateDecl(EObject context, AttributeState semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, OCCIPackage.Literals.ATTRIBUTE_STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OCCIPackage.Literals.ATTRIBUTE_STATE__NAME));
			if(transientValues.isValueTransient(semanticObject, OCCIPackage.Literals.ATTRIBUTE_STATE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, OCCIPackage.Literals.ATTRIBUTE_STATE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStateDeclAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getStateDeclAccess().getValueSTRINGTerminalRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
}
