package com.ICL;

import com.ICL.TRANSLITTER.TranslitService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Scanner;


public class ActivatorNameCyr implements BundleActivator {
    public void start(BundleContext bundleContext) throws Exception {
        TranslitService translitService = new TranslitService();
        String NNName = translitService.LastVersionOfName();
        System.out.println("Imya na latinice");
        System.out.println(NNName);

    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopped");
    }
}
