package org.archimetrix.metricvaluesanalyzer;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.archimetrix.commons.ConfigConstants;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.handlers.HandlerUtil;


public class StartingHandler extends AbstractHandler
{

   @Override
   public Object execute(final ExecutionEvent event) throws ExecutionException
   {
      final ExecutionEvent execEvent = event;
      Job job = new Job("Metric Values Analyzer")
      {
         @Override
         protected IStatus run(final IProgressMonitor monitor)
         {
            startMetricValuesAnalysis(execEvent);
            return Status.OK_STATUS;
         }
      };

      job.schedule();

      return null;
   }


   private void startMetricValuesAnalysis(final ExecutionEvent event)
   {
      Properties properties = new Properties();
      try
      {
         InputStream stream = Activator.getDefault().getBundle().getEntry(ConfigConstants.CONFIG_PROPERTIES_FILE)
               .openStream();
         properties.load(stream);
         stream.close();

         final String input = properties.getProperty("metricvaluesanalyzer.input");
         final String output = properties.getProperty("metricvaluesanalyzer.output");

         int modus = Integer.parseInt(properties.getProperty("metricvaluesanalyzer.modus"));
         boolean append = Boolean.parseBoolean(properties.getProperty("metricvaluesanalyzer.append"));

         Activator.getDefault().log("Started Metric Values Analyzer!");
         Activator.getDefault().log("Result will be stored in " + output + ".");
         if (!append)
         {
            Activator.getDefault().log("Old content will be deleted.");
         }

         MetricValuesAnalyzer analyzer = new MetricValuesAnalyzer(append, modus, input, output);
         analyzer.printResult();

         Activator.getDefault().log("Finished!");
         Display.getDefault().asyncExec(new Runnable()
         {
            @Override
            public void run()
            {
               showFinishedMessage(event, output);
            }
         });
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }


   private void showFinishedMessage(final ExecutionEvent event, final String output)
   {
      MessageBox message = new MessageBox(HandlerUtil.getActiveShell(event));
      message.setText("Metric Values Writer Finished");
      message.setMessage("Wrote Metric Values in " + output);
      message.open();
   }


}
