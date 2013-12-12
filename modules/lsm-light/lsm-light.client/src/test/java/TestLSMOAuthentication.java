import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.SerializationUtils;
import org.jasig.cas.authentication.ImmutableAuthentication;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.ticket.support.NeverExpiresExpirationPolicy;
import org.openiot.lsm.security.oauth.LSMOAuthHttpManager;
import org.openiot.lsm.security.oauth.LSMRegisteredServiceImpl;
import org.openiot.lsm.security.oauth.LSMServiceTicketImpl;
import org.openiot.lsm.security.oauth.LSMTicketGrantingTicketImpl;
import org.openiot.lsm.security.oauth.mgmt.Permission;
import org.openiot.lsm.security.oauth.mgmt.Role;
import org.openiot.lsm.security.oauth.mgmt.User;

import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP;
/**
 * 
 * @author Hoan Nguyen Mau Quoc
 * 
 */
public class TestLSMOAuthentication {
	static String OAuthGraphURL = "http://lsm.deri.ie/OpenIoT/OAuth#";

	public static Permission generatePermission(String name, String des) {
		Permission per = new Permission();
		per.setDescription(des);
		per.setName(name);
		return per;
	}

	public static Role generateRole() {
		Role role = new Role();
		role.setDescription("Administrator role");
		role.setName("admin");

		Permission per = new Permission();
		per.setDescription("Create new users");
		per.setName("admin:create_user");
		role.addPermissionForService((long) 2, per);

		Permission per2 = new Permission();
		per2.setDescription("Delete stream s1");
		per2.setName("admin:delete_sensor:s1");
		role.addPermissionForService((long) 2, per2);

		Permission per3 = new Permission();
		per3.setDescription("Delete existing users");
		per3.setName("admin:delete_user");
		role.addPermissionForService((long) 1, per3);

		return role;
	}

	public static User generateOAuthUser() {
		Role role = generateRole();
		List<Role> roles = new ArrayList();
		roles.add(role);

		Permission per = new Permission();
		per.setDescription("Query stream s2");
		per.setName("sensor:query:s2");

		Role role2 = new Role();
		role2.setDescription("guest role");
		role2.setName("guest");
		role2.addPermissionForService((long) 3, per);
		roles.add(role2);

		User user = new User();
		user.setUsername("admin");
		user.setEmail("admin@example.com");
		user.setName("administrator");
		user.setPassword("5ebe2294ecd0e0f08eab7690d2a6ee69");
		user.setRoles(roles);
		return user;
	}

	public static LSMRegisteredServiceImpl createRegisteredService() {
		LSMRegisteredServiceImpl reg_ser = new LSMRegisteredServiceImpl();
		reg_ser.setId((long) 1);
		reg_ser.setAllowedToProxy(true);
		reg_ser.setAnonymousAccess(true);
		reg_ser.setDescription("Service Manager");
		reg_ser.setEnabled(true);
		reg_ser.setEvaluationOrder(0);
		reg_ser.setIgnoreAttributes(false);
		reg_ser.setName("Service Manager");
		reg_ser.setServiceId("https://localhost:8443/openiot-cas/services/j_acegi_cas_security_check");
		reg_ser.setSsoEnabled(false);
		return reg_ser;
	}

	public static LSMTicketGrantingTicketImpl createTicketGrantingTicket() {
		LSMTicketGrantingTicketImpl tgt = new LSMTicketGrantingTicketImpl();
		tgt.setId("TGT-1-0VPQMgR6P4OeVdAFK3O3CWxkKUZUaZlRPnEOOw9qIVIhj6tP9A-openiot.eu");
		tgt.setCountOfUses(1);
		tgt.setCreationTime(1385137975212L);
		tgt.setExpirationPolicy(new NeverExpiresExpirationPolicy());
		tgt.setLastTimeUsed(1385137975237L);
		tgt.setPreviousLastTimeUsed(1385137975212L);
		tgt.setExpired(false);
		tgt.setAuthentication(new ImmutableAuthentication(new SimplePrincipal("sp-id")));
		final HashMap<String, Service> services = new HashMap<String, Service>();
		services.put("dummy-id", new SimpleWebApplicationServiceImpl("dummy-id"));
		tgt.setServices(services);

		tgt.setTicketGrantingTicket(null);
		return tgt;
	}

	public static LSMTicketGrantingTicketImpl createTicketGrantingTicket(LSMTicketGrantingTicketImpl grantingTicket) {
		LSMTicketGrantingTicketImpl tgt = new LSMTicketGrantingTicketImpl();
		tgt.setId("TGT-2-eLPogT3jXcUd1chRvtqKH6Rxv49XbtXZfEp5qoR1ynhbGOlxIK-openiot.eu");
		tgt.setCountOfUses(2);
		tgt.setCreationTime(1385138057030L);
		tgt.setExpirationPolicy(new NeverExpiresExpirationPolicy());
		tgt.setLastTimeUsed(1385138114044L);
		tgt.setPreviousLastTimeUsed(1385138057063L);
		tgt.setExpired(false);
		tgt.setAuthentication(new ImmutableAuthentication(new SimplePrincipal("sp-id2")));
		final HashMap<String, Service> services = new HashMap<String, Service>();
		services.put("dummy-id2", new SimpleWebApplicationServiceImpl("dummy-id2"));
		tgt.setServices(services);
		tgt.setTicketGrantingTicket(grantingTicket);
		return tgt;
	}
	
