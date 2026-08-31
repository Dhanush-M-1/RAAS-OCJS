import sys
import math
#import random
#sys.setrecursionlimit(10000000)
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

t=inp()

for _ in range(t):
	a,b,c=invr()
	ans=0
	
	while b>0 and c>1:
		ans+=3
		b-=1
		c-=2
	
	while a>0 and b>1:
		ans+=3
		a-=1
		b-=2
	
	print(ans)
			
			
			
