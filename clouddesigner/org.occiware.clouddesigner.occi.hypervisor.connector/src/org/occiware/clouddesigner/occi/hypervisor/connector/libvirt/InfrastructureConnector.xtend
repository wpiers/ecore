/*******************************************************************************
 * Copyright (c) 2015 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	- Fawaz PARAISO 
 * 	- Philippe MERELE
 *******************************************************************************/
package org.occiware.clouddesigner.occi.hypervisor.connector.libvirt

import org.libvirt.Connect
import org.libvirt.Domain
import org.occiware.clouddesigner.occi.hypervisor.HypervisorPackage
import org.occiware.clouddesigner.occi.hypervisor.Machine
import org.occiware.clouddesigner.occi.hypervisor.Machine_VirtualBox
import org.occiware.clouddesigner.occi.hypervisor.impl.HypervisorFactoryImpl
import org.occiware.clouddesigner.occi.hypervisor.impl.MachineImpl
import org.occiware.clouddesigner.occi.hypervisor.impl.Machine_VirtualBoxImpl
import org.occiware.clouddesigner.occi.infrastructure.Compute
import org.occiware.clouddesigner.occi.infrastructure.ComputeStatus
import org.occiware.clouddesigner.occi.infrastructure.RestartMethod
import org.occiware.clouddesigner.occi.infrastructure.StopMethod
import org.occiware.clouddesigner.occi.infrastructure.SuspendMethod
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.occiware.clouddesigner.occi.hypervisor.connector.libvirt.util.DomainMarshaller

/**
 * This class overrides the generated EMF factory of the  package.
 * 
 * This factory creates instances of classes starting with Executable prefix
 * instead of instances of generated EMF classes suffixed by Impl.
 */
class ExecutableHypervisorFactory extends HypervisorFactoryImpl {
	private static Logger LOGGER = LoggerFactory.getLogger(typeof(ExecutableHypervisorFactory))

	/**
	 * Initialize the ExecutableFactory singleton.
	 */
	def static init() {

		// Replace the default generated factory of the  package by an executable  factory.
		val factory = new ExecutableHypervisorFactory
		HypervisorPackage.eINSTANCE.setEFactoryInstance(factory)
		return factory
	}

	/**
	 * Create an executable Machine instance.
	 */
	override def Machine createMachine() {
		println(this.class.name + ":createCompute()")
		return new ExecutableMachine
	}

	/**
	 * Create an executable Machine_VirtualBox instance.
	 */
	override def Machine_VirtualBox createMachine_VirtualBox() {
		println(this.class.name + ":createCompute()")
		return new ExecutableMachine_VirtualBox
	}

}

/**
 * This class implements the state machine of any Compute resource.
 */
class ComputeStateMachine<T extends Compute> {

	/**
	 * Reference to the Compute resource.
	 */
	protected T compute

	/**
	 * Construct a compute state machine for a given Compute resource.
	 */
	new(T c) {
		compute = c
	}

	/**
	 * Start OCCI Action.
	 */
	def start() {
		println(this.class.name + ":start() - current state is " + compute.state)
		if (compute.state == ComputeStatus.INACTIVE) {
			println(this.class.name + ":start() - move from inactive to active state")
			start_from_inactive_state()
			compute.state = ComputeStatus.ACTIVE
		} else if (compute.state == ComputeStatus.ACTIVE) {
			println(this.class.name + ":start() - already active state")
			start_from_active_state()
		} else if (compute.state == ComputeStatus.SUSPENDED) {
			println(this.class.name + ":start() - move from suspended to active state")
			start_from_suspended_state()
			compute.state = ComputeStatus.ACTIVE
		} else {
			throw new RuntimeException("Must never happen!")
		}
		println(this.class.name + ":start() - final state is " + compute.state)
		if(compute.state != ComputeStatus.ACTIVE) throw new RuntimeException("Must never happen!")
	}

	/**
	 * This method implements the transition from inactive state for the start action.
	 * 
	 * By default, this method calls the start_execute method.
	 */
	def start_from_inactive_state() {
		start_execute
	}

	/**
	 * This method implements the transition from active state for the start action.
	 * 
	 * By default, this method does nothing.
	 */
	def start_from_active_state() {
		println(this.class.name + ":start_from_active_state() - DO NOTHING")
	}

	/**
	 * This method implements the transition from suspended state for the start action.
	 * 
	 * By default, this method calls the start_execute method.
	 */
	def start_from_suspended_state() {
		start_execute
	}

