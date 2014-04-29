/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reclipse.structure.specification.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.reclipse.structure.specification.util.SpecificationAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecificationItemProviderAdapterFactory extends SpecificationAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
   /**
    * This keeps track of the root adapter factory that delegates to this adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ComposedAdapterFactory parentAdapterFactory;

   /**
    * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected IChangeNotifier changeNotifier = new ChangeNotifier();

   /**
    * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected Collection<Object> supportedTypes = new ArrayList<Object>();

   /**
    * This constructs an instance.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public SpecificationItemProviderAdapterFactory()
   {
      supportedTypes.add(IEditingDomainItemProvider.class);
      supportedTypes.add(IStructuredItemContentProvider.class);
      supportedTypes.add(ITreeItemContentProvider.class);
      supportedTypes.add(IItemLabelProvider.class);
      supportedTypes.add(IItemPropertySource.class);
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSCatalog} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSCatalogItemProvider psCatalogItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSCatalog}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSCatalogAdapter()
   {
      if (psCatalogItemProvider == null)
      {
         psCatalogItemProvider = new PSCatalogItemProvider(this);
      }

      return psCatalogItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSPatternSpecification} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSPatternSpecificationItemProvider psPatternSpecificationItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSPatternSpecification}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSPatternSpecificationAdapter()
   {
      if (psPatternSpecificationItemProvider == null)
      {
         psPatternSpecificationItemProvider = new PSPatternSpecificationItemProvider(this);
      }

      return psPatternSpecificationItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSLink} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSLinkItemProvider psLinkItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSLink}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSLinkAdapter()
   {
      if (psLinkItemProvider == null)
      {
         psLinkItemProvider = new PSLinkItemProvider(this);
      }

      return psLinkItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSPath} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSPathItemProvider psPathItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSPath}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSPathAdapter()
   {
      if (psPathItemProvider == null)
      {
         psPathItemProvider = new PSPathItemProvider(this);
      }

      return psPathItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSCombinedFragment} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSCombinedFragmentItemProvider psCombinedFragmentItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSCombinedFragment}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSCombinedFragmentAdapter()
   {
      if (psCombinedFragmentItemProvider == null)
      {
         psCombinedFragmentItemProvider = new PSCombinedFragmentItemProvider(this);
      }

      return psCombinedFragmentItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSSpecificationConstraint} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSSpecificationConstraintItemProvider psSpecificationConstraintItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSSpecificationConstraint}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSSpecificationConstraintAdapter()
   {
      if (psSpecificationConstraintItemProvider == null)
      {
         psSpecificationConstraintItemProvider = new PSSpecificationConstraintItemProvider(this);
      }

      return psSpecificationConstraintItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSObject} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSObjectItemProvider psObjectItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSObject}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSObjectAdapter()
   {
      if (psObjectItemProvider == null)
      {
         psObjectItemProvider = new PSObjectItemProvider(this);
      }

      return psObjectItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSAnnotation} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSAnnotationItemProvider psAnnotationItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSAnnotation}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSAnnotationAdapter()
   {
      if (psAnnotationItemProvider == null)
      {
         psAnnotationItemProvider = new PSAnnotationItemProvider(this);
      }

      return psAnnotationItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSFuzzyMetricConstraint} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSFuzzyMetricConstraintItemProvider psFuzzyMetricConstraintItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSFuzzyMetricConstraint}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSFuzzyMetricConstraintAdapter()
   {
      if (psFuzzyMetricConstraintItemProvider == null)
      {
         psFuzzyMetricConstraintItemProvider = new PSFuzzyMetricConstraintItemProvider(this);
      }

      return psFuzzyMetricConstraintItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSFuzzySetRatingConstraint} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSFuzzySetRatingConstraintItemProvider psFuzzySetRatingConstraintItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSFuzzySetRatingConstraint}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSFuzzySetRatingConstraintAdapter()
   {
      if (psFuzzySetRatingConstraintItemProvider == null)
      {
         psFuzzySetRatingConstraintItemProvider = new PSFuzzySetRatingConstraintItemProvider(this);
      }

      return psFuzzySetRatingConstraintItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSAttributeConstraint} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSAttributeConstraintItemProvider psAttributeConstraintItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSAttributeConstraint}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSAttributeConstraintAdapter()
   {
      if (psAttributeConstraintItemProvider == null)
      {
         psAttributeConstraintItemProvider = new PSAttributeConstraintItemProvider(this);
      }

      return psAttributeConstraintItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSMetricConstraint} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSMetricConstraintItemProvider psMetricConstraintItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSMetricConstraint}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSMetricConstraintAdapter()
   {
      if (psMetricConstraintItemProvider == null)
      {
         psMetricConstraintItemProvider = new PSMetricConstraintItemProvider(this);
      }

      return psMetricConstraintItemProvider;
   }

   /**
    * This keeps track of the one adapter used for all {@link org.reclipse.structure.specification.PSFunctionParameter} instances.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected PSFunctionParameterItemProvider psFunctionParameterItemProvider;

   /**
    * This creates an adapter for a {@link org.reclipse.structure.specification.PSFunctionParameter}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter createPSFunctionParameterAdapter()
   {
      if (psFunctionParameterItemProvider == null)
      {
         psFunctionParameterItemProvider = new PSFunctionParameterItemProvider(this);
      }

      return psFunctionParameterItemProvider;
   }

   /**
    * This returns the root adapter factory that contains this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ComposeableAdapterFactory getRootAdapterFactory()
   {
      return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
   }

   /**
    * This sets the composed adapter factory that contains this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
   {
      this.parentAdapterFactory = parentAdapterFactory;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean isFactoryForType(Object type)
   {
      return supportedTypes.contains(type) || super.isFactoryForType(type);
   }

   /**
    * This implementation substitutes the factory itself as the key for the adapter.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Adapter adapt(Notifier notifier, Object type)
   {
      return super.adapt(notifier, this);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object adapt(Object object, Object type)
   {
      if (isFactoryForType(type))
      {
         Object adapter = super.adapt(object, type);
         if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
         {
            return adapter;
         }
      }

      return null;
   }

   /**
    * This adds a listener.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void addListener(INotifyChangedListener notifyChangedListener)
   {
      changeNotifier.addListener(notifyChangedListener);
   }

   /**
    * This removes a listener.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void removeListener(INotifyChangedListener notifyChangedListener)
   {
      changeNotifier.removeListener(notifyChangedListener);
   }

   /**
    * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void fireNotifyChanged(Notification notification)
   {
      changeNotifier.fireNotifyChanged(notification);

      if (parentAdapterFactory != null)
      {
         parentAdapterFactory.fireNotifyChanged(notification);
      }
   }

   /**
    * This disposes all of the item providers created by this factory. 
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void dispose()
   {
      if (psCatalogItemProvider != null) psCatalogItemProvider.dispose();
      if (psPatternSpecificationItemProvider != null) psPatternSpecificationItemProvider.dispose();
      if (psLinkItemProvider != null) psLinkItemProvider.dispose();
      if (psPathItemProvider != null) psPathItemProvider.dispose();
      if (psCombinedFragmentItemProvider != null) psCombinedFragmentItemProvider.dispose();
      if (psSpecificationConstraintItemProvider != null) psSpecificationConstraintItemProvider.dispose();
      if (psObjectItemProvider != null) psObjectItemProvider.dispose();
      if (psAnnotationItemProvider != null) psAnnotationItemProvider.dispose();
      if (psFuzzyMetricConstraintItemProvider != null) psFuzzyMetricConstraintItemProvider.dispose();
      if (psFuzzySetRatingConstraintItemProvider != null) psFuzzySetRatingConstraintItemProvider.dispose();
      if (psAttributeConstraintItemProvider != null) psAttributeConstraintItemProvider.dispose();
      if (psMetricConstraintItemProvider != null) psMetricConstraintItemProvider.dispose();
      if (psFunctionParameterItemProvider != null) psFunctionParameterItemProvider.dispose();
   }

}
