"""
    Author : thekushalghosh
    Team   : CodeDiggers
"""
import sys,math
input = sys.stdin.readline
 
############ ---- USER DEFINED INPUT FUNCTIONS ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(s[:len(s) - 1])
def invr():
    return(map(int,input().split()))
################################################################
############ ---- THE ACTUAL CODE STARTS BELOW ---- ############
t = 1
for tt in range(t):
    n = inp()
    a = []
    for i in range(1,math.ceil(n ** (1 / 2))):
        if n % i == 0:
            a.append(i)
    a.reverse()
    for i in range(len(a)):
        if math.gcd(a[i],n // a[i]) == 1:
            print(a[i],n // a[i])
            break
    if n == 1:
        print(1,1)