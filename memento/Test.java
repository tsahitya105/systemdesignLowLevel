package DESIGNPATTERNS.memento;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]){
        Document document = new Document("INITIAL COntent ");
        History history = new History();
        history.addMementos(document.createMemento());

        document.write("addition content1 ");
        history.addMementos(document.createMemento()); //add current snapshot

        document.write("addition content2 ");
        history.addMementos(document.createMemento()); //add current snapshot

        System.out.println(history.getMemento(0).getSavedContent());
        System.out.println(history.getMemento(1).getSavedContent());
        System.out.println(history.getMemento(2).getSavedContent());
    }
}


//memento to be stored history of
class DocumentMemento{
    String contentState;
    DocumentMemento(String contentState){
        this.contentState =contentState;
    }

    public String getSavedContent(){
        return contentState;
    }
}


class Document{
    private String doc;
    Document(String text){
        this.doc = text;
    }

    public String getDocContent(){
        return doc;
    }

    public void write(String text){
        this.doc+=text;
    }

    public DocumentMemento createMemento(){
        return new DocumentMemento(this.doc);
    }

}

class History{
    private List<DocumentMemento> documentMementoList;

    History(){
        this.documentMementoList = new ArrayList<>();
    }

    public void addMementos(DocumentMemento documentMemento){
        documentMementoList.add(documentMemento);
    }

    public DocumentMemento getMemento(int index){
        return this.documentMementoList.get(index);
    }
}



