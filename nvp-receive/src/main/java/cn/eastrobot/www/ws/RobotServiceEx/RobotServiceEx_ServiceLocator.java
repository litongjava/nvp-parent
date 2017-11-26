/**
 * RobotServiceEx_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.eastrobot.www.ws.RobotServiceEx;

public class RobotServiceEx_ServiceLocator extends org.apache.axis.client.Service
		implements RobotServiceEx_Service {

	public RobotServiceEx_ServiceLocator() {
	}

	public RobotServiceEx_ServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public RobotServiceEx_ServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for DefaultRobotServiceExPort
	// private java.lang.String DefaultRobotServiceExPort_address =
	// "http://bjyhzxyhr.demo.xiaoi.com/dev/ws/RobotServiceEx";
	//private String DefaultRobotServiceExPort_address = "http://111.202.106.148:8348/robot/ws/RobotServiceEx";
	private String DefaultRobotServiceExPort_address = "http://192.168.28.194:8000/robot/ws/RobotServiceEx";
	// private String DefaultRobotServiceExPort_address =
	// properties.getProperty("DefaultRobotServiceExPort_address");

	public String getDefaultRobotServiceExPortAddress() {
		return DefaultRobotServiceExPort_address;
	}

	// The WSDD service name defaults to the port name.
	private String DefaultRobotServiceExPortWSDDServiceName = "DefaultRobotServiceExPort";

	public String getDefaultRobotServiceExPortWSDDServiceName() {
		return DefaultRobotServiceExPortWSDDServiceName;
	}

	public void setDefaultRobotServiceExPortWSDDServiceName(String name) {
		DefaultRobotServiceExPortWSDDServiceName = name;
	}

	public RobotServiceEx_PortType getDefaultRobotServiceExPort()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(DefaultRobotServiceExPort_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getDefaultRobotServiceExPort(endpoint);
	}

	public RobotServiceEx_PortType getDefaultRobotServiceExPort(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			cn.eastrobot.www.ws.RobotServiceEx.RobotServiceExSoapBindingStub _stub = new cn.eastrobot.www.ws.RobotServiceEx.RobotServiceExSoapBindingStub(
					portAddress, this);
			_stub.setPortName(getDefaultRobotServiceExPortWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setDefaultRobotServiceExPortEndpointAddress(String address) {
		DefaultRobotServiceExPort_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	@Override
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (RobotServiceEx_PortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				cn.eastrobot.www.ws.RobotServiceEx.RobotServiceExSoapBindingStub _stub = new cn.eastrobot.www.ws.RobotServiceEx.RobotServiceExSoapBindingStub(
						new java.net.URL(DefaultRobotServiceExPort_address), this);
				_stub.setPortName(getDefaultRobotServiceExPortWSDDServiceName());
				return _stub;
			}
		} catch (Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	@Override
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		String inputPortName = portName.getLocalPart();
		if ("DefaultRobotServiceExPort".equals(inputPortName)) {
			return getDefaultRobotServiceExPort();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	@Override
	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx", "RobotServiceEx");
	}

	private java.util.HashSet ports = null;

	@Override
	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://www.eastrobot.cn/ws/RobotServiceEx",
					"DefaultRobotServiceExPort"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {

		if ("DefaultRobotServiceExPort".equals(portName)) {
			setDefaultRobotServiceExPortEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, String address)
			throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
