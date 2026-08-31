public class Driver {
	static int online = 0;
	static int bytes = 0;
	static String command;
	static String[] values;

	public static void main(String[] args) throws java.io.IOException {
		java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
		java.io.BufferedReader in = new java.io.BufferedReader(isr);
		
		command = in.readLine();
		while (command != null) {
			switch (command.charAt(0)) {
				case '+':
					online++;
					break;
				case '-':
					online--;
					break;
				default:
					values = command.split(":");
					if (values.length > 1) {
						bytes += (values[1].length() * online);
					}
			}
			command = in.readLine();
		}		
		System.out.println(bytes);
		in.close();
	}
}