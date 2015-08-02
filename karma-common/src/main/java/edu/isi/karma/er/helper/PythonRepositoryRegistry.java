package edu.isi.karma.er.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PythonRepositoryRegistry {

	private static PythonRepositoryRegistry singleton = new PythonRepositoryRegistry();

	private final Map<String, PythonRepository> karmaHomeToPythonRepository = new ConcurrentHashMap<String, PythonRepository>();

	public static PythonRepositoryRegistry getInstance() {
		return singleton;
	}

	public void register(PythonRepository pythonRepository) {
		karmaHomeToPythonRepository.put(pythonRepository.getRepositoryPath(), pythonRepository);
	}

	public PythonRepository getPythonRepository(String karmaHome) {
		return karmaHomeToPythonRepository.get(karmaHome);
	}
	
	public void deregister(String karmaHome) {
		karmaHomeToPythonRepository.remove(karmaHome);
	}
}
