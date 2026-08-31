'''input
11 5 4
11010100101
'''
from sys import stdin, setrecursionlimit
from bisect import bisect_right

setrecursionlimit(15000)


def get_gdict(arr):
	gdict = dict()
	for i in range(len(arr)):
		if arr[i] in gdict:
			gdict[arr[i]] += 1
		else:
			gdict[arr[i]] = 1
	return gdict


def initial_check(barr, garr):
	for i in garr:
		if i < barr[-1]:
			return False
	return True


# main starts
n, x, y = list(map(int, stdin.readline().split()))
string = list(stdin.readline().strip())
count = 0
for i in range(n - 1, n - y - 1, -1):
	if string[i] == '1':
		string[i] = '0'
		count += 1
if string[n - y - 1] == '0':
	string[n - y - 1] = '1'
	count += 1
for i in range(n - y - 2, max(-1, n - x -1),-1):
	if string[i] == '1':
		string[i] = 0
		count += 1
#print(string)
print(count)