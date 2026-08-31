		import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.plaf.synth.SynthSeparatorUI;
		
		public class CF_428_DIV2_A {
			
			

			public static void main(String[] args) throws IOException {
				
				BufferedReader input = new BufferedReader (new InputStreamReader(System.in));

				int n = Integer.parseInt(input.readLine());
				String[] line = input.readLine().split(" ");
				int[] N = new int[n];
				int k = 0;
				int sum = 0;
				for (int i = 0; i < n; i++) {
					N[i] = Integer.parseInt(line[i]);
					sum += N[i];
					k = Math.max(k, N[i]);
					
				}
				
				
				for (int i = k;  i < 202; i++) {
					if (n*i > 2*sum) {
						k = i;
						break;
					}
				}
				
				System.out.println(k);
				
				input.close();
			}
		}
