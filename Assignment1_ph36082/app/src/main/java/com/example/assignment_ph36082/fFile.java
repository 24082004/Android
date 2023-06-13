package com.example.assignment_ph36082;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class fFile {

    public static void ghiFile(Context context, String a, Object object){
        try {
            FileOutputStream out = context.openFileOutput(a, Context.MODE_APPEND);
            ObjectOutputStream output = new ObjectOutputStream(out);
            output.writeObject(object);
            out.close();
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Object docFile(Context context, String a){
        Object file = null;
        try {
            FileInputStream in = context.openFileInput(a);
            ObjectInputStream input = new ObjectInputStream(in);
            file = (ArrayList) input.readObject();
            input.close();
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return file;
    }


}
