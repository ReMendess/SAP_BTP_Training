import com.sap.gateway.ip.core.customdev.util.Message
import javax.xml.parsers.*
import javax.xml.transform.*
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import org.xml.sax.InputSource

Message processData(Message message) {
    
    // Pega o conteúdo da mensagem
    def body = message.getBody(String)
    
    // Constrói o parser
    def factory = DocumentBuilderFactory.newInstance()
    def builder = factory.newDocumentBuilder()
    def doc = builder.parse(new InputSource(new StringReader(body)))

    // Exemplo: alterar o valor da tag <valor>
    def nodes = doc.getElementsByTagName("valor")
    if (nodes.length > 0) {
        def node = nodes.item(0)
        node.setTextContent("9999")  // Novo valor
    }

    // Converter de volta para String
    def transformer = TransformerFactory.newInstance().newTransformer()
    def writer = new StringWriter()
    transformer.transform(new DOMSource(doc), new StreamResult(writer))

    // Colocar o XML alterado no body da mensagem
    message.setBody(writer.toString())
    return message
}