	/**
	 * This method is the default implementation of the start action.
	 */
	def void start_execute() {
		println(this.class.name + ":start_execute() - DO NOTHING")
	}

	/**
	 * Stop OCCI Action.
	 */
	def stop(StopMethod method) {
		println(this.class.name + ":stop(" + method + ") - current state is " + compute.state)
		if (compute.state == ComputeStatus.INACTIVE) {
			println(this.class.name + ":stop() - already inactive state")
			stop_from_inactive_state(method)
		} else if (compute.state == ComputeStatus.ACTIVE) {
			println(this.class.name + ":stop() - move from active to inactive state")
			stop_from_active_state(method)
			compute.state = ComputeStatus.INACTIVE
		} else if (compute.state == ComputeStatus.SUSPENDED) {
			println(this.class.name + ":stop() - move from suspended to inactive state")
			stop_from_suspended_state(method)
			compute.state = ComputeStatus.INACTIVE
		} else {
			throw new RuntimeException("Must never happen!")
		}
		println(this.class.name + ":stop() - final state is " + compute.state)
		if(compute.state != ComputeStatus.INACTIVE) throw new RuntimeException("Must never happen!")
	}

	/**
	 * This method implements the transition from inactive state for the stop action.
	 * 
	 * By default, this method does nothing.
	 */
	def stop_from_inactive_state(StopMethod method) {
		println(this.class.name + ":stop_from_inactive_state() - DO NOTHING")
	}

	/**
	 * This method implements the transition from active state for the stop action.
	 * 
	 * By default, this method calls the stop_execute method.
	 */
	def stop_from_active_state(StopMethod method) {
		stop_execute(method)
	}

	/**
	 * This method implements the transition from suspended state for the stop action.
	 * 
	 * By default, this method calls the stop_execute method.
	 */
	def stop_from_suspended_state(StopMethod method) {
		stop_execute(method)
	}

	/**
	 * This method is the default implementation of the stop action.
	 */
	def void stop_execute(StopMethod method) {
		println(this.class.name + ":stop_execute(" + method + ") - DO NOTHING")
	}

	/**
	 * Restart OCCI Action.
	 */
	def restart(RestartMethod method) {
		println(this.class.name + ":restart(" + method + ") - current state is " + compute.state)
		if (compute.state == ComputeStatus.INACTIVE) {
			println(this.class.name + ":restart(" + method + ')' + " - move from inactive to active state")
			restart_from_inactive_state(method)
			compute.state = ComputeStatus.ACTIVE
		} else if (compute.state == ComputeStatus.ACTIVE) {
			println(this.class.name + ":restart(" + method + ')' + " - move from active to active state")
			restart_from_active_state(method)
			compute.state = ComputeStatus.ACTIVE
		} else if (compute.state == ComputeStatus.SUSPENDED) {
			println(this.class.name + ":stop() - move from suspended to active state")
			restart_from_suspended_state(method)
			compute.state = ComputeStatus.ACTIVE
		} else {
			throw new RuntimeException("Must never happen!")
		}
		println(this.class.name + ":restart(" + method + ')' + " - final state is " + compute.state)
		if(compute.state != ComputeStatus.ACTIVE) throw new RuntimeException("Must never happen!")
	}

	/**
	 * This method implements the transition from inactive state for the restart action.
	 * 
	 * By default, this method calls the restart_execute method.
	 */
	def restart_from_inactive_state(RestartMethod method) {
		restart_execute(method)
	}

	/**
	 * This method implements the transition from active state for the restart action.
	 * 
	 * By default, this method calls the restart_execute method.
	 */
	def restart_from_active_state(RestartMethod method) {
		restart_execute(method)
	}

	/**
	 * This method implements the transition from suspended state for the restart action.
	 * 
	 * By default, this method calls the restart_execute method.
	 */
	def restart_from_suspended_state(RestartMethod method) {
		restart_execute(method)
	}

	/**
	 * This method is the default implementation of the restart action.
	 */
	def void restart_execute(RestartMethod method) {
		println(this.class.name + ":restart_execute(" + method + ") - DO NOTHING")
	}

