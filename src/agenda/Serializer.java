package agenda;

import java.io.*;
import java.util.ArrayList;

public class Serializer {

	static byte[] encode(Object message) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] encoded = null;

		try {
			ObjectOutput out = new ObjectOutputStream(bos);
			out.writeObject(message);
			encoded = bos.toByteArray();
			bos.close();
		}
		catch (Exception e) {
			System.out.println("[ MessageSerializer ] Erro no encode da mensagem " + e);
		}

		return encoded;
	}

	static Object decode(byte[] message) {
		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		Object decoded = null;

		try {
			ObjectInputStream in = new ObjectInputStream(bis);
			decoded = in.readObject();
			in.close();
		}
		catch (Exception e) {
			System.out.println("[ MessageSerializer ] Erro no decode da mensagem " + e);
		}

		return decoded;
	}

	static Object serializeArrayList(ArrayList<Usuario> Array) 
	{ 

		ArrayList<Usuario> decoded = new ArrayList<>();
		try { 
			// an OutputStream file 
			// "namesListData" is 
			// created 
			FileOutputStream fos = new FileOutputStream("lista"); 

			// an ObjectOutputStream object is 
			// created on the FileOutputStream 
			// object 
			ObjectOutputStream oos = new ObjectOutputStream(fos); 

			// calling the writeObject() 
			// method of the 
			// ObjectOutputStream on the 
			// OutputStream file "namesList" 
			oos.writeObject(decoded); 

			// close the ObjectOutputStream 
			oos.close(); 

			// close the OutputStream file 
			fos.close(); 

			System.out.println("lista serializada"); 
		} 
		catch (IOException ioe) { 
			ioe.printStackTrace(); 
		}
		return decoded; 
	} 

	static ArrayList<Usuario> deserializeArrayList(Object lista){ 

		ArrayList<Usuario> decoded = new ArrayList<>();
		try { 
			// an OutputStream file 
			// "namesListData" is 
			// created 
			FileInputStream fis = new FileInputStream("lista");

			// an ObjectOutputStream object is 
			// created on the FileOutputStream 
			// object 
			ObjectInputStream ois = new ObjectInputStream(fis);

			// calling the writeObject() 
			// method of the 
			// ObjectOutputStream on the 
			// OutputStream file "namesList" 
			decoded = (ArrayList) ois.readObject();

			// close the ObjectOutputStream 
			ois.close(); 

			// close the OutputStream file 
			fis.close(); 

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decoded;
	}
}