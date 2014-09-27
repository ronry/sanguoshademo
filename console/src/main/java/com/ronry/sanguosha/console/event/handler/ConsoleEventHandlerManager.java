package com.ronry.sanguosha.console.event.handler;

import static com.google.common.collect.Maps.newHashMap;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import com.ronry.sanguosha.event.Event;
import com.ronry.sanguosha.event.handler.EventHandler;
import com.ronry.sanguosha.event.handler.EventHandlerManager;


public class ConsoleEventHandlerManager implements EventHandlerManager {

    private String                             searchPackage = "com.ronry.sanguosha.console.event.handler";

    @SuppressWarnings("rawtypes")
    private static Map<Class<?>, EventHandler> handlers = newHashMap();

    public ConsoleEventHandlerManager() throws Exception{
        List<Class<?>> allClass = getClasses(searchPackage);
        for (int i = 0; i < allClass.size(); i++) {
            if (EventHandler.class.isAssignableFrom(allClass.get(i))) {
                if (!EventHandler.class.equals(allClass.get(i))) {
                    Class<?> handlerClass=allClass.get(i);
                    ParameterizedType type = (ParameterizedType) handlerClass.getGenericInterfaces()[0];
                    handlers.put((Class<?>) type.getActualTypeArguments()[0],
                                 (EventHandler<?>) handlerClass.newInstance());
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    @Override
    public EventHandler<Event<?>> getHandler(Class<?> eventType) {
        return handlers.get(eventType);
    }

    public static List<Class<?>> getClasses(String packageName) throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");

        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {

        List<Class<?>> classes = new ArrayList<Class<?>>();
        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    public static void main(String[] args) throws Exception {
        new ConsoleEventHandlerManager();
    }


}
