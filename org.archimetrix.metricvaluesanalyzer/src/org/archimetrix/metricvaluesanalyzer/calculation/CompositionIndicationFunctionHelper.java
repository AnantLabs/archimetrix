package org.archimetrix.metricvaluesanalyzer.calculation;


import org.somox.configuration.SoMoXConfiguration;


public class CompositionIndicationFunctionHelper
{

   private final SoMoXConfiguration somoxConfig;

   private double DMSWeight, packageMappingWeight, directoryMappingWeight, interfaceAdherenceWeight,
         subsystemComponentWeight;


   public CompositionIndicationFunctionHelper(final SoMoXConfiguration somoxConfiguration)
   {
      super();

      this.somoxConfig = somoxConfiguration;
      getWeightsFromConfiguration();
   }


   public double computeOverallDirectedMetricValue(final double nameResemblanceStrategy, final double interfaceAdherenceStrategy,
         final double subsystemComponentStrategy, final double hierarchyMappingStrategy, final double dmsStrategy)
   {
      double sum = getMaxNameResemblanceWeigth() + interfaceAdherenceWeight + subsystemComponentWeight
            + packageMappingWeight + DMSWeight + directoryMappingWeight;

      double score = nameResemblanceStrategy + interfaceAdherenceStrategy + subsystemComponentStrategy
            + hierarchyMappingStrategy - dmsStrategy;

      score = score / sum;

      return score;
   }


   private double getMaxNameResemblanceWeigth()
   {
      double result = Math.max(somoxConfig.getWeightLowCoupling(), somoxConfig.getWeightHighCoupling());
      result = Math.max(result, somoxConfig.getWeightLowNameResemblance());
      result = Math.max(result, somoxConfig.getWeightMidNameResemblance());
      result = Math.max(result, somoxConfig.getWeightHighNameResemblance());
      result = Math.max(result, somoxConfig.getWeightHighestNameResemblance());

      return result;
   }


   private double getNameResemblance(final double nameResemblance, final double coupling)
   {

      // determine nameResemblance
      if (coupling >= 0 && coupling < 0.2)
      {
         return somoxConfig.getWeightLowNameResemblance() * nameResemblance;
      }
      else if (coupling >= 0.2 && coupling < 0.7)
      {
         return somoxConfig.getWeightMidNameResemblance() * nameResemblance;
      }
      else if (coupling >= 0.7 && coupling < 0.9)
      {
         return somoxConfig.getWeightHighNameResemblance() * nameResemblance;
      }
      else
      {
         return somoxConfig.getWeightHighestNameResemblance() * nameResemblance;
      }
   }


   private double getInterfaceAdherenceWeight(final double coupling, final double interfaceAdherence)
   {
      if (coupling >= 0.3)
      {
         if (interfaceAdherence > 0.0)
         {
            interfaceAdherenceWeight = somoxConfig.getWeightInterfaceViolationRelevant();
         }
         else
         {
            interfaceAdherenceWeight = -1 * somoxConfig.getWeightInterfaceViolationIrrelevant();
         }
      }
      else
      {
         interfaceAdherenceWeight = 0.0;
      }
      return interfaceAdherenceWeight;
   }


   private double getSubsystemComponentWeight(final double slaq)
   {
      if (slaq >= 0.5)
      {
         subsystemComponentWeight = somoxConfig.getWeightHighSLAQ();
      }
      else
      {
         subsystemComponentWeight = somoxConfig.getWeightLowSLAQ();
      }
      return subsystemComponentWeight;
   }


   public double getNameResemblanceStrategy(final double nameResemblance, final double coupling)
   {
      return getNameResemblance(nameResemblance, coupling);
   }


   public double getInterfaceAdherenceStrategy(final double interfaceAdherence, final double coupling)
   {
      return interfaceAdherence * getInterfaceAdherenceWeight(coupling, interfaceAdherence);
   }


   public double getSubsystemComponentStrategy(final double subsystemComponent, final double slaq)
   {
      return subsystemComponent * getSubsystemComponentWeight(slaq);
   }


   public double getHierarchyMappingStrategy(final double packageMapping, final double directoryMapping)
   {
      return packageMapping * packageMappingWeight + directoryMapping * directoryMappingWeight;
   }


   private void getWeightsFromConfiguration()
   {
      packageMappingWeight = somoxConfig.getWeightPackageMapping();
      directoryMappingWeight = somoxConfig.getWeightDirectoryMapping();
      DMSWeight = somoxConfig.getWeightDMS();
   }


   public double getDmsStrategy(final double dms)
   {
      return dms * DMSWeight;
   }
}
