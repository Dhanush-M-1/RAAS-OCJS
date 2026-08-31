# Python 3 code to generate all 
# possible subsequences. 

# Uses python3
from sys import stdin, stdout 
import sys
import math
import itertools
sys.setrecursionlimit(10**6)

def printSubsequences(arr, index, subarr,sequence): 
	# Print the subsequence when reach 
	# the leaf of recursion tree 
	if index == len(arr): 
		
		# Condition to avoid printing 
		# empty subsequence 
		if len(subarr) != 0: 
			sequence.append(subarr) 
	
	else: 
		# Subsequence without including 
		# the element at current index 
		printSubsequences(arr, index + 1, subarr,sequence) 
		
		# Subsequence including the element 
		# at current index 
		printSubsequences(arr, index + 1, subarr+[arr[index]],sequence) 
	
	return sequence

# def printSubsequences(arr, n) : 

# 	# Number of subsequences is (2**n -1) 
# 	opsize = math.pow(2, n) 

# 	# Run from counter 000..1 to 111..1 
# 	sequence = list()
# 	for counter in range( 1, (int)(opsize)) : 
# 		sequence.append(list())
# 		for j in range(0, n) : 
			
# 			# Check if jth bit in the counter 
# 			# is set If set then print jth 
# 			# element from arr[] 
# 			if (counter & (1<<j)) : 
# 				sequence[counter-1].append(arr[j])
# 	return sequence

# This code is contributed by Nikita Tiwari. 


def main(): 
	t = int(stdin.readline().strip())
	for i in range (1,t+1):
		k=0
		l = [int(x) for x in stdin.readline().split()]
		
		a = [int(x) for x in stdin.readline().split()] 
		b = [int(x) for x in stdin.readline().split()]

		for i in a:
			if i in b:
				stdout.write("YES"+'\n')
				stdout.write("1 "+str(i)+'\n')
				k = 1
				break
		if k==1:
			continue
		stdout.write("NO"+'\n')

# call the main method 
if __name__ == "__main__": 
	main()	 