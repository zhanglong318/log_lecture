package com.test.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonService;

public class ThriftDemoServer {

    public static void main(String[] args) throws Exception {

        TNonblockingServerSocket socket = new TNonblockingServerSocket(9999);
        THsHaServer.Args arg = new THsHaServer.Args(socket).workerThreads(4);
        PersonService.Processor processor = new PersonService.Processor(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server Started!");

        server.serve();
    }

}
