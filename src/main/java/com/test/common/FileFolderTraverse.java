package com.test.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件夹遍历
 * Created by liusven on 2016/11/13.
 */
public class FileFolderTraverse
{
    private static List<File> fileList = new ArrayList<>();
    private static List<File> folderList = new ArrayList<>();

    /**
     * 通过while循环遍历
     *
     * @param path 文件夹路径
     */
    public static void traverseByWhile(String path)
    {
        File file = new File(path);
        if (file.isFile())
        {
            System.out.println(file.getAbsolutePath());
            return;
        }
        if (!file.isDirectory())
        {
            return;
        }
        File[] fList = file.listFiles();
        if (null != fList && fList.length > 0)
        {
            List<File> fileList = new ArrayList<>();
            List<File> folderList = new ArrayList<>();
            setList(fList, fileList, folderList);
            if (folderList.size() > 0)
            {
                int index = 0;
                while (index < folderList.size())
                {
                    File f = folderList.get(index);
                    File[] subFileList = f.listFiles();
                    setList(subFileList, fileList, folderList);
                    ++index;
                }
            }
            System.out.println("total folder size:" + folderList.size());
            System.out.println("total file size:" + fileList.size());
        }
    }

    private static void setList(File[] fList, List<File> fileList, List<File> folderList)
    {
        for (File f : fList)
        {
            if (f.isFile())
            {
                System.out.println("add file:" + f.getAbsolutePath());
                fileList.add(f);
            }
            if (f.isDirectory())
            {
                System.out.println("add folder:" + f.getAbsolutePath());
                folderList.add(f);
            }
        }
    }

    /**
     * 递归遍历文件夹
     * @param path 文件夹路径
     */
    public static void traverseByRecursion(String path){
        File file = new File(path);
        if (file.isFile())
        {
            fileList.add(file);
            System.out.println(file.getAbsolutePath());
            return;
        }
        if (!file.isDirectory())
        {
            return;
        }
        folderList.add(file);
        File[] fList = file.listFiles();
        if (null != fList && fList.length > 0)
        {
            for (File f: fList)
            {
                traverseByRecursion(f.getAbsolutePath());
            }
        }
    }


    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
//        traverseByWhile("/Users/liusven/Desktop/GitWorkspace/zgk-webapp");
        traverseByRecursion("/Users/liusven/Desktop/GitWorkspace/zgk-webapp");
        System.out.println("total folder size:" + folderList.size());
        System.out.println("total file size:" + fileList.size());
        System.out.println(System.currentTimeMillis() - start);
    }
}
