import sys
import math

def read_int():
	return int(input().strip())

def read_int_list():
	return list(map(int,input().strip().split()))

def read_string():
	return input().strip()

def read_string_list(delim=" "):
	return input().strip().split(delim)

###### Author : Samir Vyas #######
###### Write Code Below    #######

q = read_int()

for _ in range(q):
	[l,r,d] = read_int_list()

	if d < l:
		print(d)
		continue

	if d > r:
		print(d)
		continue


	temp = (l//d - 1)*d

	if temp < l and temp >= d:
		print(temp)
		continue

	temp = (r//d + 1)*d

	if temp > r and temp >= d:
		print(temp)
		continue
