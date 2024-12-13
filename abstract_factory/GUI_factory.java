package abstract_factory;
public interface GUI_factory{ 
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsGUIfactory implements GUI_factory{
    public Button createButton(){
        return new WinButton();
    }

    public Checkbox createCheckbox(){
        return new WinCheckbox();
    }
}


class MacGUIfactory implements GUI_factory{
    public Button createButton(){
        return new MacButton();
    }
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }  
}

interface Button {
    void click();
}
interface Checkbox{
    void showCheckbox();
}

class MacButton implements Button{
    public void click(){
        System.out.println("mac button has been clicked");
    }
}

class WinButton implements Button {
    public void click (){
        System.out.println("win button has been clicked");
    }
}

class MacCheckbox implements Checkbox{
    public void showCheckbox(){
        System.out.println("Mac checkbox has been created");
    }
}


class WinCheckbox implements Checkbox{
    public void showCheckbox(){
        System.out.println("Win checkbox has been created");
    }
}


class Main{
    public static void main(String [] args){
        GUI_factory factory = new WindowsGUIfactory();
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        button.click();
        checkbox.showCheckbox();
    }
}