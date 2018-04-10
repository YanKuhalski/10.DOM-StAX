import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

public interface InfoBase {
    public Collection<Patient> getAllInfo() throws IOException, ParseException, XMLStreamException;
}