	/**
	 * Suspend OCCI Action.
	 */
	def suspend(SuspendMethod method) {
		println(this.class.name + ":suspend(" + method + ") - current state is " + compute.state)
		if (compute.state == ComputeStatus.INACTIVE) {
			println(this.class.name + ":suspend() - move from inactive to suspended state")
			suspend_from_inactive_state(method)
			compute.state = ComputeStatus.SUSPENDED
		} else if (compute.state == ComputeStatus.ACTIVE) {
			println(this.class.name + ":suspend() - move from active to suspended state")
			suspend_from_active_state(method)
			compute.state = ComputeStatus.SUSPENDED
		} else if (compute.state == ComputeStatus.SUSPENDED) {
			println(this.class.name + ":suspend() - already suspended state")
			suspend_from_suspended_state(method)
		} else {
			throw new RuntimeException("Must never happen!")
		}
		println(this.class.name + ":suspend() - final state is " + compute.state)
		if(compute.state != ComputeStatus.SUSPENDED) throw new RuntimeException("Must never happen!")
	}

	/**
	 * This method implements the transition from inactive state for the suspend action.
	 * 
	 * By default, this method calls the suspend_execute method.
	 */
	def suspend_from_inactive_state(SuspendMethod method) {
		suspend_execute(method)
	}

	/**
	 * This method implements the transition from active state for the suspend action.
	 * 
	 * By default, this method calls the suspend_execute method.
	 */
	def suspend_from_active_state(SuspendMethod method) {
		suspend_execute(method)
	}

	/**
	 * This method implements the transition from suspended state for the suspend action.
	 * 
	 * By default, this method does nothing.
	 */
	def suspend_from_suspended_state(SuspendMethod method) {
		println(this.class.name + ":suspend_from_suspended_state() - DO NOTHING")
	}

	/**
	 * This method is the default implementation of the suspend action.
	 */
	def void suspend_execute(SuspendMethod method) {
		println(this.class.name + ":suspend_execute(" + method + ") - DO NOTHING")
	}
}

/**
 * This class implements an abstract Libvirt node manager.
 */
abstract class LibvirtManager extends ComputeStateMachine<Machine> {
	private static Logger LOGGER = LoggerFactory.getLogger(typeof(LibvirtManager))

	/**
	 * Construct a  machine manager for a given  machine.
	 */
	new(Machine m) {
		super(m)
	}

	/**
	 * Return the  machine driver name.
	 */
	def abstract String getDriver()

	/**
	 * Append specific libvirt hypervisor driver parameters.
	 */
	def abstract void appendHypervisorParameters(String sb)

	/**
	 * Start Libvirt node.
	 */
	override def start_execute() {

		// Execute the -machine start command.
		val domainMarshaller = new DomainMarshaller
		domainMarshaller.loadUri
		var Connect connection = null;
		val String libvirtURI = domainMarshaller.uri.get(getDriver)
		if (libvirtURI != null) {
			LOGGER.info("Hypervisor URI is: {}", libvirtURI)
			try {

				// initialize connection to vm
				connection = new Connect(libvirtURI);

				// Create virtual machine XMl
				val vmDomain = domainMarshaller.createComputeDescription(this.compute)
				var String domainDescription = domainMarshaller.asString(vmDomain.getUuid)
				LOGGER.info("Domain description: " + domainDescription)

				// create vm domain for libvirt
				val Domain domain = connection.domainDefineXML(domainDescription)
				LOGGER.debug("VM with id {} is created.", domain.UUIDString)

				domain.create()
				LOGGER.info("VM with id {} is running.", this.compute.id)

				// save hypervisor for stop, suspend and resume
				// methods
				//				ComputeLocation location = new ComputeLocation(libvirtURI, this.compute);
				LOGGER.debug("closing connection to libvirt")
				connection.close()
			} catch (Exception e) {
				LOGGER.error("Error while processing. ", e)
				this.compute.state = ComputeStatus.INACTIVE
			}
		}
	}

	/**
	 * Stop a libvirt node.
	 */
	override def stop_execute(StopMethod method) {

		// Stop libvirt node.
		if (method == StopMethod.GRACEFUL) {
		}

		// Execute the -machine stop command.
		println("EXECUTE COMMAND:  machine stop " + compute.hostname);

	// TODO: must be implemented
	}

	/**
	 * Restart a libvirt node.
	 */
	override def restart_execute(RestartMethod method) {
		println("EXECUTE COMMAND:  machine restart " + compute.hostname);

	// TODO: must be implemented
	}

	/**
	 * Suspend a libvirt node.
	 */
	override def suspend_execute(SuspendMethod method) {
		println("EXECUTE COMMAND:  machine suspend " + compute.hostname);

	// TODO: must be implemented
	}
}

/**
 * This class implements an abstract JClouds node manager.
 */
abstract class JCloudsManager extends ComputeStateMachine<Compute> {

