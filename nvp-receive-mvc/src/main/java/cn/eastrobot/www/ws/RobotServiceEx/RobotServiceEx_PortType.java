/**
 * RobotServiceEx_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.eastrobot.www.ws.RobotServiceEx;

public interface RobotServiceEx_PortType extends java.rmi.Remote {
    public RobotResponse openSession(RobotRequest robotRequest) throws java.rmi.RemoteException;
    public RobotResponse closeSession(RobotRequest robotRequest) throws java.rmi.RemoteException;
    public RobotResponse deliver(RobotRequest robotRequest) throws java.rmi.RemoteException;
}
