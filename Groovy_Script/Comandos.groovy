import com.sap.gateway.ip.core.customdev.util.Message
def Message processData(Message message) {
    // código aqui
    return message
}

// Alterar o body da mensagem
import com.sap.gateway.ip.core.customdev.util.Message
def Message processData(Message message) {
    def body = message.getBody(String)   // pega body como String
    body = body.toUpperCase()            // transforma em maiúsculo
    message.setBody(body)                // retorna novo body
    return message
}

// Manipular Headers
import com.sap.gateway.ip.core.customdev.util.Message
def Message processData(Message message) {
    def headers = message.getHeaders()
    headers.put("NewHeader", "ABC123")  // adiciona header
    message.setHeaders(headers)
    return message
}

// Manipular XML

import com.sap.gateway.ip.core.customdev.util.Message
import groovy.xml.*
def Message processData(Message message) {
    def body = message.getBody(String)
    
    def xml = new XmlSlurper().parseText(body)
    
    // Exemplo: ler um nó XML
    def customer = xml.Customer.Name.text()
    
    // Alterar valor
    xml.Customer.Name.replaceBody("Renan Mendes")
    
    // Converter de volta para String
    def output = XmlUtil.serialize(xml)
    message.setBody(output)
    
    return message
}

// Manipular JSON

import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.*
def Message processData(Message message) {
    def body = message.getBody(String)
def jsonSlurper = new JsonSlurper()
    def jsonObj = jsonSlurper.parseText(body)
// Exemplo: acessar campo
    def name = jsonObj.customer.name
// Alterar valor
    jsonObj.customer.name = "Renan Mendes"
// Converter de volta para JSON
    def jsonOutput = JsonOutput.toJson(jsonObj)
    message.setBody(jsonOutput)
return message
}
