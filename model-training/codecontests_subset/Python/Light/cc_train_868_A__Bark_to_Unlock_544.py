import os
import math

def work():
	ans = input()
	n = int(input())
	a = []
	for i in range(n):
		a.append(input())
	flag = False
	for i in range(n):
		for j in range(n):
			temp = a[i] + a[j]
			if (temp.count(ans) > 0):
				flag = True
	
	if (flag):
		print ('YES')
	else :
		print ('NO')

if __name__ == "__main__":
	work()
