import sys
# from itertools import permutations
import math
def input():    return sys.stdin.readline().strip()
def iinput():   return int(input())
def rinput():   return map(int, sys.stdin.readline().strip().split()) 
def get_list(): return list(map(int, sys.stdin.readline().strip().split())) 
mod = int(1e9)+7

M = 1000000007

def factorial(n) :
    f = 1
 
    for i in range(1, n + 1): 
        f = (f * i) % M 
 
    return f 

n = iinput()
ans2 = (factorial(n) - (math.ceil(2**(n-1)))%M)%M

print(ans2)                  