	/**
	 * Construct a  machine manager for a given  machine.
	 */
	new(Compute m) {
		super(m)
	}

	/**
	 * Return the JClouds machine driver name.
	 */
	def abstract String getDriverName()

	/**
	 * Append specific JClouds machine driver parameters.
	 */
	def abstract void appendDriverParameters(StringBuilder sb)

	/**
	 * Start JClouds node.
	 */
	override def start_execute() {
		// Execute the -machine start command.
	}

	/**
	 * Stop a JClouds node.
	 */
	override def stop_execute(StopMethod method) {

		// Stop libvirt node.
		if (method == StopMethod.GRACEFUL) {
		}

		// Execute the -machine stop command.
		println("EXECUTE COMMAND:  machine stop " + compute.hostname);

	// TODO: must be implemented
	}

	/**
	 * Restart a JClouds node.
	 */
	override def restart_execute(RestartMethod method) {
		println("EXECUTE COMMAND:  machine restart " + compute.hostname);

	// TODO: must be implemented
	}

	/**
	 * Suspend a JClouds node.
	 */
	override def suspend_execute(SuspendMethod method) {
		println("EXECUTE COMMAND:  machine suspend " + compute.hostname);

	// TODO: must be implemented
	}
}

class ExecutableMachine extends MachineImpl {
	protected String driver = "vbox"

	//	val stateMachine = new ComputeStateMachine<Compute>(this)
	/**
	 * The hypervisor manager.
	 */
	val manager = new LibvirtManager(this) {
		override def getDriver() {
			"vbox" // TODO: check driver name
		}

		override def appendHypervisorParameters(String sb) {

			// TODO: must be implemented
			throw new UnsupportedOperationException
		}

	}

	// Delegation to the container state machine.
	override def start() { manager.start }

	override def stop(StopMethod method) { manager.stop(method) }

	override def restart(RestartMethod method) { manager.restart(method) }

	override def suspend(SuspendMethod method) { manager.suspend(method) }

	def String getDriver() { manager.driver }
}

class ExecutableMachine_VirtualBox extends Machine_VirtualBoxImpl {
	protected String driver = "vbox"

	//	val stateMachine = new ComputeStateMachine<Compute>(this)
	/**
	 * The hypervisor manager.
	 */
	val manager = new LibvirtManager(this) {
		override def getDriver() {
			"vbox" // TODO: check driver name
		}

		override def appendHypervisorParameters(String sb) {
			// TODO Check not null of attributes
			throw new UnsupportedOperationException
		}

	}

	// Delegation to the container state machine.
	override def start() { manager.start }

	override def stop(StopMethod method) { manager.stop(method) }

	override def restart(RestartMethod method) { manager.restart(method) }

	override def suspend(SuspendMethod method) { manager.suspend(method) }

	def String getDriver() { manager.driver }

}

class ExecutableLibvirtModel {
}

class ExecutablJcloudsModel {
}

class LibvirtExecutableModel {
	def static void main(String[] args) {

		// Initialize the executable Docker factory.
		ExecutableHypervisorFactory.init

		// Obtain the Infrastructure package factory.
		val factory = HypervisorPackage.eINSTANCE.hypervisorFactory

		// Create a VirtualBox machine.
		val machine = factory.createMachine_VirtualBox
		machine.name = "libvirt-machine"
		machine.hostname = machine.id
		machine.memory = 654321f
		machine.cores = 2

		// Create Interface
		val network = factory.createInterface
		network.type = 'bridge'
		network.label = "en0" // Set ethx for linux
		network.model = "82540EM"
		network.mac_addresss = '00:0c:29:76:78:50'
		
		// Put the network inside the machine.
		val contains = factory.createContains
		contains.target = network
		machine.links.add(contains)
		
		// Create Disk
		val disk = factory.createDisk
		disk.device = "cdrom"
		disk.source = "/Users/spirals/Downloads/ubuntu-14.04-server-i386.iso"
//		disk.target = ""

		/*
		// Create Network
		val network = factory.createEthernet
		network.label = "en0" // Set ethx for linux

		// NetworkLink
		val networkInterface = factory.createInterface
		networkInterface.target = network

		//		networkInterface.mac = value
		machine.links.add(networkInterface)

		// Create storage
		val storage = factory.createStorage

		// StorageLink
		val storageLink = factory.createStoragelink

		//		storageLink.deviceid = value
		storageLink.target = storage
		machine.links.add(storageLink)
		*/
		machine.start

	}

}
