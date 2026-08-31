# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
from sys import stdin, stdout
from collections import defaultdict
from collections import deque
import math
import copy

T = int(input())
#N = int(input())
#s1 = input()
#s2 = input()
#N,Q = [int(x) for x in stdin.readline().split()]
#arr = [int(x) for x in stdin.readline().split()]
 
for i in range(T):
    A,B,N = [int(x) for x in stdin.readline().split()]
    
    if N==0:
        print(A)
    elif N==1:
        print(B)
    else:
        u,v = B,A
        N = (N-2)%3 + 1
        
        for i in range(N):
            s = u ^ v
            u, v = s, u
        
        print(s)
    