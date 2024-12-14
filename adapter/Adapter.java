package adapter;

interface JSONData{
    String getJson();
}

class XMLDataProvider{
    public String getXMLData() {
        return "<data><item>Value1</item><item>Value2</item></data>";
    }
}
public class Adapter implements JSONData{
    private XMLDataProvider xmlDataProvider;

    public Adapter(XMLDataProvider xmlDataProvider){
        this.xmlDataProvider=xmlDataProvider;
    }

    public String getJson(){
        String xml = xmlDataProvider.getXMLData();
        String json = xml.replace("<data>", "{ \"data\": [")
                         .replace("</data>", "] }")
                         .replace("<item>", "\"")
                         .replace("</item>", "\",");
        return json.substring(0, json.length() - 1); // Removing last comma

    }



}
class Main{
    public static void main(String[] args) {
        XMLDataProvider xmlDataProvider=new XMLDataProvider();
        Adapter adapter=new Adapter(xmlDataProvider);
        System.out.println(adapter.getJson());
    }
}