######################################################################
# Write your code here
import sys
#import resource
#resource.setrlimit(resource.RLIMIT_STACK, [0x10000000, resource.RLIM_INFINITY])
#sys.setrecursionlimit(0x100000)
# Write your code here
# For getting input from input.txt file 
# sys.stdin = open('input.txt', 'r')  
# Printing the Output to output.txt file 
# sys.stdout = open('output.txt', 'w')
RI =   lambda : [int(x) for x in sys.stdin.readline().strip().split()]
rw =   lambda : sys.stdin.readline().strip().split()
ri =   lambda : int(sys.stdin.readline().strip())
rs =   lambda : sys.stdin.readline().strip()
from collections import defaultdict as df
#import heapq 
#heapq.heapify(li) heappush(li,4) heappop(li)
import random
# random.shuffle(list)
#infinite = float('inf')
#######################################################################
from queue import PriorityQueue as pq
# from math import pow as p
from math import ceil

n = ri()

def fact(n,mod):
	res = 1
	for i in range(1,n+1):
		res = (res*i)%mod
	return res



mod = 1000000007
ans = fact(n,mod)
# print(ans)
ans = ans - pow(2,n-2,mod)*2
ans = ans%mod
print(ans)