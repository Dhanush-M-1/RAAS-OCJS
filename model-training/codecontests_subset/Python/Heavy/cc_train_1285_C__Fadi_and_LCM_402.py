from bisect import bisect_left as bl
from bisect import bisect_right as br
import heapq
import math
from collections import *
from functools import reduce,cmp_to_key
import sys
input = sys.stdin.readline
 
M = mod = 998244353
def factors(n):return sorted(list(set(reduce(list.__add__,([i, n//i] for i in range(1, int(n**0.5) + 1) if n % i == 0)))))
# def inv_mod(n):return pow(n, mod - 2, mod)
 
def li():return [int(i) for i in input().rstrip('\n').split()]
def st():return input().rstrip('\n')
def val():return int(input().rstrip('\n'))
def li2():return [i for i in input().rstrip('\n').split(' ')]
def li3():return [int(i) for i in input().rstrip('\n')]


def gcd(a,b): 
    if a == 0: 
        return b 
    return gcd(b % a, a) 
  
# Function to return LCM of two numbers 
def lcm(a,b): 
    return (a*b) / gcd(a,b) 

x = val()
# if int(x**0.5)**2 == x:
#     ans = int(x**0.5)
#     a = ans
#     b = ans
#     currans = [a,b]

# l = factors(x)
# ans = x
# a = 1
# b = x
# currans = [1,x]
# # print(l,lcm(6,8))
# i,j = 0,len(l)-1
# while i<=j and i < len(l) and j:
#     temp = lcm(l[i],l[j])

#     if temp == x:
#         if max(l[i],l[j]) < ans:
#             ans = max(l[i],l[j])
#             currans = sorted([l[i],l[j]])
#         if i == 0:i += 1
#         j -= 1
#     elif temp > x:
#         j -= 1
#     else:
#         i += 1
#     if int(temp) == max(l[i],l[j]):
#         j-=1
#         continue
# print(*currans)
ans = x
currans = [1,x]
for i in range(1,int(x**0.5) + 1):
    if x//i == x/i:
        temp = gcd(i,x//i)
        if gcd(i,x//i) == 1:
            if ans > max(i,x//i):
                ans = max(i,x//i)
                currans = [i,x//i]
print(*currans)