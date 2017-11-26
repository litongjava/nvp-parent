/**
 * RobotResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.eastrobot.www.ws.RobotServiceEx;

public class RobotResponse  implements java.io.Serializable {
    private RobotCommand[] commands;

    private String content;

    private String moduleId;

    private String nodeId;

    private String[] relatedQuestions;

    private float similarity;

    private String[] tags;

    private int type;

    public RobotResponse() {
    }

    public RobotResponse(
           RobotCommand[] commands,
           String content,
           String moduleId,
           String nodeId,
           String[] relatedQuestions,
           float similarity,
           String[] tags,
           int type) {
           this.commands = commands;
           this.content = content;
           this.moduleId = moduleId;
           this.nodeId = nodeId;
           this.relatedQuestions = relatedQuestions;
           this.similarity = similarity;
           this.tags = tags;
           this.type = type;
    }


    /**
     * Gets the commands value for this RobotResponse.
     * 
     * @return commands
     */
    public RobotCommand[] getCommands() {
        return commands;
    }


    /**
     * Sets the commands value for this RobotResponse.
     * 
     * @param commands
     */
    public void setCommands(RobotCommand[] commands) {
        this.commands = commands;
    }

    public RobotCommand getCommands(int i) {
        return this.commands[i];
    }

    public void setCommands(int i, RobotCommand _value) {
        this.commands[i] = _value;
    }


    /**
     * Gets the content value for this RobotResponse.
     * 
     * @return content
     */
    public String getContent() {
        return content;
    }


    /**
     * Sets the content value for this RobotResponse.
     * 
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }


    /**
     * Gets the moduleId value for this RobotResponse.
     * 
     * @return moduleId
     */
    public String getModuleId() {
        return moduleId;
    }


    /**
     * Sets the moduleId value for this RobotResponse.
     * 
     * @param moduleId
     */
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }


    /**
     * Gets the nodeId value for this RobotResponse.
     * 
     * @return nodeId
     */
    public String getNodeId() {
        return nodeId;
    }


    /**
     * Sets the nodeId value for this RobotResponse.
     * 
     * @param nodeId
     */
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }


    /**
     * Gets the relatedQuestions value for this RobotResponse.
     * 
     * @return relatedQuestions
     */
    public String[] getRelatedQuestions() {
        return relatedQuestions;
    }


    /**
     * Sets the relatedQuestions value for this RobotResponse.
     * 
     * @param relatedQuestions
     */
    public void setRelatedQuestions(String[] relatedQuestions) {
        this.relatedQuestions = relatedQuestions;
    }

    public String getRelatedQuestions(int i) {
        return this.relatedQuestions[i];
    }

    public void setRelatedQuestions(int i, String _value) {
        this.relatedQuestions[i] = _value;
    }


    /**
     * Gets the similarity value for this RobotResponse.
     * 
     * @return similarity
     */
    public float getSimilarity() {
        return similarity;
    }


    /**
     * Sets the similarity value for this RobotResponse.
     * 
     * @param similarity
     */
    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }


    /**
     * Gets the tags value for this RobotResponse.
     * 
     * @return tags
     */
    public String[] getTags() {
        return tags;
    }


    /**
     * Sets the tags value for this RobotResponse.
     * 
     * @param tags
     */
    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTags(int i) {
        return this.tags[i];
    }

    public void setTags(int i, String _value) {
        this.tags[i] = _value;
    }


    /**
     * Gets the type value for this RobotResponse.
     * 
     * @return type
     */
    public int getType() {
        return type;
    }


    /**
     * Sets the type value for this RobotResponse.
     * 
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    private Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(Object obj) {
        if (!(obj instanceof RobotResponse)) return false;
        RobotResponse other = (RobotResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.commands==null && other.getCommands()==null) || 
             (this.commands!=null &&
              java.util.Arrays.equals(this.commands, other.getCommands()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.moduleId==null && other.getModuleId()==null) || 
             (this.moduleId!=null &&
              this.moduleId.equals(other.getModuleId()))) &&
            ((this.nodeId==null && other.getNodeId()==null) || 
             (this.nodeId!=null &&
              this.nodeId.equals(other.getNodeId()))) &&
            ((this.relatedQuestions==null && other.getRelatedQuestions()==null) || 
             (this.relatedQuestions!=null &&
              java.util.Arrays.equals(this.relatedQuestions, other.getRelatedQuestions()))) &&
            this.similarity == other.getSimilarity() &&
            ((this.tags==null && other.getTags()==null) || 
             (this.tags!=null &&
              java.util.Arrays.equals(this.tags, other.getTags()))) &&
            this.type == other.getType();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    @Override
	public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCommands() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommands());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getCommands(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getModuleId() != null) {
            _hashCode += getModuleId().hashCode();
        }
        if (getNodeId() != null) {
            _hashCode += getNodeId().hashCode();
        }
        if (getRelatedQuestions() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRelatedQuestions());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getRelatedQuestions(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Float(getSimilarity()).hashCode();
        if (getTags() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTags());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getTags(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getType();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RobotResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "RobotResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commands");
        elemField.setXmlName(new javax.xml.namespace.QName("", "commands"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "RobotCommand"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodeId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nodeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedQuestions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "relatedQuestions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("similarity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "similarity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tags");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tags"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
