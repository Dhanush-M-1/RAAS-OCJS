# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
# TAIWAN NUMBER ONE!!!!!!!!!!!!!!!!!!!
from sys import stdin, stdout
from math import sqrt
import math
import heapq
from itertools import accumulate

N = int(input())

arr = [int(x) for x in stdin.readline().split()]

summ = sum(arr)

for k in range(max(arr),401):
    total_votes = k*N
    
    Awruk = total_votes - summ
    
    if Awruk>summ:
        print(k)
        quit()
    #print(k,Awruk,summ)


    
            