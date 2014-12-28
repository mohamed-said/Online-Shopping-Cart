package dataPersistence;

import java.sql.SQLException;

/**
 * @author Mohamed Said
 */

public class PersistenceFactory {

	/**
	 * @param type of the desired persistence mechanism
	 * @return an object of the needed persistence mechanism
	 * @throws ClassNotFoundException if the given type not found
	 * @throws SQLException if an error happened when accessing the database
	 */
	public IPersistenceMechanism loadMechanism(String type) throws ClassNotFoundException, SQLException {
		if (type.equalsIgnoreCase("FilePersistence")) {
			return FilePersistence.getInstance();
		} else if (type.equalsIgnoreCase("SQLPersistence")) {
				return SQLPersistence.getInstance();
		} else throw new ClassCastException();
	}
	
//	private HashMap<String, IPersistenceMechanism> registrants = new HashMap<String, IPersistenceMechanism>();
//	
//	public void registerMechanism(String mechanism, IPersistenceMechanism ob) {
//		registrants.put(mechanism, ob);
//	}	
	
//	public IPersistenceMechanism loadMechanism(String type) {
//		Class<IPersistenceMechanism> ob = (Class)registrants.get(type);
//		Constructor<IPersistenceMechanism> mechanismConstructor = cClass.getDeclaredConstructor(new Class [] {String.class});
//		return (IPersistenceMechanism)mechanismConstructor.newInstance(new Object[] {});
//	}
	
//	public IPersistenceMechanism loadMechanism(String type) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//		String className = type;
//		Object ob = Class.forName(className).newInstance();
//		return (IPersistenceMechanism)ob;
//	}

}
