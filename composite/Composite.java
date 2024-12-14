// the composte design pattern is used when you need to represent a group of objects as a single entity .it particularly useful whn dealing with hierarchical structures 
// such as trees ,where individula structures such as trees,where individual objects and their compositions are treated uniformly

//component: defines the common interface for all objects and their compositions 
//leaf: represents each individual objects composion.Implements the component interface

package composite;

import java.util.ArrayList;
import java.util.List;

public interface Composite {

    void showdetails();
}

class File implements Composite {
    String filename;
    String contents;

    File(String filename,String contents){
        this.filename=filename;
        this.contents=contents;
    }

    File(String filename){
        this.filename=filename;
        this.contents="";
    }

    public void showdetails(){
        System.out.println("File name : "+this.filename);
        System.out.println("Contents :"+contents);
    }
}

class Directory implements Composite {
    String dirName;
    List<Composite>child;
    Directory(String dirName){
        this.dirName=dirName;
        child=new ArrayList<>();
    }

    public void showdetails(){
        System.out.println("Dirname : "+this.dirName);
        for (Composite c : child) {
            c.showdetails();
        }
    }

    public void addChild(Composite composite){
        child.add(composite);
    }

    public void removeChild(Composite composite){
        child.remove(composite);
    }


}

class Main{
    public static void main(String[] args) {
        File fileOne=new File("fileOne.txt","this is a file obj");
        File fileTwo=new File("AnotherFile.txt","This is another file");

        Directory dir=new Directory("myDir");
        dir.addChild(fileOne);
        dir.addChild(fileTwo);
        fileOne.showdetails();
        fileTwo.showdetails();
        dir.showdetails();
    }
}