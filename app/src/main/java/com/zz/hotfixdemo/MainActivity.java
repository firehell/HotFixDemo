package com.zz.hotfixdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class MainActivity extends AppCompatActivity {
    TextView titleTv;
    Button showTitleBt;
    Button hotfixBt;
    Button removeHotfixBt;
    Button killSelfBt;

//    File apk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTv = findViewById(R.id.titleTv);
        showTitleBt = findViewById(R.id.showTitleBt);
        hotfixBt = findViewById(R.id.hotfixBt);
        removeHotfixBt = findViewById(R.id.removeHotfixBt);
        killSelfBt = findViewById(R.id.killSelfBt);


//        apk = new File(getCacheDir() + "/hotfix.dex");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (v.getId()) {
          /*case R.id.loadPluginBt:
            File apk = new File(getCacheDir() + "/plugin.apk");
            if (!apk.exists()) {
              try (Source source = Okio.source(getAssets().open("apk/plugin.apk"));
                   BufferedSink sink = Okio.buffer(Okio.sink(apk))) {
                sink.writeAll(source);
              } catch (IOException e) {
                e.printStackTrace();
              }
            }
            if (apk.exists()) {
              try {
                DexClassLoader classLoader = new DexClassLoader(apk.getPath(), getCacheDir().getPath(), null, null);
                Class pluginUtilsClass = classLoader.loadClass("com.hencoder.plugin.Utils");
                Constructor utilsConstructor = pluginUtilsClass.getDeclaredConstructors()[0];
                Object utils = utilsConstructor.newInstance();
                Method shoutMethod = pluginUtilsClass.getDeclaredMethod("shout");
                shoutMethod.invoke(utils);
              } catch (ClassNotFoundException e) {
                e.printStackTrace();
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              } catch (InstantiationException e) {
                e.printStackTrace();
              } catch (InvocationTargetException e) {
                e.printStackTrace();
              } catch (NoSuchMethodException e) {
                e.printStackTrace();
              }
            }
            break;*/
                    case R.id.showTitleBt:
                        Title title = new Title();
                        titleTv.setText(title.getTitle());
                        break;
                    case R.id.hotfixBt:
                        File apk = new File(getCacheDir() + "/hotfix.dex");
                        if (!apk.exists()) {
                            try(Source source = Okio.source(getAssets().open("apk/hotfix.dex"));
                                BufferedSink sink = Okio.buffer(Okio.sink(apk))) {
                                sink.writeAll(source);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
//                        if (apk.exists()) {
//                            try {
//                                ClassLoader originalLoader = getClassLoader();
//                                DexClassLoader classLoader = new DexClassLoader(apk.getPath(), getCacheDir().getPath(), null, null);
//                                Class loaderClass = BaseDexClassLoader.class;
//                                Field pathListField = loaderClass.getDeclaredField("pathList");
//                                pathListField.setAccessible(true);
//                                Object pathListObject = pathListField.get(classLoader);
//
//                                Class pathListClass = pathListObject.getClass();
//                                Field dexElementsField = pathListClass.getDeclaredField("dexElements");
//                                dexElementsField.setAccessible(true);
//                                Object dexElementsObject = dexElementsField.get(pathListObject);
//
//                                Object originalPathListObject = pathListField.get(originalLoader);
//                                dexElementsField.set(originalPathListObject, dexElementsObject);
//
//                            } catch (NoSuchFieldException | IllegalAccessException e) {
//                                e.printStackTrace();
//                            }
//                        }

                        break;
                    case R.id.removeHotfixBt:
//                        if (apk.exists()) {
//                            apk.delete();
//                        }
                        break;
                    case R.id.killSelfBt:
                        android.os.Process.killProcess(android.os.Process.myPid());
                        break;
                    default:
                        break;
                }
            }
        };

        showTitleBt.setOnClickListener(onClickListener);
        hotfixBt.setOnClickListener(onClickListener);
        removeHotfixBt.setOnClickListener(onClickListener);
        killSelfBt.setOnClickListener(onClickListener);
    }
}