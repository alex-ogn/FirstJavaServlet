package bg.tu_varna.sit.f21621588.utilites;
import bg.tu_varna.sit.f21621588.domain.Task;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


public class XmlWorker<T> {
    public void writeXML(T object, Writer writer) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(object, writer);
    }

    public Task readerXML(String xmlFile) throws JAXBException, SAXException {
        JAXBContext context = JAXBContext.newInstance(Task.class);
        Unmarshaller um = context.createUnmarshaller();

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource((new Validator()).getFile("xsd/task.xsd"));
        Schema schema = factory.newSchema(schemaFile);
        um.setSchema(schema);

        Task group = (Task) um.unmarshal(new StringReader(xmlFile));
        return group;
    }
}