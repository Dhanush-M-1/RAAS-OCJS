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

n = read_int()
s = read_string()

dik = {}

for i in range(n-1):
	temp = s[i:i+2]
	dik[temp] = dik.get(temp,0) + 1

maxi = max(list(dik.values()))

# print(dik)
for k in dik:
	if dik[k] == maxi:
		print(k)
		sys.exit()