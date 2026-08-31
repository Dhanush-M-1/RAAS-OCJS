# Python program to print prime factors 
  
import math 
  
# A function to print all prime factors of  
# a given number n 
def primeFactors(n): 
	r = []
	while n % 2 == 0:
		r.append(2)
		n = n // 2
	for i in range(3,int(math.sqrt(n))+1,2): 
		while n % i== 0: 
			r.append(int(i))
			n = n // i 
	if n > 2: 
		r.append(n)
	return r 
  
# n =30
# print(primeFactors(n))
  
# This code is contributed by Harshit Agrawal 

for _ in range(0, int(input())):
	n = int(input())

	move=  0 

	while True:
		if n == 1:
			print(move)
			break
		move += 1
		if n % 6 == 0:
			n //= 6
		elif n % 3 == 0:
			n *= 2
		else:
			print(-1)
			break