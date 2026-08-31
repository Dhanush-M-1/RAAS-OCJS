from sys import stdin, stdout 
from bisect import bisect_left, bisect_right
import math
cin = stdin.readline
def cout(x):
	stdout.write(str(x)+'\n')

def nexint():
    return int(stdin.readline())
def readline():
    return map(int,stdin.readline().split())
def readlist():
    return list(map(int,stdin.readline().split()))

def find_lt(a, x):#'Find rightmost value less than x'
    i = bisect_left(a, x)
    if i:
        return a[i-1]
    raise ValueError

def find_gt(a, x):#'Find leftmost value greater than x'
    i = bisect_right(a, x)
    if i != len(a):
        return a[i]
    raise ValueError

# ---------------------Template ends-------------------------------------

n,k = readline()
arr = readlist()

arr.sort()

count = 0
for x in arr:
	ix = bisect_right(arr,x)
	if ix != len(arr) and  x < arr[ix] <= x+k :
		count+=1
	
cout(n-count)
		





	
