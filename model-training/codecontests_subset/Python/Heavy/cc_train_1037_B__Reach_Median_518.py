import sys
import math
#import random
sys.setrecursionlimit(100000)
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

n,k=invr()
ara=inara()

ara.sort()

ans=0

for i in range(n//2,n):
	if ara[i]<=k:
		ans+=(k-ara[i])

for i in range(n//2+1):
	if ara[i]>=k:
		ans+=(ara[i]-k)

print(ans)
			
	
			
			
			
