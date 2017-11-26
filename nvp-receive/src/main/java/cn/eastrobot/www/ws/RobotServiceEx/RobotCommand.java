/**
 * RobotCommand.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.eastrobot.www.ws.RobotServiceEx;

public class RobotCommand  implements java.io.Serializable {
    private String[] args;

    private String name;

    private int state;

    public RobotCommand() {
    }

    public RobotCommand(
           String[] args,
           String name,
           int state) {
           this.args = args;
           this.name = name;
           this.state = state;
    }


    /**
     * Gets the args value for this RobotCommand.
     * 
     * @return args
     */
    public String[] getArgs() {
        return args;
    }


    /**
     * Sets the args value for this RobotCommand.
     * 
     * @param args
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getArgs(int i) {
        return this.args[i];
    }

    public void setArgs(int i, String _value) {
        this.args[i] = _value;
    }


    /**
     * Gets the name value for this RobotCommand.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name value for this RobotCommand.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Gets the state value for this RobotCommand.
     * 
     * @return state
     */
    public int getState() {
        return state;
    }


    /**
     * Sets the state value for this RobotCommand.
     * 
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    private Object __equalsCalc = null;
    @Override
	public synchronized boolean equals(Object obj) {
        if (!(obj instanceof RobotCommand)) return false;
        RobotCommand other = (RobotCommand) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.args==null && other.getArgs()==null) || 
             (this.args!=null &&
              java.util.Arrays.equals(this.args, other.getArgs()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.state == other.getState();
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
        if (getArgs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArgs());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getArgs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += getState();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RobotCommand.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "RobotCommand"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("args");
        elemField.setXmlName(new javax.xml.namespace.QName("", "args"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("", "state"));
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
