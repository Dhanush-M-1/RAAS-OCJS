import sys
import math
#from queue import *
#import random
#sys.setrecursionlimit(int(1e6))
input = sys.stdin.readline
 
############ ---- USER DEFINED INPUT FUNCTIONS ---- ############
def inp():
    return(int(input()))
def inara():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))
################################################################
############ ---- THE ACTUAL CODE STARTS BELOW ---- ############

n=inp()
ara=inara()
ara.sort()

lo=ara[-1]
hi=100000000000000000000000000000
ans=hi

while hi>=lo:
	mid=(hi+lo)//2
	tot=0
	for num in ara:
		tot+=mid-num
		if tot>=mid:
			break
	
	if tot>=mid:
		ans=mid
		hi=mid-1
	else:
		lo=mid+1

print(ans)
	
				