	public static LSMServiceTicketImpl createServiceTicket(LSMTicketGrantingTicketImpl grantingTicket) {
		LSMServiceTicketImpl serviceTicket = new LSMServiceTicketImpl();
		serviceTicket.setId("ST-3-HC7u5cS33WUK5UJOoZyA-openiot.eu");
		serviceTicket.setCountOfUses(0);
		serviceTicket.setCreationTime(1385138114044L);
		serviceTicket.setExpirationPolicy(new NeverExpiresExpirationPolicy());
		serviceTicket.setLastTimeUsed(1385138114044L);
		serviceTicket.setPreviousLastTimeUsed(0L);
		serviceTicket.setFromNewLogin(false);
		serviceTicket.setService(new SimpleWebApplicationServiceImpl("dummy-id3"));
		serviceTicket.setTicketGrantingTicket(grantingTicket);
		return serviceTicket;
	}

	public static void testSPARQLService(){
		String sparqlQueryString = "select distinct ?weatherSensor where {{"+
				   " select ?sensor AS ?weatherSensor from <http://lsm.deri.ie/sensormeta#> where {" +
				   " ?sensor <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://purl.oclc.org/NET/ssnx/ssn#Sensor>."+
                "?sensor <http://purl.org/net/provenance/ns#PerformedBy> ?source."+
                "?sensor <http://lsm.deri.ie/ont/lsm.owl#hasSensorType> ?typeId."+
                "?typeId <http://www.w3.org/2000/01/rdf-schema#label> 'weather'."+
                "?sensor <http://www.loa-cnr.it/ontologies/DUL.owl#hasLocation> ?place."+
                "?place geo:geometry ?geo. filter (<bif:st_intersects>(?geo,<bif:st_point>(-0.12719,51.506432),15))."+
                "}}"+
                " ?weatherSensor <http://purl.oclc.ie/NET/ssnx/ssn#observes> ?observedProperty."+
                " ?observedProperty <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://lsm.deri.ie/ont/lsm.owl#WindChill>.}";       

		System.out.println(sparqlQueryString);
		QueryExecution qexec = new QueryEngineHTTP("http://lsm.deri.ie/sparql", sparqlQueryString);
//		Query query = QueryFactory.create(sparqlQueryString);
//		ARQ.getContext().setTrue(ARQ.useSAX);
//		
//		QueryExecution qexec = QueryExecutionFactory.sparqlService("http://lsm.deri.ie/sparql", query);
		//Retrieving the SPARQL Query results
		ResultSet results = qexec.execSelect();
		//Iterating over the SPARQL Query results
		while (results.hasNext()) {
			QuerySolution soln = results.nextSolution();			
			System.out.println(soln.get("?weatherSensor"));                                                
		}
		qexec.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LSMOAuthHttpManager oM = new LSMOAuthHttpManager(OAuthGraphURL);

		// oM.addPermission(generatePermission("admin:create_user","Create new users"));
		// oM.deletePermission("admin:create_user");

		// oM.addRole(generateRole());
		// oM.deleteRole("admin");

		// oM.addUser(generateOAuthUser());
		// oM.deleteUser("admin");

		 oM.addRegisteredService(createRegisteredService());
		// oM.deleteRegisteredService(1);

		// User user = oM.getUser("admin");
		// System.out.println(user.getRoles().size());
		// LSMRegisteredServiceImpl service = oM.getRegisteredService((long)1);
		// System.out.println(service.getId());

		final LSMTicketGrantingTicketImpl tgt = createTicketGrantingTicket();
//		oM.addTicketGrangtingTicket(tgt);
		
		final LSMTicketGrantingTicketImpl ticketGranting = oM.getTicketGranting(tgt.getId());
		System.out.println(ticketGranting);
//		oM.deleteTicketGranting(tgt.getId());
//		final LSMTicketGrantingTicketImpl ticketGranting2 = oM.getTicketGranting(tgt.getId());
//		System.out.println(ticketGranting2);

		final LSMTicketGrantingTicketImpl tgt2 = createTicketGrantingTicket(tgt);
		
		oM.addTicketGrangtingTicket(tgt2);
		final LSMTicketGrantingTicketImpl ticketGranting2 = oM.getTicketGranting(tgt2.getId());
		System.out.println(ticketGranting2);

//		oM.deleteTicketGranting(tgt2.getId());
//		final LSMTicketGrantingTicketImpl ticketGranting22 = oM.getTicketGranting(tgt2.getId());
//		System.out.println(ticketGranting22);
		
		
		final LSMServiceTicketImpl serviceTicket = createServiceTicket(tgt);
		oM.addServiceTicketImpl(serviceTicket);
		
//		LSMServiceTicketImpl serviceTicket2 = oM.getServiceTicketImpl(serviceTicket.getId());
//		System.out.println(serviceTicket2);
		
//		oM.deleteServiceTicketImpl(serviceTicket.getId());
//		serviceTicket2 = oM.getServiceTicketImpl(serviceTicket.getId());
//		System.out.println(serviceTicket2);
//		
//		oM.deleteTicketGranting(tgt2.getId()); 
		
//		final List<LSMTicketGrantingTicketImpl> allTkts = oM.getAllTicketGrantingTickets();
//		System.out.println(allTkts.size());
//		if(!allTkts.isEmpty())
//			System.out.println(allTkts.get(0));
//		
//		final List<LSMServiceTicketImpl> allTktsOf = oM.getAllServiceTicketsOfTicketGrantingTicket(tgt.getId());
//		System.out.println("allTktsOf size: " + allTktsOf.size());
//		if(!allTktsOf.isEmpty())
//			System.out.println(allTktsOf.get(0));
//		
//		final List<LSMServiceTicketImpl> allServiceTkts = oM.getAllServiceTickets();
//		System.out.println("allServiceTkts size: " + allServiceTkts.size());
//		if(!allServiceTkts.isEmpty())
//			System.out.println(allServiceTkts.get(0));
//		System.out.println(oM.getAllRegisteredServices().size());
	}
}
