import sys,math

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
gr = read_int_list()
an = read_int_list()

if (gr[0] != an[0]) or (gr[-1] != an[-1]):
	print("No")
	sys.exit()

d1,d2 = [],[]
for i in range(n-1):
	d1.append(gr[i+1]-gr[i])
	d2.append(an[i+1]-an[i])

d1.sort()
d2.sort()

if d1 == d2:
	print("Yes")
else:
	print("No")
