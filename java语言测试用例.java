import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyApp {
    // 列出当前目录中的所有文件和子目录
    private static void listFiles(String[] args) {
        // 解析命令行参数
        List<String> argList = Arrays.asList(args);
        String path = ".";
        if (argList.contains("-path")) {
            int index = argList.indexOf("-path");
            if (index < argList.size() - 1) {
                path = argList.get(index + 1);
            }
        }

        // 列出当前目录下的所有文件和子目录
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Invalid directory: " + path);
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    // 计算文件大小
    private static void getFileSize(String[] args) {
        // 解析命令行参数
        List<String> argList = Arrays.asList(args);
        String path = ".";
        if (argList.contains("-path")) {
            int index = argList.indexOf("-path");
            if (index < argList.size() - 1) {
                path = argList.get(index + 1);
            }
        }

        // 获取文件大小
        File file = new File(path);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Invalid file: " + path);
            return;
        }
        long size = file.length();
        if (size < 1024) {
            // 文件大小小于1KB
            System.out.printf("%d bytes\n", size);
        } else if (size < 1048576) {
            // 文件大小小于1MB
            System.out.printf("%.2f KB\n", size / 1024.0);
        } else if (size < 1073741824) {
            // 文件大小小于1GB
            System.out.printf("%.2f MB\n", size / 1048576.0);
        } else {
            // 文件大小大于等于1GB
            System.out.printf("%.2f GB\n", size / 1073741824.0);
        }
    }

    // 查找文件
    private static void findFiles(String[] args) {
        // 解析命令行参数
        List<String> argList = Arrays.asList(args);
        String pattern = "*";
        String path = ".";
        if (argList.contains("-pattern")) {
            int index = argList.indexOf("-pattern");
            if (index < argList.size() - 1) {
                pattern = argList.get(index + 1);
            }
        }
        if (argList.contains("-path")) {
            int index = argList.indexOf("-path");
            if (index < argList.size() - 1) {
                path = argList.get(index + 1);
            }
        }

        // 查找文件
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("Invalid directory: " + path);
            return;
        }
        File
