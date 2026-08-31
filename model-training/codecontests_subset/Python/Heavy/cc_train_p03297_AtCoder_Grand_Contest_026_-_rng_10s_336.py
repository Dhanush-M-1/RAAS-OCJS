

import sys
#sys.stdin=open("data.txt")
input=sys.stdin.readline

def gcd(a,b):
    while b:
        a,b=b,a%b
    return a

def good(a,b,c,d):
    # easy cases
    if b>a: return 0
    if b>d: return 0
    if b<=c: return 1
    # normal case
    # think about the number of cans mod b
    # this shouldn't be in the interval (c,b)
    a%=b
    d%=b
    g=gcd(b,d)
    a+=((b-a-1)//g)*g
    return not c<a<b

for _ in range(int(input())):
    a,b,c,d=map(int,input().split())
    if good(a,b,c,d): print("Yes")
    else: print("No")
