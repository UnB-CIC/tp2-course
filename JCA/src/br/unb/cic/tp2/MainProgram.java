package br.unb.cic.tp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class MainProgram {
	
	public static void main(String args[]) {
		if(args.length < 1) {
			help();
		}
		try {
			switch(args[0]) {
			   case "--list": list(args); break;
			   case "--generate-key": generateKey(args);
			   case "--generate-password": generatePassword(args); break; 
			   case "--retrieve-password": retrievePassword(args); break; 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void generateKey(String args[]) throws Exception { 
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		SecretKey key = kg.generateKey();
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File(args[1])));
		os.writeObject(key);
		os.flush();
		os.close();
	}
	private static void generatePassword(String args[]) throws Exception { 
		byte[] password = new byte[16]; 
		new Random().nextBytes(password);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(args[1]))); 
		
		SecretKey key = (SecretKey)ois.readObject();
		
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] res = cipher.doFinal(password);
		
		System.out.println("Plain text password " + password);
		System.out.println("Ciphered password " + res);
		
		ois.close();
	}
	
	private static void retrievePassword(String args[]) {
		// TODO: this method is still missing. 
		// Here you should retrieve in the second command 
		// line argument (args[1]) the ciphered password as String, 
		// and then convert it to a byte array. The third argument 
		// should be the path to the secret key object (see the 
		// implementation of the generatePassword method). 
		// Considering this, it must be possible to "decrypt" the 
		// password. 
	}
	
	private static void list(String args[]) {
		if(args.length == 1) {
			Provider[] providers = Security.getProviders();
			for(Provider p: providers) {
				System.out.println(String.format("%s: %s", p.getName(), p.getInfo()));
			}
		}
		else if(args.length == 3) {
			String providerName = args[1]; 
			String primitiveName = args[2]; 
			
			Provider p = Security.getProvider(providerName);
			
			System.out.println("List of available algorithms for " + primitiveName);
			
			assert p != null;
			assert p.getServices() != null; 
			
			for(Service service: p.getServices()) {
				if(service.getType().equals(primitiveName)) {
					System.out.println(service.getAlgorithm());
				}
			}
		}
		else {
			help();
		}
	}
	
	private static void help() {
		System.out.println("Try the following commands"); 
		System.out.println(" --list    : list the name of the installed providers"); 
		System.out.println(" --list <provider> <algorithm>  : list the implementations of an algorithm from a given provider");
		System.exit(0);
	}

}
