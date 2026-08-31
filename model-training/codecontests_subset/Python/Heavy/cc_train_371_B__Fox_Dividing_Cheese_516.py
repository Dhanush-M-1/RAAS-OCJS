import sys
import math
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

q = inlt()
a = q[0]
b = q[1]

sum = 0

for i in ([2,3,5]):
    ct1 = 0
    ct2 = 0
    while(a%i == 0):
        ct1 = ct1 + 1
        a = a // i
    while (b % i == 0):
        ct2 = ct2 + 1
        b = b // i
    sum = sum + abs(ct1-ct2)

if(a == b):
    print(sum)
else:
    print(-1)

