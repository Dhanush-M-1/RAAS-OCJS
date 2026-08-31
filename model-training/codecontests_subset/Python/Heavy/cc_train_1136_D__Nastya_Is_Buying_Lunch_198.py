# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
from sys import stdin, stdout
import collections
 
#Q = int(input())
 
#ans = [0]*Q
#s = input()
#N = len(s)
#arr = [int(x) for x in stdin.readline().split()]

N,M = [int(x) for x in stdin.readline().split()]
            
P = [int(x) for x in stdin.readline().split()]
 
idx = {}
 
for i in range(N):
    idx[P[i]] = i
    
swap = [0]*N
 
data = {}

for i in range(N):
    data[i] = []
    
for i in range(M):
    x,y = [int(x) for x in stdin.readline().split()]
    
    A = idx[x]
    B = idx[y]
    
    if A<B:
        swap[A] += 1
        data[B].append(A)
 

k = N-1
#print(swap)
res = 0
for i in range(N-2,-1,-1):
    #print(swap[i],k)
    if swap[i]>= k-i:
        k -= 1
        for j in data[i]:
            swap[j] -= 1
        
        
print(N-1-k)

